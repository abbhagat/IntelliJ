package com.splitwise.service;

import com.splitwise.model.User;
import com.splitwise.model.expense.*;
import com.splitwise.model.split.PercentSplit;
import com.splitwise.model.split.Split;

import java.util.List;

public class ExpenseService {

    public static Expense createExpense(ExpenseType expenseType, double amount, User paidBy, List<Split> splits, ExpenseMetadata expenseMetadata) {
        switch (expenseType) {
            case EXACT:     return new ExactExpense(amount, paidBy, splits, expenseMetadata);
            case PERCENT:
                            for (Split split : splits) {
                                PercentSplit percentSplit = (PercentSplit) split;
                                split.setAmount((amount * percentSplit.getPercent()) / 100.0);
                            }
                            return new PercentExpense(amount, paidBy, splits, expenseMetadata);
            case EQUAL:
                            int totalSplits = splits.size();
                            double splitAmount = ((double) Math.round(amount * 100 / totalSplits)) / 100.0;
                            for (Split split : splits) {
                                split.setAmount(splitAmount);
                            }
                            splits.get(0).setAmount(splitAmount + (amount - splitAmount * totalSplits));
                            return new EqualExpense(amount, paidBy, splits, expenseMetadata);
            default:
                return null;
        }
    }
}