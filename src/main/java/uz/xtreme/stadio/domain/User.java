package uz.xtreme.stadio.domain;

import javax.persistence.*;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(name = "users_table_username_unique", columnNames = "username")
})
public class User extends Pk {
    @Column(name = "username", nullable = false) private String username;
    @Column(name = "phone_number") private String phoneNumber;
    @Column(name = "email") private String email;
    @Column(name = "first_name") private String firstName;
    @Column(name = "last_name") private String lastName;
}