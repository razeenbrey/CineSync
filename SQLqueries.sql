CREATE TABLE Users(
  uName VARCHAR(15) NOT NULL,
  PRIMARY KEY(uName)
);

CREATE TABLE Series(
  sId VARCHAR(4) NOT NULL,
  sName VARCHAR(30) NOT NULL,
  producer VARCHAR(15) NOT NULL,
  PRIMARY KEY(sId)
);

CREATE TABLE Episodes(
  eId VARCHAR(8) NOT NULL,
  eName VARCHAR(30) NOT NULL,
  status ENUM("Writing", "Written", "Filmed", "Editing", "Release Ready", "Completed") NOT NULL,
  synopsis VARCHAR(150) NOT NULL,
  leadPresenter VARCHAR(15) NOT NULL,
  writer VARCHAR(15) NOT NULL,
  guests VARCHAR(30),
  informationSheet VARBINARY(7340032) -- 7 MB (7 * 1024 * 1024 bytes)
  productionSheet VARBINARY(7340032) -- 7 MB (7 * 1024 * 1024 bytes)
  PRIMARY KEY(eId)
);
