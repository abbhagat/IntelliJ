package lld.digitalwallet;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WalletManager {

  private final Map<String, Wallet> walletMap;

  public WalletManager() {
    this.walletMap = new ConcurrentHashMap<>();
  }

  public Wallet createWallet(String id) {
    if (walletMap.containsKey(id)) {
      throw new IllegalArgumentException("Wallet already exists");
    }
    Wallet wallet = new Wallet(id);
    walletMap.put(id, wallet);
    return wallet;
  }

  public Wallet getWallet(String id) {
    Wallet wallet = walletMap.get(id);
    if (wallet == null) {
      throw new IllegalArgumentException("Wallet not found");
    }
    return wallet;
  }
}
