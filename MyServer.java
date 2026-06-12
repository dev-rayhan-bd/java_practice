// import java.io.DataInputStream;
// import java.net.ServerSocket;
// import java.net.Socket;

// public class MyServer {
//     public static void main(String[] args) {
//         try {
//             // port open
//             ServerSocket ss = new ServerSocket(5003);
//             System.out.println("server is waiting on port 5003");
//             // client req accept
//             Socket s = ss.accept();
//             System.out.println("client connected!");

//             DataInputStream dis = new DataInputStream(s.getInputStream());
//             String str = (String) dis.readUTF();

//             System.out.println("message from cleint " + str);
//             ss.close();

//         } catch (Exception e) {
//             System.out.println(e);
//         }
//     }
// }
import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(5003);
            System.out.println("Server is waiting for data...");

            Socket s = ss.accept();
            DataInputStream dis = new DataInputStream(s.getInputStream());

  
            String receivedData = dis.readUTF();

  
            String[] dataArray = receivedData.split(",");

       
            System.out.println("\n--- Received Student Data ---");
            System.out.println("ID: " + dataArray[0]);
            System.out.println("Name: " + dataArray[1]);
            System.out.println("GPA: " + dataArray[2]);

            ss.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}