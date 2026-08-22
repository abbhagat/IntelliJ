package lld.digitalwallet;

import lombok.ToString;

@ToString
public class AuditRecord {

  private final String transactionId;
  private final String message;
  private final long timestamp;

  public AuditRecord(String transactionId, String message) {
    this.transactionId = transactionId;
    this.message = message;
    this.timestamp = System.currentTimeMillis();
  }

}
