package com.ceyentra.applab.service;

import com.ceyentra.applab.dto.UserRegistrationDto;
import com.ceyentra.applab.entity.Admin;
import com.ceyentra.applab.entity.AuthAdminDetails;
import com.ceyentra.applab.entity.AuthUserDetails;
import com.ceyentra.applab.entity.User;
import com.ceyentra.applab.enums.SecurityRole;
import com.ceyentra.applab.exception.CustomOauthException;
import com.ceyentra.applab.repository.AdminRepository;
import com.ceyentra.applab.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final AdminRepository adminRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, AdminRepository adminRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public User save(UserRegistrationDto registrationDto) {

        User user = new User(registrationDto.getFirstName(), registrationDto.getLastName(), registrationDto.getEmail(), registrationDto.getUsername(), passwordEncoder.encode(registrationDto.getPassword()), SecurityRole.ROLE_PUBLIC_USER);


        return userRepository.save(user);

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsernamePasswordAuthenticationToken authentication =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
        String clientId = principal.getUsername();
        if (clientId.equals("user")) {
            User user = userRepository.findByUsername(username).orElseThrow(() -> new CustomOauthException("Invalid username"));
            return new AuthUserDetails(user);
        } else {
            Admin admin = adminRepository.findByUsername(username).orElseThrow(() -> new CustomOauthException("Invalid username"));
            return new AuthAdminDetails(admin);
        }
    }


}
