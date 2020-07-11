package cn.cqucc.library.es.client;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author JianfeiChen
 * @date 2020/7/3 17:34
 * @Description cn.cqucc.library.es.client
 */
@Configuration
// 指定扫描路径只要类名没有，类的包名会自动加载
@ComponentScan(basePackageClasses = ESClientPoolFactory.class)
public class ESConfig {

    @Value("${hostname}")
    private String hostName;

    @Value("${port}")
    private int port;

    @Value("${scheme}")
    private String scheme;

    @Bean
    public HttpHost httpHost() {
        return new HttpHost(hostName, port, scheme);
    }

    @Bean(initMethod = "init",destroyMethod = "close")
    public ESClientPoolFactory getFactory(){
        return ESClientPoolFactory.build(httpHost());
    }

    @Bean
    @Scope("singleton")
    public RestHighLevelClient getRestHighLevelClient() {
        return getFactory().getClient();
    }

    public static void main(String[] args) {
        ESConfig esConfig = new ESConfig();
        System.out.println("esConfig = " + esConfig.toString());
    }

}
