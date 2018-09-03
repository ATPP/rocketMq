package produce;

import com.hom.common.consumer.RocketMqConsumer;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsumerTest {

    private ApplicationContext container;

    @Before
    public void setup() {
        container = new ClassPathXmlApplicationContext("classpath:spring-consumer.xml");
    }

    @Test
    public void consume() throws Exception {
        RocketMqConsumer consumer = container.getBean(RocketMqConsumer.class);
        Thread.sleep(200 * 1000);
        consumer.destroy();
    }
}
