package fr.afcepf.ad1.springpetclinic.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Speciality extends BaseEntity {
    private String description;

}
