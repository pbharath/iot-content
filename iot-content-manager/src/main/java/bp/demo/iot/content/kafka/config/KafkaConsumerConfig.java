package bp.demo.iot.content.kafka.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;

import java.util.HashMap;
import java.util.Map;

@Configuration
@PropertySource(value = {"classpath:iot-content-kafka.properties"})
public class KafkaConsumerConfig {

  @Value(value = "${bp.demo.iot.content.kafka.brokerlist}")
  private String bootstrapAddress;


  public ConsumerFactory<String, String> contentAccessDataConsumerFactory() {
    Map<String, Object> props = new HashMap<>();
      props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
      props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
      props.put(ConsumerConfig.GROUP_ID_CONFIG, "Content - Content Access");
      return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(),
              new StringDeserializer());
  }

  @Bean
  public ConcurrentKafkaListenerContainerFactory<String, String>
    contentAccessDataKafkaListenerContainerFactory() {
      ConcurrentKafkaListenerContainerFactory<String, String> factory =
              new ConcurrentKafkaListenerContainerFactory<>();
      factory.setMessageConverter(new StringJsonMessageConverter());
      factory.setConsumerFactory(contentAccessDataConsumerFactory());
      return factory;
  }
}
