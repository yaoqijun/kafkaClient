package yqj.kafka.nouse;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by yaoqijun.
 * Date:2015-05-15
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
public class ProducerCli {
    public static void main(String []args){
        /**配置producer必要的参数*/
        Properties props = new Properties();
        props.put("zk.connect", "localhost:2181");
        /**选择用哪个类来进行序列化*/
        props.put("serializer.class", "org.gfg.kafka.message.KeywordMessage");
        props.put("zk.connectiontimeout.ms", "6000");
        ProducerConfig config=new ProducerConfig(props);

        /**制造数据*/
        Keyword keyword=new Keyword();
        keyword.setUser("Chenhui");
        keyword.setId("123");
        keyword.setPassword("china");
        keyword.setDate("19909900");


        List<Keyword> msg=new ArrayList<Keyword>();
        msg.add(keyword);

        /**构造数据发送对象*/
        List<KeyedMessage<String, Keyword>> data = new ArrayList();
        KeyedMessage<String,Keyword> d1 = new KeyedMessage("test","test",keyword);
        data.add(d1);
        Producer<String, Keyword> producer= new Producer(config);
        producer.send(data);
    }
}
