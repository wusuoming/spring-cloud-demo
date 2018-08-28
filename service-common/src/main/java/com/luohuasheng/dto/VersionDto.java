
package com.luohuasheng.dto;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;

public class VersionDto {


    private static final VersionDto INSTANCE = load();
    private String updateTime;
    private String buildTime;
    private String commitId;
    private String buildName;
    private String buildEnvironment;
    private String buildVersion;
    private String buildGroupId;
    private String buildArtifactId;

    public static VersionDto getInstance() {
        return INSTANCE;
    }


    private static VersionDto load() {
        VersionDto version = new VersionDto();
        Properties properties = loadProperties();
        version.setBuildTime(properties.getProperty("git.build.time"));
        version.setUpdateTime(properties.getProperty("git.commit.time"));
        version.setBuildEnvironment(properties.getProperty("Build-Jdk"));
        version.setBuildName(properties.getProperty("git.build.user.name"));
        version.setBuildVersion(properties.getProperty("git.build.version"));
        version.setCommitId(properties.getProperty("git.commit.id"));
        version.setBuildGroupId(properties.getProperty("groupId"));
        version.setBuildArtifactId(properties.getProperty("artifactId"));
        return version;
    }


    private static Properties loadProperties() {
        Properties properties = new Properties();
        try {
            Enumeration<URL> en = Thread.currentThread().getContextClassLoader().getResources("META-INF/MANIFEST.MF");
            loadValue(en, properties);
            en = Thread.currentThread().getContextClassLoader().getResources("META-INF/common/git.properties");
            loadValue(en, properties);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }


    private static void loadValue(Enumeration<URL> en, Properties properties) throws IOException {
        while (en.hasMoreElements()) {
            URL url = en.nextElement();
            if (url.getPath().contains("BOOT-INF")) {
                continue;
            }
            InputStream is = url.openStream();
            properties.load(is);

        }
    }


    public String getCommitId() {
        return commitId;
    }

    public void setCommitId(String commitId) {
        this.commitId = commitId;
    }

    public String getBuildName() {
        return buildName;
    }

    public void setBuildName(String buildName) {
        this.buildName = buildName;
    }

    public String getBuildEnvironment() {
        return buildEnvironment;
    }

    public void setBuildEnvironment(String buildEnvironment) {
        this.buildEnvironment = buildEnvironment;
    }

    public String getBuildVersion() {
        return buildVersion;
    }

    public void setBuildVersion(String buildVersion) {
        this.buildVersion = buildVersion;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getBuildTime() {
        return buildTime;
    }

    public void setBuildTime(String buildTime) {
        this.buildTime = buildTime;
    }

    public String getBuildGroupId() {
        return buildGroupId;
    }

    public void setBuildGroupId(String buildGroupId) {
        this.buildGroupId = buildGroupId;
    }

    public String getBuildArtifactId() {
        return buildArtifactId;
    }

    public void setBuildArtifactId(String buildArtifactId) {
        this.buildArtifactId = buildArtifactId;
    }
}
