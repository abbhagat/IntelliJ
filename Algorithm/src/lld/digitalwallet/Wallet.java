package lld.digitalwallet;

import lombok.Getter;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Getter
public class Wallet {

  private final String id;
  private final List<Transaction> transactions;
  private final List<AuditRecord> auditHistory;
  private double balance;

  public Wallet(String id) {
    this.id = id;
    this.transactions = new CopyOnWriteArrayList<>();
    this.auditHistory = new CopyOnWriteArrayList<>();
  }

  public synchronized double getBalance() { // read-modify-write operations.the lock is on the current object (this)
    return balance;
  }

  public void addTransaction(Transaction transaction) {
    transactions.add(transaction);
  }

  public void addAudit(AuditRecord auditRecord) {
    auditHistory.add(auditRecord);
  }

  // Called while WalletService owns the lock.
  public void depositAmount(double amount) {
    balance += amount;
  }

  public void withdrawAmount(double amount) {
    if (balance < amount) {
      throw new IllegalStateException("Insufficient balance");
    }
    balance -= amount;
  }
}
