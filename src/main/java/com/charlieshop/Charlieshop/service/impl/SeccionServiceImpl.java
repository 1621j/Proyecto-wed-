
package com.charlieshop.Charlieshop.service.impl;

import com.charlieshop.Charlieshop.dao.SeccionDao;
import com.charlieshop.Charlieshop.domain.Seccion;
import com.charlieshop.Charlieshop.service.SeccionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Se utiliza @Service para especificar que la clase sera un servicio.


@Service
public class SeccionServiceImpl implements SeccionService {       //Implementa de SeccionService (Hay que importar todos los metodos abstractos @Override).
    
    @Autowired              //Se utiliza que el mismo objeto se cargue en memoria para todos los usuarios. No crea diferentes instancias del mismo. Para mejorar el rendimiento.
    private SeccionDao seccionDao;
    
    @Override
    public List<Seccion> getSeccions(boolean activos){
        var lista = seccionDao.findAll();
        
        if (activos) {     //Eliminar los inactivos
            lista.removeIf(c -> !c.isActivo());      //
        }
        
        return lista;
    }

    @Override
    public Seccion getSeccion(Seccion seccion) {
        return seccionDao.findById(seccion.getIdSeccion()).orElse(null);
    }

    @Override
    public void save(Seccion seccion) {
        seccionDao.save(seccion);
        
    }

    @Override
    public void delete(Seccion seccion) {
        seccionDao.delete(seccion);
    }
    
}
