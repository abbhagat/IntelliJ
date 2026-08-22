package lld.digitalwallet;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WalletManager {

  private final Map<String, Wallet> wallets;

  public WalletManager() {
    this.wallets = new ConcurrentHashMap<>();
  }

  public Wallet createWallet(String id) {
    Wallet wallet = new Wallet(id);
    if (wallets.putIfAbsent(id, wallet) != null) {
      throw new IllegalArgumentException("Wallet already exists");
    }
    return wallet;
  }

  public Wallet getWallet(String id) {
    Wallet wallet = wallets.get(id);
    if (wallet == null) {
      throw new IllegalArgumentException("Wallet not found");
    }
    return wallet;
  }
}
