package by.itacademy.service;

import by.itacademy.entity.Room;
import by.itacademy.entity.RoomType;

import java.time.LocalDate;
import java.util.List;

public class RoomService {
    public List<Room> findRooms(LocalDate arrival, LocalDate departure, RoomType roomType, int numberOfPlaces) {
        //return RoomDao.getInstance().find(arrival, departure, roomType, numberOfPlaces);
        return  null;
    }
}
