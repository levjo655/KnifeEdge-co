package Mojodoo.KnifeEdge.co.controllers;

import Mojodoo.KnifeEdge.co.models.Knife;
import Mojodoo.KnifeEdge.co.services.KnifeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin (origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/apiKnife")

public class KnifeController {
@Autowired
    KnifeService knifeService;

    @PostMapping()
    public Knife createKnifeModel (@RequestBody Knife knife){
        return knifeService.createKnife(knife);
    }

    @GetMapping("/all")
    public List<Knife> getAllknife(){
        return knifeService.getAllKnife();

    }
    @GetMapping("{id}")
    public Knife getKnifeById(@PathVariable String id){
        try {
            return knifeService.getKnifeById(id);

        } catch (NoSuchElementException exception){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping ("/{id}")
    public Knife updateKnife(@RequestBody Knife knife){
        return knifeService.updateKnife(knife);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteKnife(@PathVariable String id){
        return knifeService.deleteKnife(id);
    }

}


