/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.charlieshop.Charlieshop.controller;

import com.charlieshop.Charlieshop.domain.CSCategoria;
import com.charlieshop.Charlieshop.service.FireBaseStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.charlieshop.Charlieshop.service.CSService;

/**
 *
 * @author tutti
 */

@Controller
@RequestMapping("/categoria")
public class CSController {
    
    @Autowired
    private CSService categoriaService;
    
    @GetMapping("/listado")
    public String listado (Model model){
        var lista = categoriaService.getCategorias(false);
        
        model.addAttribute("categorias", lista);
        model.addAttribute("totalCategorias", lista.size());
        
        return "/categoria/listado";
    }
    
    @Autowired
    private FireBaseStorageService firebaseStorageService;
    
    @PostMapping("/guardar")
    public String guardar(CSCategoria categoria, @RequestParam MultipartFile imagenFile){
        
       if (!imagenFile.isEmpty()){
           categoriaService.save(categoria);
           String rutaImagen = firebaseStorageService.cargaImagen(imagenFile, "categoria", categoria.getIdCategoria());
           categoria.setRutaImagen(rutaImagen);
       }
       
       categoriaService.save(categoria);
    
        return "redirect:/categoria/listado";
    }
    
    @GetMapping("/eliminar/{idCategoria}")
    public String eliminar(CSCategoria categoria){
        
        categoriaService.delete(categoria);
        return "redirect:/categoria/listado";
    }
    
    @GetMapping("/modificar/{idCategoria}")
    public String modificar(CSCategoria categoria, Model model){
        
        categoria = categoriaService.getCategoria(categoria);
        model.addAttribute("categoria", categoria);
        return "/categoria/modifica";
    }
    
    /* hola*/
}
