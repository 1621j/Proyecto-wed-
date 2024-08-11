package com.charlieshop.Charlieshop.dao;

import com.charlieshop.Charlieshop.domain.Perfumeria;
import org.springframework.data.jpa.repository.JpaRepository;


//Para modelo MVC

//La interface hereda de JpaRepository el cual recibe objetos tipo "Perfumeria" y la clase tiene un ID tipo "Long".

public interface PerfumeriaDao extends JpaRepository<Perfumeria,Long> {
    
}
