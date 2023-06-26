-- *********************************************
-- * SQL MySQL generation                      
-- *--------------------------------------------
-- * DB-MAIN version: 11.0.2              
-- * Generator date: Sep 14 2021              
-- * Generation date: Fri Jun 23 10:00:58 2023 
-- * LUN file: C:\Users\giaky\OneDrive - Alma Mater Studiorum Università di Bologna\Università\Secondo anno\Basi di dati\ElaboratoDB\PlayBasketDB.lun 
-- * Schema: Campionato_Basket_Logico/1-1 
-- ********************************************* 


-- Database Section
-- ________________ 

create database db23_playbasket;
use db23_playbasket;


-- Tables Section
-- _____________ 

create table ARBITRO (
     TesseraFIP char(10) not null check(LENGTH(tesserafip)=10),
     Sezione char(20) not null,
     Grado int not null check(grado<4),
     Stipendio_totale int not null check(stipendio_totale >= 0),
     constraint FKcome10_ID primary key (TesseraFIP));

create table CAMPIONATO (
     IDCampionato char(10) not null check(LENGTH(idcampionato)=10),
     Anno_campionato int not null,
     Nome_campionato char(20) not null,
     Regione char(30),
     CodiceMeccanografico char(10) check(LENGTH(codicemeccanografico)=10),
     constraint IDCAMPIONATO_1_ID primary key (IDCampionato, Anno_campionato));

create table codirezione (
     CodicePalestra char(10) not null check(LENGTH(codicepalestra)=10),
     Data_ora datetime not null,
     TesseraFIP char(10) not null check(LENGTH(tesserafip)=10),
     Rimborso int not null check(rimborso > 0),
     constraint IDcodirezione primary key (TesseraFIP, CodicePalestra, Data_ora));

create table direzione (
     CodicePalestra char(10) not null check(LENGTH(codicepalestra)=10),
     Data_ora datetime not null,
     TesseraFIP char(10) not null check(LENGTH(tesserafip)=10),
     Rimborso int not null check(rimborso > 0),
     constraint IDdirezione primary key (TesseraFIP, CodicePalestra, Data_ora));

create table GIOCATORE (
     TesseraFIP char(10) not null check(LENGTH(tesserafip)=10),
     Ruolo char(10) not null,
     Altezza int not null  check(altezza > 0),
     Peso float(1) not null  check(peso > 0),
     Apertura_alare int check(apertura_alare > 0),
     constraint FKcome9_ID primary key (TesseraFIP));

create table GIRONE (
     IDCampionato char(10) not null check(LENGTH(idcampionato)=10),
     Anno_campionato int not null,
     Nome_Girone char(1) not null,
     Provincia char(2) , 
     constraint IDGIRONE_ID primary key (IDCampionato, Anno_campionato, Nome_Girone));

create table MEMBRO_ACC (
     IDCampionato char(10) not null check(LENGTH(idcampionato)=10),
     Anno_campionato int not null,
     Nome_Girone char(1) not null,
     Nome_squadra char(30) not null,
     Stipendio int not null check(stipendio >= 0),
     TesseraFIP char(10) not null check(LENGTH(tesserafip)=10),
     constraint FKcomposizione3_ID primary key (IDCampionato, Anno_campionato, Nome_Girone, Nome_squadra));

create table MEMBRO_ADDARB (
     IDCampionato char(10) not null check(LENGTH(idcampionato)=10),
     Anno_campionato int not null,
     Nome_Girone char(1) not null,
     Nome_squadra char(30) not null,
     Stipendio int not null check(stipendio >= 0),
     TesseraFIP char(10) not null check(LENGTH(tesserafip)=10),
     constraint FKcomposizione4_ID primary key (IDCampionato, Anno_campionato, Nome_Girone, Nome_squadra));

create table MEMBRO_AIUTOALL (
     IDCampionato char(10) not null check(LENGTH(idcampionato)=10),
     Anno_campionato int not null,
     Nome_Girone char(1) not null,
     Nome_squadra char(30) not null,
     Stipendio int not null check(stipendio >= 0),
     TesseraFIP char(10) not null check(LENGTH(tesserafip)=10),
     constraint FKcomposizione6_ID primary key (IDCampionato, Anno_campionato, Nome_Girone, Nome_squadra));

create table MEMBRO_ALL (
     IDCampionato char(10) not null check(LENGTH(idcampionato)=10),
     Anno_campionato int not null,
     Nome_Girone char(1) not null,
     Nome_squadra char(30) not null,
     Stipendio int not null check(stipendio >= 0),
     TesseraFIP char(10) not null check(LENGTH(tesserafip)=10),
     constraint FKcomposizione7_ID primary key (IDCampionato, Anno_campionato, Nome_Girone, Nome_squadra));

create table MEMBRO_GIOCATORE (
     Stipendio int not null check(stipendio >= 0),
     Capitano char not null,
     IDCampionato char(10) not null check(LENGTH(idcampionato)=10),
     Anno_campionato int not null,
     Nome_Girone char(1) not null,
     Nome_squadra char(30) not null,
     TesseraFIP char(10) not null check(LENGTH(tesserafip)=10),
     constraint IDMEMBRO_GIOCATORE primary key (IDCampionato, Anno_campionato, Nome_Girone, Nome_squadra, TesseraFIP));

create table MEMBRO_MASS (
     IDCampionato char(10) not null check(LENGTH(idcampionato)=10),
     Anno_campionato int not null,
     Nome_Girone char(1) not null,
     Nome_squadra char(30) not null,
     Stipendio int not null check(stipendio >= 0),
     TesseraFIP char(10) not null check(LENGTH(tesserafip)=10),
     constraint FKcomposizione5_ID primary key (IDCampionato, Anno_campionato, Nome_Girone, Nome_squadra));

create table MEMBRO_MED (
     IDCampionato char(10) not null check(LENGTH(idcampionato)=10),
     Anno_campionato int not null,
     Nome_Girone char(1) not null,
     Nome_squadra char(30) not null,
     Stipendio int not null check(stipendio >= 0),
     TesseraFIP char(10) not null check(LENGTH(tesserafip)=10),
     constraint FKcomposizione2_ID primary key (IDCampionato, Anno_campionato, Nome_Girone, Nome_squadra));

create table MEMBRO_PF (
     IDCampionato char(10) not null check(LENGTH(idcampionato)=10),
     Anno_campionato int not null,
     Nome_Girone char(1) not null,
     Nome_squadra char(30) not null,
     Stipendio int not null check(stipendio >= 0),
     TesseraFIP char(10) not null check(LENGTH(tesserafip)=10),
     constraint FKcomposizione1_ID primary key (IDCampionato, Anno_campionato, Nome_Girone, Nome_squadra));

create table MEMBRO_SCORER (
     IDCampionato char(10) not null check(LENGTH(idcampionato)=10),
     Anno_campionato int not null,
     Nome_Girone char(1) not null,
     Nome_squadra char(30) not null,
     Stipendio int not null check(stipendio >= 0),
     TesseraFIP char(10) not null check(LENGTH(tesserafip)=10),
     constraint FKcomposizione8_ID primary key (IDCampionato, Anno_campionato, Nome_Girone, Nome_squadra));

create table PALESTRA (
     CodicePalestra char(10) not null check(LENGTH(codicepalestra)=10),
     Nome_Palestra char(50) not null,
     Via char(50) not null,
     Civico int not null,
     Superficie char(20) not null,
     Capienza int not null check(capienza > 0),
     constraint IDPALESTRA_ID primary key (CodicePalestra));

create table partecipazione_casa (
     CodicePalestra char(10) not null check(LENGTH(codicepalestra)=10),
     Data_ora datetime not null,
     punti_fatti int not null check(punti_fatti>=0),
     IDCampionato char(10) not null check(LENGTH(idcampionato)=10),
     Anno_campionato int not null,
     Nome_Girone char(1) not null,
     Nome_squadra char(30) not null,
     constraint FKpar_PAR_1_ID primary key (CodicePalestra, Data_ora));

create table partecipazione_ospiti (
     CodicePalestra char(10) not null check(LENGTH(codicepalestra)=10),
     Data_ora datetime not null,
     punti_fatti int not null check(punti_fatti>=0),
     IDCampionato char(10) not null check(LENGTH(idcampionato)=10),
     Anno_campionato int not null,
     Nome_Girone char(1) not null,
     Nome_squadra char(30) not null,
     constraint FKpar_PAR_ID primary key (CodicePalestra, Data_ora));

create table PARTITA (
     CodicePalestra char(10) not null check(LENGTH(codicepalestra)=10),
     Data_ora datetime not null,
     IDCampionato char(10) not null check(LENGTH(idcampionato)=10),
     Anno_campionato int not null,
     Nome_Girone char(1) not null,
     constraint IDPARTITA_ID primary key (CodicePalestra, Data_ora));

create table performance (
     CodicePalestra char(10) not null check(LENGTH(codicepalestra)=10),
     Data_ora datetime not null,
     TesseraFIP char(10) not null check(LENGTH(tesserafip)=10),
     Rimbalzi int not null check(rimbalzi>=0),
     Assist int not null check(assist>=0),
     Falli_fatti int not null check(falli_fatti>=0),
     Falli_subiti int not null check(falli_subiti>=0),
     Minuti int not null check(minuti>=0),
     Tiri_2 int not null check(tiri_2>=0),
     Tiri_3 int not null check(tiri_3>=0),
     Tiri_liberi int not null check(tiri_liberi>=0),
     Tiri_2_segnati int not null check(tiri_2_segnati>=0),
     Tiri_3_segnati int not null check(tiri_3_segnati>=0),
     Tiri_liberi_segnati int not null check(tiri_liberi_segnati>=0),
     Palle_rubate int not null check(palle_rubate>=0),
     Palle_perse int not null check(palle_perse>=0),
     Stoppate int not null check(stoppate>=0),
     constraint IDperformance primary key (CodicePalestra, Data_ora, TesseraFIP));

create table PROPRIETARIO (
     CF char(16) not null check(LENGTH(cf)=16),
     Nome char(20) not null,
     Cognome char(20) not null,
     constraint IDPROPRIETARIO_ID primary key (CF));

create table SCHEMI (
     IDCampionato char(10) not null check(LENGTH(idcampionato)=10),
     Anno_campionato int not null,
     Nome_Girone char(1) not null,
     Nome_squadra char(30) not null,
     Nome char(30) not null,
     Tipo char(7) not null,
     constraint IDSCHEMI primary key (IDCampionato, Anno_campionato, Nome_Girone, Nome_squadra, Nome));

create table SOCIETA (
     CodiceMeccanografico char(10) not null check(LENGTH(codicemeccanografico)=10),
     Titoli int not null check(titoli>=0),
     Sponsor char(50) not null,
     Nome char(50) not null,
     Telefono int not null,
     Email char(50) not null,
     Via char(50) not null,
     Civico int not null,
     CF_proprietario char(16) not null check(LENGTH(cf_proprietario)=16),
     constraint IDSOCIETA_ID primary key (CodiceMeccanografico));

create table SQUADRA (
     IDCampionato char(10) not null check(LENGTH(idcampionato)=10),
     Anno_campionato int not null,
     Nome_Girone char(1) not null,
     Nome_squadra char(30) not null,
     CodicePalestra char(10) not null check(LENGTH(codicepalestra)=10),
     Punti_segnati int not null check(punti_segnati>=0),
     Punti_subiti int not null check(punti_subiti>=0),
     Numero_vittorie int not null check(numero_vittorie>=0),
     Numero_sconfitte int not null check(numero_sconfitte>=0),
     Num_vittorie_ospiti int not null check(num_vittorie_ospiti>=0),
     CodiceMeccanografico char(10) not null check(LENGTH(codicemeccanografico)=10),
     constraint IDSQUADRA_ID primary key (IDCampionato, Anno_campionato, Nome_Girone, Nome_squadra),
     constraint FKfruizione_ID unique (CodicePalestra));

create table TESSERATO (
     Nome char(20) not null,
     Cognome char(20) not null,
     CF char(16) not null check(LENGTH(cf)=16),
     TesseraFIP char(10) not null check(LENGTH(tesserafip)=10),
     Eta int not null check(eta>=0),
     Preparatore_fisico char not null,
     Medico char not null,
     Accompagnatore char not null,
     Addetto_arbitro char not null,
     Massaggiatore char not null,
     Aiuto_allenatore char not null,
     Allenatore char not null,
     Scorer char not null,
     Anno_patentino int check(anno_patentino>=0), 
     Specializzazione char(50),
     constraint IDTESSERATO primary key (TesseraFIP));

create table UFFICIALE_DI_CAMPO (
     TesseraFIP char(10) not null check(LENGTH(tesserafip)=10),
     Cronometrista char not null,
     Refertista char not null,
     Segnapunti char not null,
     Stipendio_totale int not null check(stipendio_totale>=0),
     constraint FKcome11_ID primary key (TesseraFIP));


-- Constraints Section
-- ___________________ 

alter table ARBITRO add constraint FKcome10_FK
     foreign key (TesseraFIP)
     references TESSERATO (TesseraFIP)
     on delete cascade;

-- Not implemented
-- alter table CAMPIONATO add constraint IDCAMPIONATO_1_CHK
--     check(exists(select * from GIRONE
--                  where GIRONE.IDCampionato = IDCampionato and GIRONE.Anno_campionato = Anno_campionato)); 

alter table CAMPIONATO add constraint FKconseguimento
     foreign key (CodiceMeccanografico)
     references SOCIETA (CodiceMeccanografico)
     on delete cascade;

alter table codirezione add constraint FKco_UFF
     foreign key (TesseraFIP)
     references UFFICIALE_DI_CAMPO (TesseraFIP)
     on delete cascade;

alter table codirezione add constraint FKco_PAR
     foreign key (CodicePalestra, Data_ora)
     references PARTITA (CodicePalestra, Data_ora)
     on delete cascade;

alter table direzione add constraint FKdir_ARB
     foreign key (TesseraFIP)
     references ARBITRO (TesseraFIP)
     on delete cascade;

alter table direzione add constraint FKdir_PAR
     foreign key (CodicePalestra, Data_ora)
     references PARTITA (CodicePalestra, Data_ora)
     on delete cascade;

alter table GIOCATORE add constraint FKcome9_FK
     foreign key (TesseraFIP)
     references TESSERATO (TesseraFIP)
     on delete cascade;

-- Not implemented
-- alter table GIRONE add constraint IDGIRONE_CHK
--     check(exists(select * from SQUADRA
--                  where SQUADRA.IDCampionato = IDCampionato and SQUADRA.Anno_campionato = Anno_campionato and SQUADRA.Nome_Girone = Nome_Girone)); 

alter table GIRONE add constraint FKsuddivisione
     foreign key (IDCampionato, Anno_campionato)
     references CAMPIONATO (IDCampionato, Anno_campionato)
     on delete cascade;

alter table MEMBRO_ACC add constraint FKcomposizione3_FK
     foreign key (IDCampionato, Anno_campionato, Nome_Girone, Nome_squadra)
     references SQUADRA (IDCampionato, Anno_campionato, Nome_Girone, Nome_squadra)
     on delete cascade;

alter table MEMBRO_ACC add constraint FKessere3
     foreign key (TesseraFIP)
     references TESSERATO (TesseraFIP)
     on delete cascade;

alter table MEMBRO_ADDARB add constraint FKcomposizione4_FK
     foreign key (IDCampionato, Anno_campionato, Nome_Girone, Nome_squadra)
     references SQUADRA (IDCampionato, Anno_campionato, Nome_Girone, Nome_squadra)
     on delete cascade;

alter table MEMBRO_ADDARB add constraint FKessere4
     foreign key (TesseraFIP)
     references TESSERATO (TesseraFIP)
     on delete cascade;

alter table MEMBRO_AIUTOALL add constraint FKcomposizione6_FK
     foreign key (IDCampionato, Anno_campionato, Nome_Girone, Nome_squadra)
     references SQUADRA (IDCampionato, Anno_campionato, Nome_Girone, Nome_squadra)
     on delete cascade;

alter table MEMBRO_AIUTOALL add constraint FKessere6
     foreign key (TesseraFIP)
     references TESSERATO (TesseraFIP)
     on delete cascade;

alter table MEMBRO_ALL add constraint FKcomposizione7_FK
     foreign key (IDCampionato, Anno_campionato, Nome_Girone, Nome_squadra)
     references SQUADRA (IDCampionato, Anno_campionato, Nome_Girone, Nome_squadra)
     on delete cascade;

alter table MEMBRO_ALL add constraint FKessere7
     foreign key (TesseraFIP)
     references TESSERATO (TesseraFIP)
     on delete cascade;

alter table MEMBRO_GIOCATORE add constraint FKcomposizione9
     foreign key (IDCampionato, Anno_campionato, Nome_Girone, Nome_squadra)
     references SQUADRA (IDCampionato, Anno_campionato, Nome_Girone, Nome_squadra)
     on delete cascade;

alter table MEMBRO_GIOCATORE add constraint FKessere9
     foreign key (TesseraFIP)
     references GIOCATORE (TesseraFIP)
     on delete cascade;

alter table MEMBRO_MASS add constraint FKcomposizione5_FK
     foreign key (IDCampionato, Anno_campionato, Nome_Girone, Nome_squadra)
     references SQUADRA (IDCampionato, Anno_campionato, Nome_Girone, Nome_squadra)
     on delete cascade;

alter table MEMBRO_MASS add constraint FKessere5
     foreign key (TesseraFIP)
     references TESSERATO (TesseraFIP)
     on delete cascade;

alter table MEMBRO_MED add constraint FKessere2
     foreign key (TesseraFIP)
     references TESSERATO (TesseraFIP)
     on delete cascade;

alter table MEMBRO_MED add constraint FKcomposizione2_FK
     foreign key (IDCampionato, Anno_campionato, Nome_Girone, Nome_squadra)
     references SQUADRA (IDCampionato, Anno_campionato, Nome_Girone, Nome_squadra)
     on delete cascade;

alter table MEMBRO_PF add constraint FKcomposizione1_FK
     foreign key (IDCampionato, Anno_campionato, Nome_Girone, Nome_squadra)
     references SQUADRA (IDCampionato, Anno_campionato, Nome_Girone, Nome_squadra)
     on delete cascade;

alter table MEMBRO_PF add constraint FKessere1
     foreign key (TesseraFIP)
     references TESSERATO (TesseraFIP)
     on delete cascade;

alter table MEMBRO_SCORER add constraint FKcomposizione8_FK
     foreign key (IDCampionato, Anno_campionato, Nome_Girone, Nome_squadra)
     references SQUADRA (IDCampionato, Anno_campionato, Nome_Girone, Nome_squadra)
     on delete cascade;

alter table MEMBRO_SCORER add constraint FKessere8
     foreign key (TesseraFIP)
     references TESSERATO (TesseraFIP)
     on delete cascade;

-- Not implemented
-- alter table PALESTRA add constraint IDPALESTRA_CHK
--     check(exists(select * from SQUADRA
--                  where SQUADRA.CodicePalestra = CodicePalestra)); 

alter table partecipazione_casa add constraint FKpar_SQU_1
     foreign key (IDCampionato, Anno_campionato, Nome_Girone, Nome_squadra)
     references SQUADRA (IDCampionato, Anno_campionato, Nome_Girone, Nome_squadra)
     on delete cascade;

alter table partecipazione_casa add constraint FKpar_PAR_1_FK
     foreign key (CodicePalestra, Data_ora)
     references PARTITA (CodicePalestra, Data_ora)
     on delete cascade;

alter table partecipazione_ospiti add constraint FKpar_SQU
     foreign key (IDCampionato, Anno_campionato, Nome_Girone, Nome_squadra)
     references SQUADRA (IDCampionato, Anno_campionato, Nome_Girone, Nome_squadra)
     on delete cascade;

alter table partecipazione_ospiti add constraint FKpar_PAR_FK
     foreign key (CodicePalestra, Data_ora)
     references PARTITA (CodicePalestra, Data_ora)
     on delete cascade;

-- Not implemented
-- alter table PARTITA add constraint IDPARTITA_CHK
--     check(exists(select * from partecipazione_ospiti
--                  where partecipazione_ospiti.CodicePalestra = CodicePalestra and partecipazione_ospiti.Data_ora = Data_ora)); 

-- Not implemented
-- alter table PARTITA add constraint IDPARTITA_CHK
--     check(exists(select * from partecipazione_casa
--                  where partecipazione_casa.CodicePalestra = CodicePalestra and partecipazione_casa.Data_ora = Data_ora)); 

-- Not implemented
-- alter table PARTITA add constraint IDPARTITA_CHK
--     check(exists(select * from codirezione
--                  where codirezione.CodicePalestra = CodicePalestra and codirezione.Data_ora = Data_ora)); 

-- Not implemented
-- alter table PARTITA add constraint IDPARTITA_CHK
--     check(exists(select * from direzione
--                  where direzione.CodicePalestra = CodicePalestra and direzione.Data_ora = Data_ora)); 

alter table PARTITA add constraint FKsvolgimento
     foreign key (CodicePalestra)
     references PALESTRA (CodicePalestra)
     on delete cascade;

alter table PARTITA add constraint FKassociazione
     foreign key (IDCampionato, Anno_campionato, Nome_Girone)
     references GIRONE (IDCampionato, Anno_campionato, Nome_Girone)
     on delete cascade;

alter table performance add constraint FKper_GIO
     foreign key (TesseraFIP)
     references GIOCATORE (TesseraFIP)
     on delete cascade;

alter table performance add constraint FKper_PAR
     foreign key (CodicePalestra, Data_ora)
     references PARTITA (CodicePalestra, Data_ora)
     on delete cascade;

-- Not implemented
-- alter table PROPRIETARIO add constraint IDPROPRIETARIO_CHK
--     check(exists(select * from SOCIETA
--                  where SOCIETA.CF_proprietario = CF)); 

alter table SCHEMI add constraint FKesecuzione
     foreign key (IDCampionato, Anno_campionato, Nome_Girone, Nome_squadra)
     references SQUADRA (IDCampionato, Anno_campionato, Nome_Girone, Nome_squadra)
     on delete cascade;

-- Not implemented
-- alter table SOCIETA add constraint IDSOCIETA_CHK
--     check(exists(select * from SQUADRA
--                  where SQUADRA.CodiceMeccanografico = CodiceMeccanografico)); 

alter table SOCIETA add constraint FKpossedere
     foreign key (CF_proprietario)
     references PROPRIETARIO (CF)
     on delete cascade;

alter table SQUADRA add constraint FKaffiliazione
     foreign key (CodiceMeccanografico)
     references SOCIETA (CodiceMeccanografico)
     on delete cascade;

-- Not implemented
-- alter table SQUADRA add constraint IDSQUADRA_CHK
--     check(exists(select * from MEMBRO_GIOCATORE
--                  where MEMBRO_GIOCATORE.IDCampionato = IDCampionato and MEMBRO_GIOCATORE.Anno_campionato = Anno_campionato and MEMBRO_GIOCATORE.Nome_Girone = Nome_Girone and MEMBRO_GIOCATORE.Nome_squadra = Nome_squadra)); 

-- Not implemented
-- alter table SQUADRA add constraint IDSQUADRA_CHK
--     check(exists(select * from MEMBRO_ALL
--                  where MEMBRO_ALL.IDCampionato = IDCampionato and MEMBRO_ALL.Anno_campionato = Anno_campionato and MEMBRO_ALL.Nome_Girone = Nome_Girone and MEMBRO_ALL.Nome_squadra = Nome_squadra)); 

alter table SQUADRA add constraint FKiscrizione
     foreign key (IDCampionato, Anno_campionato, Nome_Girone)
     references GIRONE (IDCampionato, Anno_campionato, Nome_Girone)
     on delete cascade;

alter table SQUADRA add constraint FKfruizione_FK
     foreign key (CodicePalestra)
     references PALESTRA (CodicePalestra)
     on delete cascade;

alter table TESSERATO add constraint CK_specializzazione
	check (specializzazione is null or medico = true);

alter table TESSERATO add constraint CK_anno_patentino
	check ((anno_patentino is null) or (anno_patentino is not null and (allenatore= true or aiuto_allenatore = true)));

alter table UFFICIALE_DI_CAMPO add constraint FKcome11_FK
     foreign key (TesseraFIP)
     references TESSERATO (TesseraFIP)
     on delete cascade;


-- Index Section
-- _____________ 

