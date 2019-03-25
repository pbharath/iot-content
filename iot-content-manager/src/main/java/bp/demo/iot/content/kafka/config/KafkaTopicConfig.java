package bp.demo.iot.content.kafka.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
@PropertySource(value = {"classpath:iot-content-kafka.properties"})
public class KafkaTopicConfig {

  @Value(value = "${bp.demo.iot.content.kafka.brokerlist}")
  private String bootstrapAddress;

  @Value(value = "${bp.demo.iot.operation.kafka.event.content.access.topic}")
  private String contentAccessTopicName;

  @Bean
  public KafkaAdmin kafkaAdmin() {
    Map<String, Object> configs = new HashMap<>();
    configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
    return new KafkaAdmin(configs);
  }

  @Bean
  public NewTopic contentAccessTopic() {
    return new NewTopic(contentAccessTopicName, 1, (short) 1);
  }
}
