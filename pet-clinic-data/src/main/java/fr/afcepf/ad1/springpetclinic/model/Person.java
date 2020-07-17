package fr.afcepf.ad1.springpetclinic.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Person extends BaseEntity {
    private String firstName;
    private String lastName;

}
