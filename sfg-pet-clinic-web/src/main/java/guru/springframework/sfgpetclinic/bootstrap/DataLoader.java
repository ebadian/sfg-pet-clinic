package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.OwnerServiceMap;
import guru.springframework.sfgpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService   = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner firstOwner = new Owner();
        firstOwner.setId(1L);
        firstOwner.setFirstName("John");
        firstOwner.setLastName("Smith");

        ownerService.save(firstOwner);

        Owner secondOwner = new Owner();
        secondOwner.setId(2L);
        secondOwner.setFirstName("Patrice");
        secondOwner.setLastName("O'Neal");

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
