package lld.digitalwallet;

import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
public class Transaction {

  private final String transId;
  private final String idempotencyKey;
  private final TransactionType type;
  private final double amount;
  private TransactionStatus status;
  private final long timestamp;

  public Transaction(String idempotencyKey, TransactionType type, double amount) {
    this.transId = UUID.randomUUID().toString();
    this.idempotencyKey = idempotencyKey;
    this.type = type;
    this.amount = amount;
    this.status = TransactionStatus.PENDING;
    this.timestamp = System.currentTimeMillis();
  }

  public void setStatus(TransactionStatus status) {
    this.status = status;
  }
}
