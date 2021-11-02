package com.mycompany.assignment1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import java.util.Random;

public class Sensors {
    public static void main(String[] args)
    {
        try
        {
            ServerSocket server = new ServerSocket(6666);
            System.out.println("Sensors are working");
            while (true)
            {
                Socket s = server.accept();
                System.out.println("Server Accepted");

                DataInputStream inputStream = new DataInputStream(s.getInputStream());
                DataOutputStream outputStream = new DataOutputStream(s.getOutputStream());
                String serverMsg = inputStream.readUTF();
                System.out.println(serverMsg);
                
                
                while (true)
                { 
                    
                    Random r = new Random();
                    String street =  Integer.toString(r.nextInt(100));
                    
                    
                    outputStream.writeUTF(street);
                    outputStream.flush();
                    System.out.println("Found the best path");
                    System.out.println("Sensors connection ended");
                    break;
                    
                }

                inputStream.close();
                outputStream.close();
                s.close();
            }



        } catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

}
