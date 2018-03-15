package by.itacademy;

import by.itacademy.entity.Application;
import by.itacademy.repository.ApplicationRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class ApplicationTest extends BaseTest{

    @Autowired
    private ApplicationRepository applicationRepository;

    @Test
    public void testGetApplications() {
        Application application = applicationRepository.findOne(1l);
        assertEquals(application.getDayOfArrival(), LocalDate.parse("2018-04-01"));
    }

}
