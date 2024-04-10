package com.tn.demoavro.s.serializer;

import lombok.extern.slf4j.Slf4j;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.Decoder;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificRecordBase;
import org.apache.kafka.common.serialization.Deserializer;

import java.lang.reflect.Constructor;
import java.util.Map;

@Slf4j
public class AvroDeserializer<T extends SpecificRecordBase> implements Deserializer {

    protected final Class<T> targetType;

    public AvroDeserializer(Class<T> targetType) {
        this.targetType = targetType;
    }

    @Override
    public void configure(Map configs, boolean isKey) {
    }

    @Override
    public T deserialize(String topic, byte[] bytes) {
        T returnObject = null;
        try{
            if(bytes != null && bytes.length > 0) {
                log.info("Received {} bytes for deserialization", bytes.length);
                Constructor<T> constructor = targetType.getConstructor();
                T recordInstance =  constructor.newInstance();

                DatumReader<GenericRecord> datumReader = new SpecificDatumReader<>(recordInstance.getSchema());
                Decoder decoder = DecoderFactory.get().binaryDecoder(bytes, null);
                returnObject = (T) datumReader.read(null, decoder);
                log.info("Deserialized data={}",returnObject.toString());
            } else {
                log.warn("Received empty or null byte array for deserialization");
            }
        }catch (Exception e){
            log.error("Unable to deserialize bytes[] ", e);
        }
        return returnObject;
    }

    @Override
    public void close() {
       // Deserializer.super.close();
    }
}
