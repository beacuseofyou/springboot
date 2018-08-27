package com.learning.repository;

import com.learning.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface IUserRepository extends CrudRepository<User,Integer> {

    @Query("from User where id =:id ")
    public User getUser(@Param("id") Integer id);
}
