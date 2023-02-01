public class Test08 {
    public static void main(String[] args) {
        SavingsAccount savingsAccount = new SavingsAccount(2000);
        System.out.println(savingsAccount.getBalance() + " " + savingsAccount.withdrawCount);
        savingsAccount.deposit(2000);
        System.out.println(savingsAccount.getBalance() + " " + savingsAccount.withdrawCount);

        savingsAccount.deposit(1000);
        System.out.println(savingsAccount.getBalance() + " " + savingsAccount.withdrawCount);

        savingsAccount.deposit(500);
        System.out.println(savingsAccount.getBalance() + " " + savingsAccount.withdrawCount);
        savingsAccount.withdraw(500);
        System.out.println(savingsAccount.getBalance() + " " + savingsAccount.withdrawCount);
        savingsAccount.withdraw(1000);
        System.out.println(savingsAccount.getBalance() + " " + savingsAccount.withdrawCount);
        savingsAccount.withdraw(1500);
        System.out.println(savingsAccount.getBalance() + " " + savingsAccount.withdrawCount);
//        CheckingAccount checkingAccount = new CheckingAccount(1000);
//        checkingAccount.withdraw(999);
//        System.out.println(checkingAccount.getBalance());


    }
}

class BankAccount {
    private double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public BankAccount(double balance) {
        setBalance(balance);
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }
}

class CheckingAccount extends BankAccount {
    public CheckingAccount(double balance) {
        super(balance);
    }

    public void deposit(double amount) {
        super.deposit(amount - 1);
    }

    public void withdraw(double amount) {
        if (getBalance() - amount - 1 < 0) {
            System.out.println("取钱失败，余额不足！");
            return;
        }
        super.withdraw(amount - 1);
    }
}

class SavingsAccount extends BankAccount {
    int withdrawCount = 3;

    public SavingsAccount(double balance) {
        super(balance);
    }

    private void earnMonthInterest() {
        setBalance(getBalance() * 1.05);
        withdrawCount = 3;
    }

    @Override
    public void deposit(double amount) {
        if (withdrawCount == 1) {
            super.deposit(amount-1);
            earnMonthInterest();
        } else {
            super.deposit(amount);
            withdrawCount--;
        }
    }

    @Override
    public void withdraw(double amount) {
        if (withdrawCount == 1) {
            super.withdraw(amount-1);
            earnMonthInterest();
        } else {
            super.withdraw(amount);

            withdrawCount--;
        }
    }
}