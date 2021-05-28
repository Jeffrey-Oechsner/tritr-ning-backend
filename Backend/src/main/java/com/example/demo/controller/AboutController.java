package com.example.demo.controller;

import com.example.demo.model.About;
import com.example.demo.repository.AboutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8080")



//    ==================================================== GET ABOUT ============================================

//    ====== SELECT ABOUT =====
public class AboutController {
    @Autowired AboutRepository aboutRepository;

    @GetMapping("/select/about/{id}")
        public About getAbout(@PathVariable int id){
            About about = aboutRepository.findById(id);

            return about;
        }

    @PostMapping(value = "/insert/about", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public About insertAbout(@RequestBody About about){

        return aboutRepository.save(about);
    }

    @PostMapping(value = "/edit/about{id}", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public void editAbout(@RequestBody About about){
        System.out.println(about.getId());

        About objectToUpdate = aboutRepository.findById(about.getId());
        System.out.println(objectToUpdate);
        if (about.getDescription() != null){
            objectToUpdate.setDescription(about.getDescription());
        }
        objectToUpdate.setImg(about.getImg());
        objectToUpdate.setTitle(about.getTitle());
        System.out.println(about);

        aboutRepository.save(objectToUpdate);
    }
}
