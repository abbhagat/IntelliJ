package lld.digitalwallet;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WalletManager {

  private final Map<String, Wallet> walletMap;

  public WalletManager() {
    this.walletMap = new ConcurrentHashMap<>();
  }

  public Wallet createWallet(String id) {
    return walletMap.computeIfAbsent(id, value -> new Wallet(id));
  }

  public Wallet getWallet(String id) {
    Wallet wallet = walletMap.get(id);
    if (wallet == null) {
      throw new IllegalArgumentException("Wallet not found");
    }
    return wallet;
  }
}
