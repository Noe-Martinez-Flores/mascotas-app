package mx.edu.utez.mascotaapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import mx.edu.utez.mascotaapp.model.MascotasModel;

import java.util.LinkedList;
import java.util.Date;

@Service
public class MascotasService implements IMascotaService{


    private List<MascotasModel> listaMascotas = new LinkedList<>();

    public void llenarLista(){
        
        listaMascotas.add(new MascotasModel("Roky",3,"Perro tactico","perro","perrito1.jpg",true, new Date()));
        listaMascotas.add(new MascotasModel("Mandy",3,"Gato tactico","gato","gato1.jpg",true, new Date()));
        listaMascotas.add(new MascotasModel("cindy",3,"Gato tactico","gato","gato1.jpg",true, new Date()));
        listaMascotas.add(new MascotasModel("katy",3,"Perro tactico","perro","perrito1.jpg",true, new Date()));

    }

    @Override
    public List<MascotasModel> listarMascotas() {
        // TODO Auto-generated method stub
        llenarLista();
        return listaMascotas;
    }

    @Override
    public void guardarMascota(MascotasModel mascota) {
        listaMascotas.add(mascota);
    }

 
    
}
