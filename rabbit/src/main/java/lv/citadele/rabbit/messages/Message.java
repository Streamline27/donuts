package lv.citadele.rabbit.messages;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Builder
@Entity
public class Message
{
    @Id
    @GeneratedValue
    private Long id;
    private String text;
}
