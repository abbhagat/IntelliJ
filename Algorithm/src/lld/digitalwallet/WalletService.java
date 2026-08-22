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
      Transaction transaction = new Transaction(idempotencyKey, TransactionType.DEPOSIT, amount);
      try {
        wallet.depositInternal(amount);
        transaction.setStatus(TransactionStatus.SUCCESS);
        wallet.addTransaction(transaction);
        wallet.addAudit(new AuditRecord(transaction.getTransactionId(), "Deposited " + amount));
        processedTransactions.put(idempotencyKey, transaction);
        return transaction;
      } catch (Exception e) {
        wallet.addTransaction(transaction);
        wallet.addAudit(new AuditRecord(transaction.getTransactionId(),"Deposit failed"));
        processedTransactions.put(idempotencyKey, transaction);
        throw e;
      }
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
      Transaction transaction = new Transaction(idempotencyKey, TransactionType.WITHDRAW, amount);
      try {
        wallet.withdrawInternal(amount);
        transaction.setStatus(TransactionStatus.SUCCESS);
        wallet.addTransaction(transaction);
        wallet.addAudit(new AuditRecord(transaction.getTransactionId(),"Withdrawn " + amount));
        processedTransactions.put(idempotencyKey, transaction);
        return transaction;
      } catch (Exception e) {
        wallet.addTransaction(transaction);
        wallet.addAudit(new AuditRecord(transaction.getTransactionId(), "Withdrawal failed"));
        processedTransactions.put(idempotencyKey, transaction);
        throw e;
      }
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
   // Lock wallets in deterministic order to prevent deadlock.
    Wallet first = from, second = to;
    if (from.getId().compareTo(to.getId()) > 0) {
      first = to;
      second = from;
    }
    synchronized (first) {
      synchronized (second) {
        // Check again after locking
        existing = processedTransactions.get(idempotencyKey);
        if (existing != null) {
          return existing;
        }
        Transaction transaction = new Transaction(idempotencyKey, TransactionType.TRANSFER, amount);
        try {
          from.withdrawInternal(amount);
          to.depositInternal(amount);
          transaction.setStatus(TransactionStatus.SUCCESS);
          from.addTransaction(transaction);
          to.addTransaction(transaction);
          from.addAudit(new AuditRecord(transaction.getTransactionId(), "Transferred " + amount  + " to "                      + to.getId()));
          to.addAudit(new AuditRecord(transaction.getTransactionId(), "Received " + amount + " from " + from.getId()));
          processedTransactions.put(idempotencyKey, transaction);
          return transaction;
        } catch (Exception e) {
          from.addTransaction(transaction);
          from.addAudit(new AuditRecord(transaction.getTransactionId(), "Transfer failed"));
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
