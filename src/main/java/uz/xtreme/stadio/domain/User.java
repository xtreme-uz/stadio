package uz.xtreme.stadio.domain;

import lombok.Getter;
import lombok.Setter;
import uz.xtreme.stadio.core.model.Pk;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(name = "users_table_username_unique", columnNames = "username")
})
public class User extends Pk {
    @Column(name = "username", nullable = false) private String username;
    @Column(name = "password", nullable = false) private String password;
    @Column(name = "email") private String email;
    @Column(name = "first_name") private String firstName;
    @Column(name = "last_name") private String lastName;

    @ElementCollection
    @CollectionTable(name = "user_phone_numbers", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "phone_number")
    private List<String> phoneNumbers = new ArrayList<>();

}
