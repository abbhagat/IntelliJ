package com.kafka.streams.order.launcher;

import com.kafka.streams.order.topology.OrdersTopology;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import java.util.List;
import java.util.Properties;
import static com.kafka.streams.order.Util.BROKER_LIST;
import static com.kafka.streams.order.Util.LATEST;

@Slf4j
public class OrdersKafkaStreamApp {

    private static final Properties config = new Properties();

    static {
        config.put(StreamsConfig.APPLICATION_ID_CONFIG, "orders-app");
        config.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, BROKER_LIST);
        config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, LATEST);

        TopicUtil.createTopics(config, List.of(TopicUtil.ORDERS, TopicUtil.STORES));
    }

    public static void main(String[] args) {
        Topology topology = OrdersTopology.buildTopology();
        var kafkaStreams = new KafkaStreams(topology, config);
        Runtime.getRuntime().addShutdownHook(new Thread(kafkaStreams::close));  //This closes the streams anytime the JVM shuts down normally or abruptly.
        try{
            kafkaStreams.start();
        }catch (Exception e ){
            log.error("Exception in starting the Streams : {}", e.getMessage(), e);
        }
    }
}
