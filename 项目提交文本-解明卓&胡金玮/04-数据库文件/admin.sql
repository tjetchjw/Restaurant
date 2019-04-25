prompt
prompt Creating table ADMINISTRATION
prompt =============================
prompt
create table ADMIN.ADMINISTRATION
(
  admid   NUMBER(10) not null,
  admname VARCHAR2(20) not null,
  admpass VARCHAR2(20) not null
)
tablespace DATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ADMIN.ADMINISTRATION
  add constraint PK_ADMINISTRATION primary key (ADMID)
  using index 
  tablespace DATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table CUSTOMER
prompt =======================
prompt
create table ADMIN.CUSTOMER
(
  cuid    NUMBER(10) not null,
  cuname  VARCHAR2(20) not null,
  memtype VARCHAR2(20) not null,
  cubal   NUMBER(10,2) default 0.00 not null,
  frozen  NUMBER(1) default 1 not null
)
tablespace DATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ADMIN.CUSTOMER
  add constraint PK_CUSTOMER primary key (CUID)
  using index 
  tablespace DATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table CUSTOMERCONSUMPTIONRECORDS
prompt =========================================
prompt
create table ADMIN.CUSTOMERCONSUMPTIONRECORDS
(
  orid       VARCHAR2(38) not null,
  diid       NUMBER(10) not null,
  dinum      NUMBER(3) not null,
  ordate     DATE not null,
  cuid       NUMBER(10) not null,
  totalprice NUMBER(11,2) not null
)
tablespace DATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ADMIN.CUSTOMERCONSUMPTIONRECORDS
  add constraint FK_CUSTOMER_REFERENCE_CUSTOMER foreign key (CUID)
  references ADMIN.CUSTOMER (CUID);

prompt
prompt Creating table DISHESTYPE
prompt =========================
prompt
create table ADMIN.DISHESTYPE
(
  dtid   NUMBER(1) not null,
  dtname VARCHAR2(20) not null
)
tablespace DATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ADMIN.DISHESTYPE
  add constraint PK_DISHESTYPE primary key (DTID)
  using index 
  tablespace DATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table DISHES
prompt =====================
prompt
create table ADMIN.DISHES
(
  diid     NUMBER(10) not null,
  diname   VARCHAR2(20) not null,
  diprice  NUMBER(7,2) not null,
  dtid     NUMBER(1) not null,
  dimonsv  NUMBER(10) default 0 not null,
  isdelete NUMBER(1) default 1,
  ischeap  NUMBER(1) default 0 not null
)
tablespace DATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ADMIN.DISHES
  add constraint PK_DISHES primary key (DIID)
  using index 
  tablespace DATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ADMIN.DISHES
  add constraint FK_DISHES_REFERENCE_DISHESTY foreign key (DTID)
  references ADMIN.DISHESTYPE (DTID);

prompt
prompt Creating table HAHA
prompt ===================
prompt
create table ADMIN.HAHA
(
  id    NUMBER(4) not null,
  hname VARCHAR2(20)
)
tablespace DATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ADMIN.HAHA
  add primary key (ID)
  using index 
  tablespace DATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table STAFF
prompt ====================
prompt
create table ADMIN.STAFF
(
  stid     NUMBER(10) not null,
  stname   VARCHAR2(20) not null,
  stpass   VARCHAR2(20) not null,
  isdelete NUMBER(1) default 1 not null
)
tablespace DATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ADMIN.STAFF
  add constraint PK_STAFF primary key (STID)
  using index 
  tablespace DATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table ORDERTABLE
prompt =========================
prompt
create table ADMIN.ORDERTABLE
(
  orid   VARCHAR2(38) not null,
  ordate DATE not null,
  stid   NUMBER(10),
  cuid   NUMBER(10) not null
)
tablespace DATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ADMIN.ORDERTABLE
  add constraint PK_ORDERTABLE primary key (ORID)
  using index 
  tablespace DATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ADMIN.ORDERTABLE
  add constraint FK_ORDERTAB_REFERENCE_CUSTOMER foreign key (CUID)
  references ADMIN.CUSTOMER (CUID);
alter table ADMIN.ORDERTABLE
  add constraint FK_ORDERTAB_REFERENCE_STAFF foreign key (STID)
  references ADMIN.STAFF (STID);

prompt
prompt Creating table ORDERTERM
prompt ========================
prompt
create table ADMIN.ORDERTERM
(
  orid    VARCHAR2(38) not null,
  diid    NUMBER(10) not null,
  dinum   NUMBER(3) not null,
  diprice NUMBER(10,3) default 0 not null
)
tablespace DATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ADMIN.ORDERTERM
  add constraint FK_ORDERTER_REFERENCE_DISHES foreign key (DIID)
  references ADMIN.DISHES (DIID);
alter table ADMIN.ORDERTERM
  add constraint FK_ORDERTER_REFERENCE_ORDERTAB foreign key (ORID)
  references ADMIN.ORDERTABLE (ORID) on delete cascade;

prompt
prompt Creating sequence SEQ_CUS
prompt =========================
prompt
create sequence ADMIN.SEQ_CUS
minvalue 1
maxvalue 9999999
start with 61
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_DIS
prompt =========================
prompt
create sequence ADMIN.SEQ_DIS
minvalue 1
maxvalue 9999999
start with 21
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_STA
prompt =========================
prompt
create sequence ADMIN.SEQ_STA
minvalue 1
maxvalue 9999999
start with 41
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_STID
prompt ==========================
prompt
create sequence ADMIN.SEQ_STID
minvalue 1
maxvalue 9999999
start with 21
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_TEST
prompt ==========================
prompt
create sequence ADMIN.SEQ_TEST
minvalue 1
maxvalue 9999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_T_RECV
prompt ============================
prompt
create sequence ADMIN.SEQ_T_RECV
minvalue 1
maxvalue 9999999
start with 1
increment by 1
cache 50;

