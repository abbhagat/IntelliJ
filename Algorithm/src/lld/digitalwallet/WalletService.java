package lld.digitalwallet;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WalletService {

  private final Map<String, Transaction> processedTransactions = new ConcurrentHashMap<>();

  public Transaction deposit(Wallet wallet, double amount, String idempotencyKey) {
    validateAmount(amount);
    Transaction existing = processedTransactions.get(idempotencyKey);  // Idempotency check
    if (existing != null) {
      return existing;
    }
    synchronized (wallet) {
      // Check again after acquiring lock.
      existing = processedTransactions.get(idempotencyKey);
      if (existing != null) {
        return existing;
      }
      AuditRecord auditRecord;
      TransactionStatus status;
      Transaction transaction = new Transaction(idempotencyKey, TransactionType.DEPOSIT, amount);
      try {
        wallet.depositAmount(amount);
        status      = TransactionStatus.SUCCESS;
        auditRecord = new AuditRecord(transaction.getTransId(), "Deposited " + amount);
      } catch (Exception e) {
        status      = TransactionStatus.FAILED;
        auditRecord = new AuditRecord(transaction.getTransId(), "Deposit failed");
      }
      transaction.setStatus(status);
      wallet.addTransaction(transaction);
      wallet.addAudit(auditRecord);
      processedTransactions.put(idempotencyKey, transaction);
      return transaction;
    }
  }

  public Transaction withdraw(Wallet wallet, double amount, String idempotencyKey) {
    validateAmount(amount);
    Transaction existing = processedTransactions.get(idempotencyKey);
    if (existing != null) {
      return existing;
    }
    synchronized (wallet) {
      existing = processedTransactions.get(idempotencyKey);
      if (existing != null) {
        return existing;
      }
      AuditRecord auditRecord;
      TransactionStatus status;
      Transaction transaction = new Transaction(idempotencyKey, TransactionType.WITHDRAW, amount);
      try {
        wallet.withdrawAmount(amount);
        status      = TransactionStatus.SUCCESS;
        auditRecord = new AuditRecord(transaction.getTransId(), "Withdrawn " + amount);
      } catch (Exception e) {
        status      = TransactionStatus.FAILED;
        auditRecord = new AuditRecord(transaction.getTransId(), "Withdrawal failed");
      }
      transaction.setStatus(status);
      wallet.addAudit(auditRecord);
      wallet.addTransaction(transaction);
      processedTransactions.put(idempotencyKey, transaction);
      return transaction;
    }
  }

  public Transaction transfer(Wallet from, Wallet to, double amount, String idempotencyKey) {
    validateAmount(amount);
    if (from == to) {
      throw new IllegalArgumentException("Cannot transfer to same wallet");
    }
    Transaction existing = processedTransactions.get(idempotencyKey);  // Idempotency check
    if (existing != null) {
      return existing;
    }
    Wallet first = from, second = to;
    if (from.getId().compareTo(to.getId()) > 0) {   // Lock wallets in deterministic order to prevent deadlock.
      first  = to;
      second = from;
    }
    synchronized (first) {
      synchronized (second) {
        existing = processedTransactions.get(idempotencyKey);  // Check again after locking
        if (existing != null) {
          return existing;
        }
        Transaction transaction = new Transaction(idempotencyKey, TransactionType.TRANSFER, amount);
        try {
          from.withdrawAmount(amount);
          to.depositAmount(amount);
          transaction.setStatus(TransactionStatus.SUCCESS);
          from.addTransaction(transaction);
          to.addTransaction(transaction);
          from.addAudit(new AuditRecord(transaction.getTransId(), "Transferred " + amount + " to " + to.getId()));
          to.addAudit(new AuditRecord(transaction.getTransId(), "Received " + amount + " from " + from.getId()));
          processedTransactions.put(idempotencyKey, transaction);
          return transaction;
        } catch (Exception e) {
          from.addTransaction(transaction);
          from.addAudit(new AuditRecord(transaction.getTransId(), "Transfer failed"));
          processedTransactions.put(idempotencyKey, transaction);
          throw e;
        }
      }
    }
  }

  private void validateAmount(double amount) {
    if (amount <= 0) {
      throw new IllegalArgumentException("Amount must be greater than zero");
    }
  }
}
