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
    strategy.splitExpense(expense);
    strategy.validateExpense(expense);
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
      balanceSheet.balanceSheet()
                  .computeIfAbsent(user.id(), value -> new HashMap<>())
                  .merge(paidBy.id(), split.getAmount(), Double::sum);

      balanceSheet.balanceSheet()
                  .computeIfAbsent(paidBy.id(), value -> new HashMap<>())
                  .merge(user.id(), -split.getAmount(), Double::sum);
    }
  }

  public void settleUp(User from, User to, double amount) {

    balanceSheet.balanceSheet()
                .get(to.id())
                .merge(from.id(), amount, Double::sum);

    balanceSheet.balanceSheet()
                .get(from.id())
                .merge(to.id(), -amount, Double::sum);
  }
}
