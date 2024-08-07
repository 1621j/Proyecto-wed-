/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.charlieshop.Charlieshop.service;

import com.charlieshop.Charlieshop.domain.CSCategoria;
import java.util.List;

/**
 *
 * @author tutti
 */
public interface CSService {
    
    public List<CSCategoria> getCategorias(boolean activos);
    
    public CSCategoria getCategoria(CSCategoria categoria);
    
    public void save (CSCategoria categoria);
    
    public void delete (CSCategoria categoria);
}
