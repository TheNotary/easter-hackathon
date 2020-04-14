CREATE TABLE IF NOT EXISTS hellos
(
  id int(11) NOT NULL AUTO_INCREMENT,
  title varchar(30) NOT NULL,
  body varchar(250) NOT NULL,
  created_at datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  is_good tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
