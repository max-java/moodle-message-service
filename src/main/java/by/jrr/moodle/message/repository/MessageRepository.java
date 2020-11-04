package by.jrr.moodle.message.repository;

import by.jrr.moodle.message.bean.Message;
import by.jrr.moodle.message.bean.MessageStatus;
import by.jrr.moodle.message.bean.MessageType;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface MessageRepository extends PagingAndSortingRepository<Message, Long> {

    List<Message> findFirstByTelegramStatusAndAndMessageType(MessageStatus status, MessageType type);
}
