package lv.citadele.rabbit.messages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MessageConsumer {

    private static final Logger LOG = LoggerFactory.getLogger(MessageConsumer.class);

    private final MessageDao dao;

    @Autowired
    public MessageConsumer(MessageDao dao) {
        this.dao = dao;
    }

    @RabbitListener(queues = "test.delayed-destination")
    public void receiveMessage(String text) {
        Message message = Message.builder()
                .text(text)
                .dateTime(LocalDateTime.now())
                .build();

        LOG.info("Received message:[{}]", text);
        dao.save(message);
    }
}
