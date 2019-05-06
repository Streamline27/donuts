package lv.citadele.rabbit.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    private final MessageDao dao;

    @Autowired
    public MessageController(MessageDao dao) {
        this.dao = dao;
    }

    @GetMapping("/messages")
    public Iterable<Message> save() {
        return dao.findFirst10ByOrderByDateTimeDesc();
    }
}
