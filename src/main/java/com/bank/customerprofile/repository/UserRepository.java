package com.bank.customerprofile.repository;

import com.bank.customerprofile.models.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsername(String username);

}
