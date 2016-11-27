package net.rocketeer.sevens.player;

import java.util.UUID;

public class SevensPlayer {
  final int id;
  private final PlayerDatabase database;
  private final int score;
  private final UUID uuid;

  SevensPlayer(PlayerDatabase database, UUID uuid, int id, int score) {
    this.id = id;
    this.score = score;
    this.database = database;
    this.uuid = uuid;
  }

  public UUID uuid() {
    return this.uuid;
  }

  public int id() {
    return this.id;
  }

  public int score() {
    return this.score;
  }

  public void addScore(int points) throws Exception {
    this.database.updateScore(this, points);
  }

  public void addKillAgainst(SevensPlayer other) throws Exception {
    Record record = this.database.fetchRecord(this, other);
    if (record.player1().id() == this.id)
      this.database.updateRecord(record, 1, 0);
    else
      this.database.updateRecord(record, 0, 1);
  }

  public void addDeathAgainst(SevensPlayer other) throws Exception {
    Record record = this.database.fetchRecord(this, other);
    if (record.player1().id() == this.id)
      this.database.updateRecord(record, 0, 1);
    else
      this.database.updateRecord(record, 1, 0);
  }
}
