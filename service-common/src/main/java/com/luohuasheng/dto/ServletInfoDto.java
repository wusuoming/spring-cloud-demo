
package com.luohuasheng.dto;

import com.google.common.collect.Lists;

import javax.servlet.ServletContext;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;


public class ServletInfoDto {
    private String serverInfo;
    private String servletVersion;
    private String localAddr;
    private String localName;

    private int serverPort = 80;
    private String contextPath;
    private List<String> consumers = Lists.newArrayList();
    private List<String> providers = Lists.newArrayList();
    private String name;

    public ServletInfoDto(ServletContext servletContext) {
        this.serverInfo = servletContext.getServerInfo();
        this.servletVersion = String.valueOf(servletContext.getMajorVersion()) + "." + servletContext.getMinorVersion();
        this.contextPath = servletContext.getSessionCookieConfig().getPath();
        localAddr = null;
        try {
            this.localAddr = InetAddress.getLocalHost().getHostAddress();
            this.localName= InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }


    public String getServerInfo() {
        return this.serverInfo;
    }


    public void setServerInfo(String serverInfo) {
        this.serverInfo = serverInfo;
    }


    public String getServletVersion() {
        return this.servletVersion;
    }


    public void setServletVersion(String servletVersion) {
        this.servletVersion = servletVersion;
    }


    public String getLocalAddr() {
        return this.localAddr;
    }


    public void setLocalAddr(String localAddr) {
        this.localAddr = localAddr;
    }


    public int getServerPort() {
        return this.serverPort;
    }


    public void setServerPort(int serverPort) {
        this.serverPort = serverPort;
    }


    public String getContextPath() {
        return this.contextPath;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getConsumers() {
        return consumers;
    }

    public void setConsumers(List<String> consumers) {
        this.consumers = consumers;
    }

    public List<String> getProviders() {
        return providers;
    }

    public void setProviders(List<String> providers) {
        this.providers = providers;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }
}
