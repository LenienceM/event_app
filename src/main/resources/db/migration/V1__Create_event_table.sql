CREATE TABLE event  (
        id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
        name character varying(255) COLLATE pg_catalog."default",
        event_year character varying(255) COLLATE pg_catalog."default",
        CONSTRAINT event_pkey PRIMARY KEY (id)
);

