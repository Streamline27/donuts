package lv.citadele.rabbit.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    private final MessageDao dao;
    private final MessageProducer producer;

    @Autowired
    public MessageController(MessageDao dao, MessageProducer producer) {
        this.dao = dao;
        this.producer = producer;
    }

    @GetMapping("/messages/{text}")
    public String create(@PathVariable("text") String text) {
        producer.send(text);
        return "Great success";
    }

    @GetMapping("/messages")
    public Iterable<Message> save() {
        return dao.findFirst10ByOrderByDateTimeDesc();
    }
}
