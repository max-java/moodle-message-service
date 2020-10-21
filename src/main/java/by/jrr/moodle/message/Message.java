package by.jrr.moodle.message;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Message {

    @Id
    @GeneratedValue
    private UUID courseId;

}
