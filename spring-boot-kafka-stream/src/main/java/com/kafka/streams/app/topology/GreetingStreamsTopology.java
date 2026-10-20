package com.kafka.streams.app.topology;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.streams.app.model.Greeting;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Printed;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.support.serializer.JsonSerde;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class GreetingStreamsTopology {

  @Value("${topic.greetings.input.name:greetings}")
  private String GREETINGS;

  @Value("${topic.greetings.output.name:greetings-output}")
  private String GREETINGS_OUTPUT;

  private final ObjectMapper objectMapper;

  public GreetingStreamsTopology(ObjectMapper objectMapper) {
    this.objectMapper = objectMapper;
  }

  //  @Autowired
  public void processMessage(StreamsBuilder streamsBuilder) {
    KStream<String, String> greetingsStream = streamsBuilder.stream(GREETINGS, Consumed.with(Serdes.String(), Serdes.String()));
    greetingsStream.print(Printed.<String, String>toSysOut().withLabel("with-greetings-stream"));
    KStream<String, String> modifiedStream = greetingsStream.mapValues((readOnlyKey, value) -> value.toUpperCase());
    modifiedStream.print(Printed.<String, String>toSysOut().withLabel("with-modified-stream"));
    modifiedStream.to(GREETINGS_OUTPUT, Produced.with(Serdes.String(), Serdes.String()));
  }

  // Adding Custom Serde
  @Autowired
  public void process(StreamsBuilder streamsBuilder) {
    KStream<String, Greeting> greetingsStream = streamsBuilder.stream(GREETINGS, Consumed.with(Serdes.String(), new JsonSerde<>(Greeting.class, objectMapper)));
    greetingsStream.print(Printed.<String, Greeting>toSysOut().withLabel("with-greetings-stream"));
    KStream<String, Greeting> modifiedStream = greetingsStream.mapValues((readOnlyKey, value) -> {
      if (value.message().equals("Error")) {
        throw new RuntimeException("Error processing message: " + value.message());
      }
      return new Greeting(value.message().toUpperCase(), value.timeStamp());
    });
    modifiedStream.print(Printed.<String, Greeting>toSysOut().withLabel("with-modified-stream"));
    modifiedStream.to(GREETINGS_OUTPUT, Produced.with(Serdes.String(), new JsonSerde<>(Greeting.class, objectMapper)));
  }

}
