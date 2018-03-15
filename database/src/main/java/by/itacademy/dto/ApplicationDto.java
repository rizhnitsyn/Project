package by.itacademy.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationDto {
    private LocalDate dayOfArrival;
    private LocalDate dayOfDeparture;
    private long roomTypeId;
    private int numberOfPlaces;
}
