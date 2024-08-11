package com.charlieshop.Charlieshop.controller;

import com.charlieshop.Charlieshop.domain.Perfumeria;
import com.charlieshop.Charlieshop.service.PerfumeriaService;
import com.charlieshop.Charlieshop.service.FirebaseStorageService;
import com.charlieshop.Charlieshop.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/perfumeria") //Clase controladora ruta localhost/perfumeria y las subrutas. Esta ruta se ve en el navegador.
public class PerfumeriaController {

//    @Autowired
//    private PerfumeriaService perfumeriaService;
    
    @Autowired
    private ProductoService productoService;

    @GetMapping("/listado") //Es la subruta del mapeo anterior. (localhost/perfumeria/listado). Aca se hace el codigo de lo que queremos mostrar en esta ruta.
    public String listado(Model model) {   //Model es un objeto que se utiliza para pasar informacion a paginas html.
//        var lista = perfumeriaService.getPerfumerias(false);
//        model.addAttribute("perfumerias",lista);
//        model.addAttribute("totalPerfumerias",lista.size());

//        var lista = productoService.getProductosPer(5);
//        model.addAttribute("perfumerias", lista);
//        model.addAttribute("totalPerfumerias", lista.size());

        return "/perfumeria/listado";  //retorna la ruta de la pagina html. (templates/perfumeria/listado.html). Es diferente a la ruta del navegador o metodo mencionado anteriormente.
    }

    @Autowired
    private FirebaseStorageService firebaseStorageService;

//    @PostMapping("/guardar")
//    public String guardar(Perfumeria perfumeria, @RequestParam MultipartFile imagenFile) {
//        if (!imagenFile.isEmpty()) {
//            //Se sube la imagen al Storage
//            perfumeriaService.save(perfumeria);
//            String rutaImagen = firebaseStorageService.cargaImagen(imagenFile, "perfumeria", perfumeria.getIdPerfumeria());
//            perfumeria.setRutaImagen(rutaImagen);
//        }
//        perfumeriaService.save(perfumeria);
//        return "redirect:/perfumeria/listado";
//    }
//
//    @GetMapping("/eliminar/{idPerfumeria}")
//    public String eliminar(Perfumeria perfumeria) {
//        perfumeriaService.delete(perfumeria);
//        return "redirect:/perfumeria/listado";
//    }
//
//    @GetMapping("/modificar/{idPerfumeria}")
//    public String modificar(Perfumeria perfumeria, Model model) {
//        perfumeria = perfumeriaService.getPerfumeria(perfumeria);
//        model.addAttribute("perfumeria", perfumeria);
//        return "/perfumeria/modifica";
//    }

}
