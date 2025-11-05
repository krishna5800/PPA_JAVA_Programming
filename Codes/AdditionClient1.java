import java.util.*;
import java.net.*;
import java.io.*;

class AdditionClient1 
{
    public static void main(String A[]) throws Exception
    {
        System.out.println("Client is running...");


        Socket sobj = new Socket("localhost", 2100);
        System.out.println("Server successfully connected");
    }
}