package com.springk.apidemos.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springk.apidemos.Dao.User;


@Repository
public interface UserRepository extends CrudRepository<User,Integer> {



    public User getUserByEmail(String email);

    public User getUserById(int userid);


    
}
