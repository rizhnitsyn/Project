package by.itacademy;

import by.itacademy.entity.RoomType;
import by.itacademy.repository.RoomTypeRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class RoomTypeTest extends BaseTest{

    @Autowired
    RoomTypeRepository roomTypeRepository;

    @Test
    public void testGetRoomTypes() {
        RoomType roomType = roomTypeRepository.findOne(1l);
        assertEquals(roomType.getCostForOneNight(), 100);
    }
}
