package lv.citadele.rabbit.messages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageProducer {

    private static final Integer MESSAGE_DELAY_MILLIS = 15000;

    private static final Logger LOG = LoggerFactory.getLogger(MessageProducer.class);

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public MessageProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send(String text) {
        LOG.info("Sending message:[{}]", text);
        rabbitTemplate.convertAndSend("test.delay-fanout", "", text, this::addDelayHeader);
    }

    private Message addDelayHeader(Message rabbitMsg) {
        rabbitMsg.getMessageProperties().getHeaders().put("x-delay", MESSAGE_DELAY_MILLIS);
        return rabbitMsg;
    }
}
