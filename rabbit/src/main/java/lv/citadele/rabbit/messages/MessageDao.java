package lv.citadele.rabbit.messages;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface MessageDao extends CrudRepository<Message, Long> {
}
