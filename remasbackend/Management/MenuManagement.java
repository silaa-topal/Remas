package com.example.remasbackend.Management;

import com.example.remasbackend.model.Menu;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author ABRA
 */
public class MenuManagement implements Serializable{
    public static void main(String[] args) throws FileNotFoundException, IOException {
     Scanner sc = new Scanner(System.in);
    //ADD-CHANGE-DELETE
    
    System.out.println("Select the menu: Add Item(1) Change Item(2) Delete Item(3) Display All Item(4)");
    int select = sc.nextInt();
    
    
    
    if(select==1){ //ADD ITEM
        System.out.println("Enter the name: ");
        String trash = sc.nextLine();
        String ename = sc.nextLine();
        System.out.println("Enter the price: ");
        int eprice = sc.nextInt();
        
        Menu menu = new Menu(ename, eprice);
        System.out.println("Name:"+menu.getName()+" Price:"+menu.getPrice());

        File file = new File("menu.out");
        FileOutputStream fOut = new FileOutputStream(file,true);
        ObjectOutputStream out = new ObjectOutputStream(fOut);
        out.writeObject(menu);
        
        
        
        
    }
    else if(select==2){ //CHANGE ITEM
    
        
        
    }
    else if(select==3){ //DELETE ITEM
    
    }
    else if(select==4){ //DISPLAY ALL ITEM
        
        /*Menu menu = new Menu();
        
        try{
        sc = new Scanner(new File("menu.out"));
        }
        catch(FileNotFoundException e){
        e.printStackTrace();
            System.out.println("File is not found!");
        }
        
        while(sc.hasNext()){
        String a = menu.getName();
        int b = menu.getPrice();
        
            System.out.println(a+" "+b);
        }*/
        
        for (int i = 0; i < 10; i++) {
            
            
         try {
             
            final FileInputStream file = new FileInputStream("menu.out");
            final ObjectInputStream read = new ObjectInputStream(file);
            final Menu menu = (Menu) read.readObject();
            System.out.println("Name:"+menu.getName()+" Price:"+menu.getPrice());

            
        }
        catch (final Exception e) {
            System.out.println(e.getMessage());
        }
        }
   
    }
    
    else{
    
    }
    
    
    
    
    }
    
    
}
