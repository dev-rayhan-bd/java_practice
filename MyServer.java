import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    public static void main(String[] args) {
        try {
            // port open
            ServerSocket ss = new ServerSocket(5003);
            System.out.println("server is waiting on port 5003");
            // client req accept
            Socket s = ss.accept();
            System.out.println("client connected!");

            DataInputStream dis = new DataInputStream(s.getInputStream());
            String str = (String) dis.readUTF();

            System.out.println("message from cleint " + str);
            ss.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
