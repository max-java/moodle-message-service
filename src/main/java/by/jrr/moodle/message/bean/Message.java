package by.jrr.moodle.message.bean;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
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
    @CreationTimestamp
    private LocalDateTime timeStamp;
    @UpdateTimestamp
    private LocalDateTime lastUpdate;

    String chatToken;
    Long userProfileId;


    @Enumerated(value = EnumType.STRING)
    MessageStatus telegramStatus;
    @Enumerated(value = EnumType.STRING)
    MessageStatus eMailStatus;

    @Lob
    private String messageText;

    @Enumerated(value = EnumType.STRING)
    MessageType type;

}
