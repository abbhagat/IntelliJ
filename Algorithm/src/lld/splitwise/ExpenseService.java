package lld.splitwise;

import java.util.HashMap;

public class ExpenseService {

  private final BalanceSheet balanceSheet;

  public ExpenseService(BalanceSheet balanceSheet) {
    this.balanceSheet = balanceSheet;
  }

  public void addExpense(Expense expense) {
    IExpense strategy = ExpenseSplitFactory.getStrategy(expense.getType());
    strategy.validate(expense);
    strategy.splitExpense(expense);
    updateBalanceSheet(expense);
  }

  public void updateBalanceSheet(Expense expense) {
    User paidBy = expense.getPaidBy();
    for (Split split : expense.getSplits()) {
      User user = split.getUser();
      if (user.getUserId().equals(paidBy.getUserId())) {
        continue;
      }
      balanceSheet.getBalanceSheet()
          .computeIfAbsent(user.getUserId(), v -> new HashMap<>())
          .merge(paidBy.getUserId(), split.getAmount(), Double::sum);
      balanceSheet.getBalanceSheet()
          .computeIfAbsent(paidBy.getUserId(), v -> new HashMap<>())
          .merge(user.getUserId(), -split.getAmount(), Double::sum);
    }
  }

  public void settleUp(User from, User to, double amount) {
    balanceSheet.getBalanceSheet().get(from.getUserId()).merge(to.getUserId(), -amount, Double::sum);
    balanceSheet.getBalanceSheet().get(to.getUserId()).merge(from.getUserId(), amount, Double::sum);
  }
}
