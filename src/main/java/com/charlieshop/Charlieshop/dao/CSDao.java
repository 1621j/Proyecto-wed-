/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.charlieshop.Charlieshop.dao;

import com.charlieshop.Charlieshop.domain.CSCategoria;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author tutti
 */
public interface CSDao extends JpaRepository<CSCategoria,Long>{
    
}
