/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.charlieshop.Charlieshop.service;

import com.charlieshop.Charlieshop.domain.Producto;
import java.util.List;

/**
 *
 * @author tutti
 */
public interface ProductoService {
    
    public List<Producto> getProductos(boolean activos);
    
    public Producto getProducto(Producto producto);
    
    public void save (Producto producto);
    
    public void delete (Producto producto);
    
    //Retorna una lista de porductos que se encuentran en un ragno de precios
    public List<Producto> consulta1(double precioInf, double precioSup);
}
