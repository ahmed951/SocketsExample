package com.mycompany.assignment1;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Computer {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        try
        {
            Socket s = new Socket("127.0.0.1", 2020);
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            
            while (true)
            {
                String computerMsg="";
                String serverMsg = dis.readUTF();  
                System.out.println(serverMsg);
                if(serverMsg.equals("stop"))
                {
                    System.out.println("Session ended");
                    break;
                }else if(serverMsg.contains("Do you want to choose another location and distenation? (y/n)")||serverMsg.equals("Enter your location :")||serverMsg.equals("Enter your destination :"))
                {
                    computerMsg = scanner.next();
                    dos.writeUTF(computerMsg);
                    dos.flush();
                }                          
            }

            dis.close();
            dos.close();
            s.close();
            scanner.close();
            
        } 
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }   

}
