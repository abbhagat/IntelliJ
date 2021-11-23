package com.splitwise.model.expense;

import com.splitwise.model.User;
import com.splitwise.model.split.Split;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public abstract class Expense {

    private String id;
    private double amount;
    private User paidBy;
    private List<Split> splits;
    private ExpenseMetadata metadata;

    public abstract boolean validate();
}
