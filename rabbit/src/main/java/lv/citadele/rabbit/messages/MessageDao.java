package lv.citadele.rabbit.messages;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface MessageDao extends CrudRepository<Message, Long> {
    List<Message> findFirst10ByOrderByDateTimeDesc();
}
