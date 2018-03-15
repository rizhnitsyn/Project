package by.itacademy.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "additional_conveniences")
@ToString(callSuper = true, exclude = "applications")
@NoArgsConstructor
public class AdditionalConvenience extends BaseEntity {

    @Column(name = "title", nullable = false, unique = true)
    @Getter
    @Setter
    private String title;

    @Column(name = "cost", nullable = false)
    @Getter
    @Setter
    private int cost;

    @ManyToMany(mappedBy = "conveniences")
    private Set<Application> applications = new HashSet<>();

    public AdditionalConvenience(String title, int cost) {
        this.title = title;
        this.cost = cost;
    }
}
