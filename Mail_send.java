import java.io.*;
import java.time.LocalDateTime;
import java.util.*;
import javax.net.ssl.*;

class net {

    private static DataOutputStream dos;
    public static BufferedReader br;

    public static void main(String argv[]) throws Exception {
        String user = "s2110276152@ru.ac.bd";   //change
        String pass = "yqlqzfwvjjvgvvgv";	//change

        String username =new String(Base64.getEncoder().encode(user.getBytes()));
        String password = new String(Base64.getEncoder().encode(pass.getBytes()));
        SSLSocket s = (SSLSocket) SSLSocketFactory.getDefault().createSocket("smtp.gmail.com", 465);
        dos = new DataOutputStream(s.getOutputStream());
        br = new BufferedReader(new InputStreamReader(s.getInputStream()));

        send("EHLO smtp.gmail.com\r\n");
        System.out.println("SERVER: "+ br.readLine());
        System.out.println("SERVER: "+ br.readLine());
        System.out.println("SERVER: "+ br.readLine());
        System.out.println("SERVER: "+ br.readLine());
        System.out.println("SERVER: "+ br.readLine());
        System.out.println("SERVER: "+ br.readLine());
        System.out.println("SERVER: "+ br.readLine());
        System.out.println("SERVER: "+ br.readLine());
        System.out.println("SERVER: "+ br.readLine());



        send("AUTH LOGIN\r\n");
        System.out.println("SERVER: "+ br.readLine());


        send(username + "\r\n");
        System.out.println("SERVER: "+ br.readLine());



        send(password + "\r\n");
        System.out.println("SERVER: "+ br.readLine());


        send("MAIL FROM:<ms2110276152@ru.ac.bd>\r\n");//change
        System.out.println("SERVER: "+ br.readLine());


        send("RCPT TO:<hkowsar23@gmail.com>\r\n");//change
        System.out.println("SERVER: "+ br.readLine());

        send("DATA\r\n");
        System.out.println("SERVER: "+ br.readLine());


        send("FROM: s2110276152@ru.ac.bd\r\n");//change
        send("TO: hkowsar23@gmail.com\r\n");//change
        send("Subject: Email test" + LocalDateTime.now() + "\r\n");
        send("2110276152\r\n");
        send(".\r\n");
        System.out.println("SERVER: "+ br.readLine());

        send("QUIT\r\n");
        System.out.println("SERVER: "+ br.readLine());
    }

    private static void send(String s) throws Exception {
        dos.writeBytes(s);
        Thread.sleep(1000);
        System.out.println("CLIENT: " + s);
    }
}
