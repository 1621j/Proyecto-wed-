package com.charlieshop.Charlieshop.dao;

import com.charlieshop.Charlieshop.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;


//Para modelo MVC

//La interface hereda de JpaRepository el cual recibe objetos tipo "Categoria" y la clase tiene un ID tipo "Long".

public interface CategoriaDao extends JpaRepository<Categoria,Long> {
    
}
