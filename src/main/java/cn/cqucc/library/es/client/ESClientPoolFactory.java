package cn.cqucc.library.es.client;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

/**
 * @author JianfeiChen
 * @date 2020/7/6 8:54
 * @Description cn.cqucc.library.es.client
 */
public class ESClientPoolFactory {

    private static HttpHost httpHost;
    private  RestHighLevelClient client;
    // 项目运行后ESClientPoolFactory已经加入堆内存中，创建ESClientPoolFactory对象再分配一个对象堆空间。
    private static ESClientPoolFactory poolFactory = new ESClientPoolFactory();

    ESClientPoolFactory() {

    }

    public static ESClientPoolFactory build(HttpHost http) {
        httpHost =http;
        return poolFactory;
    }

    public  RestHighLevelClient getClient() {
        return client ;
    }

    public void init(){
        System.out.println("初始化Client："+httpHost.getHostName());
        client = new RestHighLevelClient(RestClient.builder(
                httpHost));
    }

    public void close() {
        System.out.println("close client");
        if (client != null) {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
