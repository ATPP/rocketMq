package produce;

import com.hom.common.produce.RocketMqProduce;
import org.junit.Test;

public class produceSendTest {
    private RocketMqProduce rocketMqProduce = new RocketMqProduce();

    @Test
    public void send(){
        rocketMqProduce.init();
    }
}
