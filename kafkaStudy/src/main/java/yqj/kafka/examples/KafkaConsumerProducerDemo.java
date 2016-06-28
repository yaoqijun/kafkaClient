package yqj.kafka.examples;

/**
 * Created by yaoqijun.
 * Date:2016-06-29
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
public class KafkaConsumerProducerDemo {
    public static void main(String[] args) {
        LocalProducer localProducer = new LocalProducer(KafkaProperties.topic);
        localProducer.start();

        LocalConsumer localConsumer = new LocalConsumer(KafkaProperties.topic);
        localConsumer.start();
    }
}
