package com.hom.common.conf;

public class ConsumerConf {
    private String namesrvAddr = "127.0.0.1:9876";
    private String groupName = "LOG-MQ-ROCKET-GROUP";
    private int codec = 0;
    private boolean broadcasting = false;

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

    public boolean isBroadcasting() {
        return broadcasting;
    }

    public void setBroadcasting(boolean broadcasting) {
        this.broadcasting = broadcasting;
    }
}
