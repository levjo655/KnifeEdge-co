package Mojodoo.KnifeEdge.co.services;

import Mojodoo.KnifeEdge.co.models.User;
import Mojodoo.KnifeEdge.co.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public User createUser(User user){
        return userRepository.save(user);
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public User getUserById( String id) {
        try {
            return userRepository.findById(id).get();

        } catch (NoSuchElementException exception) {
            System.out.println("Could not find the requessted user");
            throw exception;
        }
    }
    public User updateUser (User user){
        return userRepository.save(user);
    }

    public String deleteUser ( String id){
        userRepository.deleteById(id);
        return "User deleted";
    }
}