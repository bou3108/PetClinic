package fr.afcepf.ad1.springpetclinic.bootstrap;

import fr.afcepf.ad1.springpetclinic.model.*;
import fr.afcepf.ad1.springpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final PetService petService;
    private final PetTypeService petTypeService;
    private final VetService vetService;
    private final VisitService visitService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, PetService petService, PetTypeService petTypeService,
                      VetService vetService, VisitService visitService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.petService = petService;
        this.petTypeService = petTypeService;
        this.vetService = vetService;
        this.visitService = visitService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {
        // Insert Speciality
        Speciality radiology = new Speciality();
        radiology.setDescription("radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("surgery");
        Speciality savedSurgery = specialityService.save((surgery));

        Speciality dentistry = new Speciality();
        dentistry.setDescription("dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        System.out.println("Load Speciality");

        // Add Pet Type
        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        PetType savedCatPetType = petTypeService.save(cat);

        System.out.println("Load Pet Type");

        // Add Owner
        Owner owner1 = new Owner();
        owner1.setFirstName("Bob");
        owner1.setLastName("Johnson");
        owner1.setAddress("rue Main");
        owner1.setCity("Boston");
        owner1.setTelephone("0123456789");

        Pet bobsPet = new Pet();
        bobsPet.setPetType(savedDogPetType);
        bobsPet.setOwner(owner1);
        bobsPet.setBirthDate(LocalDate.now());
        bobsPet.setName("Thibaud");
        owner1.getPets().add(bobsPet);

        ownerService.save(owner1);


        Owner owner2 = new Owner();
        owner2.setFirstName("Raoul");
        owner2.setLastName("Volfoni");
        owner2.setAddress("rue du Bourre-pif");
        owner2.setCity("Montauban");
        owner2.setTelephone("0123456790");

        Pet raoulsPet = new Pet();
        raoulsPet.setPetType(savedCatPetType);
        raoulsPet.setOwner(owner2);
        raoulsPet.setBirthDate(LocalDate.now());
        raoulsPet.setName("Benoît");
        owner2.getPets().add(raoulsPet);

        ownerService.save(owner2);

        System.out.println("Load Owners and Pets");

        // Add visits

        Visit catVisit = new Visit();
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Cat headache");
        catVisit.setPet(raoulsPet);
        visitService.save(catVisit);

        System.out.println("load visit");

        // Add vets

        Vet vet1 = new Vet();
        vet1.setFirstName("Pino");
        vet1.setLastName("Chio");
        vet1.getSpecialities().add(savedSurgery);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Ge");
        vet2.setLastName("Petto");
        vet2.getSpecialities().add(savedDentistry);
        vetService.save(vet2);
    }
}
