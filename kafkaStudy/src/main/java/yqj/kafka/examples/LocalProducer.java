package yqj.kafka.examples;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

import java.util.Properties;

/**
 * Created by yaoqijun.
 * Date:2016-06-29
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
public class LocalProducer extends Thread {

    private final Producer<Integer,String> producer;

    private final String topic;

    private final Properties properties = new Properties();

    public LocalProducer(String topic)
    {
        properties.put("serializer.class", "kafka.serializer.StringEncoder");
        properties.put("metadata.broker.list", "localhost:9092");
        producer = new kafka.javaapi.producer.Producer<Integer, String>(new ProducerConfig(properties));
        this.topic = topic;
    }

    @Override
    public void run(){
        int messageNo = 1;
        try{
            while (true){
                String message = "Message _ " + messageNo;
                producer.send(new KeyedMessage<Integer, String>(topic, message));
                messageNo ++ ;
                Thread.sleep(1000);
            }
        }catch (Exception e){
            System.out.println("send message error cause error");
        }
    }

    /**
     * create data
     * @param args
     */
    public static void main(String[] args) {
        LocalProducer producer1 = new LocalProducer(KafkaProperties.topic2);
        LocalProducer producer2 = new LocalProducer(KafkaProperties.topic3);

        producer1.start();
        producer2.start();

    }
}
