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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "rooms")
@ToString(callSuper = true, exclude = {"applications",  "facilities"})
@NoArgsConstructor
public class Room extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "type_id")
    @Getter
    @Setter
    private RoomType type;


    @Column(name = "number_of_places")
    @Getter
    @Setter
    private int numberOfPlaces;

    @OneToMany(mappedBy = "room")
    @Getter
    @Setter
    private Set<Application> applications = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "rooms_facilities",
            joinColumns = @JoinColumn(name = "facility_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "room_id", nullable = false)
    )
    private Set<RoomFacility> facilities = new HashSet<>();

    public Room(RoomType type, int numberOfPlaces) {
        this.type = type;
        this.numberOfPlaces = numberOfPlaces;
    }
}

