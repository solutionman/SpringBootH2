package com.spring.h2.controller;

import com.spring.h2.entity.Hero;
import com.spring.h2.repository.HeroRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
class Controller {

    HeroRepository heroRepository;

    Controller(HeroRepository heroRepository){
        this.heroRepository = heroRepository;
    }

    @GetMapping(path = "/hello/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String hello(@PathVariable String name) {
        return "Hello " + name + "!";
    }

    @GetMapping(path = "/hero/{name}")
    public void saveHero(@PathVariable String name){
        Hero hero = new Hero();
        hero.setName(name);
        heroRepository.save(hero);
    }

    @GetMapping(path = "/gethero/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getHero(@PathVariable String name){
        List<Hero> heroList = heroRepository.findByName(name);
        if(heroList.isEmpty()) return "";
        return heroList.stream().map(Hero::toString).collect(Collectors.joining(", "));
    }

    @GetMapping(path = "/heroes", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getHeroes(){
        List<Hero> heroList = heroRepository.findAll();
        if(heroList.isEmpty()) return "";
        return heroList.stream().map(Hero::toString).collect(Collectors.joining(", "));
    }

}
