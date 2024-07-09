CREATE TABLE Users(
  Uname VARCHAR(15) NOT NULL,
  PRIMARY KEY(Uname)
);

CREATE TABLE Series(
  Sid VARCHAR(4) NOT NULL,
  Sname VARCHAR(30) NOT NULL,
  Producer VARCHAR(15) NOT NULL,
  PRIMARY KEY(Sid)
);

CREATE TABLE Episodes(
  Eid VARCHAR(8) NOT NULL,
  Ename VARCHAR(30) NOT NULL,
  Status ENUM("Writing", "Written", "Filmed", "Editing", "Release Ready", "Completed") NOT NULL,
  Synopsis VARCHAR(150) NOT NULL,
  LeadPresenter VARCHAR(15) NOT NULL,
  Writer VARCHAR(15) NOT NULL,
  Guests VARCHAR(30),
  PRIMARY KEY(Eid)
);

-- use this for pdf storage
CREATE TABLE PdfStorageTable
(
    Id INT PRIMARY KEY,
    PdfData VARBINARY(7340032) -- 7 MB (7 * 1024 * 1024 bytes)
);
