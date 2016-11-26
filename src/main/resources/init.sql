CREATE TABLE IF NOT EXISTS svns_players(id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL, uuid BINARY(16) NOT NULL UNIQUE,
  points INT UNSIGNED NOT NULL, INDEX uuid_i(uuid)) ENGINE=InnoDB;
CREATE TABLE IF NOT EXISTS svns_record(id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL, player1 INT UNSIGNED NOT NULL,
  player2 INT UNSIGNED NOT NULL, kills INT UNSIGNED NOT NULL, deaths INT UNSIGNED NOT NULL,
  CONSTRAINT FOREIGN KEY(player1) REFERENCES svns_players(id) ON DELETE CASCADE, CONSTRAINT FOREIGN KEY(player2) REFERENCES
  svns_players(id) ON DELETE CASCADE, CONSTRAINT UNIQUE CLUSTERED(player1, player2)) ENGINE=InnoDB;
