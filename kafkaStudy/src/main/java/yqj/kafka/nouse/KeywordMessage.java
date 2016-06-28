package yqj.kafka.nouse;

import kafka.serializer.Encoder;

/**
 * Created by yaoqijun.
 * Date:2015-05-15
 * Email:yaoqj@terminus.io
 * Descirbe:
 */
public class KeywordMessage implements Encoder<Keyword> {

    public byte[] toBytes(Keyword keyword) {
        return keyword.toString().getBytes();
    }
}
