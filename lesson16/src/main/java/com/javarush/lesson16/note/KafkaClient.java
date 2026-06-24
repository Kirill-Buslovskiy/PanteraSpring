package com.javarush.lesson16.note;

import com.javarush.lesson16.note.model.NoteEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;
import java.time.Duration;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeoutException;

@EnableKafka
@Component
@RequiredArgsConstructor
public class KafkaClient {

    public static final String REQUEST_TOPIC = "InTopic";
    public static final String RESPONSE_TOPIC = "OutTopic";
    private final KafkaTemplate<String, String> sender;
    private final ObjectMapper json;
    private final ConcurrentHashMap<UUID, Sinks.One<NoteEvent>> kafkaCache = new ConcurrentHashMap<>();
    private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(1000);

    public Mono<NoteEvent> sync(NoteEvent noteEvent) {
        UUID uuid = UUID.randomUUID();
        Sinks.One<NoteEvent> sink = Sinks.one();
        kafkaCache.put(uuid, sink);
        try {
            sender.send(REQUEST_TOPIC, uuid.toString(), json.writeValueAsString(noteEvent));
        } catch (Exception e) {
            kafkaCache.remove(uuid);
            return Mono.error(new RuntimeException("Serialization error", e));
        }
        return sink.asMono()
                .timeout(DEFAULT_TIMEOUT)
                .doOnTerminate(() -> kafkaCache.remove(uuid))
                .onErrorMap(TimeoutException.class, e -> new TimeoutException("Kafka request timed out"));
    }

    @KafkaListener(topics = RESPONSE_TOPIC, groupId = "groupId=#{T(java.util.UUID).randomUUID().toString()}")
    private void processNote(ConsumerRecord<String, String> record) {
        try {
            UUID uuid = UUID.fromString(record.key());
            Sinks.One<NoteEvent> sink = kafkaCache.get(uuid);
            if (sink != null) {
                String payload = record.value();
                com.fasterxml.jackson.databind.JsonNode root = json.readTree(payload);
                NoteEvent result = root.has("noteResponseTos")
                        ? json.readValue(payload, NoteEvent.class)
                        : new NoteEvent(json.readValue(payload, NoteEvent.class).noteResponseTos());
                sink.tryEmitValue(result);
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
}