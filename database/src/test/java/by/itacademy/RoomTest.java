package by.itacademy;

import by.itacademy.entity.Room;
import by.itacademy.repository.RoomFacilityRepository;
import by.itacademy.repository.RoomRepository;
import by.itacademy.repository.RoomTypeRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class RoomTest extends BaseTest{

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    RoomFacilityRepository roomFacilityRepository;

    @Autowired
    RoomTypeRepository roomTypeRepository;

    @Test
    public void testGetRooms() {
        Room room = roomRepository.findOne(1l);
        assertEquals(room.getNumberOfPlaces(), 1);
    }


    @Test
    public void testRooms() {
        Room room = roomRepository.findRooms(LocalDate.parse("2018-02-14"),
                LocalDate.parse("2018-03-01"),
                roomTypeRepository.findOne(2l),
                1).get(0);
        assertEquals(room.getId(), 6);
    }

}
