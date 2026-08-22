package lld.splitwise;

import java.util.HashMap;
import static lld.splitwise.SplitStrategy.getStrategy;

public class ExpenseService {

  private final BalanceSheet balanceSheet;

  public ExpenseService(BalanceSheet balanceSheet) {
    this.balanceSheet = balanceSheet;
  }

  public void addExpense(Expense expense) {
    ExpenseType expenseType = expense.getExpenseType();
    Split strategy = getStrategy(expenseType);
    strategy.validateExpense(expense);
    strategy.splitExpense(expense);
    updateBalanceSheet(expense);
    Group group = expense.getGroup();
    group.addExpense(expense);
  }

  private void updateBalanceSheet(Expense expense) {
    User paidBy = expense.getPaidBy();
    for (Split split : expense.getSplits()) {
      User user = split.getUser();
      if (user.id().equals(paidBy.id())) {
        continue;
      }
      balanceSheet.getBalanceSheet()
                  .computeIfAbsent(user.id(), value -> new HashMap<>())
                  .merge(paidBy.id(), split.getAmount(), Double::sum);
//      Map<String, Double> userBalance = balanceSheet.getBalanceSheet().computeIfAbsent(user.id(), value -> new HashMap<>());
//      Double currentAmount = userBalance.get(paidBy.id());
//      if (currentAmount == null) {
//        userBalance.put(paidBy.id(), split.getAmount());
//      } else {
//        userBalance.put(paidBy.id(), currentAmount + split.getAmount());
//      }
      balanceSheet.getBalanceSheet()
                  .computeIfAbsent(paidBy.id(), value -> new HashMap<>())
                  .merge(user.id(), -split.getAmount(), Double::sum);
    }
  }

  public void settleUp(User from, User to, double amount) {

    balanceSheet.getBalanceSheet()
                .get(to.id())
                .merge(from.id(), amount, Double::sum);

    balanceSheet.getBalanceSheet()
                .get(from.id())
                .merge(to.id(), -amount, Double::sum);
  }
}
