package Buildings;

import Game.GameObject;

import java.util.ArrayList;
import java.util.List;

/**
 * The class Bank represents the bank building.
 * It contains user's balance (int variable).
 */
public class Bank extends Building {

    protected int balance;

    public Bank() {
        this.balance = this.getBalance();
        this.addAccessibleObjects(getAvailableOptions());
    }

    public int getBalance() {
        return balance;
    }

    protected void setBalance(int balance) {
        this.balance = balance;
    }

    protected int getNumberOfSteps() {
        return 5;
    }

    public List<GameObject> getAvailableOptions() {

        List<GameObject> availableOptions = new ArrayList<GameObject>();
        availableOptions.add(new BankDepositMoney(this, 100));
        availableOptions.add(new BankDepositMoney(this, 500));
        availableOptions.add(new BankDepositMoney(this, 1000));
        availableOptions.add(new BankWithdrawMoney(this, 100));
        availableOptions.add(new BankWithdrawMoney(this, 500));
        availableOptions.add(new BankWithdrawMoney(this, 1000));

        return availableOptions;
    }

    public String getWelcomeMessage() {
        return "Welcome to the Bank!";
    }

    public String getOptionMessage() {
        return "Go to Bank.";
    }
}
