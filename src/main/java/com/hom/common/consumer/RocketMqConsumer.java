package com.hom.common.consumer;

import com.hom.common.conf.ConsumerConf;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

/**
 * 封装consumer
 */
public class RocketMqConsumer {

    private static final Logger logger = LoggerFactory.getLogger(RocketMqConsumer.class);

    private DefaultMQPushConsumer consumer;
//    private ConsumerConf consumerConf = new ConsumerConf();
    @Autowired
    private ConsumerConf consumerConf;
    private MessageListenerConcurrently messageListener;
    private String topic;
    private String tag;

    public RocketMqConsumer(String topic ,MessageListenerConcurrently messageListener) {
        this.topic = topic;
        this.messageListener = messageListener;
    }

    /**
     * 初始化consumer
     * @throws Exception
     */
    public void init() throws Exception {
        this.consumer = new DefaultMQPushConsumer(this.consumerConf.getGroupName());
        this.consumer.setNamesrvAddr(this.consumerConf.getNamesrvAddr());
        this.consumer.setInstanceName("RocketMqConsumer:" + UUID.randomUUID().toString());
        //默认什么位置开始消费
        this.consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        //消息模型
        if (consumerConf.isBroadcasting()) {
            this.consumer.setMessageModel(MessageModel.BROADCASTING);
        }
        //订阅关系
        this.consumer.subscribe(topic, tag);
        //消息监听器
        this.consumer.setMessageListener(messageListener);
        this.consumer.start();
    }

    public void destroy(){
        consumer.shutdown();
    }

}
