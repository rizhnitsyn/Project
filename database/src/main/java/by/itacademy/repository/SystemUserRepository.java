package by.itacademy.repository;

import by.itacademy.entity.SystemUser;
import org.springframework.data.repository.CrudRepository;

public interface SystemUserRepository extends CrudRepository<SystemUser, Long> {
    SystemUser findByEmail(String email);
}
