 
package com.charlieshop.Charlieshop.controller;

import com.charlieshop.Charlieshop.domain.Categoria;
import com.charlieshop.Charlieshop.service.CategoriaService;
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
@RequestMapping("/categoria") //Clase controladora ruta localhost/categoria y las subrutas. Esta ruta se ve en el navegador.
public class CategoriaController {
    
    @Autowired
    private CategoriaService categoriaService;
    
    @GetMapping ("/listado") //Es la subruta del mapeo anterior. (localhost/categoria/listado). Aca se hace el codigo de lo que queremos mostrar en esta ruta.
    public String listado(Model model){   //Model es un objeto que se utiliza para pasar informacion a paginas html.
        var lista = categoriaService.getCategorias(false);
        model.addAttribute("categorias",lista);
        model.addAttribute("totalCategorias",lista.size());
        
        return "/categoria/listado";  //retorna la ruta de la pagina html. (templates/categoria/listado.html). Es diferente a la ruta del navegador o metodo mencionado anteriormente.
    }
    
    @Autowired
    private FirebaseStorageService firebaseStorageService;
    
    @PostMapping("/guardar")
    public String guardar(Categoria categoria, @RequestParam MultipartFile imagenFile){
        if(!imagenFile.isEmpty()) {
            //Se sube la imagen al Storage
            categoriaService.save(categoria);
            String rutaImagen=firebaseStorageService.cargaImagen(imagenFile, "categoria", categoria.getIdCategoria());
            categoria.setRutaImagen(rutaImagen);
        }
        categoriaService.save(categoria);
        return "redirect:/categoria/listado";
    }
    
    @GetMapping ("/eliminar/{idCategoria}")
    public String eliminar(Categoria categoria){
        categoriaService.delete(categoria);
        return "redirect:/categoria/listado";
    }
    
    @GetMapping ("/modificar/{idCategoria}")
    public String modificar(Categoria categoria,Model model){
        categoria = categoriaService.getCategoria(categoria);
        model.addAttribute("categoria", categoria);       
        return "/categoria/modifica";
    }
    
}
