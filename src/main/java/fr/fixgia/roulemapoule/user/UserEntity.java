package fr.fixgia.roulemapoule.user;

import jakarta.persistence.*;
import lombok.Data;


import java.util.UUID;

@Entity(name="user")
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private UUID ID;
    @Column
    private String lastname;
    @Column
    private String firstname;
    @Column
    private String email;
}
