package Mojodoo.KnifeEdge.co.services;

import Mojodoo.KnifeEdge.co.repository.UserRepository;
import Mojodoo.KnifeEdge.co.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public User createUser(User user){
        return userRepository.save(user);
    }
}
