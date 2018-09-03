package com.hom.common.conf;

public class ProduceConf {
    private String namesrvAddr = "127.0.0.1:9876";
    private String groupName = "LOG-MQ-ROCKET-GROUP";
    private int codec = 0;
    private int retryTimes = 0;
    private boolean isRetryAnotherBrokerWhenNotStoreOK = true;
    private boolean isAsync = false;
    private boolean isRetryTooMuchRequest = false;

    public String getNamesrvAddr() {
        return namesrvAddr;
    }

    public void setNamesrvAddr(String namesrvAddr) {
        this.namesrvAddr = namesrvAddr;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getCodec() {
        return codec;
    }

    public void setCodec(int codec) {
        this.codec = codec;
    }

    public int getRetryTimes() {
        return retryTimes;
    }

    public void setRetryTimes(int retryTimes) {
        this.retryTimes = retryTimes;
    }

    public boolean isRetryAnotherBrokerWhenNotStoreOK() {
        return isRetryAnotherBrokerWhenNotStoreOK;
    }

    public void setRetryAnotherBrokerWhenNotStoreOK(boolean retryAnotherBrokerWhenNotStoreOK) {
        isRetryAnotherBrokerWhenNotStoreOK = retryAnotherBrokerWhenNotStoreOK;
    }

    public boolean isAsync() {
        return isAsync;
    }

    public void setAsync(boolean async) {
        isAsync = async;
    }

    public boolean isRetryTooMuchRequest() {
        return isRetryTooMuchRequest;
    }

    public void setRetryTooMuchRequest(boolean retryTooMuchRequest) {
        isRetryTooMuchRequest = retryTooMuchRequest;
    }
}
