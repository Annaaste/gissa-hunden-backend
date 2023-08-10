package com.annapanna.gissahundenbackend.service;

import com.annapanna.gissahundenbackend.dao.request.SignUpRequest;
import com.annapanna.gissahundenbackend.dao.request.SigninRequest;
import com.annapanna.gissahundenbackend.dao.request.response.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SigninRequest request);
}