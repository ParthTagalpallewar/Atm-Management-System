package MIcroproject;

import java.util.Scanner;

public class CM {
    
    public void print(String msg){
        System.out.println(msg);
    }
    public void print(int msg){
        System.out.println(msg);
    }

    public String getData(String data){

        if(data != null){
            print(data);
        }

        return new Scanner(System.in).nextLine();
    }

    public int getIntData(String data){
        if(data != null){
            print(data);
        }
        return new Scanner(System.in).nextInt();
    }


}
