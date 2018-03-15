package by.itacademy;

import by.itacademy.entity.SystemUser;
import by.itacademy.repository.SystemUserRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class SystemUserTest extends BaseTest {

    @Autowired
    SystemUserRepository systemUserRepository;

    @Test
    public void testSaveUsers() {
        SystemUser systemUser = systemUserRepository.findByEmail("alicamorigan@mail.ru");
        assertEquals(systemUser.getName().getFirstName(), "Alica");
    }

}
