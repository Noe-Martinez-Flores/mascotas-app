package mx.edu.utez.mascotaapp.service;

import org.springframework.stereotype.Service;

import mx.edu.utez.mascotaapp.model.Person;

@Service
public class PersonServiceImp implements IPersonService {

    @Override
    public void savePerson(Person person) {
        System.out.println("Nombre: " + person.getName());
        System.out.println("Correo: " + person.getEmail());
        System.out.println("Telefono: " + person.getPhone());
    }
    
}
