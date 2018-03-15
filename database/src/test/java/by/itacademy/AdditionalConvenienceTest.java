package by.itacademy;

import by.itacademy.config.PersistenceConfig;
import by.itacademy.entity.AdditionalConvenience;
import by.itacademy.repository.AdditionalConvenienceRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = PersistenceConfig.class)
public class AdditionalConvenienceTest{

    @Autowired
    private AdditionalConvenienceRepository additionalConvenienceRepository;

    @Test
    public void testGetAdditionalConveniences() {
        AdditionalConvenience additionalConvenience = additionalConvenienceRepository.findOne(1l);
        assertEquals(additionalConvenience.getCost(), 20);
    }
}
