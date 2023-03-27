package com.tfm.aseguradora.backend.middle.config;

import com.tfm.aseguradora.backend.middle.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tfm.aseguradora.backend.middle.users.client.UserApi;
import com.tfm.aseguradora.backend.middle.users.dto.RolClientDto;

@Service
public class UsuarioDetailsService implements UserDetailsService  {
  @Autowired
  private UserApi userApi;
  @Autowired
  private JwtUtilService jwtUtilService;

  @Override
  public UserDetails loadUserByUsername(String token) throws UsernameNotFoundException {
    var username = jwtUtilService.extractUsername(token.replace("Bearer ", ""));
    var userListWrapper = userApi.getUsers(token, null, username,null);
    var userDto = userListWrapper.getUsers().get(0);
    if (userDto != null) {
      var roles = userDto.getRoles();
      if (roles != null && !roles.isEmpty()) {
        User.UserBuilder userBuilder = User.withUsername(username);
        String encryptedPassword = "nonEmpty";
        String[] rolesListString = roles.stream()
                .map(RolClientDto::getNombre)
                .toArray(String[]::new);
        userBuilder.password(encryptedPassword).username(token).roles(rolesListString);
        return userBuilder.build();
      } else {
        throw new UsernameNotFoundException("Username [" + username + "] has not permissions");
      }
    } else {
      throw new UsernameNotFoundException("Username [" + username + "] does not exist in the system");
    }
  }
}