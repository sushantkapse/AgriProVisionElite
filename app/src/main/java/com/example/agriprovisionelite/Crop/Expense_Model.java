package com.example.agriprovisionelite.Crop;

public class Expense_Model {

    String c_id ,c_name ,activity ,amount,expense_date ;

    public Expense_Model(String c_id, String c_name, String activity, String amount, String expense_date) {
        this.c_id = c_id;
        this.c_name = c_name;
        this.activity = activity;
        this.amount = amount;
        this.expense_date = expense_date;
    }

    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getExpense_date() {
        return expense_date;
    }

    public void setExpense_date(String expense_date) {
        this.expense_date = expense_date;
    }
}
