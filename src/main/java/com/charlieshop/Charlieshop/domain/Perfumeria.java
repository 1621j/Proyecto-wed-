package com.charlieshop.Charlieshop.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

// Esta clase se crea solamente para hacer un mapeo de las tablas de la base de datos con los atributos del codigo.
//Las columnas de la tabla de base de datos se agregan como atributos en esta clase.
// Para crear constructores, sets, gets solo se pone @Data arriba del public class y se hace los importesde lombok.
// Se agrega @Entity y se hace importe de jakarta para especificar que esta clase va a hacer el mapeo de una tabla.


@Data
@Entity
@Table(name = "perfumeria")
public class Perfumeria implements Serializable { //Se importa de Serializable porque se envia informacion a la BD por medio de objetos "Perfumeria".

    private static final long serialVersionUID = 1l;      

    @Id                                                   //Se utiliza para especificar la llave de la tabla (Primary Key).
    @GeneratedValue(strategy = GenerationType.IDENTITY)   //Se utiliza para especificar los valores generados sean identicos a los generados en la BD.
    @Column(name = "id_perfumeria")                        //Es opcional. Se utiliza para mapear columans de bases de datos y atributos de codigos que tienen nombres distintos.
    private Long idPerfumeria;
    
    private String descripcion;
    private String rutaImagen;
    private boolean activo;
    
    /*
    @OneToMany
    @JoinColumn(name="id_perfumeria", updatable=false)
    private List<Producto> productos;
    */
    
}
