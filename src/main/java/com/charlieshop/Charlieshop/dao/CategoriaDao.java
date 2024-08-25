/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.charlieshop.Charlieshop.dao;

import com.charlieshop.Charlieshop.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author tutti
 */
public interface CategoriaDao extends JpaRepository<Categoria,Long>{
    
}
