package by.jrr.moodle.message.bean;

import lombok.Data;
import rx.BackpressureOverflow;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
public class Message {

    @Id
    @GeneratedValue
    private UUID Uuid;
    private LocalDateTime timeStamp;

    @Enumerated(value = EnumType.STRING)
    MessageStatus telegramStatus;
    @Enumerated(value = EnumType.STRING)
    MessageStatus eMailStatus;

    @Lob
    private String messageText;
}
