# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table cliente (
  cli_id                        integer auto_increment not null,
  cli_ci                        varchar(255),
  cli_nom                       varchar(255),
  cli_ape                       varchar(255),
  cli_fec_nac                   timestamp,
  cli_dir                       varchar(255),
  cli_tel                       varchar(255),
  cli_fec_ing                   timestamp,
  cli_cel                       varchar(255),
  cli_tip_cli_id                integer,
  cli_mail                      varchar(255),
  constraint pk_cliente primary key (cli_id)
);

create table cuota (
  cuo_id                        integer auto_increment not null,
  cuo_nro_comp                  integer,
  cuo_fec                       timestamp,
  cuo_fec_ven                   timestamp,
  cuo_nro_cuo                   integer,
  cuo_can_cuo                   integer,
  cuo_imp                       integer,
  cuo_est                       integer,
  cuo_sal_cobrar                integer,
  cuo_mon_cobrado               integer,
  constraint ck_cuota_cuo_est check ( cuo_est in (0,1)),
  constraint pk_cuota primary key (cuo_id)
);

create table entidad (
  ent_id                        integer auto_increment not null,
  ent_nom                       varchar(255),
  ent_ruc                       varchar(255),
  ent_dir                       varchar(255),
  ent_tel                       varchar(255),
  ent_cont                      varchar(255),
  ent_interes                   integer,
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
  constraint pk_tipo_cliente primary key (tip_cli_id)
);


# --- !Downs

drop table if exists cliente;

drop table if exists cuota;

drop table if exists entidad;

drop table if exists prestamo;

drop table if exists tipo_cliente;

