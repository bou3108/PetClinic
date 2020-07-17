package fr.afcepf.ad1.springpetclinic.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetType extends BaseEntity {
    private String name;

}
