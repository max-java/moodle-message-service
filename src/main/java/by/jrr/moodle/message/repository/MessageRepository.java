package by.jrr.moodle.message.repository;

import by.jrr.moodle.message.bean.Message;
import by.jrr.moodle.message.bean.MessageStatus;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;
import java.util.UUID;

@RepositoryRestResource
public interface MessageRepository extends PagingAndSortingRepository<Message, UUID> {

    List<Message> findAllByTelegramStatus(MessageStatus status);
}