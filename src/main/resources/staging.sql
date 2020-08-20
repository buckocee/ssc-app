create table if not exists ref_data.brokers_staging
(
    id integer default nextval('brokers_staging_id_seq'::regclass) not null
        constraint brokers_staging_pkey
            primary key,
    name varchar(255),
    mc_number varchar(255),
    dot_number varchar(255),
    city varchar(255),
    state varchar(255)
);

alter table ref_data.brokers_staging owner to ssc;

create unique index if not exists brokers_staging_id_uindex
    on ref_data.brokers_staging (id);


create table ref_data.carriers_staging
(
    dot_number varchar(1000),
    legal_name varchar(1000),
    dba_name varchar(1000),
    carrier_operation varchar(255),
    hm_flag varchar(255),
    pc_flag varchar(255),
    phy_street varchar(255),
    phy_city varchar(255),
    phy_state varchar(255),
    phy_zip varchar(255),
    phy_country varchar(255),
    mailing_street varchar(255),
    id integer default nextval('carriers_staging_id_seq'::regclass) not null,
    mailing_city varchar(255),
    mailing_state varchar(255),
    mailing_zip varchar(255),
    mailing_country varchar(255),
    telephone varchar(255),
    fax varchar(255),
    email_address varchar(255),
    mcs150_date varchar(255),
    mcs150_mileage varchar(255),
    mcs150_mileage_year varchar(255),
    add_date varchar(255),
    oic_state varchar(255),
    nbr_power_unit varchar(255),
    driver_total varchar(255)
);

alter table ref_data.carriers_staging owner to ssc;

create table ref_data.carriers_staging_clean
(
    dot_number varchar(1000),
    legal_name varchar(1000),
    dba_name varchar(1000),
    carrier_operation varchar(255),
    hm_flag varchar(255),
    pc_flag varchar(255),
    phy_street varchar(255),
    phy_city varchar(255),
    phy_state varchar(255),
    phy_zip varchar(255),
    phy_country varchar(255),
    mailing_street varchar(255),
    id integer,
    mailing_city varchar(255),
    mailing_state varchar(255),
    mailing_zip varchar(255),
    mailing_country varchar(255),
    telephone varchar(255),
    fax varchar(255),
    email_address varchar(255),
    mcs150_date varchar(255),
    mcs150_mileage varchar(255),
    mcs150_mileage_year varchar(255),
    add_date varchar(255),
    oic_state varchar(255),
    nbr_power_unit varchar(255),
    driver_total varchar(255)
);

alter table ref_data.carriers_staging_clean owner to ssc;

