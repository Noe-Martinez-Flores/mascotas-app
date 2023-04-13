package mx.edu.utez.mascotaapp.service;

import mx.edu.utez.mascotaapp.model.Caracter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CatacterServImp implements ICaracterService{

    private List<Caracter> lista = null;

    public void caracters () {
        lista = new ArrayList<>();
        lista.add(new Caracter(1, "Cariñoso"));
        lista.add(new Caracter(2, "Jugueton"));
        lista.add(new Caracter(3, "Mimoso"));
        lista.add(new Caracter(4, "Cariñoso"));
        lista.add(new Caracter(5, "Jugueton"));
    }

    @Override
    public List<Caracter> findAll() {
        caracters();
        return lista;
    }
}
