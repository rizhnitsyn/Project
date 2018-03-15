package by.itacademy.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "facilities")
@ToString(callSuper = true, exclude = "rooms")
@NoArgsConstructor
public class RoomFacility extends BaseEntity {

    @Column(name = "title", nullable = false, unique = true)
    @Getter
    @Setter
    private String title;

    @Column(name = "cost", nullable = false)
    @Getter
    @Setter
    private int cost;

    @ManyToMany(mappedBy = "facilities")
    private Set<Room> rooms = new HashSet<>();

    public RoomFacility(String title) {
        this.title = title;
    }

}