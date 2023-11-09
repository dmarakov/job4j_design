package ru.job4j.ood.lsp;

/*
В данном случае у нас есть класс "сберегательный счет" в котором переопределен метод из родительского класс.
Таким образом, при подстановке класса наследника на место базового класса, у нас получится нарушение принципа Лисков
 */
class Account {
    protected double balance;

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}

class SavingsAccount extends Account {
    private double interestRate;

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public void withdraw(double amount) {
        throw new UnsupportedOperationException("Cannot withdraw from savings account.");
    }

    public void addInterest() {
        balance += balance * interestRate;
    }
}

