package by.jrr.moodle.message.controller.api;

import by.jrr.moodle.message.bean.Message;
import by.jrr.moodle.message.model.Endpoint;
import by.jrr.moodle.message.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageController {
//todo consider finding new messages based on user profile id.

    @Autowired
    MessageRepository messageRepository;

    @CrossOrigin
    @GetMapping(Endpoint.SELECT_MESSAGES_BY_CHAT_ID+"/{chatToken}")
    public List<Message> selectMessagesByChatToken(@PathVariable String chatToken) {
        return messageRepository.findAllByChatToken(chatToken);
    }
}
