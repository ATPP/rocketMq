package com.hom.common.produce;

import com.hom.common.conf.ProduceConf;
import com.hom.util.ObjectAndBytes;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.common.MixAll;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.logging.InternalLogger;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class RocketMqProduce {

    private static final Logger logger = LoggerFactory.getLogger(RocketMqProduce.class);

    private ProduceConf produceConf = new ProduceConf();
    private DefaultMQProducer producer;

    public RocketMqProduce() {
    }

    public void init() throws MQClientException {
//        MixAll.printObjectProperties((InternalLogger) logger, this);
        this.producer = new DefaultMQProducer(this.produceConf.getGroupName());
        this.producer.setNamesrvAddr(this.produceConf.getNamesrvAddr());
        this.producer.setInstanceName("RocketMqProduce" + UUID.randomUUID().toString());
        this.producer.setRetryAnotherBrokerWhenNotStoreOK(this.produceConf.isRetryAnotherBrokerWhenNotStoreOK());
        this.producer.start();
    }

    public void destroy(){
        producer.shutdown();
    }

    public void send(String topic, Object message) {
        try {
            Message msg = new Message();
            msg.setTopic(topic);
            msg.setBody(ObjectAndBytes.objectToByteArray(message));
            SendResult sendResult = this.producer.send(msg);
            SendStatus sendStatus = sendResult.getSendStatus();
            logger.info("sendResult:" + sendResult);
            logger.info("sendStatus:" + sendStatus);
        } catch (MQClientException e) {
            e.printStackTrace();
        } catch (RemotingException e) {
            e.printStackTrace();
        } catch (MQBrokerException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public DefaultMQProducer getProducer() {
        return producer;
    }

}
