package by.itacademy.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
@Getter
@Setter
@ToString
public class Role extends BaseEntity {

    @Column(name = "name")
    private String name;
}
