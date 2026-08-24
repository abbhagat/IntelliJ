package lld.digitalwallet;

import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
public class Transaction {

  private final String transId;
  private final String idempotencyKey;
  private final double amount;
  private final long timestamp;
  private final TransactionType type;
  private       TransactionStatus status;

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
