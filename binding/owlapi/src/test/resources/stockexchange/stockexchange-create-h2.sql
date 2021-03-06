--
-- H2 database dump
--



CREATE TABLE address (
    id integer NOT NULL,
    street character varying(100),
    number integer,
    city character varying(100),
    state character varying(100),
    country character varying(100)
);



CREATE TABLE broker (
    id integer NOT NULL
);



CREATE TABLE brokerworksfor (
    brokerid integer NOT NULL,
    companyid integer,
    clientid integer
);


CREATE TABLE client (
    id integer NOT NULL
);



CREATE TABLE company (
    id integer NOT NULL,
    name character varying(100) NOT NULL,
    marketshares integer NOT NULL,
    networth double precision NOT NULL,
    addressid integer NOT NULL
);



CREATE TABLE person (
    id integer NOT NULL,
    name character varying(100) NOT NULL,
    lastname character varying(100) NOT NULL,
    dateofbirth date NOT NULL,
    ssn character varying(100) NOT NULL,
    addressid integer NOT NULL
);



CREATE TABLE stockbooklist (
    date date NOT NULL,
    stockid integer NOT NULL
);



CREATE TABLE stockinformation (
    id integer NOT NULL,
    numberofshares integer NOT NULL,
    sharetype boolean NOT NULL,
    companyid integer NOT NULL,
    description text NOT NULL
);



CREATE TABLE transaction (
    id integer NOT NULL,
    date timestamp NOT NULL,
    stockid integer NOT NULL,
    type boolean NOT NULL,
    brokerid integer NOT NULL,
    forclientid integer,
    forcompanyid integer,
    amount numeric(10,4) NOT NULL
);



ALTER TABLE  address
    ADD CONSTRAINT address_pkey PRIMARY KEY (id);



ALTER TABLE  broker
    ADD CONSTRAINT broker_pkey PRIMARY KEY (id);


ALTER TABLE  client
    ADD CONSTRAINT client_pkey PRIMARY KEY (id);



ALTER TABLE  company
    ADD CONSTRAINT company_pkey PRIMARY KEY (id);


ALTER TABLE  person
    ADD CONSTRAINT person_pkey PRIMARY KEY (id);



ALTER TABLE  stockbooklist
    ADD CONSTRAINT stockbooklist_pkey PRIMARY KEY (date);



ALTER TABLE  stockinformation
    ADD CONSTRAINT stockinformation_pkey PRIMARY KEY (id);



ALTER TABLE  transaction
    ADD CONSTRAINT transaction_pkey PRIMARY KEY (id);




INSERT INTO address (id, street, number, city, state, country) VALUES (998, 'Jalan Madura 12', 245, 'Jakarta', 'Jakarta', 'Indonesia');
INSERT INTO address (id, street, number, city, state, country) VALUES (991, 'Road street', 24, 'Chonala', 'Veracruz', 'Mexico');
INSERT INTO address (id, street, number, city, state, country) VALUES (992, 'Via Marconi', 3, 'Bolzano', 'Bolzano', 'Italy');
INSERT INTO address (id, street, number, city, state, country) VALUES (995, 'Huberg Strasse', 3, 'Bolzano', 'Bolzano', 'Italy');
INSERT INTO address (id, street, number, city, state, country) VALUES (996, 'Via Piani di Bolzano', 7, 'Marconi', 'Trentino', 'Italy');
INSERT INTO address (id, street, number, city, state, country) VALUES (993, 'Romer Street', 32, 'Malaga', 'Malaga', 'Spain');
INSERT INTO address (id, street, number, city, state, country) VALUES (997, 'Samara road', 9976, 'Puebla', 'Puebla', 'Mexico');



INSERT INTO broker (id) VALUES (112);
INSERT INTO broker (id) VALUES (113);
INSERT INTO broker (id) VALUES (114);



INSERT INTO brokerworksfor (brokerid, companyid, clientid) VALUES (112, NULL, 111);
INSERT INTO brokerworksfor (brokerid, companyid, clientid) VALUES (112, NULL, 112);
INSERT INTO brokerworksfor (brokerid, companyid, clientid) VALUES (113, 212, NULL);
INSERT INTO brokerworksfor (brokerid, companyid, clientid) VALUES (113, 211, NULL);
INSERT INTO brokerworksfor (brokerid, companyid, clientid) VALUES (114, 212, NULL);
INSERT INTO brokerworksfor (brokerid, companyid, clientid) VALUES (114, NULL, 111);
INSERT INTO brokerworksfor (brokerid, companyid, clientid) VALUES (112, NULL, 111);
INSERT INTO brokerworksfor (brokerid, companyid, clientid) VALUES (112, NULL, 112);
INSERT INTO brokerworksfor (brokerid, companyid, clientid) VALUES (113, 212, NULL);
INSERT INTO brokerworksfor (brokerid, companyid, clientid) VALUES (113, 211, NULL);
INSERT INTO brokerworksfor (brokerid, companyid, clientid) VALUES (114, 212, NULL);
INSERT INTO brokerworksfor (brokerid, companyid, clientid) VALUES (114, NULL, 111);



INSERT INTO client (id) VALUES (111);
INSERT INTO client (id) VALUES (112);



INSERT INTO company (id, name, marketshares, networth, addressid) VALUES (211, 'General Motors', 25000000, 1234.56780000000003, 995);
INSERT INTO company (id, name, marketshares, networth, addressid) VALUES (212, 'GnA Investments', 100000, 1234.56780000000003, 996);



INSERT INTO person (id, name, lastname, dateofbirth, ssn, addressid) VALUES (111, 'John', 'Smith', '1950-03-21', 'JSRX229500321', 991);
INSERT INTO person (id, name, lastname, dateofbirth, ssn, addressid) VALUES (112, 'Joana', 'Lopatenkko', '1970-07-14', 'JLPTK54992', 992);
INSERT INTO person (id, name, lastname, dateofbirth, ssn, addressid) VALUES (113, 'Walter', 'Schmidt', '1968-09-03', 'WSCH9820783903', 993);
INSERT INTO person (id, name, lastname, dateofbirth, ssn, addressid) VALUES (114, 'Patricia', 'Lombrardi', '1975-02-22', 'PTLM8878767830', 997);


INSERT INTO stockbooklist (date, stockid) VALUES ('2008-04-01', 661);
INSERT INTO stockbooklist (date, stockid) VALUES ('2008-04-02', 662);
INSERT INTO stockbooklist (date, stockid) VALUES ('2008-04-03', 663);
INSERT INTO stockbooklist (date, stockid) VALUES ('2008-04-04', 664);
INSERT INTO stockbooklist (date, stockid) VALUES ('2008-04-05', 665);
INSERT INTO stockbooklist (date, stockid) VALUES ('2008-04-06', 666);
INSERT INTO stockbooklist (date, stockid) VALUES ('2008-04-07', 667);
INSERT INTO stockbooklist (date, stockid) VALUES ('2008-04-08', 668);
INSERT INTO stockbooklist (date, stockid) VALUES ('2008-04-09', 669);


INSERT INTO stockinformation (id, numberofshares, sharetype, companyid, description) VALUES (661, 100, false, 211, 'Text description 1');
INSERT INTO stockinformation (id, numberofshares, sharetype, companyid, description) VALUES (660, 100, false, 211, 'Text description 2');
INSERT INTO stockinformation (id, numberofshares, sharetype, companyid, description) VALUES (662, 100, false, 211, 'Text description 3');
INSERT INTO stockinformation (id, numberofshares, sharetype, companyid, description) VALUES (663, 100, false, 211, 'Text description 4');
INSERT INTO stockinformation (id, numberofshares, sharetype, companyid, description) VALUES (664, 100, false, 211, 'Text description 5');
INSERT INTO stockinformation (id, numberofshares, sharetype, companyid, description) VALUES (665, 100, true, 211, 'Testo di descrizione 1');
INSERT INTO stockinformation (id, numberofshares, sharetype, companyid, description) VALUES (666, 100, true, 211, 'Testo di descrizione 2');
INSERT INTO stockinformation (id, numberofshares, sharetype, companyid, description) VALUES (667, 100, true, 211, 'Testo di descrizione 3');
INSERT INTO stockinformation (id, numberofshares, sharetype, companyid, description) VALUES (669, 100, true, 211, 'Testo di descrizione 4');
INSERT INTO stockinformation (id, numberofshares, sharetype, companyid, description) VALUES (668, 100, true, 211, 'Testo di descrizione 5');


INSERT INTO transaction (id, date, stockid, type, brokerid, forclientid, forcompanyid, amount) VALUES (3331, '2008-04-01', 661, true, 112, 111, NULL, 12.6000);
INSERT INTO transaction (id, date, stockid, type, brokerid, forclientid, forcompanyid, amount) VALUES (3332, '2008-04-02', 662, true, 112, 111, NULL, 108.3400);
INSERT INTO transaction (id, date, stockid, type, brokerid, forclientid, forcompanyid, amount) VALUES (3333, '2008-04-03', 663, true, 112, NULL, 212, -2.3490);
INSERT INTO transaction (id, date, stockid, type, brokerid, forclientid, forcompanyid, amount) VALUES (3334, '2008-04-14', 663, true, 113, NULL, NULL, 1667.0092);



ALTER TABLE  company
    ADD CONSTRAINT fk_address_company_pkey FOREIGN KEY (addressid) REFERENCES address(id);



ALTER TABLE  person
    ADD CONSTRAINT fk_address_pkey FOREIGN KEY (addressid) REFERENCES address(id);



ALTER TABLE  brokerworksfor
    ADD CONSTRAINT fk_broker_pkey FOREIGN KEY (brokerid) REFERENCES broker(id);



ALTER TABLE  transaction
    ADD CONSTRAINT fk_broker_transaction_pkey FOREIGN KEY (brokerid) REFERENCES broker(id);



ALTER TABLE  brokerworksfor
    ADD CONSTRAINT fk_brokerworksfor_brokerid_pkey FOREIGN KEY (brokerid) REFERENCES broker(id);



ALTER TABLE  brokerworksfor
    ADD CONSTRAINT fk_brokerworksfor_clientid_pkey FOREIGN KEY (clientid) REFERENCES client(id);



ALTER TABLE  brokerworksfor
    ADD CONSTRAINT fk_brokerworksfor_companyid_pkey FOREIGN KEY (companyid) REFERENCES company(id);



ALTER TABLE  stockinformation
    ADD CONSTRAINT fk_company_pkey FOREIGN KEY (companyid) REFERENCES company(id);



ALTER TABLE  transaction
    ADD CONSTRAINT fk_forclientid_pkey FOREIGN KEY (forclientid) REFERENCES client(id);



ALTER TABLE  transaction
    ADD CONSTRAINT fk_forcompanyid_pkey FOREIGN KEY (forcompanyid) REFERENCES company(id);



ALTER TABLE  broker
    ADD CONSTRAINT fk_person_broker_pkey FOREIGN KEY (id) REFERENCES person(id);



ALTER TABLE  client
    ADD CONSTRAINT fk_person_client_pkey FOREIGN KEY (id) REFERENCES person(id);



ALTER TABLE  stockbooklist
    ADD CONSTRAINT fk_stockid_pkey FOREIGN KEY (stockid) REFERENCES stockinformation(id);



ALTER TABLE  transaction
    ADD CONSTRAINT fk_stockinformation_pkey FOREIGN KEY (stockid) REFERENCES stockinformation(id);
