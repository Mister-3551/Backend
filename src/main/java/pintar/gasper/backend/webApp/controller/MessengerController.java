package pintar.gasper.backend.webApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pintar.gasper.backend.webApp.entity.messenger.Message;
import pintar.gasper.backend.webApp.entity.users.UsersEntity;
import pintar.gasper.backend.webApp.service.MessengerService;

import java.util.ArrayList;

@RestController
public class MessengerController {

    private MessengerService messengerService;

    @Autowired
    public MessengerController(MessengerService messengerService) {
        this.messengerService = messengerService;
    }

    @PostMapping("/web-get-user-messenger-friends")
    public ArrayList<UsersEntity> getUserMessengerFriends(@RequestParam(name = "idUser") String idUser) {
        return messengerService.getUserMessengerFriends(idUser);
    }

    @PostMapping("/web-get-conversation")
    public ArrayList<Message> getConversation(@RequestParam(name = "idUser") String idUser, @RequestParam(name = "username") String username) {
        return messengerService.getConversation(idUser, username);
    }
}