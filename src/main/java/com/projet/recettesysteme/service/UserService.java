package com.projet.recettesysteme.service;

import com.projet.recettesysteme.domain.User;
import com.projet.recettesysteme.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
}
