package com.mycompany.assignment1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server
{

    public static void main(String[] args)
    {
        try
        {
            ServerSocket server = new ServerSocket(2020);
            System.out.println("The server is Running now");
            while (true)
            {

                Socket s = server.accept();
                System.out.println("Client Connected ");

                DataInputStream inputStream = new DataInputStream(s.getInputStream());
                DataOutputStream outputStream = new DataOutputStream(s.getOutputStream());
                while (true)
                {

                    outputStream.writeUTF("Enter your location :");
                    outputStream.flush();
                    String location = inputStream.readUTF();
                    outputStream.writeUTF("Enter your destination :");
                    outputStream.flush();
                    String destination = inputStream.readUTF();
                    try
                    {
                        Socket SensorServer = new Socket("127.0.0.1", 6666);

                        DataInputStream sensorInputStream = new DataInputStream(SensorServer.getInputStream());
                        DataOutputStream sensorOutputStream = new DataOutputStream(SensorServer.getOutputStream());
                        sensorOutputStream.writeUTF("Find the best path from: "+location+ " to "+destination );
                        sensorOutputStream.flush();
                        sensorOutputStream.writeUTF(location);
                        sensorOutputStream.flush();
                        sensorOutputStream.writeUTF(destination);
                        sensorOutputStream.flush();
                        
                        outputStream.writeUTF("The best path from " + location+" to "+destination+ " is taking street number :");
                        outputStream.flush();
                        String sensorMsg = sensorInputStream.readUTF();
                        outputStream.writeUTF(sensorMsg);
                        outputStream.flush();

                        
                        sensorInputStream.close();
                        sensorOutputStream.close();
                        SensorServer.close();
                        
                    } 
                    catch (IOException ex)
                    {
                        System.out.println(ex.getMessage());
                    }
                    outputStream.writeUTF("Do you want to choose another location and distenation? (y/n)");
                    outputStream.flush();
                    String usr_choice = inputStream.readUTF();

                    if (usr_choice.equals("n"))
                    {
                        outputStream.writeUTF("stop");
                        outputStream.flush();
                        break;
                    }
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
