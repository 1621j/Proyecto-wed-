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
@RequestMapping("/descuentos")
public class DescuentosController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private CategoriaService categoriaService;
   
    private final ProductoDao productodao;
    
    @Autowired
    public DescuentosController(ProductoDao productodao){
        this.productodao = productodao;
    }

    @GetMapping("/listado")
    public String getDescuentos(Model model) {        
        String categoriaDescuentosHombres = "Descuentos - Hombres"; 
        List<Producto> descuentosHombres = productodao.findByCategoriaDescripcion(categoriaDescuentosHombres);
        model.addAttribute("descuentosHombres",descuentosHombres);
        
        String categoriaDescuentosMujeres = "Descuentos - Mujeres"; 
        List<Producto> descuentosMujeres = productodao.findByCategoriaDescripcion(categoriaDescuentosMujeres);
        model.addAttribute("descuentosMujeres",descuentosMujeres);
        
        
 
        return "/descuentos/listado";
        
    }
    

    @GetMapping("/listado/{idCategoria}")
    public String listado(Categoria categoria, Model model) {
        var productos = categoriaService.getCategoria(categoria).getProductos();
        model.addAttribute("productos", productos);

//        var categorias = categoriaService.getCategorias(false);
//        model.addAttribute("categoriass", categorias);

        return "/descuentos/listado";
    }

    @GetMapping("/listado2")
    public String listado2(Model model) {
        var productos = productoService.getProductos(false);
        model.addAttribute("productos", productos);

        return "/pruebas/listado2";
    }

    @PostMapping("/consulta1")
    public String consulta1(@RequestParam(value = "precioInf") double precioInf,
            @RequestParam(value = "precioSup") double precioSup, Model model) {

        var productos = productoService.consulta1(precioInf, precioSup);
        model.addAttribute("productos", productos);
        model.addAttribute("precioInf", precioInf);
        model.addAttribute("precioSup", precioSup);
        return "/pruebas/listado2";
    }
}
