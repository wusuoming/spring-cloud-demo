package com.luohuasheng.dto;


public class SystemInfoDto {
    private String vmName;
    private String vmVendor;
    private String vmVersion;
    private String runtimeName;
    private String runtimeVersion;
    private String osName;
    private String osVersion;
    private String cpu;
    private long maxMemory = 0L;
    private long totalMemory = 0L;
    private long freeMemory = 0L;


    public SystemInfoDto() {
        this.vmName = System.getProperty("java.vm.name", "");
        this.vmVendor = System.getProperty("java.vm.vendor");
        this.vmVersion = System.getProperty("java.vm.version");
        this.runtimeName = System.getProperty("java.runtime.name");
        this.runtimeVersion = System.getProperty("java.runtime.version");
        this.osName = System.getProperty("os.name");
        this.osVersion = System.getProperty("os.version");
        this.cpu = System.getProperty("sun.cpu.isalist");

        Runtime runtime = Runtime.getRuntime();
        this.maxMemory = runtime.maxMemory();
        this.totalMemory = runtime.totalMemory();
        this.freeMemory = runtime.freeMemory();
    }


    public String getVmName() {
        return this.vmName;
    }


    public void setVmName(String vmName) {
        this.vmName = vmName;
    }


    public String getVmVendor() {
        return this.vmVendor;
    }

    public void setVmVendor(String vmVendor) {
        this.vmVendor = vmVendor;
    }

    public String getVmVersion() {
        return this.vmVersion;
    }

    public void setVmVersion(String vmVersion) {
        this.vmVersion = vmVersion;
    }


    public String getRuntimeName() {
        return this.runtimeName;
    }


    public void setRuntimeName(String runtimeName) {
        this.runtimeName = runtimeName;
    }


    public String getRuntimeVersion() {
        return this.runtimeVersion;
    }


    public void setRuntimeVersion(String runtimeVersion) {
        this.runtimeVersion = runtimeVersion;
    }


    public String getOsName() {
        return this.osName;
    }


    public void setOsName(String osName) {
        this.osName = osName;
    }


    public String getOsVersion() {
        return this.osVersion;
    }


    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }


    public String getCpu() {
        return this.cpu;
    }


    public void setCpu(String cpu) {
        this.cpu = cpu;
    }


    public long getMaxMemory() {
        return this.maxMemory;
    }


    public void setMaxMemory(long maxMemory) {
        this.maxMemory = maxMemory;
    }


    public long getTotalMemory() {
        return this.totalMemory;
    }


    public void setTotalMemory(long totalMemory) {
        this.totalMemory = totalMemory;
    }


    public long getFreeMemory() {
        return this.freeMemory;
    }


    public void setFreeMemory(long freeMemory) {
        this.freeMemory = freeMemory;
    }
}
