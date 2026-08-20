package lld.atm;

public class ATM {

  private ATMState state = ATMState.IDLE;

  private Card card;
  private Account account;

  private final BankService bankService;

  public ATM(BankService bankService) {
    this.bankService = bankService;
  }

  public void insertCard(Card card) {
    if (state != ATMState.IDLE) {
      throw new IllegalStateException("ATM is busy");
    }
    this.card = card;
    state = ATMState.CARD_INSERTED;
    System.out.println("Card inserted");
  }

  public boolean enterPin(int pin) {
    if (state != ATMState.CARD_INSERTED) {
      throw new IllegalStateException("Insert card first");
    }
    if (!card.validatePin(pin)) {
      System.out.println("Invalid PIN");
      return false;
    }
    account = bankService.getAccount(card.getCardNumber());
    if (account == null) {
      System.out.println("Account not found");
      return false;
    }
    state = ATMState.AUTHENTICATED;
    System.out.println("Authentication successful");
    return true;
  }

  public double checkBalance() {
    validateAuthentication();
    return account.getBalance();
  }

  public void deposit(double amount) {
    validateAuthentication();

    account.deposit(amount);

    System.out.println("Deposited: " + amount);
  }

  public boolean withdraw(double amount) {
    validateAuthentication();
    if (!account.withdraw(amount)) {
      System.out.println("Insufficient balance");
      return false;
    }

    System.out.println("Cash dispensed: " + amount);
    return true;
  }

  public void ejectCard() {
    if (state == ATMState.IDLE) {
      return;
    }

    card = null;
    account = null;
    state = ATMState.IDLE;

    System.out.println("Card ejected");
  }

  private void validateAuthentication() {
    if (state != ATMState.AUTHENTICATED) {
      throw new IllegalStateException("Please authenticate first");
    }
  }
}
