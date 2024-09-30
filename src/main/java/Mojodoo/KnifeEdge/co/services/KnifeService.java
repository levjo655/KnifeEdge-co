package Mojodoo.KnifeEdge.co.services;

import Mojodoo.KnifeEdge.co.models.Knife;
import Mojodoo.KnifeEdge.co.repository.KnifeRepository;
import Mojodoo.KnifeEdge.co.repository.UserRepository;
import Mojodoo.KnifeEdge.co.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service

public class KnifeService {
    @Autowired
    KnifeRepository knifeRepository;
    @Autowired
    private UserRepository userRepository;

    public Knife addKnifeToUser ( String userId, Knife knife){
        Knife savedKnife = knifeRepository.save(knife);
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        user.addKnife(new Knife());

        userRepository.save(user);
        return savedKnife;
    }

};
