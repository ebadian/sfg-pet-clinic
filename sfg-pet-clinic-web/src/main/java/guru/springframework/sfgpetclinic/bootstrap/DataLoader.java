package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType dogPetType = new PetType();
        dogPetType.setGetType("Dog");
        PetType catPetType = new PetType();
        catPetType.setGetType("Cat");

        petTypeService.save(dogPetType);
        petTypeService.save(catPetType);

        Owner firstOwner = new Owner();
        firstOwner.setId(1L);
        firstOwner.setFirstName("John");
        firstOwner.setLastName("Smith");

        Pet johnsPet = new Pet();
        johnsPet.setPetType(dogPetType);
        johnsPet.setOwner(firstOwner);
        johnsPet.setName("Ross");
        johnsPet.setBirthDate(LocalDate.now());

        firstOwner.setPets(johnsPet);

        ownerService.save(firstOwner);

        Owner secondOwner = new Owner();
        secondOwner.setId(2L);
        secondOwner.setFirstName("Patrice");
        secondOwner.setLastName("O'Neal");

        Pet patriceCat = new Pet();
        patriceCat.setPetType(catPetType);
        patriceCat.setBirthDate(LocalDate.now());
        patriceCat.setName("Jimmy");
        patriceCat.setOwner(secondOwner);

        secondOwner.setPets(patriceCat);

        ownerService.save(secondOwner);

        System.out.println("Loaded Owners");

        Vet firstVet = new Vet();
        firstVet.setId(1L);
        firstVet.setFirstName("Anthony");
        firstVet.setLastName("Cumia");

        vetService.save(firstVet);

        Vet secondVet = new Vet();
        secondVet.setId(2L);
        secondVet.setFirstName("Bill");
        secondVet.setLastName("Burr");

        vetService.save(secondVet);

        System.out.println("Loaded Vets");


    }
}
