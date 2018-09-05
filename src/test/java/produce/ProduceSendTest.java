package produce;

import com.hom.common.consumer.RocketMqConsumer;
import com.hom.common.produce.RocketMqProduce;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProduceSendTest {
    private ApplicationContext container;

    @Before
    public void setup() {
        container = new ClassPathXmlApplicationContext("classpath:spring-producer.xml");
    }

    @Test
    public void sendMessage() throws Exception {
        RocketMqProduce producer = container.getBean(RocketMqProduce.class);
        for (int i = 0; i < 20; i++) {
            //创建一条消息对象，指定其主题、标签和消息内容
            Message msg = new Message(
                    "homTopic",
                    null,
                    ("Spring RocketMQ demo " + i).getBytes(RemotingHelper.DEFAULT_CHARSET) /* 消息内容 */
            );
            //发送消息并返回结果
            SendResult result = producer.getProducer().send(msg);
//            producer.send("diffebnTopic","消息"+i);
//            System.out.printf("%s%n", sendResult);
        }
    }
}
