package com.njax.destructocats.java.app.models.version;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.boot.info.BuildProperties;

// @Component
public class Version {
    // @Autowired // https://www.vojtechruzicka.com/spring-boot-version/
    // BuildProperties buildProperties;
    //
    // @Autowired
    // public Version(BuildProperties buildProperties) {
    //     this.buildProperties = buildProperties;
    // }

    public String info() {
        // String artifactId = buildProperties.getArtifact();
        // String group = buildProperties.getGroup();
        // String version = buildProperties.getVersion();
        String artifactId = "java-app-models";
        String group = "com.njax.destructocats";
        String version = Version.class.getPackage().getImplementationVersion();

        if (version == null) {
            version = "UNKNOWN";
        }

        String versionString = group + ":" + artifactId + ":" + version;
        return versionString;
    }
}
