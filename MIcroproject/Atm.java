package MIcroproject;

import java.util.ArrayList;

public class Atm {

    private Account userAccount = null;
    private CM cm;
    private OperationsHelper helper;

    public static void main(String[] args) {

        Atm atm = new Atm();
        atm.intiData();

        atm.checkUser();

    }

    private void checkUser() {
        if (userAccount != null) {

            askUserForOperations();

        } else {
            String userData = cm.getData("Already Have Account 'Y' to Login 'N' to Create one");
            String data = userData.toUpperCase();

            switch (data) {
                case "Y":
                    loginUser();
                    break;
                case "N":
                    createUser();
                    break;
                default:
                    cm.print("Please Enter Correct Choice");
                    checkUser();
                    break;
            }

        }
    }

    private void askUserForOperations() {
        cm.print("\n\n");
        

        cm.print("----------|| Welcome " + userAccount.getName() + " ||----------");
        cm.print("Automated Teller Machine");
        cm.print("Choose 1 for Withdraw");
        cm.print("Choose 2 for Deposit");
        cm.print("Choose 3 for Check Balance");
        cm.print("Choose 4 for Logout");
        cm.print("Choose 5 for EXIT");

        int userChoice = cm.getIntData("Choose the operation you want to perform:  ");

        switch (userChoice) {
            case 1:
                withDraw();
                break;

            case 2:
                deposit();
                break;

            case 3:
                balance();
                break;

            case 4:
                logout();
                break;

            case 5:
                System.exit(0);
            
            
        }

    }

    private void logout() {

        userAccount = null;
        checkUser();
    
    }

    private void balance() {
        cm.print("Your current balence is " + userAccount.getMoney());
        askUserForOperations();
    }

    private void deposit() {
        int amount = cm.getIntData("How much amount you wanted to deposit ? ");
        helper.updateUserMoney(userAccount.getName(), amount, OperationType.Add);

        cm.print("Amount Successfully Added");

        userAccount = helper.loginUser(userAccount.getName(), userAccount.getPin());

        askUserForOperations();

    }

    private void withDraw() {
        int amount = cm.getIntData("Enter How much you wanted to withDraw");

        if (userAccount.getMoney() < amount) {
            cm.print("you can withdraw upto " + userAccount.getMoney());
            withDraw();
        } else {
            helper.updateUserMoney(userAccount.getName(), amount, OperationType.Sub);

            cm.print("Amount Successfully WithDraw");

            userAccount = helper.loginUser(userAccount.getName(), userAccount.getPin());
        }

        askUserForOperations();
    }

    private void createUser() {
        String name = cm.getData("Enter Your Name");
        int pin = cm.getIntData("Enter Your Pin");

        helper.addAccount(new Account(name, pin));

        userAccount = new Account(name, pin);

        checkUser();

    }

    private void loginUser() {
        String name = cm.getData("Enter Your Name");

        int pin = cm.getIntData("Enter Your Pin");

        Account user = helper.loginUser(name, pin);

        if (user == null) {
            cm.print("user with Name " + name + "and Pin " + pin + " Does not found");
            checkUser();
        } else {
            userAccount = user;
        }

        checkUser();

    }

    public void intiData() {
        cm = new CM();
        helper = new OperationsHelper();

     

    }

}
