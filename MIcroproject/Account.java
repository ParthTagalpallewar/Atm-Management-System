package MIcroproject;

import java.io.Serializable;

public class Account  implements Serializable {
    private String name;
    private int money;
    private int pin;

    private int initialAmount = 1000 ; 

    //constructor
    public Account(String name,int pin){
        this.name = name;
        this.money = initialAmount;
        this.pin = pin;
    }

    

    public int getPin(){
        return this.pin;
    }
    
    public String getName(){
        return name;
    }

    public int getMoney(){
        return money;
    }

    public void addMoney(int amount){
        int userAmount = getMoney();
        int newAmount = userAmount + amount;

        this.money = newAmount;
    }

    public void subMoney(int amount){
        int userAmount = getMoney();
        int newAmount = userAmount - amount;

        this.money = newAmount;
    }



}
