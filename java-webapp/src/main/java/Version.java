package com.njax.destructocats.java.webapp.version;

public class Version {
    public String info() {
        String artifactId = "java-webapp";
        String group = "com.njax.destructocats";
        String version = Version.class.getPackage().getImplementationVersion();

        if (version == null) {
            version = "UNKNOWN";
        }

        String versionString = group + ":" + artifactId + ":" + version;
        return versionString;
    }
}
