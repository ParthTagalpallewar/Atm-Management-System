package MIcroproject;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class OperationsHelper {

    private String fileName = "AccountsDataBase";

    public void addAccounts(ArrayList<Account> accounts) {

        try {
            // creates a new file with object ObjectOutputStream
            FileOutputStream out = new FileOutputStream(fileName);
            ObjectOutputStream oout = new ObjectOutputStream(out);

            // writes the array into the file
            oout.writeObject(accounts);

            // closes the stream
            oout.flush();
            oout.close();

        } catch (Exception e) {
           
        }

    }

    public void addAccount(Account account) {
        try {

            ArrayList<Account> accounts = getAccounts();
            if(accounts == null){
                accounts = new ArrayList<Account>();
            }

            accounts.add(account);

            // creates a new file with object ObjectOutputStream
            FileOutputStream out = new FileOutputStream(fileName);
            ObjectOutputStream oout = new ObjectOutputStream(out);

            // writes the array into the file
            oout.writeObject(accounts);

            // closes the stream
            oout.flush();
            oout.close();

        } catch (Exception e) {
            
        }

    }

    public ArrayList<Account> getAccounts() {
        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);

            ArrayList<Account> accounts = (ArrayList<Account>) ois.readObject();

            ois.close();

            return accounts;

        } catch (Exception e) {
            
            return null;
        }

    }

    public void deleteAccount(Account account) {
        try {

            ArrayList<Account> accounts = getAccounts();

            for (int r = 0; r < accounts.size(); r++) {
                if (account.getName().equals(accounts.get(r).getName())) {
                    accounts.remove(r);
                }
            }

            // creates a new file with object ObjectOutputStream
            FileOutputStream out = new FileOutputStream(fileName);
            ObjectOutputStream oout = new ObjectOutputStream(out);

            // writes the array into the file
            oout.writeObject(accounts);

            // closes the stream
            oout.flush();
            oout.close();

        } catch (Exception e) {
        }
    }

    public void updateUserMoney(String name, int amount, OperationType type) {
        try {

            ArrayList<Account> accounts = getAccounts();

            for (int r = 0; r < accounts.size(); r++) {
                if (name.equals(accounts.get(r).getName())) {

                    if (type == OperationType.Add) {
                        accounts.get(r).addMoney(amount);
                    } else {
                        accounts.get(r).subMoney(amount);
                    }
                }
            }

            // creates a new file with object ObjectOutputStream
            FileOutputStream out = new FileOutputStream(fileName);
            ObjectOutputStream oout = new ObjectOutputStream(out);

            // writes the array into the file
            oout.writeObject(accounts);

            // closes the stream
            oout.flush();
            oout.close();

        } catch (Exception e) {
           
        }
    }

    public Account loginUser(String name, int pin) {

        ArrayList<Account> accounts = getAccounts();

        for (int r = 0; r < accounts.size(); r++) {
            if (accounts.get(r).getName().equals(name) && accounts.get(r).getPin() == pin) {
                return accounts.get(r);
            }
        }

        return null;

    }

}
