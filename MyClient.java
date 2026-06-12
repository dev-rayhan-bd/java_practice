// import java.io.DataOutputStream;
// import java.net.Socket;

// public class MyClient {
//     public static void main(String[] args) {
//         try {
//             Socket s = new Socket("localhost", 5003);
//             DataOutputStream dout = new DataOutputStream(s.getOutputStream());
//             dout.writeUTF("Hello Server I am from client");
//             dout.flush();
//             dout.close();
//             s.close();
//         } catch (Exception e) {
//             System.out.println(e);
//         }

//     }
// }
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class MyClient {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            Socket s = new Socket("localhost", 5003);
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());

            System.out.print("Enter Student ID: ");
            int id = sc.nextInt();
            sc.nextLine(); 
            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Result (GPA): ");
            double gpa = sc.nextDouble();

          
            String info = id + "," + name + "," + gpa;

           
            dout.writeUTF(info);
            dout.flush();

            System.out.println("Student info sent successfully!");

            dout.close();
            s.close();
            sc.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}