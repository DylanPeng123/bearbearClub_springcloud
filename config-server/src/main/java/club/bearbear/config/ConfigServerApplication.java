package club.bearbear.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * ClassName ConfigServerApplication
 *
 * @author Dylan
 * @description TODO
 * @createDate 2020-03-04 11:12
 */
@SpringBootApplication
//开启配置服务
@EnableConfigServer
public class ConfigServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}
