## MySQL Setup

BEST REF for java:  https://spring.io/guides/gs/accessing-data-mysql/

Ref:  https://www.liquibase.org/documentation/tutorials/mysql.html
Ref:  https://qxf2.com/blog/mysql-and-liquibase/


###### Spin up MySQL

```
cd ../charts/helm-mysql/

helm upgrade -i helm-mysql-dev .
```

###### Access MySQL

```
#MYSQL_ROOT_PASSWORD=$(kubectl get secret --namespace default helm-mysql-dev -o jsonpath="{.data.mysql-root-password}" | base64 --decode; echo)
#MYSQL_HOST=$(kubectl get nodes --namespace default -o jsonpath='{.items[0].status.addresses[0].address}')
#MYSQL_PORT=$(kubectl get svc --namespace default helm-mysql-dev -o jsonpath='{.spec.ports[0].nodePort}')

MYSQL_ROOT_PASSWORD=$(kubectl get secret --namespace ops-services helm-mysql-dev -o jsonpath="{.data.mysql-root-password}" | base64 --decode; echo)
MYSQL_HOST=$(kubectl get nodes --namespace ops-services -o jsonpath='{.items[0].status.addresses[0].address}')
MYSQL_PORT=$(kubectl get svc --namespace ops-services helm-mysql-dev -o jsonpath='{.spec.ports[0].nodePort}')


mysql -h helm-mysql-dev.ops-services.svc.cluster.local -u root -p

mysql -h ${MYSQL_HOST}:${MYSQL_PORT} -u root -p

kubectl run --rm -i --tty ubuntu --image=registry.njax.org/$USER/liquibase_client --restart=Never -- bash -il
mysql -h helm-mysql-dev.ops-services.svc.cluster.local -u root -p
```


## Liquibase Setup

###### Build the Liquibase Image

```
docker build . -t registry.njax.org/$USER/liquibase_client
docker push registry.njax.org/$USER/liquibase_client
```


###### Run liquibase via binary

```
MYSQL_ROOT_PASSWORD=$(kubectl get secret --namespace ops-services helm-mysql-dev -o jsonpath="{.data.mysql-root-password}" | base64 --decode; echo)
MYSQL_HOST=$(kubectl get nodes --namespace ops-services -o jsonpath='{.items[0].status.addresses[0].address}')
MYSQL_PORT=$(kubectl get svc --namespace ops-services helm-mysql-dev -o jsonpath='{.spec.ports[0].nodePort}')

liquibase \
  --driver=com.mysql.cj.jdbc.Driver \
  --classpath=mysql-connector-java-8.0.19.jar \
  --url="jdbc:mysql://${MYSQL_HOST}:${MYSQL_PORT}/demo" \
  --changeLogFile=changelog.xml \
  --username=root \
  --password=$MYSQL_ROOT_PASSWORD \
  generateChangeLog
```


###### Run via Docker locally

```
docker run -it \
  -v ${PWD}/mysql-connector-java-8.0.19.jar:/liquibase/jdbc/mysql-connector-java-8.0.19.jar \
  registry.njax.org/$USER/liquibase_client \
  /liquibase/liquibase \
  --driver=com.mysql.cj.jdbc.Driver \
  --classpath=/liquibase/jdbc/mysql-connector-java-8.0.19.jar \
  --url="jdbc:mysql://helm-mysql-dev.default.svc.cluster.local:3306/mysql" --changeLogFile=changelog.xml \
  --username=root \
  --password=$MYSQL_ROOT_PASSWORD \
  generateChangeLog
```


#### Run Liquibase in-cluster

###### Create the PVC

```
kubectl apply -f - <<EOF


EOF
```


###### Boot a console in the cluster

```
kubectl run -it --rm -l="app=debug" --image registry.njax.org/rmanhatt/liquibase_client \
    --overrides='
    {
      "apiVersion": "apps/v1beta1",
      "spec": {
        "template": {
          "spec": {
            "containers": [{
                "name": "my-shell",
                "image": "registry.njax.org/rmanhatt/liquibase_client",
                "args": [ "bash" ],
                "stdin": true,
                "stdinOnce": true,
                "tty": true,
                "volumeMounts": [{
                  "mountPath": "/app",
                  "name": "my-shell"
                }]
            }],
            "volumes": [{
              "name":"my-shell",
              "persistentVolumeClaim": { "claimName": "my-shell" }
            }]
          }
        }
      }
    }
    ' my-shell -- bash

```

Get a shell to that running pod:

```
kubectl exec -it my-shell -- /bin/bash
```


###### generate the changelog.xml file

```
/liquibase/liquibase \
  --driver=com.mysql.cj.jdbc.Driver \
  --classpath=/liquibase/jdbc/mysql-connector-java-8.0.19.jar \
  --url="jdbc:mysql://helm-mysql-dev.default.svc.cluster.local:3306/mysql" --changeLogFile=changelog.xml \
  --username=root \
  --password=$MYSQL_ROOT_PASSWORD \
  generateChangeLog
```

###### Update Database to match changelog

```
MYSQL_ROOT_PASSWORD=$(kubectl get secret --namespace ops-services helm-mysql-dev -o jsonpath="{.data.mysql-root-password}" | base64 --decode; echo)
MYSQL_HOST=$(kubectl get nodes --namespace ops-services -o jsonpath='{.items[0].status.addresses[0].address}')
MYSQL_PORT=$(kubectl get svc --namespace ops-services helm-mysql-dev -o jsonpath='{.spec.ports[0].nodePort}')

liquibase \
  --url="jdbc:mysql://${MYSQL_HOST}:${MYSQL_PORT}/demo?createDatabaseIfNotExist=true" \
  --password=$MYSQL_ROOT_PASSWORD \
  update
```
