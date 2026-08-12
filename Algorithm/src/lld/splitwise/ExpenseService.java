package lld.splitwise;

import java.util.HashMap;
import static lld.splitwise.SplitStrategy.getStrategy;

public class ExpenseService {

  private final BalanceSheet balanceSheet;

  public ExpenseService(BalanceSheet balanceSheet) {
    this.balanceSheet = balanceSheet;
  }

  public void addExpense(Expense expense) {
    Split strategy = getStrategy(expense.getExpenseType());
    strategy.splitExpense(expense);
    strategy.validateExpense(expense);
    updateBalanceSheet(expense);
    expense.getGroup().addExpense(expense);
  }

  private void updateBalanceSheet(Expense expense) {
    User paidBy = expense.getPaidBy();
    for (Split split : expense.getSplits()) {
      User user = split.getUser();
      if (user.getId().equals(paidBy.getId())) {
        continue;
      }
      balanceSheet.getBalanceSheet()
          .computeIfAbsent(user.getId(), v -> new HashMap<>())
          .merge(paidBy.getId(), split.getAmount(), Double::sum);

      balanceSheet.getBalanceSheet()
          .computeIfAbsent(paidBy.getId(), v -> new HashMap<>())
          .merge(user.getId(), -split.getAmount(), Double::sum);
    }
  }

  public void settleUp(User from, User to, double amount) {
    balanceSheet.getBalanceSheet()
        .get(from.getId())
        .merge(to.getId(), -amount, Double::sum);

    balanceSheet.getBalanceSheet()
        .get(to.getId())
        .merge(from.getId(), amount, Double::sum);
  }
}
