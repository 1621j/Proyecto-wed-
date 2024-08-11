package com.charlieshop.Charlieshop.dao;

import com.charlieshop.Charlieshop.domain.Seccion;
import org.springframework.data.jpa.repository.JpaRepository;


//Para modelo MVC

//La interface hereda de JpaRepository el cual recibe objetos tipo "Seccion" y la clase tiene un ID tipo "Long".

public interface SeccionDao extends JpaRepository<Seccion,Long> {
    
}
