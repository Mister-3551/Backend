package pintar.gasper.backend.webApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import pintar.gasper.backend.webApp.entity.messenger.Message;
import pintar.gasper.backend.webApp.entity.messenger.MessengerEntity;
import pintar.gasper.backend.webApp.entity.users.UsersEntity;
import pintar.gasper.backend.webApp.repository.MessengerRepository;
import pintar.gasper.backend.webApp.service.time.TimeChanger;

import java.util.ArrayList;

@Component
public class MessengerService {

    private MessengerRepository messengerRepository;

    @Autowired
    public MessengerService(MessengerRepository messengerRepository) {
        this.messengerRepository = messengerRepository;
    }

    public ArrayList<UsersEntity> getUserMessengerFriends(@RequestParam(name = "idUser") String idUser) {
        var list = messengerRepository.getUserMessengerFriends(idUser);
        ArrayList<UsersEntity> friends = new ArrayList<>();

        for (String string : list) {
            var word = string.split(",");
            friends.add(new UsersEntity(Long.parseLong(word[0]), word[1], Integer.parseInt(word[2]), word[3]));
        }
        return friends;
    }

    public ArrayList<Message> getConversation(String idUser, String username) {
        var conversation = messengerRepository.getConversation(idUser, username);
        ArrayList<Message> messages = new ArrayList<>();

        for (MessengerEntity message : conversation) {
            messages.add(new Message(message.getId(), message.getIdUser(), message.getText(), TimeChanger.calculateTime(message.getYears(), message.getMonths(), message.getWeeks(), message.getDays(), message.getHours(), message.getMinutes())));
        }
        return messages;
    }
}
