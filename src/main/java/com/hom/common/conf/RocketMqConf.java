package com.hom.common.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RocketMqConf {

    @Bean
    public ConsumerConf consumerConf(){
        return new ConsumerConf();
    }

    @Bean
    public ProduceConf produceConf(){
        return new ProduceConf();
    }
}
