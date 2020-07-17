package fr.afcepf.ad1.springpetclinic.model;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Owner extends Person {
    private String address;
    private String city;
    private String telephone;
    private Set<Pet> pets = new HashSet<>();
}
