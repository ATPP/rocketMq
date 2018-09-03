package com.hom.common.produce;

import com.hom.common.conf.ProduceConf;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.MixAll;
import org.apache.rocketmq.logging.InternalLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class RocketMqProduce {

    private static final Logger logger = LoggerFactory.getLogger(RocketMqProduce.class);

    private ProduceConf produceConf = new ProduceConf();
    private DefaultMQProducer producer;

    public RocketMqProduce() {
    }

    public void init() {
        MixAll.printObjectProperties((InternalLogger) logger, this);
        logger.info("mylog");
        this.producer = new DefaultMQProducer(this.produceConf.getGroupName());
        this.producer.setNamesrvAddr(this.produceConf.getNamesrvAddr());
        this.producer.setInstanceName("RocketMqProduce" + UUID.randomUUID().toString());
        this.producer.setRetryAnotherBrokerWhenNotStoreOK(this.produceConf.isRetryAnotherBrokerWhenNotStoreOK());
    }

    public void send(String topic, Object message) {

    }
}
