package com.bank.customerprofile.services;

import com.bank.customerprofile.models.DTOs.userrequest.createuserrequest;

public interface UserService {

    String createuser(createuserrequest data);
}
