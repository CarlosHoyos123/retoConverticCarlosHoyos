INSERT INTO tbltipo_documento(tipo_documento) VALUES ('CEDULA');
INSERT INTO tbltipo_documento(tipo_documento) VALUES ('PASAPORTE');
INSERT INTO tbltipo_documento(tipo_documento) VALUES ('NIT');
INSERT INTO tbltipo_documento(tipo_documento) VALUES ('CEDULA DE EXTRANGERIA');

INSERT INTO tblpaises (nombre_pais) VALUES ('COLOMBIA');
INSERT INTO tblpaises (nombre_pais) VALUES ('ECUADOR');
INSERT INTO tblpaises (nombre_pais) VALUES ('PARAGUAY');
INSERT INTO tblpaises (nombre_pais) VALUES ('MEXICO');
INSERT INTO tblpaises (nombre_pais) VALUES ('EEUU');

INSERT INTO tbltipo_telefono (tipo_telefono) VALUES ('MOVIL');
INSERT INTO tbltipo_telefono (tipo_telefono) VALUES ('FIJO');

INSERT INTO tblshopping_car(ID_cliente,fecha_creacion,ID_producto,ID_talla,ID_color,cantidad) VALUES (1,'2023-02-16',3,2,3,5)
INSERT INTO tblshopping_car(ID_cliente,fecha_creacion,ID_producto,ID_talla,ID_color,cantidad) VALUES (2,'2023-02-16',3,2,3,15)
INSERT INTO tblshopping_car(ID_cliente,fecha_creacion,ID_producto,ID_talla,ID_color,cantidad) VALUES (2,'2023-02-26',3,2,3,5)
INSERT INTO tblshopping_car(ID_cliente,fecha_creacion,ID_producto,ID_talla,ID_color,cantidad) VALUES (1,'2023-02-18',3,2,3,10)

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

INSERT INTO tblcolor(color,hexadecimal) VALUES('amarillo',  '#FFFF00');
INSERT INTO tblcolor(color,hexadecimal) VALUES('azul rey',  '#0000FF');
INSERT INTO tblcolor(color,hexadecimal) VALUES('rojo',      '#FF0000');
INSERT INTO tblcolor(color,hexadecimal) VALUES('naranjado', '#FFA500');
INSERT INTO tblcolor(color,hexadecimal) VALUES('negro',     '#000000');
INSERT INTO tblcolor(color,hexadecimal) VALUES('gris',      '#808080');

INSERT INTO tbltallas(nombre,talla) VALUES('Extra Pequeña',   'XS');
INSERT INTO tbltallas(nombre,talla) VALUES('Pequeña',   'S');
INSERT INTO tbltallas(nombre,talla) VALUES('Mediana',   'M');
INSERT INTO tbltallas(nombre,talla) VALUES('Grande',    'L');
INSERT INTO tbltallas(nombre,talla) VALUES('Extra Grande',   'XL');
INSERT INTO tbltallas(nombre,talla) VALUES('Extra XL',   'XXL');

INSERT INTO tblgenero(nombre) VALUES ('HOMBRE');
INSERT INTO tblgenero(nombre) VALUES ('MUJER');

INSERT INTO tblfabricantes(nombre_fabricante,contacto_fabricante,telefono_fabricante) VALUES ('galax',      'paola cardona','3567890432');
INSERT INTO tblfabricantes(nombre_fabricante,contacto_fabricante,telefono_fabricante) VALUES ('everfit',    'Luis Muñoz',   '3210984157');
INSERT INTO tblfabricantes(nombre_fabricante,contacto_fabricante,telefono_fabricante) VALUES ('wear fit',   'carlos ocampo','3567740432');
INSERT INTO tblfabricantes(nombre_fabricante,contacto_fabricante,telefono_fabricante) VALUES ('ego fit',    'ricardo mina', '3210988657');
INSERT INTO tblfabricantes(nombre_fabricante,contacto_fabricante,telefono_fabricante) VALUES ('bellas wear','camilo cardi', '3567820432');
INSERT INTO tblfabricantes(nombre_fabricante,contacto_fabricante,telefono_fabricante) VALUES ('suits mens', 'miguel manuz', '3210984657');
INSERT INTO tblfabricantes(nombre_fabricante,contacto_fabricante,telefono_fabricante) VALUES ('elegant wmn','pablo camps',  '3561890432');
INSERT INTO tblfabricantes(nombre_fabricante,contacto_fabricante,telefono_fabricante) VALUES ('col people', 'laura muñoz',  '3218963657');

INSERT INTO tblproductos(plu,nombre_producto,ID_fabricante,precio,descripcion_producto,fecha_creacion,ID_genero,cantidad_busquedas,fotos) VALUES ('p001','Medias para clima frio',1,18000.00,'EN TELA PARA FRIO','2022-10-22',2,12,'../../../assets/images/mediasFrio.jpg');
INSERT INTO tblproductos(plu,nombre_producto,ID_fabricante,precio,descripcion_producto,fecha_creacion,ID_genero,cantidad_busquedas,fotos) VALUES ('p002','camisa polo hombre',4,60000.00,'TIPO POLO EN ALGODON','2022-10-23',1,11,'../../../assets/images/poloHombre.jpg');
INSERT INTO tblproductos(plu,nombre_producto,ID_fabricante,precio,descripcion_producto,fecha_creacion,ID_genero,cantidad_busquedas,fotos) VALUES ('p003','camisa polo mujer',2,55000.00,'EN TELA DE DE ALGODON DE MUJER','2022-10-22',2,10,'../../../assets/images/poloMujer.jpg');
INSERT INTO tblproductos(plu,nombre_producto,ID_fabricante,precio,descripcion_producto,fecha_creacion,ID_genero,cantidad_busquedas,fotos) VALUES ('p004','boxer largo rayado vertical',1,16000.00,'EN TELA SINTETICA','2022-10-23',1,9,'../../../assets/images/boxerRayado.jpg');
INSERT INTO tblproductos(plu,nombre_producto,ID_fabricante,precio,descripcion_producto,fecha_creacion,ID_genero,cantidad_busquedas,fotos) VALUES ('p005','Medias de traje',6,15000.00,'EN TELA DELGADA PARA TRAJE','2022-10-22',1,8,'../../../assets/images/mediasTraje.jpg');
INSERT INTO tblproductos(plu,nombre_producto,ID_fabricante,precio,descripcion_producto,fecha_creacion,ID_genero,cantidad_busquedas,fotos) VALUES ('p006','camisa esqueleto',4,30000.00,'CAMISA EN ALGODON','2022-10-23',1,7,'../../../assets/images/esqueleto.jpg');
INSERT INTO tblproductos(plu,nombre_producto,ID_fabricante,precio,descripcion_producto,fecha_creacion,ID_genero,cantidad_busquedas,fotos) VALUES ('p007','Medias tobillera',8,5000.00,'EN ALGODON QUE QUE NO SE VE','2022-10-22',2,6,'../../../assets/images/tobillera.jpg');
INSERT INTO tblproductos(plu,nombre_producto,ID_fabricante,precio,descripcion_producto,fecha_creacion,ID_genero,cantidad_busquedas,fotos) VALUES ('p008','jean mujer con degradado',5,80000.00,'JEAN CASUAL','2022-10-23',2,5,'../../../assets/images/jeanMujer.jpg');
INSERT INTO tblproductos(plu,nombre_producto,ID_fabricante,precio,descripcion_producto,fecha_creacion,ID_genero,cantidad_busquedas,fotos) VALUES ('p009','pantaloneta baño',3,28000.00,'EN TELA DE SECADO RAPIDO','2022-10-22',1,4,'../../../assets/images/pantalonetaBaño.jpg');
INSERT INTO tblproductos(plu,nombre_producto,ID_fabricante,precio,descripcion_producto,fecha_creacion,ID_genero,cantidad_busquedas,fotos) VALUES ('p010','blusa flores',7,60000.00,'BLUSA EN ALGODON ESTAMPADO DE FLORES','2022-10-23',2,3,'../../../assets/images/blusaFlores.jpg');
INSERT INTO tblproductos(plu,nombre_producto,ID_fabricante,precio,descripcion_producto,fecha_creacion,ID_genero,cantidad_busquedas,fotos) VALUES ('p011','pantaloneta deportiva',1,27000.00,'EN TELA DE SECADO RAPIDO','2022-10-22',2,2,'../../../assets/images/deportiva.jpg');
INSERT INTO tblproductos(plu,nombre_producto,ID_fabricante,precio,descripcion_producto,fecha_creacion,ID_genero,cantidad_busquedas,fotos) VALUES ('p012','camiseta estampada espadas',6,60000.00,'PARA HOMBRE EN ALGODON','2022-10-23',1,1,'../../../assets/images/espadas.jpg');
