# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table cliente (
  cli_id                        integer auto_increment not null,
  cli_ci                        varchar(255),
  cli_nom                       varchar(255),
  cli_ape                       varchar(255),
  cli_dir                       varchar(255),
  cli_tel                       varchar(255),
  cli_tip_cli_id                integer,
  cli_cant_hijos                integer,
  cli_fech_nac                  date,
  observacion                   varchar(255),
  constraint pk_cliente primary key (cli_id)
);

create table cuota (
  cuo_id                        integer auto_increment not null,
  cuo_ent                       integer,
  cuo_nro_comp                  integer,
  cuo_cli                       integer,
  cuo_fec                       timestamp,
  cuo_fec_ven                   timestamp,
  cuo_nro_cuo                   integer,
  cuo_can_cuo                   integer,
  cuo_imp                       integer,
  cuo_pres                      integer,
  constraint pk_cuota primary key (cuo_id)
);

create table entidad (
  ent_id                        integer auto_increment not null,
  ent_nom                       varchar(255),
  ent_ruc                       varchar(255),
  ent_dir                       varchar(255),
  ent_tel                       varchar(255),
  ent_cont                      varchar(255),
  cant_empleados                integer,
  fecha_creacion                date,
  lema                          varchar(255),
  constraint pk_entidad primary key (ent_id)
);

create table prestamo (
  pres_id                       integer auto_increment not null,
  pres_nro                      varchar(255),
  pres_fec                      timestamp,
  total_solicitado              integer,
  total_prestamo                integer,
  cant_cuotas                   integer,
  constraint pk_prestamo primary key (pres_id)
);

create table tipo_cliente (
  tip_cli_id                    integer auto_increment not null,
  descripcion                   varchar(255),
  cant_max_cuota                integer,
  codigo						integer,
  observacion					varchar (255),
  fecha_carga					date,
  constraint pk_tipo_cliente primary key (tip_cli_id)
);

create table usuario (
  usrid                         integer auto_increment not null,
  usr_alias                     varchar(255),
  usr_nom                       varchar(255),
  usr_pass                      varchar(255),
  constraint pk_usuario primary key (usrid)
);


# --- !Downs

drop table if exists cliente;

drop table if exists cuota;

drop table if exists entidad;

drop table if exists prestamo;

drop table if exists tipo_cliente;

drop table if exists usuario;

