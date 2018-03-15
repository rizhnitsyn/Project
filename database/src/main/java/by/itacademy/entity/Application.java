package by.itacademy.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "applications")
@ToString(callSuper = true, exclude = "conveniences")
@NoArgsConstructor
public class Application extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    @Getter
    @Setter
    private Room room;

    @ManyToMany
    @JoinTable(
            name = "applications_conveniences",
            joinColumns = @JoinColumn(name = "convenience_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "application_id", nullable = false)
    )
    private Set<AdditionalConvenience> conveniences = new HashSet<>();

    @Column(name = "day_of_arrival", nullable = false)
    @Getter
    @Setter
    private LocalDate dayOfArrival;

    @Column(name = "day_of_departure", nullable = false)
    @Getter
    @Setter
    private LocalDate dayOfDeparture;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @Getter
    @Setter
    private SystemUser customer;

    public Application(Room room, LocalDate dayOfArrival, LocalDate dayOfDeparture, SystemUser customer) {
        this.room = room;
        this.dayOfArrival = dayOfArrival;
        this.dayOfDeparture = dayOfDeparture;
        this.customer = customer;
    }
}
