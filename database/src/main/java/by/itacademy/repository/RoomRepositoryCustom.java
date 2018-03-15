package by.itacademy.repository;

import by.itacademy.entity.Room;
import by.itacademy.entity.RoomType;

import java.time.LocalDate;
import java.util.List;

public interface RoomRepositoryCustom {
    List<Room> findRooms(LocalDate dayOfArrival,
                         LocalDate dayOfDeparture,
                         RoomType roomType,
                         int numberOfPlaces);


}
