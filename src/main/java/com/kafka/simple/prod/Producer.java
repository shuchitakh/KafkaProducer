package com.kafka.simple.prod;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * Consumer can be started as
 * kafka-console-consumer --bootstrap-server 127.0.0.1:9092 --topic first_topic --group first_app
 */
public class Producer {
  public static void main(String[] args) {

    //Create producer props
    Properties properties = new Properties();
    properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
    properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
    properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

    //Create producer
    KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

    //Send data
    ProducerRecord<String, String> record = new ProducerRecord<>("first_topic", "hello world");
    producer.send(record);
    producer.flush();
    producer.close();
  }
}
