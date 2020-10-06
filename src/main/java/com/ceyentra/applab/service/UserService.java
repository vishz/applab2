package com.ceyentra.applab.service;

import com.ceyentra.applab.entity.User;
import com.ceyentra.applab.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User save(UserRegistrationDto registrationDto);



}
