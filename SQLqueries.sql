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
  -- Change to enum below
  Status VARCHAR(30) NOT NULL,
  Synopsis VARCHAR(150) NOT NULL,
  LeadPresenter VARCHAR(15) NOT NULL,
  Writer VARCHAR(15) NOT NULL,
  -- maybe make smaller
  Guests VARCHAR(50) NOT NULL,
  PRIMARY KEY(Eid)
);
