package cn.test.druid.test;

//import org.junit.*;
//import org.elasticsearch.action.search.SearchResponse;
//import org.elasticsearch.client.transport.TransportClient;
//import org.elasticsearch.common.settings.Settings;
//import org.elasticsearch.common.transport.InetSocketTransportAddress;
//import org.elasticsearch.transport.client.PreBuiltTransportClient;
//import org.junit.After;
//import org.junit.Before;
//
//import java.net.InetAddress;
///**
// * @Auther jxy
// * @Date 2020-04-26
// */
//public class ElastaicTest {
//    protected TransportClient client;
//
//    @Before
//    public void setUp() throws Exception {
//
//        Settings esSettings = Settings.builder()
//                .put("cluster.name", "utan-es") //设置ES实例的名称
//                .put("client.transport.sniff", true) //自动嗅探整个集群的状态，把集群中其他ES节点的ip添加到本地的客户端列表中
//                .build();
//
//        /**
//         * 这里的连接方式指的是没有安装x-pack插件,如果安装了x-pack则参考{@link ElasticsearchXPackClient}
//         * 1. java客户端的方式是以tcp协议在9300端口上进行通信
//         * 2. http客户端的方式是以http协议在9200端口上进行通信
//         */
//        client = new PreBuiltTransportClient(esSettings)
//                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
//
//        System.out.println("ElasticsearchClient 连接成功");
//    }
//
//    @Test
//    public void testClientConnection() throws Exception {
//
//        System.out.println("--------------------------");
//    }
//
//
//    @After
//    public void tearDown() throws Exception {
//        if (client != null) {
//            client.close();
//        }
//
//    }
//
//}
