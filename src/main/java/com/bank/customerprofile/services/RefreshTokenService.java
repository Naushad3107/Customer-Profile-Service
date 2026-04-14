package com.bank.customerprofile.services;

import com.bank.customerprofile.models.entities.RefreshToken;
import com.bank.customerprofile.models.entities.User;

public interface RefreshTokenService {
    RefreshToken createRefreshToken(User user);

    RefreshToken verifyExpiration(RefreshToken token);

    void deleteByUser(User user);
}
