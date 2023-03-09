package mx.edu.utez.mascotaapp.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import mx.edu.utez.mascotaapp.model.MascotasModel;
import mx.edu.utez.mascotaapp.service.MascotasService;

@Controller
@RequestMapping(value = "/mascotas")
public class MascotasController {

    @Autowired
    private MascotasService mascotaService;

    List<MascotasModel> listaMascotas = new LinkedList<>();

    @GetMapping(value = "/listar")
    public String listarMascotas(Model model) {
        listaMascotas = mascotaService.listarMascotas();
        System.out.println(String.format("Lista de mascotas: %s", listaMascotas));
        model.addAttribute("mascotas", listaMascotas);
        // List<MascotasModel> listaMascota = new LinkedList<>();
        // listaMascota.add(new MascotasModel("Bethoven", 5, "Perrito Bonito", "perro",
        // "perrito1.jpg", true));
        // listaMascota.add(new MascotasModel("Dazter", 8, "Gato Bonito", "gato",
        // "gato1.jpg", true));
        // listaMascota.add(new MascotasModel("Bethoven", 7, "Perrito Bonito", "perro",
        // "perro2.jpg", true));
        // model.addAttribute("mascotas", listaMascota);
        return "index";
    }

    @GetMapping(value = { "/listar/{tipo}", "/listar/{tipo}/{adoptado}", "/listar/inicio/{adoptado}" })
    public String listarMascotasPerroGato(@PathVariable Map<String, String> pathMaps, Model model) throws Exception {
        System.out.println("Entro");
        String tipo = pathMaps.get("tipo");
        String adoptado = pathMaps.get("adoptado");

        listaMascotas.clear();

        if (adoptado == null) {
            if (tipo.equals("perro")) {
                listaMascotas.add(
                        new MascotasModel("Bethoven", 5, "Perrito Bonito", "perro", "perrito1.jpg", true, new Date()));
                listaMascotas.add(
                        new MascotasModel("Camila", 7, "Perrito Bonito", "perro", "perro2.jpg", false, new Date()));
            } else if (tipo.equals("gato")) {
                listaMascotas.add(new MascotasModel("Dazter", 8, "Gato Bonito", "gato", "gato1.jpg", true, new Date()));
                listaMascotas
                        .add(new MascotasModel("Garfield", 9, "Gato Gruñon", "gato", "gato1.jpg", false, new Date()));

            } else if (tipo.equals("inicio")) {
                listaMascotas.add(
                        new MascotasModel("Bethoven", 5, "Perrito Bonito", "perro", "perrito1.jpg", true, new Date()));
                listaMascotas.add(new MascotasModel("Dazter", 8, "Gato Bonito", "gato", "gato1.jpg", true, new Date()));
                listaMascotas.add(
                        new MascotasModel("Bethoven", 7, "Perrito Bonito", "perro", "perro2.jpg", true, new Date()));
                listaMascotas
                        .add(new MascotasModel("Garfield", 9, "Gato Gruñon", "gato", "gato1.jpg", false, new Date()));
            }
        } else {
            if (tipo.equals("perro")) {
                listaMascotas.add(
                        new MascotasModel("Bethoven", 5, "Perrito Bonito", "perro", "perrito1.jpg", true, new Date()));
            } else if (tipo.equals("gato")) {
                listaMascotas.add(new MascotasModel("Dazter", 8, "Gato Bonito", "gato", "gato1.jpg", true, new Date()));
            }

        }

        model.addAttribute("listado", listaMascotas);
        model.addAttribute("tipado", tipo);
        return "listado";
    }

    @GetMapping(value = "/listar/{tipo}/form")
    public String formMascota( MascotasModel mascotas,@PathVariable String tipo, Model model) {
        model.addAttribute("mascotas", mascotas);
        model.addAttribute("tipo", tipo);
        return "formMascota";
    }

    // @PostMapping(value = "/{tipo}/save")
    // public String addNewPet(@PathVariable String tipo,
    // @RequestParam("nombre") String nombre,
    // @RequestParam("edad") Integer edad,
    // @RequestParam("descripcion") String descripcion,
    // @RequestParam(name = "diponibleAdopcion", required = false, defaultValue =
    // "true") boolean disponibleAdopcion,
    // Model model) {

    // String tipoMascota = null, imagen = null;
    // System.out.println(disponibleAdopcion);
    // if (tipo.equals("perro")) {
    // tipoMascota = "perro";
    // imagen = "perrito1.jpg";
    // } else {
    // tipoMascota = "gato";
    // imagen = "gato1.jpg";
    // }

    // MascotasModel mascota = new MascotasModel();
    // mascota.setNombre(nombre);
    // mascota.setEdad(edad);
    // mascota.setDescripcion(descripcion);
    // mascota.setTipoMascota(tipoMascota);
    // mascota.setImagen(imagen);
    // listaMascotas.add(mascota);
    // model.addAttribute("listado", listaMascotas);
    // model.addAttribute("tipo", tipo);
    // return "listado";
    // }

    @PostMapping(value = "/{tipo}/save")
    public String savedPet(@ModelAttribute("mascotas") MascotasModel mascotas, BindingResult results,@PathVariable String tipo,  Model model) {
        if (results.hasErrors()) {
            return "formMascota";
           
        }

        if (tipo.equals("perro")) {
            mascotas.setTipoMascota("perro");
            mascotas.setImagen("perrito1.jpg");
        } else if (tipo.equals("gato")) {
            mascotas.setTipoMascota("gato");
            mascotas.setImagen("gato1.jpg");
        }
        mascotaService.guardarMascota(mascotas);
        System.out.println(mascotas.toString());
        listaMascotas = mascotaService.listarMascotas();
        model.addAttribute("tipado", tipo);
        model.addAttribute("listado", listaMascotas);
        return "listado";

    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        webDataBinder.registerCustomEditor(Date.class,
                new CustomDateEditor(dateFormat, false));
    }

}
