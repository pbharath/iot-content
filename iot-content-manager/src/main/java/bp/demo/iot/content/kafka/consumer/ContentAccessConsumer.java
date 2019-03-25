package bp.demo.iot.content.kafka.consumer;

import bp.demo.iot.content.manager.model.ContentAccess;
import bp.demo.iot.content.manager.service.ContentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;

@Service
public class ContentAccessConsumer {
  private CountDownLatch contentAccessDataLatch = new CountDownLatch(1);

  private Logger logger =
          LoggerFactory.getLogger(ContentAccessConsumer.class);

  @Autowired
  private ContentService contentService;

  public CountDownLatch getContentAccessDataLatch() {
    return this.contentAccessDataLatch;
  }

  @KafkaListener(
          topics = "${bp.demo.iot.operation.kafka.event.content.access.topic}",
          containerFactory = "contentAccessDataKafkaListenerContainerFactory")
  public void carrierListener(ContentAccess contentAccess) {

    logger.info("Received content access data message: " + contentAccess);

    if(contentService.upsertContentAccess(contentAccess))
      logger.info("Persisted content access data message: " + contentAccess);
    else
      logger.error("Could not persist content access data message: " + contentAccess);

    this.getContentAccessDataLatch().countDown();
  }

}
