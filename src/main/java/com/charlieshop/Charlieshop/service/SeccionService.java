
package com.charlieshop.Charlieshop.service;

import com.charlieshop.Charlieshop.domain.Seccion;
import java.util.List;

public interface SeccionService {
    
    //Se enuncia un metodo que recupera los registros de la
    //tabla seccion dentro de un ArrayList, puden ser
    //todos los registros o solo los activos
    
    public List<Seccion> getSeccions(boolean activos);
    
    //Se obtiene un registro de la tabla seccion en un objeto Seccion
    //si el idSeccion existe... si no... se pasa un null
    
    public Seccion getSeccion(Seccion seccion);
    
    //Se crea un nuevo registro en seccion si el objeto Seccion NO tiene idSeccion - vacio-
    //Se actualiza el registro en la tabla seccion si el objeto seccion tiene un idSeccion
    
    public void save(Seccion seccion);
    
    
    //Se elimina el registro que tiene idSeccion.
    
    public void delete(Seccion seccion);
    
    
}
