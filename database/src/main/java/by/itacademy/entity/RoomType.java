package by.itacademy.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "room_types")
@ToString(callSuper = true, exclude = "rooms")
@NoArgsConstructor
public class RoomType extends BaseEntity {

    @Column(name = "room_title", nullable = false, unique = true)
    @Getter
    @Setter
    private String title;

    @Column(name = "cost_for_one_night", nullable = false)
    @Getter
    @Setter
    private int costForOneNight;

    @OneToMany(mappedBy = "type")
    @Getter
    @Setter
    private Set<Room> rooms = new HashSet<>();

    public RoomType(String title, int costForOneNight) {
        this.title = title;
        this.costForOneNight = costForOneNight;
    }
}
