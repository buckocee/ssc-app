create sequence claims_id_seq;

create sequence brokers_id_seq;

create sequence carriers_id_seq;

create sequence users_id_seq;

create sequence address_id_seq;

create sequence roles_id_seq;

create sequence privilege_id_seq;

create sequence password_reset_tokens_id_seq;

create sequence loads_id_seq;

create sequence brokers_staging_id_seq;

create sequence clients_id_seq;

create table claims
(
	id integer default nextval('claims_id_seq'::regclass) not null
		constraint claims_pkey
			primary key,
	submit_date varchar(255),
	update_date varchar(255),
	invoice_number varchar(255),
	description varchar(1000),
	created_by integer,
	broker_id integer,
	carrier_id integer,
	status varchar(10),
	updated_by integer,
	payable_date varchar(255),
	invoice varchar(10000),
	invoice_name varchar(1000),
	distance double precision,
	amount double precision,
	load_date varchar(255),
	load_type varchar(255)
);

create unique index claims_id_uindex
	on claims (id);

create table brokers
(
	id integer default nextval('brokers_id_seq'::regclass) not null
		constraint brokers_pkey
			primary key,
	status varchar(255),
	mc_number varchar(255),
	dot_number varchar(255),
	business_name varchar(255),
	address_id integer,
	phone varchar(255),
	fax varchar(255),
	state varchar(255),
	city varchar(1000)
);

create unique index brokers_id_uindex
	on brokers (id);

create table carriers
(
	id integer default nextval('carriers_id_seq'::regclass) not null
		constraint carriers_pkey
			primary key,
	mc_number varchar(255),
	dot_number varchar(255),
	status varchar(255),
	business_name varchar(255),
	address_id integer,
	physical_address_id integer,
	mailing_address_id integer,
	phone varchar(255),
	fax varchar(255),
	email varchar(255)
);

create unique index carriers_id_uindex
	on carriers (id);

create table users
(
	id integer default nextval('users_id_seq'::regclass) not null
		constraint users_pkey
			primary key,
	email varchar(255) not null,
	first_name varchar(255),
	middle_initial varchar(255),
	last_name varchar(255),
	is_active boolean,
	created_date timestamp,
	updated_date timestamp,
	user_name varchar(255),
	password varchar(120) not null,
	status varchar(255),
	registration_token varchar(255),
	carrier_id integer
);

create unique index users_id_uindex
	on users (id);

create unique index users_email_uindex
	on users (email);

create table address
(
	id integer default nextval('address_id_seq'::regclass) not null
		constraint address_pkey
			primary key,
	street_address varchar(255),
	apt_number varchar(255),
	city varchar(255),
	state varchar(255),
	country varchar(255),
	zip_code varchar(255)
);

create unique index address_id_uindex
	on address (id);

create table roles
(
	id integer default nextval('roles_id_seq'::regclass) not null
		constraint roles_pkey
			primary key,
	name varchar(255)
);

create unique index roles_id_uindex
	on roles (id);

create table users_roles
(
	user_id integer,
	role_id integer
);

create table roles_privileges
(
	role_id integer,
	privilege_id integer
);

create table privilege
(
	id integer default nextval('privilege_id_seq'::regclass) not null
		constraint privilege_pkey
			primary key,
	name varchar(255)
);

create unique index privilege_id_uindex
	on privilege (id);

create table password_reset_tokens
(
	id integer default nextval('password_reset_tokens_id_seq'::regclass) not null
		constraint password_reset_tokens_pkey
			primary key,
	token varchar(255),
	expiry_date varchar(255)
);

create unique index password_reset_tokens_id_uindex
	on password_reset_tokens (id);

create table loads
(
	id integer default nextval('loads_id_seq'::regclass) not null
		constraint loads_pkey
			primary key,
	type varchar(255),
	description varchar(255),
	invoice_number varchar(255),
	load_date varchar(255),
	invoice_date varchar(255),
	invoice_amount varchar(255),
	invoice_path varchar(255),
	invoice_upload_date varchar(255),
	claim_id integer,
	delivery_date varchar(255),
	origin_address_id integer,
	destination_address_id integer
);

create unique index loads_id_uindex
	on loads (id);

create table carriers_source_clean
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

create table brokers_staging
(
	id integer default nextval('brokers_staging_id_seq'::regclass) not null,
	name varchar(255),
	mc_number varchar(255),
	dot_number varchar(255),
	city varchar(255),
	state varchar(255)
);

create table oauth_client_details
(
	id integer default nextval('clients_id_seq'::regclass) not null
		constraint clients_pkey
			primary key,
	client_id varchar(255),
	client_secret varchar(1000),
	scope varchar(1000),
	authorized_grant_types varchar(1000),
	authorities varchar(1000),
	autoapprove varchar(1000),
	refresh_token_validity integer,
	additional_information varchar(4096),
	web_server_redirect_uri varchar(256),
	resource_ids varchar(256),
	access_token_validity integer
);

create unique index clients_id_uindex
	on oauth_client_details (id);

create schema ref_data;

create sequence carriers_staging_id_seq;

create sequence brokers_staging_id_seq;

create table carriers_staging
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
  id integer default nextval('ref_data.carriers_staging_id_seq'::regclass) not null,
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

create table carriers_staging_clean
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

create table brokers_staging
(
  id integer default nextval('ref_data.brokers_staging_id_seq'::regclass) not null
    constraint brokers_staging_pkey
      primary key,
  name varchar(255),
  mc_number varchar(255),
  dot_number varchar(255),
  city varchar(255),
  state varchar(255)
);

create unique index brokers_staging_id_uindex
  on brokers_staging (id);

