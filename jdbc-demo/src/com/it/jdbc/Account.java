package com.it.jdbc;

import java.util.Objects;

public class Account {
    private int id;
    private String ename;
    private double money;

    public Account() {

    }

    public Account(int id, String ename, double money) {
        this.id = id;
        this.ename = ename;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id == account.id && Double.compare(account.money, money) == 0 && Objects.equals(ename, account.ename);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ename, money);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", ename='" + ename + '\'' +
                ", money=" + money +
                '}';
    }
}
