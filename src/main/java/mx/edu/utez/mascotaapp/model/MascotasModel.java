package mx.edu.utez.mascotaapp.model;

import java.util.Date;

public class MascotasModel {

    private Long id;
    private String nombre;
    private Integer edad;
    private String descripcion;
    private String tipoMascota;
    private String imagen;
    private Boolean diponibleAdopcion;
    private Date fechaRegistro;
    Caracter caracter;

    public MascotasModel() {

    }

    public MascotasModel(Long id, String nombre, Integer edad, String descripcion, String tipoMascota, String imagen, Boolean diponibleAdopcion, Date fechaRegistro, Caracter caracter) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.descripcion = descripcion;
        this.tipoMascota = tipoMascota;
        this.imagen = imagen;
        this.diponibleAdopcion = diponibleAdopcion;
        this.fechaRegistro = fechaRegistro;
        this.caracter = caracter;
    }

    public MascotasModel(String nombre, Integer edad, String descripcion, String tipoMascota, String imagen, Boolean diponibleAdopcion, Date fechaRegistro, Caracter caracter) {
        this.nombre = nombre;
        this.edad = edad;
        this.descripcion = descripcion;
        this.tipoMascota = tipoMascota;
        this.imagen = imagen;
        this.diponibleAdopcion = diponibleAdopcion;
        this.fechaRegistro = fechaRegistro;
        this.caracter = caracter;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoMascota() {
        return tipoMascota;
    }

    public void setTipoMascota(String tipoMascota) {
        this.tipoMascota = tipoMascota;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Boolean getDiponibleAdopcion() {
        return diponibleAdopcion;
    }

    public void setDiponibleAdopcion(Boolean diponibleAdopcion) {
        this.diponibleAdopcion = diponibleAdopcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }


    public Caracter getCaracter() {
        return caracter;
    }

    public void setCaracter(Caracter caracter) {
        this.caracter = caracter;
    }

    @Override
    public String toString() {
        return "MascotasModel{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", descripcion='" + descripcion + '\'' +
                ", tipoMascota='" + tipoMascota + '\'' +
                ", imagen='" + imagen + '\'' +
                ", diponibleAdopcion=" + diponibleAdopcion +
                ", fechaRegistro=" + fechaRegistro +
                ", caracter=" + caracter +
                '}';
    }
}
