//package lld.splitwise;
//
//public class ExpenseService {
//
//  BalanceSheet balanceSheet;
//
//  void addExpense(Expense expense) {
//    ExpenseSplitStrategy strategy = ExpenseSplitFactory.getStrategy(expense.type);
//
//    strategy.validate(expense);
//    strategy.splitExpense(expense);
//    updateBalanceSheet(expense);
//  }
//
//  void updateBalanceSheet(Expense expense) {
//    User paidBy = expense.paidBy;
//
//    for (Split split : expense.splits) {
//      User user = split.user;
//
//      if (user.userId.equals(paidBy.userId)) continue;
//
//      balanceSheet.balanceMap
//          .computeIfAbsent(user.userId, k -> new HashMap<>())
//          .merge(paidBy.userId, split.amount, Double::sum);
//
//      balanceSheet.balanceMap
//          .computeIfAbsent(paidBy.userId, k -> new HashMap<>())
//          .merge(user.userId, -split.amount, Double::sum);
//    }
//  }
//
//  void settleUp(User from, User to, double amount) {
//    balanceSheet.balanceMap.get(from.userId)
//        .merge(to.userId, -amount, Double::sum);
//
//    balanceSheet.balanceMap.get(to.userId)
//        .merge(from.userId, amount, Double::sum);
//  }
//}
