package com.siraj.elasticsearch.elasticsearchdemo.resource;

import com.siraj.elasticsearch.elasticsearchdemo.model.Users;
import com.siraj.elasticsearch.elasticsearchdemo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rest/search")
public class SearchResource {

    @Autowired
    UsersRepository usersRepository;

    @GetMapping(value = "/name/{text}")
    public List<Users> searchName(@PathVariable final String text){
        return usersRepository.findByName(text);
    }

    @GetMapping(value = "/salary/{text}")
    public List<Users> searchSalary(@PathVariable final Long text){
        return usersRepository.findBySalary(text);
    }

    @GetMapping(value = "/all")
    public List<Users> searchAll(){
        List<Users> usersList = new ArrayList<Users>();
        Iterable<Users> userses = usersRepository.findAll();
        userses.forEach(usersList::add);
        return usersList;
    }
}
