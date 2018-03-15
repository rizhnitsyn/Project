package by.itacademy.service;

import by.itacademy.entity.Role;
import by.itacademy.entity.SystemUser;
import by.itacademy.repository.SystemUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private SystemUserRepository systemUserRepository;

    @Autowired
    public UserServiceImpl(SystemUserRepository systemUserRepository) {
        this.systemUserRepository = systemUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        SystemUser systemUser = systemUserRepository.findByEmail(email);
        if (systemUser == null) {
            throw new UsernameNotFoundException("User doesn't exist!");
        }

        System.out.println(systemUser);
        systemUser.getRoles().forEach(System.out::println);

        return new User(systemUser.getEmail(), systemUser.getPassword(), generateAuthorities(systemUser.getRoles()));
    }

    private Collection<? extends GrantedAuthority> generateAuthorities(Set<Role> roles) {
        return roles
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }
}
