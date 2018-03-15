package by.itacademy.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@ToString(callSuper = true, exclude = {"applications", "roles"})
@NoArgsConstructor
@Getter
@Setter
public class SystemUser extends BaseEntity {

    @AttributeOverrides({
            @AttributeOverride(name = "firstName", column = @Column(name = "first_name")),
            @AttributeOverride(name = "lastName", column = @Column(name = "last_name"))
    })
    private Name name;

    @Column(name = "review")
    private String review;

    @Column(name = "evaluation")
    @Enumerated(EnumType.STRING)
    private Evaluation evaluation;

    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;

    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false, unique = true)
    private String password;

    @Column(name = "phone_number", nullable = false, unique = true)
    private Long phoneNumber;

    @OneToMany(mappedBy = "customer")
    private Set<Application> applications = new HashSet<>();

    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles = new HashSet<>();

    public SystemUser(Name name, String review,
                      Evaluation evaluation,
                      LocalDate birthday,
                      Gender gender,
                      String email,
                      String password,
                      Long phoneNumber) {
        this.name = name;
        this.review = review;
        this.evaluation = evaluation;
        this.birthday = birthday;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }
}
