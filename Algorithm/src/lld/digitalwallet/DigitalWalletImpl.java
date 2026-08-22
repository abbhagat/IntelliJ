package lld.digitalwallet;

public class DigitalWalletImpl {

  public static void main(String[] args) {

    WalletManager manager = new WalletManager();
    WalletService service = new WalletService();
    // Create wallets
    Wallet w1 = manager.createWallet("W1");
    Wallet w2 = manager.createWallet("W2");
    // Deposit
    Transaction t1 = service.deposit(w1, 1000,"deposit-001");
    System.out.println(t1);
    // Same request again
    Transaction t2 = service.deposit(w1, 1000,"deposit-001");
    System.out.println(t2);
    System.out.println("W1 Balance: " + w1.getBalance());
    // Withdraw
    Transaction t3 = service.withdraw(w1,   200,"withdraw-001");
    System.out.println(t3);
    // Transfer
    Transaction t4 = service.transfer(w1, w2,300,"transfer-001");
    System.out.println(t4);
    System.out.println("W1 Balance: " + w1.getBalance());
    System.out.println("W2 Balance: " + w2.getBalance());
    // Same transfer request again
    Transaction t5 = service.transfer(w1, w2, 300,   "transfer-001");
    System.out.println("Duplicate request returned: " + t5.getTransId());
    System.out.println("\nW1 Audit:");
    for (AuditRecord record : w1.getAuditHistory()) {
      System.out.println(record);
    }
    System.out.println("\nW2 Audit:");
    for (AuditRecord record : w2.getAuditHistory()) {
      System.out.println(record);
    }
  }
}
