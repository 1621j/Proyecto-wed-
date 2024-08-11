
package com.charlieshop.Charlieshop.service.impl;

import com.charlieshop.Charlieshop.dao.PerfumeriaDao;
import com.charlieshop.Charlieshop.domain.Perfumeria;
import com.charlieshop.Charlieshop.service.PerfumeriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Se utiliza @Service para especificar que la clase sera un servicio.


@Service
public class PerfumeriaServiceImpl implements PerfumeriaService {       //Implementa de PerfumeriaService (Hay que importar todos los metodos abstractos @Override).
    
    @Autowired              //Se utiliza que el mismo objeto se cargue en memoria para todos los usuarios. No crea diferentes instancias del mismo. Para mejorar el rendimiento.
    private PerfumeriaDao perfumeriaDao;
    
    @Override
    public List<Perfumeria> getPerfumerias(boolean activos){
        var lista = perfumeriaDao.findAll();
        
        if (activos) {     //Eliminar los inactivos
            lista.removeIf(c -> !c.isActivo());      //
        }
        
        return lista;
    }

    @Override
    public Perfumeria getPerfumeria(Perfumeria perfumeria) {
        return perfumeriaDao.findById(perfumeria.getIdPerfumeria()).orElse(null);
    }

    @Override
    public void save(Perfumeria perfumeria) {
        perfumeriaDao.save(perfumeria);
        
    }

    @Override
    public void delete(Perfumeria perfumeria) {
        perfumeriaDao.delete(perfumeria);
    }
    
}
