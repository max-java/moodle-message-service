package by.jrr.moodle.message.controller.api;

import by.jrr.moodle.message.bean.Message;
import by.jrr.moodle.message.bean.MessageStatus;
import by.jrr.moodle.message.bean.MessageType;
import by.jrr.moodle.message.model.Endpoint;
import by.jrr.moodle.message.repository.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
public class MessageSearchController {

    Logger logger = LoggerFactory.getLogger(MessageSearchController.class);

    @Autowired
    MessageRepository messageRepository;


    @GetMapping(Endpoint.NEW_USER_CONTACTS_FOR_TELEGRAM)
    public List<Message> findFirstDataByTelegramStatus(@RequestParam Map<String, String> params) {
        try {
            return messageRepository.findFirstByTelegramStatusAndAndMessageType(
                    MessageStatus.valueOf(params.get("telegramStatus")),
                    MessageType.valueOf(params.get("type"))); //todo: consider to remove param type.
        } catch (Exception ex) {
            // TODO: 30/10/2020 use ObjectMapper
        }
        return Collections.EMPTY_LIST;
    }

    @GetMapping(Endpoint.NEW_MESSAGES_FOR_TELEGRAM)
    public List<Message> findFirstNewMessageByTelegramStatus() {
        try {
            return messageRepository.findFirstByTelegramStatusAndAndMessageType(MessageStatus.NEW, MessageType.MESSAGE);
        } catch (Exception ex) {
            logger.debug("no new messages found for telegram to deliver");
        }
        return Collections.EMPTY_LIST;
    }
}
