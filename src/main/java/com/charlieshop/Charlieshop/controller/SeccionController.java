 
package com.charlieshop.Charlieshop.controller;

import com.charlieshop.Charlieshop.domain.Seccion;
import com.charlieshop.Charlieshop.service.SeccionService;
import com.charlieshop.Charlieshop.service.FirebaseStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/seccion") //Clase controladora ruta localhost/seccion y las subrutas. Esta ruta se ve en el navegador.
public class SeccionController {
    
    @Autowired
    private SeccionService seccionService;
    
    @GetMapping ("/listado") //Es la subruta del mapeo anterior. (localhost/seccion/listado). Aca se hace el codigo de lo que queremos mostrar en esta ruta.
    public String listado(Model model){   //Model es un objeto que se utiliza para pasar informacion a paginas html.
        var lista = seccionService.getSeccions(false);
        model.addAttribute("seccions",lista);
        model.addAttribute("totalSeccions",lista.size());
        
        return "/seccion/listado";  //retorna la ruta de la pagina html. (templates/seccion/listado.html). Es diferente a la ruta del navegador o metodo mencionado anteriormente.
    }
    
    @Autowired
    private FirebaseStorageService firebaseStorageService;
    
    @PostMapping("/guardar")
    public String guardar(Seccion seccion, @RequestParam MultipartFile imagenFile){
        if(!imagenFile.isEmpty()) {
            //Se sube la imagen al Storage
            seccionService.save(seccion);
            String rutaImagen=firebaseStorageService.cargaImagen(imagenFile, "seccion", seccion.getIdSeccion());
            seccion.setRutaImagen(rutaImagen);
        }
        seccionService.save(seccion);
        return "redirect:/seccion/listado";
    }
    
    @GetMapping ("/eliminar/{idSeccion}")
    public String eliminar(Seccion seccion){
        seccionService.delete(seccion);
        return "redirect:/seccion/listado";
    }
    
    @GetMapping ("/modificar/{idSeccion}")
    public String modificar(Seccion seccion,Model model){
        seccion = seccionService.getSeccion(seccion);
        model.addAttribute("seccion", seccion);       
        return "/seccion/modifica";
    }
    
}
