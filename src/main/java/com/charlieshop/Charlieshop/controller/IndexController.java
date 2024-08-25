/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.charlieshop.Charlieshop.controller;

import com.charlieshop.Charlieshop.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author tutti
 */

@Controller
public class IndexController {
    
    @Autowired
    private ProductoService productoService;
    
    @GetMapping("/")
    public String listado (Model model){
        var productos = productoService.getProductos(true);   
        model.addAttribute("productos", productos);
        return "index";
    }
}
