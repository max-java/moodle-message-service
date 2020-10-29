package by.jrr.moodle.message.controller.ui;

import by.jrr.moodle.message.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MessagesController {

    @Autowired
    MessageRepository messageRepository;

    @GetMapping("/listMessages")
    public ModelAndView listAllMessages() {
        var mov = new ModelAndView();
        mov.addObject("messageList", messageRepository.findAll());
        mov.setViewName("listMessages");
        return mov;
    }
}
