CREATE TABLE IF NOT EXISTS tblpaises(
id_pais             SERIAL      PRIMARY KEY,
nombre_pais         VARCHAR(15) UNIQUE
);

CREATE TABLE IF NOT EXISTS tbltipo_documento(
id_tipo_documento   SERIAL      PRIMARY KEY,
tipo_documento   VARCHAR(30)
);


CREATE TABLE IF NOT EXISTS tbldireccion_facturacion(
id_direccion_facturacion SERIAL PRIMARY KEY,
direccion           VARCHAR(100),
zip_code            VARCHAR(12),
ID_cliente          INTEGER,
ID_pais             int2,        FOREIGN KEY (ID_pais) REFERENCES tblpaises(id_pais)
);

CREATE TABLE IF NOT EXISTS tbldirecciones_envio(
id_direccion_envio  SERIAL      PRIMARY KEY,
direccion           VARCHAR(100),
zip_code            VARCHAR(12),
ID_cliente          INTEGER,
ID_pais             int2,        FOREIGN KEY (ID_pais) REFERENCES tblpaises(id_pais)
);

CREATE TABLE IF NOT EXISTS tbltipo_telefono(
id_tipo_telefono    SERIAL      PRIMARY KEY,
tipo_telefono       VARCHAR(10) UNIQUE
);


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

CREATE TABLE IF NOT EXISTS tblestados_factura(
id_estado           SERIAL      PRIMARY KEY,
estado              varchar(40) UNIQUE,
descripcion         text
);

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

CREATE TABLE IF NOT EXISTS tblfabricantes(
id_fabricante       SERIAL      PRIMARY KEY,
nombre_fabricante   VARCHAR(40) UNIQUE,
contacto_fabricante VARCHAR(40) NOT NULL,
telefono_fabricante VARCHAR(15) NOT NULL
);

CREATE TABLE IF NOT EXISTS tblopciones(
id_opcion           SERIAL      PRIMARY KEY,
nombre_opcion       VARCHAR(35) NOT NULL,
descripcion_opcion  TEXT
);

CREATE TABLE IF NOT EXISTS tblgenero(
id_genero           SERIAL      PRIMARY KEY,
nombre              VARCHAR(30) UNIQUE
);

CREATE TABLE IF NOT EXISTS tblcategorias(
id_categoria        SERIAL      PRIMARY KEY,
nombre              VARCHAR(30) UNIQUE,
descripcion         TEXT
);

CREATE TABLE IF NOT EXISTS tbltallas (
id_talla            SERIAL      PRIMARY KEY,
nombre              VARCHAR(25) NOT NULL,
talla               VARCHAR (5) UNIQUE
);

CREATE TABLE IF NOT EXISTS tblcolor (
id_color            SERIAL      PRIMARY KEY,
color               VARCHAR(20),
hexadecimal         VARCHAR(10) UNIQUE
);


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

CREATE TABLE IF NOT EXISTS tblprod_color_talla (
idcoloxtalla        SERIAL      PRIMARY KEY,
ID_producto         INTEGER     NOT NULL, FOREIGN KEY (ID_producto) REFERENCES tblproductos(id_producto),
ID_color            INTEGER,    FOREIGN KEY (ID_color) REFERENCES tblcolor(id_color),
ID_talla            INTEGER,    FOREIGN KEY (ID_talla) REFERENCES tbltallas(id_talla),
inventario          INT2        NOT NULL
);

CREATE TABLE IF NOT EXISTS tblopciones_producto( 
id_op_prod          SERIAL      PRIMARY KEY,
ID_opcion           INTEGER,    FOREIGN KEY (ID_opcion) REFERENCES tblopciones(id_opcion),
ID_producto         INTEGER,    FOREIGN KEY (ID_producto) REFERENCES tblproductos(id_producto)
);

CREATE TABLE IF NOT EXISTS tblcategorias_producto(
id_cat_prod         SERIAL      PRIMARY KEY,
ID_categoria        INTEGER,    FOREIGN KEY (ID_categoria) REFERENCES tblcategorias(id_categoria),
ID_producto         INTEGER,    FOREIGN KEY (ID_producto) REFERENCES tblproductos(id_producto)
);

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

CREATE TABLE IF NOT EXISTS tbltipo_documento(
id_tipo_documento   SERIAL      PRIMARY KEY,
tipo_documento   VARCHAR(30)
);