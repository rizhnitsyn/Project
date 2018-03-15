package by.itacademy.controller;

import by.itacademy.dto.ApplicationDto;
import by.itacademy.entity.RoomType;
import by.itacademy.service.RoomTypeService;
import by.itacademy.service.RoomTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
public class CreateApplicationController {

    @ModelAttribute("baseApplication")
    public ApplicationDto applicationDto() {
        return new ApplicationDto();
    }

    @ModelAttribute("allRoomTypes")
    public RoomType[] allRoomTypes() {
        List<RoomType> list = new RoomTypeServiceImpl().findAllServices();
        return list.toArray(new RoomType[list.size()]);
    }

    @GetMapping("/createApplication")
    public String showPage() {
        return "createApplication";
    }

    @PostMapping("/createApplication")
    public String showNextPage(){
        return "chooseRoom";
    }
}
