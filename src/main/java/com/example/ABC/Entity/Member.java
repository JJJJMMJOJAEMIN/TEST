package com.example.ABC.Entity;


import jakarta.persistence.*;
import lombok.*;



@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="A_ABC")


public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "A_ABC_SEQ")
    @SequenceGenerator(name = "A_ABC_SEQ", sequenceName = "A_ABC_SEQ", initialValue = 1, allocationSize = 1)

    private Long idx;

    private String userId;

    private String pwd;

    private String name;

}
