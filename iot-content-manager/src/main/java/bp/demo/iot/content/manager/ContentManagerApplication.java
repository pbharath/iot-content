package bp.demo.iot.content.manager;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
        "bp.demo.iot.content.manager",
        "bp.demo.iot.content.kafka"})
public class ContentManagerApplication {

  public static void main(String[] args) {
    SpringApplication.run(ContentManagerApplication.class, args);
  }

  @Bean
  public ModelMapper modelMapper(){
    return  new ModelMapper();
  }

}
