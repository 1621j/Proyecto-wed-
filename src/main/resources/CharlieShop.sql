
/*
tablas:

-Categoria(id_categoria(PK),descripcion,ruta_imagen)
-Producto(id_producto(PK),id_categoria(FK),descripcion,genero,precio,cantidad,talla,ruta_imagen)
-Usuario(id_usuario(PK),username,password,nombre,apellidos,correo,telefono,direccion)
-Pedido(id_pedido(PK),id_usuario(FK),fecha,total,estado)
-Rol(id_rol(PK),id_usuario(FK),nombre).
*/

/*Se crea la base de datos */
drop schema if exists CharlieShop;
drop user if exists usuario_db;
create schema CharlieShop ;

use CharlieShop;


/*Se crea un usuario para la base de datos llamado "usuario_db" y tiene la contraseña "Pass123!"*/
create user 'usuario_db'@'%' identified by 'Pass123!';


/*Se asignan los prvilegios sobre la base de datos CharlieShop al usuario creado */
grant all privileges on CharlieShop.* to 'usuario_db'@'%';
flush privileges;


/* Se crea la tabla categoria*/

create table categoria (
  id_categoria INT NOT NULL AUTO_INCREMENT,
  descripcion VARCHAR(30) NOT NULL,
  ruta_imagen varchar(1024),
  PRIMARY KEY (id_categoria))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


/* Se crea la tabla producto*/

create table producto (
  id_producto INT NOT NULL AUTO_INCREMENT,
  id_categoria INT NOT NULL,
  descripcion VARCHAR(30) NOT NULL,
  genero VARCHAR(15) NOT NULL,  
  talla VARCHAR(5) NOT NULL,  
  precio double NOT NULL,
  cantidad int NOT NULL,  
  ruta_imagen varchar(1024),
  PRIMARY KEY (id_producto),
  foreign key fk_producto_caregoria (id_categoria) references categoria(id_categoria)  
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

/*Se crea la tabla de clientes llamada cliente... igual que la clase Cliente */
create table usuario (
  id_usuario INT NOT NULL AUTO_INCREMENT,
  username varchar(20) NOT NULL,
  password varchar(512) NOT NULL,
  nombre VARCHAR(20) NOT NULL,
  apellidos VARCHAR(30) NOT NULL,
  correo VARCHAR(25) NULL,
  telefono VARCHAR(15) NULL,
  ruta_imagen varchar(1024),
  PRIMARY KEY (id_usuario))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


create table pedido (
  id_pedido INT NOT NULL AUTO_INCREMENT,
  id_usuario INT NOT NULL,
  fecha date,  
  total double,
  estado VARCHAR(15),
  PRIMARY KEY (id_pedido),
  foreign key fk_pedido_usuario (id_usuario) references usuario(id_usuario)  
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

create table rol (
  id_rol INT NOT NULL AUTO_INCREMENT,
  nombre varchar(20),
  id_usuario int,
  PRIMARY KEY (id_rol),
  foreign key fk_rol_usuario (id_usuario) references usuario(id_usuario)
)

ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

