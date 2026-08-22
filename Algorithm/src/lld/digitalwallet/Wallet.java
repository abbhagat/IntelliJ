package lld.digitalwallet;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Getter
public class Wallet {

  private final String id;
  private double balance;
  private final List<Transaction> transactions;
  private final List<AuditRecord> auditHistory;

  public Wallet(String id) {
    this.id = id;
    this.transactions = new CopyOnWriteArrayList<>();
    this.auditHistory = new CopyOnWriteArrayList<>();
  }

  public synchronized double getBalance() {
    return balance;
  }

  public synchronized void addTransaction(Transaction transaction) {
    transactions.add(transaction);
  }

  public synchronized void addAudit(AuditRecord auditRecord) {
    auditHistory.add(auditRecord);
  }

  public synchronized List<Transaction> getTransactions() {
    return new ArrayList<>(transactions);
  }

  public synchronized List<AuditRecord> getAuditHistory() {
    return new ArrayList<>(auditHistory);
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
