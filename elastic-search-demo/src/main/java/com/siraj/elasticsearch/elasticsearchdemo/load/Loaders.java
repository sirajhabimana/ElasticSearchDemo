package com.siraj.elasticsearch.elasticsearchdemo.load;

import com.siraj.elasticsearch.elasticsearchdemo.model.Users;
import com.siraj.elasticsearch.elasticsearchdemo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class Loaders {

    @Autowired
    ElasticsearchOperations elasticsearchOperations;

    @Autowired
    UsersRepository usersRepository;

    @PostConstruct
    @Transactional
    public void loadAll(){

        elasticsearchOperations.putMapping(Users.class);
        System.out.println("Loading Data");
        usersRepository.save(getData());
        System.out.println("Loading Complete");
    }

    private List<Users> getData() {
        List<Users> userses = new ArrayList<>();
        userses.add(new Users("Siraj",123L, "IT", 12000L));
        userses.add(new Users("Isaac",1234L, "Finance", 44000L));
        userses.add(new Users("Allan",1235L, "Accounting", 12000L));
        return userses;
    }
}
