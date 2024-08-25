/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.charlieshop.Charlieshop.service.impl;

import com.charlieshop.Charlieshop.dao.ProductoDao;
import com.charlieshop.Charlieshop.domain.Producto;
import com.charlieshop.Charlieshop.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author tutti
 */

@Service
public class ProductoServiceImpl implements ProductoService{
    
    @Autowired
    
    private ProductoDao productodao;
    
    @Override
    @Transactional(readOnly=true)
    public List<Producto> getProductos(boolean activos) {
        var lista = productodao.findAll();
        
        if (activos) { //eliminar inactivos
            lista.removeIf(c -> !c.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional
    public Producto getProducto(Producto producto) {
        return productodao.findById(producto.getIdProducto()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Producto producto) {
        productodao.save(producto);
    }

    @Override
    @Transactional
    public void delete(Producto producto) {
        productodao.delete(producto);
    }

    @Override
    @Transactional(readOnly=true)
    public List<Producto> consulta1(double precioInf, double precioSup) {
        return productodao.findByPrecioBetweenOrderByDescripcion(precioInf, precioSup);
    }
}
