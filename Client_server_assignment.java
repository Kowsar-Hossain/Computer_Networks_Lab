import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class client{
    public static void main(String s1[]){
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.print("Input Server IP: ");
            String IP = scanner.nextLine();
            Socket socket = new Socket(IP,7000);

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            while(true){
                System.out.print("You: ");
                String message = scanner.nextLine();
                dos.writeUTF(message);
                String serverResponse = dis.readUTF();
                System.out.println("Server: " + serverResponse);
                if(serverResponse.equals("Bye")){
                    break;
                }
            }
            scanner.close();
            dis.close();
            dos.close();
            socket.close();
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}



import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Server{
    public static void main(String fucks[]){
        try{
            // Creating server-socket on localhost port 7000
            ServerSocket serverSocket = new ServerSocket(7000);
            System.out.println("Server is running on the port 7000 ...");
            
            Socket socket = serverSocket.accept();
            DataInputStream doi = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);
            while(true){
                String message = doi.readUTF();
                System.out.println("Client: " + message);
                
                if (message.equals("Exit")) {
                    dos.writeUTF("Bye");
                    break; // Exit the inner loop after "Exit" command
                }
                System.out.print("Server: ");
                message = scanner.nextLine();
                dos.writeUTF(message);
            }
            scanner.close();
            doi.close();
            dos.close();
            socket.close();
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }    
    }
}
