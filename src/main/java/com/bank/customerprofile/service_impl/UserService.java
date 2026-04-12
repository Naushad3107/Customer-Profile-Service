package com.bank.customerprofile.service_impl;

import com.bank.customerprofile.models.DTOs.userrequest.createuserrequest;
import com.bank.customerprofile.repository.DataAccess.UserJDBCRepository;
import com.bank.customerprofile.repository.UserRepository;
import com.bank.customerprofile.services.IUserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserService implements IUserService {

    private final UserRepository userRepository;
    private final UserJDBCRepository userJDBCRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(
            UserRepository userRepository,
            UserJDBCRepository userJdbcRepository,
            PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.userJDBCRepository = userJdbcRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public String createuser(createuserrequest data) {
        if(userRepository.findByUsername(data.getUsername()) != null){
            throw new RuntimeException("User Already Exist!");
        }

        String encodedPass = passwordEncoder.encode(data.getPassword());
        data.setPassword(encodedPass);
        userJDBCRepository.createuser(data);

        return "";
    }
}
