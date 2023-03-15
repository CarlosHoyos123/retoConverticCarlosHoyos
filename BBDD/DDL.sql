--DROP DATABASE IF EXISTS e_commerce;

CREATE DATABASE e_commerce
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

CREATE TABLE IF NOT EXISTS tblpaises(
id_pais             SERIAL      PRIMARY KEY,
nombre_pais         VARCHAR(15) UNIQUE
);
INSERT INTO tblpaises (nombre_pais) VALUES ('COLOMBIA');
INSERT INTO tblpaises (nombre_pais) VALUES ('ECUADOR');
INSERT INTO tblpaises (nombre_pais) VALUES ('PARAGUAY');
INSERT INTO tblpaises (nombre_pais) VALUES ('MEXICO');
INSERT INTO tblpaises (nombre_pais) VALUES ('EEUU');

CREATE TABLE IF NOT EXISTS tbldirecciones_envio(
id_direccion_envio  SERIAL      PRIMARY KEY,
direccion           VARCHAR(100),
zip_code            VARCHAR(12),
ID_cliente          INTEGER,
ID_pais             int2,        FOREIGN KEY (ID_pais) REFERENCES tblpaises(id_pais)
);
INSERT INTO tbldirecciones_envio (direccion, zip_code, ID_cliente, id_pais) VALUES ('calle 78 b 85 A 28','050041',1,1);
INSERT INTO tbldirecciones_envio (direccion, zip_code, ID_cliente, id_pais) VALUES ('carrera 85 B 78 b 40','050046',2,2);
INSERT INTO tbldirecciones_envio (direccion, zip_code, ID_cliente, id_pais) VALUES ('calle 35 76 b 20','050046',3,1);
INSERT INTO tbldirecciones_envio (direccion, zip_code, ID_cliente, id_pais) VALUES ('carrera 85 23 c 01','050046',4,3);
INSERT INTO tbldirecciones_envio (direccion, zip_code, ID_cliente, id_pais) VALUES ('calle 78 c 81 a 24','050046',5,4);
INSERT INTO tbldirecciones_envio (direccion, zip_code, ID_cliente, id_pais) VALUES ('avenida 80 91 a 17','050046',6,1);

CREATE TABLE IF NOT EXISTS tbltipo_documento(
id_tipo_documento   SERIAL      PRIMARY KEY,
tipo_documento   VARCHAR(30)
);
INSERT INTO tbltipo_documento(tipo_documento) VALUES ('CEDULA');
INSERT INTO tbltipo_documento(tipo_documento) VALUES ('PASAPORTE');
INSERT INTO tbltipo_documento(tipo_documento) VALUES ('NIT');
INSERT INTO tbltipo_documento(tipo_documento) VALUES ('CEDULA DE EXTRANGERIA');

CREATE TABLE IF NOT EXISTS tbldireccion_facturacion(
id_direccion_facturacion SERIAL PRIMARY KEY,
direccion           VARCHAR(100),
zip_code            VARCHAR(12),
ID_cliente          INTEGER,
ID_pais             int2,        FOREIGN KEY (ID_pais) REFERENCES tblpaises(id_pais)
);
INSERT INTO tbldireccion_facturacion (direccion, zip_code,ID_cliente, id_pais) VALUES ('calle 3 55 A 28','050061',1,1);
INSERT INTO tbldireccion_facturacion (direccion, zip_code,ID_cliente, id_pais) VALUES ('circular 4 38 b 120','050066',2,2);
INSERT INTO tbldireccion_facturacion (direccion, zip_code,ID_cliente, id_pais) VALUES ('calle 3 55 A 80','050061',4,3);
INSERT INTO tbldireccion_facturacion (direccion, zip_code,ID_cliente, id_pais) VALUES ('circular 1 38 b 10','050066',3,1);
INSERT INTO tbldireccion_facturacion (direccion, zip_code,ID_cliente, id_pais) VALUES ('carrera 3 55 A 58','050061',5,2);
INSERT INTO tbldireccion_facturacion (direccion, zip_code,ID_cliente, id_pais) VALUES ('circular 2 38 b 140','050066',6,1);

CREATE TABLE IF NOT EXISTS tbltipo_telefono(
id_tipo_telefono    SERIAL      PRIMARY KEY,
tipo_telefono       VARCHAR(10) UNIQUE
);
INSERT INTO tbltipo_telefono (tipo_telefono) VALUES ('MOVIL');
INSERT INTO tbltipo_telefono (tipo_telefono) VALUES ('FIJO');

CREATE TABLE IF NOT EXISTS tblclientes(
id_cliente          SERIAL      PRIMARY KEY,
email               VARCHAR(30) UNIQUE,
contrasenia         VARCHAR(15),
Primer_nombre       VARCHAR(15),
segundo_nombre      VARCHAR(15),
primer_apellido     VARCHAR(15),
segundo_apellido    VARCHAR(15),
ID_tipo_telefono    int2,       FOREIGN KEY (ID_tipo_telefono) REFERENCES tbltipo_telefono(ID_tipo_telefono),
telefono            varchar(15) UNIQUE,
ID_pais             int2,       FOREIGN KEY (ID_pais) REFERENCES tblpaises(id_pais),
documento           VARCHAR(30),
ID_documento        INTEGER,    FOREIGN KEY (ID_documento) REFERENCES tbltipo_documento(id_tipo_documento)
);
INSERT INTO tblclientes(email,contrasenia,Primer_nombre,segundo_nombre,primer_apellido,segundo_apellido,ID_tipo_telefono,telefono,ID_pais,documento, ID_documento)
                        VALUES('chrodriguez.bmdc@gmail.com','contrasenia1', 'carlos', 'andres', 'hoyos', 'rodriguez', 1, '3109203038', 3, '1128300400',4);
INSERT INTO tblclientes(email,contrasenia,Primer_nombre,segundo_nombre,primer_apellido,segundo_apellido,ID_tipo_telefono,telefono,ID_pais,documento, ID_documento)
                        VALUES('alexandra.correa@gmail.com','contrasenia2','alexandra','maria','correa','lopez',2,'3005676231',1, '1128301401',1);
INSERT INTO tblclientes(email,contrasenia,Primer_nombre,segundo_nombre,primer_apellido,segundo_apellido,ID_tipo_telefono,telefono,ID_pais,documento, ID_documento)
                        VALUES('Luis.david@gmail.com','contrasenia','Luis','maria','david','lopez',2,'3005678237',1, '1128301401',1);
INSERT INTO tblclientes(email,contrasenia,Primer_nombre,segundo_nombre,primer_apellido,segundo_apellido,ID_tipo_telefono,telefono,ID_pais,documento, ID_documento)
                        VALUES('maria.amanda@gmail.com','contrasenia','maria','maria','amanda','lopez',1,'3085678231',2, '1128301401',4);
INSERT INTO tblclientes(email,contrasenia,Primer_nombre,segundo_nombre,primer_apellido,segundo_apellido,ID_tipo_telefono,telefono,ID_pais,documento, ID_documento)
                        VALUES('jose.hoyos@gmail.com','contrasenia','jose','maria','hoyos','lopez',1,'3005648231',1, '1128301401',1);
INSERT INTO tblclientes(email,contrasenia,Primer_nombre,segundo_nombre,primer_apellido,segundo_apellido,ID_tipo_telefono,telefono,ID_pais,documento, ID_documento)
                        VALUES('miguel.castaño@gmail.com','contrasenia','miguel','maria','castaño','lopez',2,'3005678281',1, '1128301401',1);
INSERT INTO tblclientes(email,contrasenia,Primer_nombre,segundo_nombre,primer_apellido,segundo_apellido,ID_tipo_telefono,telefono,ID_pais,documento, ID_documento)
                        VALUES('amparo.Ruiz@gmail.com','contrasenia','amparo','maria','Ruiz','lopez',1,'3005671231',1, '1128301401',1);

CREATE TABLE IF NOT EXISTS tblestados_factura(
id_estado           SERIAL      PRIMARY KEY,
estado              varchar(40) UNIQUE,
descripcion         text
);
INSERT INTO tblestados_factura(estado,descripcion) VALUES ('Pendiente de pago','La orden ha sido tomada pero no ha sido entregada y pagada contraentrega');
INSERT INTO tblestados_factura(estado,descripcion) VALUES ('Pagada','Este estado indica que la factura ya ha sido cancelada al ser entregada');

/*esta es la extension para usar en uuid-ossp en postgresql*/
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
SELECT uuid_generate_v1();  /*genera el uuid basado en la direccion MAC, fecha y un numero aleatorio*/
/*--------------------------*/
CREATE TABLE IF NOT EXISTS tblfacturas(
id_factura          uuid DEFAULT uuid_generate_v1 () PRIMARY KEY,
fecha_factura       DATE        NOT NULL,
ID_cliente          INTEGER,    FOREIGN KEY (ID_cliente)REFERENCES tblclientes(id_cliente),
total_factura       NUMERIC(15,2) NOT NULL,
ID_estado           INTEGER  DEFAULT 1,    FOREIGN KEY (ID_estado) REFERENCES tblestados_factura(id_estado),
ID_direccion_envio  int4,       FOREIGN KEY (ID_direccion_envio) REFERENCES tbldirecciones_envio(id_direccion_envio),
ID_direccion_facturacion int4,  FOREIGN KEY (ID_direccion_facturacion) REFERENCES tbldireccion_facturacion(id_direccion_facturacion)
);
INSERT INTO tblfacturas(fecha_factura,ID_cliente,total_factura,ID_estado,ID_direccion_envio,ID_direccion_facturacion)
                        VALUES ('2022-08-25',1,  30000.00,   1,3,2);

CREATE TABLE IF NOT EXISTS tblfabricantes(
id_fabricante       SERIAL      PRIMARY KEY,
nombre_fabricante   VARCHAR(40) UNIQUE,
contacto_fabricante VARCHAR(40) NOT NULL,
telefono_fabricante VARCHAR(15) NOT NULL
);
INSERT INTO tblfabricantes(nombre_fabricante,contacto_fabricante,telefono_fabricante) VALUES ('galax',      'paola cardona','3567890432');
INSERT INTO tblfabricantes(nombre_fabricante,contacto_fabricante,telefono_fabricante) VALUES ('everfit',    'Luis Muñoz',   '3210984157');
INSERT INTO tblfabricantes(nombre_fabricante,contacto_fabricante,telefono_fabricante) VALUES ('wear fit',   'carlos ocampo','3567740432');
INSERT INTO tblfabricantes(nombre_fabricante,contacto_fabricante,telefono_fabricante) VALUES ('ego fit',    'ricardo mina', '3210988657');
INSERT INTO tblfabricantes(nombre_fabricante,contacto_fabricante,telefono_fabricante) VALUES ('bellas wear','camilo cardi', '3567820432');
INSERT INTO tblfabricantes(nombre_fabricante,contacto_fabricante,telefono_fabricante) VALUES ('suits mens', 'miguel manuz', '3210984657');
INSERT INTO tblfabricantes(nombre_fabricante,contacto_fabricante,telefono_fabricante) VALUES ('elegant wmn','pablo camps',  '3561890432');
INSERT INTO tblfabricantes(nombre_fabricante,contacto_fabricante,telefono_fabricante) VALUES ('col people', 'laura muñoz',  '3218963657');

CREATE TABLE IF NOT EXISTS tblopciones(
id_opcion           SERIAL      PRIMARY KEY,
nombre_opcion       VARCHAR(35) NOT NULL,
descripcion_opcion  TEXT
);
INSERT INTO tblopciones(nombre_opcion,descripcion_opcion) VALUES ('Envio express',          'Envio despachado el mismo dia');
INSERT INTO tblopciones(nombre_opcion,descripcion_opcion) VALUES ('Recojida por garantia',  'En caso de defectos de fabrica se recoje en casa sin costo');
INSERT INTO tblopciones(nombre_opcion,descripcion_opcion) VALUES ('Garantia extendida',     'Extiende la garantia por tres meses');

CREATE TABLE IF NOT EXISTS tblgenero(
id_genero           SERIAL      PRIMARY KEY,
nombre              VARCHAR(30) UNIQUE
);
INSERT INTO tblgenero(nombre) VALUES ('HOMBRE');
INSERT INTO tblgenero(nombre) VALUES ('MUJER');

CREATE TABLE IF NOT EXISTS tblcategorias(
id_categoria        SERIAL      PRIMARY KEY,
nombre              VARCHAR(30) UNIQUE,
descripcion         TEXT
);
INSERT INTO tblcategorias(nombre) VALUES ('jeans hombre');
INSERT INTO tblcategorias(nombre) VALUES ('camisas polo');
INSERT INTO tblcategorias(nombre) VALUES ('jeans mujer');
INSERT INTO tblcategorias(nombre) VALUES ('ropa interior');
INSERT INTO tblcategorias(nombre) VALUES ('camisetas');
INSERT INTO tblcategorias(nombre) VALUES ('medias');
INSERT INTO tblcategorias(nombre) VALUES ('corbatas');
INSERT INTO tblcategorias(nombre) VALUES ('panuelos');
INSERT INTO tblcategorias(nombre) VALUES ('ropa deportiva');
INSERT INTO tblcategorias(nombre) VALUES ('ropa piscina');
INSERT INTO tblcategorias(nombre) VALUES ('blusas');

CREATE TABLE IF NOT EXISTS tbltallas (
id_talla            SERIAL      PRIMARY KEY,
nombre              VARCHAR(25) NOT NULL,
talla               VARCHAR (5) UNIQUE
);
INSERT INTO tbltallas(nombre,talla) VALUES('Extra Pequeña',   'XS');
INSERT INTO tbltallas(nombre,talla) VALUES('Pequeña',   'S');
INSERT INTO tbltallas(nombre,talla) VALUES('Mediana',   'M');
INSERT INTO tbltallas(nombre,talla) VALUES('Grande',    'L');
INSERT INTO tbltallas(nombre,talla) VALUES('Extra Grande',   'XL');
INSERT INTO tbltallas(nombre,talla) VALUES('Extra XL',   'XXL');

CREATE TABLE IF NOT EXISTS tblcolor (
id_color            SERIAL      PRIMARY KEY,
color               VARCHAR(20),
hexadecimal         VARCHAR(10) UNIQUE
);
INSERT INTO tblcolor(color,hexadecimal) VALUES('amarillo',  '#FFFF00');
INSERT INTO tblcolor(color,hexadecimal) VALUES('azul rey',  '#0000FF');
INSERT INTO tblcolor(color,hexadecimal) VALUES('rojo',      '#FF0000');
INSERT INTO tblcolor(color,hexadecimal) VALUES('naranjado', '#FFA500');
INSERT INTO tblcolor(color,hexadecimal) VALUES('negro',     '#000000');
INSERT INTO tblcolor(color,hexadecimal) VALUES('gris',      '#808080');

CREATE TABLE IF NOT EXISTS tblproductos(
id_producto         SERIAL      PRIMARY KEY,
plu                 VARCHAR(10) UNIQUE NOT NULL,
nombre_producto     VARCHAR(80) NOT NULL,
ID_fabricante       INTEGER,    FOREIGN KEY (ID_fabricante) REFERENCES tblfabricantes(id_fabricante),
precio              NUMERIC(8,2) NOT NULL,
descripcion_producto TEXT,
fecha_creacion      DATE        NOT NULL,
ID_genero           INTEGER,    FOREIGN KEY (ID_genero) REFERENCES tblgenero(id_genero),
cantidad_busquedas  BIGINT,
fotos               VARCHAR(200)
);
INSERT INTO tblproductos(plu,nombre_producto,ID_fabricante,precio,descripcion_producto,fecha_creacion,ID_genero,cantidad_busquedas,fotos)
                VALUES ('p001','Medias para clima frio',1,18000.00,'EN TELA PARA FRIO','2022-10-22',2,12,'../../../assets/images/mediasFrio.jpg');
INSERT INTO tblproductos(plu,nombre_producto,ID_fabricante,precio,descripcion_producto,fecha_creacion,ID_genero,cantidad_busquedas,fotos)
                VALUES ('p002','camisa polo hombre',4,60000.00,'TIPO POLO EN ALGODON','2022-10-23',1,11,'../../../assets/images/poloHombre.jpg');
INSERT INTO tblproductos(plu,nombre_producto,ID_fabricante,precio,descripcion_producto,fecha_creacion,ID_genero,cantidad_busquedas,fotos)
                VALUES ('p003','camisa polo mujer',2,55000.00,'EN TELA DE DE ALGODON DE MUJER','2022-10-22',2,10,'../../../assets/images/poloMujer.jpg');
INSERT INTO tblproductos(plu,nombre_producto,ID_fabricante,precio,descripcion_producto,fecha_creacion,ID_genero,cantidad_busquedas,fotos)
                VALUES ('p004','boxer largo rayado vertical',1,16000.00,'EN TELA SINTETICA','2022-10-23',1,9,'../../../assets/images/boxerRayado.jpg');
INSERT INTO tblproductos(plu,nombre_producto,ID_fabricante,precio,descripcion_producto,fecha_creacion,ID_genero,cantidad_busquedas,fotos)
                VALUES ('p005','Medias de traje',6,15000.00,'EN TELA DELGADA PARA TRAJE','2022-10-22',1,8,'../../../assets/images/mediasTraje.jpg');
INSERT INTO tblproductos(plu,nombre_producto,ID_fabricante,precio,descripcion_producto,fecha_creacion,ID_genero,cantidad_busquedas,fotos)
                VALUES ('p006','camisa esqueleto',4,30000.00,'CAMISA EN ALGODON','2022-10-23',1,7,'../../../assets/images/esqueleto.jpg');
INSERT INTO tblproductos(plu,nombre_producto,ID_fabricante,precio,descripcion_producto,fecha_creacion,ID_genero,cantidad_busquedas,fotos)
                VALUES ('p007','Medias tobillera',8,5000.00,'EN ALGODON QUE QUE NO SE VE','2022-10-22',2,6,'../../../assets/images/tobillera.jpg');
INSERT INTO tblproductos(plu,nombre_producto,ID_fabricante,precio,descripcion_producto,fecha_creacion,ID_genero,cantidad_busquedas,fotos)
                VALUES ('p008','jean mujer con degradado',5,80000.00,'JEAN CASUAL','2022-10-23',2,5,'../../../assets/images/jeanMujer.jpg');
INSERT INTO tblproductos(plu,nombre_producto,ID_fabricante,precio,descripcion_producto,fecha_creacion,ID_genero,cantidad_busquedas,fotos)
                VALUES ('p009','pantaloneta baño',3,28000.00,'EN TELA DE SECADO RAPIDO','2022-10-22',1,4,'../../../assets/images/pantalonetaBaño.jpg');
INSERT INTO tblproductos(plu,nombre_producto,ID_fabricante,precio,descripcion_producto,fecha_creacion,ID_genero,cantidad_busquedas,fotos)
                VALUES ('p010','blusa flores',7,60000.00,'BLUSA EN ALGODON ESTAMPADO DE FLORES','2022-10-23',2,3,'../../../assets/images/blusaFlores.jpg');
INSERT INTO tblproductos(plu,nombre_producto,ID_fabricante,precio,descripcion_producto,fecha_creacion,ID_genero,cantidad_busquedas,fotos)
                VALUES ('p011','pantaloneta deportiva',1,27000.00,'EN TELA DE SECADO RAPIDO','2022-10-22',2,2,'../../../assets/images/deportiva.jpg');
INSERT INTO tblproductos(plu,nombre_producto,ID_fabricante,precio,descripcion_producto,fecha_creacion,ID_genero,cantidad_busquedas,fotos)
                VALUES ('p012','camiseta estampada espadas',6,60000.00,'PARA HOMBRE EN ALGODON','2022-10-23',1,1,'../../../assets/images/espadas.jpg');

CREATE TABLE IF NOT EXISTS tblprod_color_talla (
idcoloxtalla        SERIAL      PRIMARY KEY,
ID_producto         INTEGER     NOT NULL, FOREIGN KEY (ID_producto) REFERENCES tblproductos(id_producto),
ID_color            INTEGER,    FOREIGN KEY (ID_color) REFERENCES tblcolor(id_color),
ID_talla            INTEGER,    FOREIGN KEY (ID_talla) REFERENCES tbltallas(id_talla),
inventario          INT2        NOT NULL
);
INSERT INTO tblprod_color_talla(ID_producto,ID_color,ID_talla,inventario)VALUES(1,5,2,45);
INSERT INTO tblprod_color_talla(ID_producto,ID_color,ID_talla,inventario)VALUES(2,4,3,87);
INSERT INTO tblprod_color_talla(ID_producto,ID_color,ID_talla,inventario)VALUES(3,3,4,12);
INSERT INTO tblprod_color_talla(ID_producto,ID_color,ID_talla,inventario)VALUES(4,2,5,5);
INSERT INTO tblprod_color_talla(ID_producto,ID_color,ID_talla,inventario)VALUES(5,5,4,56);
INSERT INTO tblprod_color_talla(ID_producto,ID_color,ID_talla,inventario)VALUES(2,6,3,26);
INSERT INTO tblprod_color_talla(ID_producto,ID_color,ID_talla,inventario)VALUES(3,1,2,37);
INSERT INTO tblprod_color_talla(ID_producto,ID_color,ID_talla,inventario)VALUES(4,5,2,55);
INSERT INTO tblprod_color_talla(ID_producto,ID_color,ID_talla,inventario)VALUES(5,6,3,23);

CREATE TABLE IF NOT EXISTS tblopciones_producto( 
id_op_prod          SERIAL      PRIMARY KEY,
ID_opcion           INTEGER,    FOREIGN KEY (ID_opcion) REFERENCES tblopciones(id_opcion),
ID_producto         INTEGER,    FOREIGN KEY (ID_producto) REFERENCES tblproductos(id_producto)
);
INSERT INTO tblopciones_producto (ID_opcion, ID_producto) VALUES (1,1);
INSERT INTO tblopciones_producto (ID_opcion, ID_producto) VALUES (2,4);
INSERT INTO tblopciones_producto (ID_opcion, ID_producto) VALUES (3,5);
INSERT INTO tblopciones_producto (ID_opcion, ID_producto) VALUES (3,8);
INSERT INTO tblopciones_producto (ID_opcion, ID_producto) VALUES (3,7);
INSERT INTO tblopciones_producto (ID_opcion, ID_producto) VALUES (2,12);
INSERT INTO tblopciones_producto (ID_opcion, ID_producto) VALUES (1,6);
INSERT INTO tblopciones_producto (ID_opcion, ID_producto) VALUES (2,4);

CREATE TABLE IF NOT EXISTS tblcategorias_producto(
id_cat_prod         SERIAL      PRIMARY KEY,
ID_categoria        INTEGER,    FOREIGN KEY (ID_categoria) REFERENCES tblcategorias(id_categoria),
ID_producto         INTEGER,    FOREIGN KEY (ID_producto) REFERENCES tblproductos(id_producto)
);
INSERT INTO tblcategorias_producto (ID_categoria, ID_producto) VALUES(6,1);
INSERT INTO tblcategorias_producto (ID_categoria, ID_producto) VALUES(2,2);
INSERT INTO tblcategorias_producto (ID_categoria, ID_producto) VALUES(2,3);
INSERT INTO tblcategorias_producto (ID_categoria, ID_producto) VALUES(4,4);
INSERT INTO tblcategorias_producto (ID_categoria, ID_producto) VALUES(4,6);
INSERT INTO tblcategorias_producto (ID_categoria, ID_producto) VALUES(6,7);
INSERT INTO tblcategorias_producto (ID_categoria, ID_producto) VALUES(3,8);
INSERT INTO tblcategorias_producto (ID_categoria, ID_producto) VALUES(10,9);
INSERT INTO tblcategorias_producto (ID_categoria, ID_producto) VALUES(9,11);
INSERT INTO tblcategorias_producto (ID_categoria, ID_producto) VALUES(5,12);
INSERT INTO tblcategorias_producto (ID_categoria, ID_producto) VALUES(11,10);
INSERT INTO tblcategorias_producto (ID_categoria, ID_producto) VALUES(9,6);

CREATE TABLE IF NOT EXISTS tbldetalle_factura(
id_det_fac          SERIAL      PRIMARY KEY,
ID_factura          uuid , FOREIGN KEY (ID_factura) REFERENCES tblfacturas(id_factura),
ID_producto         INTEGER,    FOREIGN KEY (ID_producto) REFERENCES tblproductos(id_producto),
ID_color            INTEGER,    FOREIGN KEY (ID_color) REFERENCES tblcolor(id_color),
ID_talla            INTEGER,    FOREIGN KEY (ID_talla) REFERENCES tbltallas(id_talla),
cantidad            INTEGER        NOT NULL,
total_producto      NUMERIC(14,2)
);


CREATE TABLE IF NOT EXISTS tblshopping_car(
    id_car          SERIAL   PRIMARY KEY,
    ID_cliente      INTEGER, FOREIGN KEY(id_cliente) REFERENCES tblclientes,
    fecha_creacion  DATE,
    ID_producto     INTEGER, FOREIGN KEY (id_producto) REFERENCES tblproductos,
    ID_talla        INTEGER, FOREIGN KEY (id_talla) REFERENCES tbltallas,
    ID_color        INTEGER, FOREIGN KEY (id_color) REFERENCES tblcolor,
    cantidad        INTEGER
)

--+++++++++++ AGREGAR FOREIGNS KEY CON ALTER ++++++++++

ALTER TABLE tbldirecciones_envio
    ADD FOREIGN KEY (ID_cliente) REFERENCES tblclientes (id_cliente);

ALTER TABLE tbldireccion_facturacion
    ADD FOREIGN KEY (ID_cliente) REFERENCES tblclientes (id_cliente);

--++++++++++++++++++++++FUNCIONES++++++++++++++++++++++

CREATE OR REPLACE FUNCTION filtrarResultados
	(IN aBuscar VARCHAR(100)) 
    RETURNS SETOF tblproductos AS $$

DECLARE
	pattern VARCHAR(82) = '%' || aBuscar || '%'::VARCHAR;
BEGIN
	return query
	SELECT *	FROM tblproductos 
	WHERE nombre_producto LIKE pattern LIMIT 4;
END;
$$ LANGUAGE plpgsql;