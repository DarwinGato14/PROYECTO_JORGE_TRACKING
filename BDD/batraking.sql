/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     31/5/2017 13:45:53                           */
/*==============================================================*/


drop table if exists alerta;

drop table if exists cliente_final;

drop table if exists comentario_seguimiento;

drop table if exists fabricante;

drop table if exists fotografias_seguimiento;

drop table if exists fotografia_control;

drop table if exists fotografia_pallet;

drop table if exists fotografia_producto;

drop table if exists pallet;

drop table if exists producto;

drop table if exists puntos_control;

drop table if exists seguimiento;

drop table if exists tipo_usuario;

drop table if exists usuario;

/*==============================================================*/
/* Table: alerta                                                */
/*==============================================================*/
create table alerta
(
   id_alerta            int(30) not null auto_increment,
   alert_nombre         char(50),
   alert_desde          decimal(10,2),
   alerts_hasta         decimal(10,2),
   alert_semaforo       varchar(100),
   primary key (id_alerta)
);

/*==============================================================*/
/* Table: cliente_final                                         */
/*==============================================================*/
create table cliente_final
(
   id_cliente           int(30) not null auto_increment,
   id_seguimiento       int,
   cli_marca            varchar(30),
   cli_modelo           varchar(30),
   cli_observacion      varchar(150),
   cli_propietario      varchar(50),
   cli_contacto         varchar(25),
   primary key (id_cliente)
);

/*==============================================================*/
/* Table: comentario_seguimiento                                */
/*==============================================================*/
create table comentario_seguimiento
(
   id_observacion_seg   int(30) not null auto_increment,
   id_seguimiento       int,
   oseg_descripcion     varchar(150),
   primary key (id_observacion_seg)
);

/*==============================================================*/
/* Table: fabricante                                            */
/*==============================================================*/
create table fabricante
(
   id_fabricante        int(30) not null auto_increment,
   fab_nombre           varchar(100),
   fab_descripcion      varchar(100),
   fab_contacto         varchar(25),
   fab_pagina_web       varchar(100),
   fab_email            varchar(100),
   fab_razon_social     varchar(100),
   primary key (id_fabricante)
);

/*==============================================================*/
/* Table: fotografias_seguimiento                               */
/*==============================================================*/
create table fotografias_seguimiento
(
   id_fotografia_seg    int(30) not null auto_increment,
   id_seguimiento       int,
   fseg_nombre          varchar(50),
   fseg_path            varchar(150),
   fseg_real            longblob,
   primary key (id_fotografia_seg)
);

/*==============================================================*/
/* Table: fotografia_control                                    */
/*==============================================================*/
create table fotografia_control
(
   id_foto_control      int(30) not null auto_increment,
   id_control           int,
   fcont_nombre         varchar(50),
   fcont_path           varchar(150),
   fcont_real           longblob,
   primary key (id_foto_control)
);

/*==============================================================*/
/* Table: fotografia_pallet                                     */
/*==============================================================*/
create table fotografia_pallet
(
   id_foto_pallet       int(30) not null auto_increment,
   id_pallet            int,
   fpall_nombre         varchar(50),
   fpall_path           varchar(150),
   fpall_real           longblob,
   primary key (id_foto_pallet)
);

/*==============================================================*/
/* Table: fotografia_producto                                   */
/*==============================================================*/
create table fotografia_producto
(
   id_foto_producto     int(30) not null auto_increment,
   id_producto          int,
   fprod_nombre         varchar(100),
   fprod_path           varchar(150),
   fprod_real           longblob,
   primary key (id_foto_producto)
);

/*==============================================================*/
/* Table: pallet                                                */
/*==============================================================*/
create table pallet
(
   id_pallet            int(30) not null auto_increment,
   pall_codigo          varchar(100),
   pall_descripcion     varchar(150),
   primary key (id_pallet)
);

/*==============================================================*/
/* Table: producto                                              */
/*==============================================================*/
create table producto
(
   id_producto          int(30) not null auto_increment,
   id_pallet            int,
   id_fabricante        int,
   prod_codigo          varchar(100),
   prod_especificaciones varchar(150),
   prod_estado_bateria  varchar(40),
   prod_fecha_produccion date,
   prod_fecha_venta     date,
   prod_fecha_mantenimiento date,
   prod_fecha_repone    date,
   primary key (id_producto)
);

/*==============================================================*/
/* Table: puntos_control                                        */
/*==============================================================*/
create table puntos_control
(
   id_control           int(30) not null auto_increment,
   con_lugar            varchar(100),
   con_longitud         varchar(100),
   con_latitud          varchar(100),
   con_descripcion      varchar(100),
   primary key (id_control)
);

/*==============================================================*/
/* Table: seguimiento                                           */
/*==============================================================*/
create table seguimiento
(
   id_seguimiento       int(30) not null auto_increment,
   id_control           int,
   id_usuario           int,
   id_alerta            int,
   id_producto          int,
   seg_fecha_llegada    date,
   seg_fecha_partida    date,
   seg_responsable_recibe varchar(100),
   seg_responsable_despacho varchar(100),
   seg_tiempo_estimado  decimal(6,2),
   seg_tiempo_empleado  decimal(6,2),
   seg_ultimo           varchar(5),
   seg_longitud         varchar(100),
   seg_latitud          varchar(100),
   primary key (id_seguimiento)
);

/*==============================================================*/
/* Table: tipo_usuario                                          */
/*==============================================================*/
create table tipo_usuario
(
   id_tipo_usuario      int(30) not null auto_increment,
   tusu_nombre          varchar(50),
   tus_abreviatura      varchar(10),
   tusu_acceso          int,
   primary key (id_tipo_usuario)
);

/*==============================================================*/
/* Table: usuario                                               */
/*==============================================================*/
create table usuario
(
   id_usuario           int(30) not null auto_increment,
   id_tipo_usuario      int,
   usu_nombre           varchar(100),
   usu_apellido         varchar(100),
   usu_login            varchar(40),
   usu_password         varchar(40),
   usu_correo           varchar(100),
   usu_nivel            int,
   usu_fotografia       longblob,
   usu_rol              varchar(50),
   usu_movil            varchar(100),
   usu_fecha_creacion   date,
   usu_fecha_modificacion date,
   usu_fecha_eliminacion date,
   usu_activo           int,
   usu_eliminado        int,
   primary key (id_usuario)
);

alter table cliente_final add constraint fk_distribuye foreign key (id_seguimiento)
      references seguimiento (id_seguimiento) on delete restrict on update restrict;

alter table comentario_seguimiento add constraint fk_relationship_13 foreign key (id_seguimiento)
      references seguimiento (id_seguimiento) on delete restrict on update restrict;

alter table fotografias_seguimiento add constraint fk_relationship_14 foreign key (id_seguimiento)
      references seguimiento (id_seguimiento) on delete restrict on update restrict;

alter table fotografia_control add constraint fk_posee foreign key (id_control)
      references puntos_control (id_control) on delete restrict on update restrict;

alter table fotografia_pallet add constraint fk_debe_tener foreign key (id_pallet)
      references pallet (id_pallet) on delete restrict on update restrict;

alter table fotografia_producto add constraint fk_presenta foreign key (id_producto)
      references producto (id_producto) on delete restrict on update restrict;

alter table producto add constraint fk_contiene foreign key (id_pallet)
      references pallet (id_pallet) on delete restrict on update restrict;

alter table producto add constraint fk_fabrica foreign key (id_fabricante)
      references fabricante (id_fabricante) on delete restrict on update restrict;

alter table seguimiento add constraint fk_controla foreign key (id_alerta)
      references alerta (id_alerta) on delete restrict on update restrict;

alter table seguimiento add constraint fk_registra foreign key (id_usuario)
      references usuario (id_usuario) on delete restrict on update restrict;

alter table seguimiento add constraint fk_relationship_11 foreign key (id_producto)
      references producto (id_producto) on delete restrict on update restrict;

alter table seguimiento add constraint fk_se_incluye foreign key (id_control)
      references puntos_control (id_control) on delete restrict on update restrict;

alter table usuario add constraint fk_relationship_12 foreign key (id_tipo_usuario)
      references tipo_usuario (id_tipo_usuario) on delete restrict on update restrict;

