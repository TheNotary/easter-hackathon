# Java Db Models

ref: https://spring.io/guides/gs/accessing-data-mysql/


## Build

```
gradle build
```


## Execute

```
export MYSQL_ROOT_PASSWORD=$(kubectl get secret --namespace ops-services helm-mysql-dev -o jsonpath="{.data.mysql-root-password}" | base64 --decode; echo)
export MYSQL_HOST=$(kubectl get nodes --namespace ops-services -o jsonpath='{.items[0].status.addresses[0].address}')
export MYSQL_PORT=$(kubectl get svc --namespace ops-services helm-mysql-dev -o jsonpath='{.spec.ports[0].nodePort}')

gradle bootRun
```


## Add records

```
curl localhost:8080/demo/add \
  -d title=hello1 \
  -d body=im%20the%20first%20hello
```

## Publish to Artifactory

```
gradle artifactoryPublish -Partifactory_user=$USER -Partifactory_password=$ARTIFACTORY_PASSWORD_DESTRUCTOCATS
```
