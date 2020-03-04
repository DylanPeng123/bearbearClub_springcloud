package club.bearbear.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * ClassName EurekaServerApplication
 *
 * @author Dylan
 * @description eureka服务端
 * @createDate 2020-03-04 10:49
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnableEurekaServer.class,args);
    }

}
