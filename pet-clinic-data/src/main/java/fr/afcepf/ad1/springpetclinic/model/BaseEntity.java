package fr.afcepf.ad1.springpetclinic.model;

import lombok.*;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseEntity implements Serializable {
    private Long id;

}
