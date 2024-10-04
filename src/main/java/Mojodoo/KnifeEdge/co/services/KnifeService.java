package Mojodoo.KnifeEdge.co.services;

import Mojodoo.KnifeEdge.co.models.Knife;
 import Mojodoo.KnifeEdge.co.models.User;
import Mojodoo.KnifeEdge.co.repository.KnifeRepository;
import Mojodoo.KnifeEdge.co.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


@Service

public class KnifeService {
    @Autowired
    KnifeRepository knifeRepository;
    @Autowired
    private UserRepository userRepository;

    public Knife createKnife( Knife knife){
        return knifeRepository.save(knife);
    }

    public List<Knife> getAllKnife(){
        return knifeRepository.findAll();
    }
    public Knife getKnifeById(String id){
        try {
            return knifeRepository.findById(id).get();
        } catch (NoSuchElementException exception){
            System.out.println("Could not find the requested Knife");
            throw exception;
        }

    }
    public Knife updateKnife(Knife knife){
        return knifeRepository.save(knife);
    }

    public String deleteKnife (String id) {
        knifeRepository.deleteById(id);
        return "Knife was deleted";

    }


    public Knife addKnifeToUser ( String userId, Knife knife){
        Knife savedKnife = knifeRepository.save(knife);
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        user.addKnife(new Knife());

        userRepository.save(user);
        return savedKnife;
    }


};
