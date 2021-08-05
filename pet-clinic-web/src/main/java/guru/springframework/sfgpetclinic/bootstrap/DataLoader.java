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

        PetType dog = new PetType();
        dog.setName("dog");
        PetType dogPetType = petTypeService.save(dog);
        PetType cat = new PetType();
        dog.setName("cat");
        PetType catPetType = petTypeService.save(cat);
        System.out.println("Loaded PetYpe....");

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("via pippo 3");
        owner1.setCity("Peppe City");
        owner1.setTelephone("1231124");

        Pet mikePet = new Pet();
        mikePet.setPetType(dogPetType);
        mikePet.setName("Peppe");
        mikePet.setOwner(owner1);
        mikePet.setBirthDate(LocalDate.now());
        owner1.getPets().add(mikePet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("via fiona 3");
        owner2.setCity("Fiona City");
        owner2.setTelephone("1231124");

        Pet fionaPet = new Pet();
        fionaPet.setName("Pepino");
        fionaPet.setPetType(catPetType);
        fionaPet.setOwner(owner2);
        fionaPet.setBirthDate(LocalDate.now());
        owner2.getPets().add(fionaPet);
        ownerService.save(owner2);
        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetService.save(vet2);

        System.out.println("Loaded Vets....");

    }
}
