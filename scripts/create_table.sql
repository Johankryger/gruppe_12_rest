CREATE TABLE IF NOT EXISTS strain
(
    id bigint NOT NULL,
    description character varying(1024) COLLATE pg_catalog."default",
    energy integer NOT NULL,
    medical character varying(255) COLLATE pg_catalog."default",
    rating integer NOT NULL,
    src character varying(255) COLLATE pg_catalog."default",
    title character varying(255) COLLATE pg_catalog."default",
    type_id bigint,
    CONSTRAINT strain_pkey PRIMARY KEY (id),
    CONSTRAINT uk_2nhij4numqo5hq4v77dfc6485 UNIQUE (title),
    CONSTRAINT fkrub8vbv78rfqu0pceyaqatvel FOREIGN KEY (type_id)
        REFERENCES public.strain_type (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE IF NOT EXISTS strain_type
(
    id integer NOT NULL,
    description character varying(255) COLLATE pg_catalog."default",
    effects character varying(255) COLLATE pg_catalog."default",
    origin character varying(255) COLLATE pg_catalog."default",
    ratio character varying(255) COLLATE pg_catalog."default",
    src character varying(255) COLLATE pg_catalog."default",
    title character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT strain_type_pkey PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS distributor
(
    id integer NOT NULL,
    title varchar(255),
    description varchar(1024),
    coordinate point
);
