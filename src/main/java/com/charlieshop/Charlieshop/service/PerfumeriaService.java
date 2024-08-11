
package com.charlieshop.Charlieshop.service;

import com.charlieshop.Charlieshop.domain.Perfumeria;
import java.util.List;

public interface PerfumeriaService {
    
    //Se enuncia un metodo que recupera los registros de la
    //tabla perfumeria dentro de un ArrayList, puden ser
    //todos los registros o solo los activos
    
    public List<Perfumeria> getPerfumerias(boolean activos);
    
    //Se obtiene un registro de la tabla perfumeria en un objeto Perfumeria
    //si el idPerfumeria existe... si no... se pasa un null
    
    public Perfumeria getPerfumeria(Perfumeria perfumeria);
    
    //Se crea un nuevo registro en perfumeria si el objeto Perfumeria NO tiene idPerfumeria - vacio-
    //Se actualiza el registro en la tabla perfumeria si el objeto perfumeria tiene un idPerfumeria
    
    public void save(Perfumeria perfumeria);
    
    
    //Se elimina el registro que tiene idPerfumeria.
    
    public void delete(Perfumeria perfumeria);
    
    
}
