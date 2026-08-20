package lld.atm;


// Insert card → Enter PIN → Select transaction → Perform transaction → Eject card
public class ATMImpl {

  public static void main(String[] args) {

    BankService bankService = new BankService();

    Card Card = new Card("1234", 1234);

    Account account = new Account("ACC-1", 10000);

    bankService.addAccount(Card.getCardNumber(), account);

    ATM atm = new ATM(bankService);

    atm.insertCard(Card);

    if (atm.enterPin(1234)) {
      System.out.println("Balance: " + atm.checkBalance());
      atm.withdraw(2000);
      atm.deposit(500);
      System.out.println("Balance: " + atm.checkBalance());
    }

    atm.ejectCard();
  }
}
