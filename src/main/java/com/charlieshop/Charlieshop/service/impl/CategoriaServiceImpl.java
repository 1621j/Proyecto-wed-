/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.charlieshop.Charlieshop.service.impl;

import com.charlieshop.Charlieshop.dao.CategoriaDao;
import com.charlieshop.Charlieshop.domain.Categoria;
import com.charlieshop.Charlieshop.service.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author tutti
 */

@Service
public class CategoriaServiceImpl implements CategoriaService{
    
    @Autowired
    
    private CategoriaDao categoriadao;
    
    @Override
    public List<Categoria> getCategorias(boolean activos) {
        var lista = categoriadao.findAll();
        
        if (activos) { //eliminar inactivos
            lista.removeIf(c -> !c.isActivo());
        }
        return lista;
    }

    @Override
    public Categoria getCategoria(Categoria categoria) {
        return categoriadao.findById(categoria.getIdCategoria()).orElse(null);
    }

    @Override
    public void save(Categoria categoria) {
        categoriadao.save(categoria);
    }

    @Override
    public void delete(Categoria categoria) {
        categoriadao.delete(categoria);
    }
    
}
