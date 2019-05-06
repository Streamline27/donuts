package lv.citadele.rabbit.messages;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    private final MessageDao dao;
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public MessageController(MessageDao dao, RabbitTemplate rabbitTemplate) {
        this.dao = dao;
        this.rabbitTemplate = rabbitTemplate;
    }

    @GetMapping("/messages/{text}")
    public String create(@PathVariable("text") String text) {
        rabbitTemplate.convertAndSend("test.delay-fanout", "", text, m -> {
            m.getMessageProperties().getHeaders().put("x-delay", 5000);
            return m;
        });

        return "Great success";
    }

    @GetMapping("/messages")
    public Iterable<Message> save() {
        return dao.findFirst10ByOrderByDateTimeDesc();
    }
}
