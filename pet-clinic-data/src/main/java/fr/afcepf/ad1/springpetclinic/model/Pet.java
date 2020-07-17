package fr.afcepf.ad1.springpetclinic.model;

import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pet extends BaseEntity {
    private String name;
    private PetType petType;
    private LocalDate birthDate;
    private Owner owner;
    private Set<Visit> visits = new HashSet<>();


}
