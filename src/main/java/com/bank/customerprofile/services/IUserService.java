package com.bank.customerprofile.services;

import com.bank.customerprofile.models.DTOs.userrequest.createuserrequest;

public interface IUserService {

    String createuser(createuserrequest data);
}
