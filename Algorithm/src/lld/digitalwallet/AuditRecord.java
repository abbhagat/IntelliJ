package lld.digitalwallet;

import lombok.ToString;

@ToString
public class AuditRecord {

  private final String transId;
  private final String message;
  private final long   timestamp;

  public AuditRecord(String transId, String message) {
    this.transId = transId;
    this.message = message;
    this.timestamp = System.currentTimeMillis();
  }

}
