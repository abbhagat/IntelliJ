package com.kafka.streams.app.topology;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Printed;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class GreetingStreamsTopology {

  @Value("${topic.greetings.input.name:greetings}")
  private String GREETINGS;

  @Value("${topic.greetings.output.name:greetings-output}")
  private String GREETINGS_OUTPUT;

  @Autowired
  public void process(StreamsBuilder streamsBuilder) {
    KStream<String, String> greetingsStream = streamsBuilder.stream(GREETINGS, Consumed.with(Serdes.String(), Serdes.String()));
    greetingsStream.print(Printed.<String, String>toSysOut().withLabel("with-greetings-stream"));
    KStream<String, String> modifiedStream = greetingsStream.mapValues((readOnlyKey, value) -> value.toUpperCase());
    modifiedStream.print(Printed.<String, String>toSysOut().withLabel("with-modified-stream"));
    modifiedStream.to(GREETINGS_OUTPUT, Produced.with(Serdes.String(), Serdes.String()));
  }

}
