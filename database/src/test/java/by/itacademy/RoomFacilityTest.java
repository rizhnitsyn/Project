package by.itacademy;

import by.itacademy.entity.RoomFacility;
import by.itacademy.repository.RoomFacilityRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class RoomFacilityTest extends BaseTest{

    @Autowired
    RoomFacilityRepository roomFacilityRepository;

    @Test
    public void testGetRoomFacilities() {
        RoomFacility facility = roomFacilityRepository.findOne(1l);
        assertEquals(facility.getCost(), 5);
    }
}
