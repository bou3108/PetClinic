package fr.afcepf.ad1.springpetclinic.model;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vet extends Person {
    private Set<Speciality> specialities = new HashSet<>();
}
