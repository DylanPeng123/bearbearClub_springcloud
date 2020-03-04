package club.bearbear.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * ClassName MyParamGatewayFilterFactory
 *
 * @author Dylan
 * @description 局部过滤器
 * @createDate 2020-02-27 20:18
 */
@Component
public class MyParamGatewayFilterFactory extends AbstractGatewayFilterFactory<MyParamGatewayFilterFactory.Config> {

    static String PARAM_NAME = "param";

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList(PARAM_NAME);
    }

    public MyParamGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            //获取请求参数中param对应的参数名的参数值
            ServerHttpRequest request = exchange.getRequest();

            if (request.getQueryParams().containsKey(config.param)) {
                List<String> strings = request.getQueryParams().get(config.param);
                strings.forEach(value -> System.out.printf("---------------局部过滤器---------%s = %s---", config.param, value));
            }
            return chain.filter(exchange);
        };
    }

    public static class Config {
        //对应在配置过滤器的时候指定的参数名
        private String param;

        public String getParam() {
            return param;
        }

        public void setParam(String param) {
            this.param = param;
        }
    }

}
