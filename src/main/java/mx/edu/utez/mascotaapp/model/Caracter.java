package mx.edu.utez.mascotaapp.model;


public class Caracter {
    private Integer id;
    private String nombre;

    public Caracter() {
    }

    public Caracter(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Caracter{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
