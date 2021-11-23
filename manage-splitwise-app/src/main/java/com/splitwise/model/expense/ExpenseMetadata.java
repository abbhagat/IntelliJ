package com.splitwise.model.expense;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ExpenseMetadata {

    private String name;
    private String imgUrl;
    private String notes;

}
