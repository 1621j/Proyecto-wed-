/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.charlieshop.Charlieshop.controller;

/**
 *
 * @author tutti
 */

import com.charlieshop.Charlieshop.domain.Categoria;
import com.charlieshop.Charlieshop.service.CategoriaService;
import com.charlieshop.Charlieshop.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/caballeros")
public class CaballerosController {

    @GetMapping("/caballeros") 
    public String caballeros(Model model) {
        return "caballeros/caballeros"; 
    }
    

}
