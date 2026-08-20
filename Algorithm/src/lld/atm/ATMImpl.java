package lld.atm;

public class ATMImpl {

  public static void main(String[] args) {
    BankService bankService = new BankService();
    Card card = new Card("1234", 1234);
    Account account = new Account("ACC-1", 10000);
    bankService.addAccount(card.getCardNumber(), account);
    ATM atm = new ATM(bankService);
    atm.insertCard(card);
    if (atm.enterPin(1234)) {
      System.out.println("Balance: " + atm.checkBalance());
      atm.withdraw(2000);
      atm.deposit(500);
      System.out.println("Balance: " + atm.checkBalance());
    }
    atm.ejectCard();
  }
}
