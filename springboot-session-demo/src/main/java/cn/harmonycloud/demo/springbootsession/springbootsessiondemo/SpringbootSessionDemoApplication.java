package cn.harmonycloud.demo.springbootsession.springbootsessiondemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@EnableRedisHttpSession
public class SpringbootSessionDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSessionDemoApplication.class, args);
    }

}
