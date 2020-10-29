package by.jrr.moodle.message.controller.api;

import by.jrr.moodle.message.bean.Message;
import by.jrr.moodle.message.bean.MessageStatus;
import by.jrr.moodle.message.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
public class MessageSearchController {

    @Autowired
    MessageRepository messageRepository;


    @GetMapping("mysearch/messages")
    public List<Message> findAllByTelegramStatus(@RequestParam Map<String, String> params) {
        try {
           return messageRepository.findAllByTelegramStatus(MessageStatus.valueOf(params.get("telegramStatus")));
        }catch (Exception ex) {
            // TODO: 30/10/2020 use ObjectMapper
        }
        return Collections.EMPTY_LIST;
    }
}
