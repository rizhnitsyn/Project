package by.itacademy.service;

import by.itacademy.entity.RoomType;
import by.itacademy.repository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class RoomTypeServiceImpl implements RoomTypeService{
    @Autowired
    RoomTypeRepository roomTypeRepository;

    public List<RoomType> findAllServices() {
        Iterable<RoomType> types = roomTypeRepository.findAll();
        List<RoomType> roomTypes = new ArrayList<>();
        types.forEach(roomTypes::add);
        return roomTypes;
    }

    public RoomType findById(Long id) {
        return null;
    }
}
