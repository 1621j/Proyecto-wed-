
package com.charlieshop.Charlieshop.service.impl;

import com.charlieshop.Charlieshop.dao.CategoriaDao;
import com.charlieshop.Charlieshop.domain.Categoria;
import com.charlieshop.Charlieshop.service.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Se utiliza @Service para especificar que la clase sera un servicio.


@Service
public class CategoriaServiceImpl implements CategoriaService {       //Implementa de CategoriaService (Hay que importar todos los metodos abstractos @Override).
    
    @Autowired              //Se utiliza que el mismo objeto se cargue en memoria para todos los usuarios. No crea diferentes instancias del mismo. Para mejorar el rendimiento.
    private CategoriaDao categoriaDao;
    
    @Override
    public List<Categoria> getCategorias(boolean activos){
        var lista = categoriaDao.findAll();
        
        if (activos) {     //Eliminar los inactivos
            lista.removeIf(c -> !c.isActivo());      //
        }
        
        return lista;
    }

    @Override
    public Categoria getCategoria(Categoria categoria) {
        return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);
    }

    @Override
    public void save(Categoria categoria) {
        categoriaDao.save(categoria);
        
    }

    @Override
    public void delete(Categoria categoria) {
        categoriaDao.delete(categoria);
    }
    
}
