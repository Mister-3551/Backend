package pintar.gasper.backend.webApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import pintar.gasper.backend.webApp.object.FollowingFollowers;
import pintar.gasper.backend.webApp.object.Message;
import pintar.gasper.backend.webApp.repository.MessengerRepository;

import java.util.ArrayList;

@Component
public class MessengerService {

    private MessengerRepository messengerRepository;

    @Autowired
    public MessengerService(MessengerRepository messengerRepository) {
        this.messengerRepository = messengerRepository;
    }

    public ArrayList<FollowingFollowers> getUserMessengerFriends(@RequestParam(name = "idUser") String idUser) {
        String[] list = messengerRepository.getUserMessengerFriends(idUser);
        ArrayList<FollowingFollowers> friends = new ArrayList();
        for (String string : list) {
            var word = string.split(",");
            friends.add(new FollowingFollowers(Long.parseLong(word[0]), word[1], Integer.parseInt(word[2])));
        }
        return friends;
    }

    public ArrayList<Message> getConversation(String idUser, String username) {
        String[] list = messengerRepository.getConversation(idUser, username);
        ArrayList<Message> friends = new ArrayList();
        for (String string : list) {
            var word = string.split(",");
            friends.add(new Message(Long.parseLong(word[0]), word[1], word[2]));
        }
        return friends;
    }
}
