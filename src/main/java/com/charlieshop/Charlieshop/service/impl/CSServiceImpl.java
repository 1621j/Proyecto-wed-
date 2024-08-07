/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.charlieshop.Charlieshop.service.impl;

import com.charlieshop.Charlieshop.dao.CSDao;
import com.charlieshop.Charlieshop.domain.CSCategoria;
import com.charlieshop.Charlieshop.service.CSService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tutti
 */

@Service
public class CSServiceImpl implements CSService{
    
    @Autowired
    
    private CSDao categoriadao;
    
    @Override
    public List<CSCategoria> getCategorias(boolean activos) {
        var lista = categoriadao.findAll();
        
        if (activos) { //eliminar inactivos
            lista.removeIf(c -> !c.isActivo());
        }
        return lista;
    }

    @Override
    public CSCategoria getCategoria(CSCategoria categoria) {
        return categoriadao.findById(categoria.getIdCategoria()).orElse(null);
    }

    @Override
    public void save(CSCategoria categoria) {
        categoriadao.save(categoria);
    }

    @Override
    public void delete(CSCategoria categoria) {
        categoriadao.delete(categoria);
    }
    
}
