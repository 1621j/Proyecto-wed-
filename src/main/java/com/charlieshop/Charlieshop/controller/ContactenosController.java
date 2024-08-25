package com.charlieshop.Charlieshop.controller;

import com.charlieshop.Charlieshop.dao.ProductoDao;
import com.charlieshop.Charlieshop.domain.Categoria;
import com.charlieshop.Charlieshop.domain.Producto;
import com.charlieshop.Charlieshop.service.CategoriaService;
import com.charlieshop.Charlieshop.service.ProductoService;
import com.charlieshop.Charlieshop.service.FireBaseStorageService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/contactenos")
public class ContactenosController {
    

    @GetMapping("/listado")
    public String listado(Model model) {
        
        return "/contactenos/listado";
    }
    
}