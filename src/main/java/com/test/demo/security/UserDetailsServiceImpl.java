package com.test.demo.security;

import com.test.demo.entety.Permission;
import com.test.demo.entety.User;
import com.test.demo.repository.OrganizationRepository;
import com.test.demo.repository.PermissionRepository;
import com.test.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PermissionRepository permissionRepository;
    @Autowired
    private OrganizationRepository organizationRepository;

    //TODO: add parse sub organizations
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByLogin(username);

        String externalId = user.getExternalId();
        List<Permission> permissions = permissionRepository.findAllByUserId(externalId);

        return new UserPrincipal(user, permissions);
    }
}
