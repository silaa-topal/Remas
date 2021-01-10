package com.example.remasbackend.Management;

import com.example.remasbackend.model.Reservation;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ABRA
 */
public class ReservationManagement implements Serializable{

    public static void main(String[] args) throws FileNotFoundException, IOException  {
        
        Scanner sc = new Scanner(System.in);

        int rezid = 0;

        
        System.out.println("Select the menu: Add Reservation(1) Change Reservation(2) Delete Reservation(3)");
        int selc = sc.nextInt();
        
        if (selc == 1) { //ADD RESERVATION          
            
            
            
            System.out.println("Enter the customer name: ");
            String trash1 = sc.nextLine();
            String name = sc.nextLine();
            
            Date tmpdate = null;
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            System.out.println("Enter the date like(dd/MM/yyyy):");
            String date = sc.nextLine();
            
            if (null != date && date.trim().length() > 0) {
                try {
                    tmpdate = format.parse(date);
                } catch (ParseException ex) {
                    Logger.getLogger(ReservationManagement.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            System.out.println("Enter the hour: ");
            int hour = sc.nextInt();
            System.out.println("Enter the table no: ");
            int table = sc.nextInt();
            rezid++;
            
            for(int i=0; i<=1 ; i++){
                
                Date cntdate = null;
                int cnttable = 0;
                int cnthour = 0;
                try {
                    final FileInputStream file = new FileInputStream("reservation.out");
                    final ObjectInputStream read = new ObjectInputStream(file);
                    final Reservation rez = (Reservation) read.readObject();
                    
                    cntdate = rez.getresDate();
                    cnttable = rez.gettableNo();
                    cnthour = rez.getHour();
                    
                    read.close();
                } catch (final Exception e) {
                    System.out.println(e.getMessage());
                }
                
            if(cnttable==table && cnthour==hour && cntdate.equals(date) ){
                System.out.println("This date,hour and table is full!!!");
            }
                else {
                    Reservation rez = new Reservation(name, rezid, table, tmpdate, hour);
                    System.out.println("RezID:" + rez.getresID() + " Name:" + rez.getname() + " TableNo:" + rez.gettableNo() + " Date:" + format.format(rez.getresDate()) + " " + rez.getHour());

                    File file = new  File("reservation.out");
                    FileOutputStream fOut=new FileOutputStream(file,true);
                    ObjectOutputStream out = new ObjectOutputStream(fOut);
                    out.writeObject(rez); 
                }
            }

            
            
            


        }
        else if(selc==2) //CHANGE RESERVATION
        {
            System.out.println("Enter the date you want to change: ");
            Date tmpdate = null;
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            System.out.println("Enter the date like(dd/MM/yyyy):");
            String trash = sc.nextLine();
            String date = sc.nextLine();

            if (null != date && date.trim().length() > 0) {
                try {
                    tmpdate = format.parse(date);
                } catch (ParseException ex) {
                    Logger.getLogger(ReservationManagement.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
                            try {
            final FileInputStream file = new FileInputStream("reservation.out");
            final ObjectInputStream read = new ObjectInputStream(file);
            final Reservation rez = (Reservation) read.readObject();
            System.out.println("RezID:" + rez.getresID() + " Name:" + rez.getname() + " TableNo:" + rez.gettableNo() + " Date:" + format.format(rez.getresDate()) + " " + rez.getHour());
            read.close();
        }
        catch (final Exception e) {
            System.out.println(e.getMessage());
        } 
            
        }
        else if(selc==3) //DELETE RESERVATION
        {
        

            Date tmpdate = null;
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            System.out.println("Enter the date you want to delete (dd/MM/yyyy):");
            String trash = sc.nextLine();
            String date = sc.nextLine();

            if (null != date && date.trim().length() > 0) {
                try {
                    tmpdate = format.parse(date);
                } catch (ParseException ex) {
                    Logger.getLogger(ReservationManagement.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            System.out.println("Enter the hour: ");
            int hour = sc.nextInt();
            
            System.out.println("Enter the table no: ");
            int table = sc.nextInt();
            
            for (int i = 0; i <= 1; i++) {

                Date cntdate = null;
                int cnttable = 0;
                int cnthour = 0;
                try {
                    final FileInputStream file = new FileInputStream("reservation.out");
                    final ObjectInputStream read = new ObjectInputStream(file);
                    final Reservation rez = (Reservation) read.readObject();

                    cntdate = rez.getresDate();
                    cnttable = rez.gettableNo();
                    cnthour = rez.getHour();

                    read.close();
                } catch (final Exception e) {
                    System.out.println(e.getMessage());
                }
                
                if (cnttable == table || cnthour == hour || cntdate.equals(date)) {
                    File f = new File("reservation.out");
                    
                    if(!f.exists()){
                        System.out.println("File was not found.");
                    }
                    else{
                        System.out.println(f.getName()+" the file named has been deleted.");
                        f.delete();
                    }

                    
                    
                }
                else{
                    System.out.println("No reservation found!");
                }
                
            }
            
            
            
        }
        else{
            System.out.println("Invalid Number!");
        }
        
        

    }
}
