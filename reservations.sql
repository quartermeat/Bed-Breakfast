
  CREATE TABLE "QUARTERMEAT"."RESERVATIONS" 
   (	"ID" NUMBER NOT NULL ENABLE, 
	"FIRSTDATE" DATE NOT NULL ENABLE, 
	"LASTDATE" DATE NOT NULL ENABLE, 
	"GUARANTEED" VARCHAR2(20 BYTE) NOT NULL ENABLE, 
	"ROOMNUMBER" NUMBER NOT NULL ENABLE, 
	"PRICEPERNIGHT" NUMBER NOT NULL ENABLE, 
	"CUSTOMER" NUMBER NOT NULL ENABLE, 
	 CONSTRAINT "RESERVATIONS_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE, 
	 CONSTRAINT "CUSTOMERID" FOREIGN KEY ("CUSTOMER")
	  REFERENCES "QUARTERMEAT"."CUSTOMERS" ("ID") ENABLE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;

  CREATE OR REPLACE TRIGGER "QUARTERMEAT"."AUTO_reservations_TRIGGER" 
BEFORE INSERT ON reservations
FOR EACH ROW

BEGIN
  SELECT AUTO_INCREMENT.NEXTVAL
  INTO :new.id
  FROM dual;
END;
/
ALTER TRIGGER "QUARTERMEAT"."AUTO_reservations_TRIGGER" ENABLE;