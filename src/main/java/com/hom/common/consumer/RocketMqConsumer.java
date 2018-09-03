package com.hom.common.consumer;

import com.hom.common.conf.ConsumerConf;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class RocketMqConsumer {

    private static final Logger logger = LoggerFactory.getLogger(RocketMqConsumer.class);

    private DefaultMQPushConsumer consumer;
    private ConsumerConf consumerConf = new ConsumerConf();
    private MessageListenerConcurrently messageListener;
    private String topic;
    private String tag;

    public RocketMqConsumer(String topic ,MessageListenerConcurrently messageListener) {
        this.topic = topic;
        this.messageListener = messageListener;
    }


    public void init() throws Exception {
        this.consumer = new DefaultMQPushConsumer(this.consumerConf.getGroupName());
        this.consumer.setNamesrvAddr(this.consumerConf.getNamesrvAddr());
        this.consumer.setInstanceName("RocketMqConsumer:" + UUID.randomUUID().toString());
        this.consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        if (consumerConf.isBroadcasting()) {
            this.consumer.setMessageModel(MessageModel.BROADCASTING);
        }
        this.consumer.subscribe(topic, "*");
        this.consumer.setMessageListener(messageListener);
        this.consumer.start();
    }

    public void destroy(){
        consumer.shutdown();
    }

}
