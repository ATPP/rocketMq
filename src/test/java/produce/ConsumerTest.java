package produce;

import com.hom.common.consumer.RocketMqConsumer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ConsumerTest {

//    private ApplicationContext container;
//
//    @Before
//    public void setup() {
//        container = new ClassPathXmlApplicationContext("classpath:spring-consumer.xml");
//    }

    @Autowired
    @Qualifier("consumer")
    private RocketMqConsumer consumer;

    @Test
    public void consume() throws Exception {
//        RocketMqConsumer consumer = container.getBean(RocketMqConsumer.class);
        Thread.sleep(200 * 1000);
        consumer.destroy();
    }
}
