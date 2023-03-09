package mx.edu.utez.mascotaapp.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Person {
    @NotBlank(message = "El nombre no puede contener espacios en blanco")
    @NotEmpty(message = "El nombre no puede ser nulo")
    private String name;
    @NotBlank(message = "El correo no puede contener espacios en blanco")
    @NotEmpty(message = "El correo no puede ser nulo")
    @Email(message = "El correo no es valido")
    @Pattern(regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$", message = "El correo no es valido")
    private String email;
    @NotNull(message = "El telefono no puede ser nulo")
    @Size(min = 10, max = 10, message = "El telefono debe contener 10 digitos")
    @Pattern(regexp = "^[0-9]*$", message = "El telefono no es valido")
    private String phone;
 
    

    public Person() {
    }

    public Person(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    

}
