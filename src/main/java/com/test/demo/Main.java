package com.test.demo;

import com.test.demo.entety.Permission;
import com.test.demo.entety.PermissionType;
import com.test.demo.entety.User;
import com.test.demo.repository.OrganizationRepository;
import com.test.demo.repository.PermissionRepository;
import com.test.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.springframework.security.crypto.factory.PasswordEncoderFactories.createDelegatingPasswordEncoder;

@SpringBootApplication
public class Main implements CommandLineRunner {
    @Autowired
    private OrganizationRepository organizationRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PermissionRepository permissionRepository;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        init();
    }

    private void init() {
        userRepository.deleteAll();
        permissionRepository.deleteAll();

        User simpleUser = new User();
        simpleUser.setLogin("user");
        simpleUser.setPass(createDelegatingPasswordEncoder().encode("pass"));
        simpleUser.setExternalId("user_external_id");

        User admin = new User();
        admin.setLogin("root");
        admin.setPass(createDelegatingPasswordEncoder().encode("pass"));
        admin.setExternalId("admin_external_id");

        userRepository.save(simpleUser);
        userRepository.save(admin);

        permissionRepository.save(new Permission("user_external_id", "net", "org", PermissionType.READ));
        permissionRepository.save(new Permission("user_external_id", "net", "org2", PermissionType.WRITE));

        permissionRepository.save(new Permission("admin_external_id", null, null, PermissionType.ALL));
    }
}