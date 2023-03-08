package mx.edu.utez.mascotaapp.service;

import java.util.List;

import mx.edu.utez.mascotaapp.model.MascotasModel;

public interface IMascotaService {
    List < MascotasModel > listarMascotas();
    void guardarMascota(MascotasModel mascota);
}
