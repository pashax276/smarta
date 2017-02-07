package com.lisnykov.repository.security;

import com.lisnykov.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select u from User u where u.username=:username")
    User findByUsername( @Param("username") String username);

}
