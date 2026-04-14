package com.bank.customerprofile.repository.DataAccess;

import com.bank.customerprofile.models.DTOs.userrequest.createuserrequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserJDBCRepository {

    private JdbcTemplate jdbcTemplate;

    public UserJDBCRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createuser(createuserrequest data){
        try{
            String username = data.getUsername();
            String password = data.getPassword();
            String role = data.getRole();
            jdbcTemplate.update("call Usp_create_user(?,?,?)",username,password,role);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
