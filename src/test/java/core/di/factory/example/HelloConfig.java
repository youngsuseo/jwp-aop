package core.di.factory.example;

import core.annotation.Bean;
import core.annotation.Configuration;
import core.di.beans.factory.FactoryBean;
import next.factory.HelloFactoryBean;
import next.hello.Hello;

@Configuration
public class HelloConfig {

    @Bean
    public HelloFactoryBean helloFactoryBean() {
        return new HelloFactoryBean();
    }
}