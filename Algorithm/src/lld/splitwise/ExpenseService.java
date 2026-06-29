package lld.splitwise;

import java.util.HashMap;

public class ExpenseService {

  private BalanceSheet balanceSheet;

  public void addExpense(Expense expense) {
    ExpenseSplitStrategy strategy = ExpenseSplitFactory.getStrategy(expense.getType());
    strategy.validate(expense);
    strategy.splitExpense(expense);
    updateBalanceSheet(expense);
  }

  public void updateBalanceSheet(Expense expense) {
    User paidBy = expense.getPaidBy();
    for (Split split : expense.getSplits()) {
      User user = split.user;
      if (user.getUserId().equals(paidBy.getUserId())) continue;
      balanceSheet.getBalanceMap().computeIfAbsent(user.getUserId(), k -> new HashMap<>())
          .merge(paidBy.getUserId(), split.amount, Double::sum);
      balanceSheet.getBalanceMap().computeIfAbsent(paidBy.getUserId(), k -> new HashMap<>())
          .merge(user.getUserId(), -split.amount, Double::sum);
    }
  }

  public void settleUp(User from, User to, double amount) {
    balanceSheet.getBalanceMap().get(from.getUserId()).merge(to.getUserId(), -amount, Double::sum);
    balanceSheet.getBalanceMap().get(to.getUserId()).merge(from.getUserId(), amount, Double::sum);
  }
}
