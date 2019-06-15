package com.tianyou.exam;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(exclude = {
        RedisAutoConfiguration.class,
        RabbitAutoConfiguration.class})
@ImportResource(locations = {"classpath:applicationContext-all.xml"})
public class ExamApplication {

    public static void main(String[] args) {

        SpringApplication.run(ExamApplication.class, args);

    }

}
