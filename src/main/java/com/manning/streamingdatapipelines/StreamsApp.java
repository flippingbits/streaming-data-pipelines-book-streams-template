package com.manning.streamingdatapipelines;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;

public class StreamsApp {
    private static final Logger logger =
            LoggerFactory.getLogger(StreamsApp.class);
    private static ObjectMapper objectMapper;

    private static final List<List<String>> PATH_ALIASES_LIST = Arrays.asList(
            Arrays.asList("/products", "/catalog"),
            Arrays.asList("/", "/home")
    );

    private static final String DEFAULT_DOMAIN = "excellenttoys.org";

    public static void main(final String[] args) {
        objectMapper = new ObjectMapper();

        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "mask-ip-addresses");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");

        final StreamsBuilder builder = new StreamsBuilder();

        // TODO

        final KafkaStreams streams = new KafkaStreams(builder.build(), props);

        try {
            streams.cleanUp();
            streams.start();
        } catch (Throwable e) {
            logger.error("Error while running Kafka Streams app", e);
            System.exit(1);
        }
    }
}
