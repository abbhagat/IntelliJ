package lld.splitwise;

import java.util.HashMap;

public class ExpenseService {

  BalanceSheet balanceSheet;

  void addExpense(Expense expense) {
    ExpenseSplitStrategy strategy = ExpenseSplitFactory.getStrategy(expense.type);

    strategy.validate(expense);
    strategy.splitExpense(expense);
    updateBalanceSheet(expense);
  }

  void updateBalanceSheet(Expense expense) {
    User paidBy = expense.paidBy;
    for (Split split : expense.splits) {
      User user = split.user;
      if (user.getUserId().equals(paidBy.getUserId())) continue;
      balanceSheet.balanceMap.computeIfAbsent(user.getUserId(), k -> new HashMap<>())
          .merge(paidBy.getUserId(), split.amount, Double::sum);
      balanceSheet.balanceMap.computeIfAbsent(paidBy.getUserId(), k -> new HashMap<>())
          .merge(user.getUserId(), -split.amount, Double::sum);
    }
  }

  void settleUp(User from, User to, double amount) {
    balanceSheet.balanceMap.get(from.getUserId()).merge(to.getUserId(), -amount, Double::sum);
    balanceSheet.balanceMap.get(to.getUserId()).merge(from.getUserId(), amount, Double::sum);
  }
}
