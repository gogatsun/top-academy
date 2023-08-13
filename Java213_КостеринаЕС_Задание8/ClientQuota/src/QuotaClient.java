import java.net.Socket;
import java.util.Scanner;


public class QuotaClient {
    static final String EXIT = "exit"; // константа
    public static void runClient(String serverIpAddressStr, int serverPort, Scanner scanner) {
        Socket remoteServer = null;
        Sender sender = null;
        Receiver receiver = null;
        try {
            remoteServer = new Socket(serverIpAddressStr, serverPort);
            // 1. создать сокет для подключения к серверу и подключится к серверу
            sender = new Sender(remoteServer);
            receiver = new Receiver(remoteServer);
            while (true) {
                System.out.print("me> Message: ");
                String msg = scanner.nextLine();
                sender.sendMsg(msg);
                if (msg.equals(EXIT)) {
                    System.out.println("\tserver> server closed...");
                    break;
                }
                msg = receiver.receiveMsg();
                System.out.println("\tserver> " + msg + "");

                if (msg.equals("exit")) {
                    System.out.println("\tserver> client closed...");
                    break;
                }
            }
        } catch (Exception ex) {
            System.out.println("me> Error: " + ex.getMessage());
        } finally {
            try {
                if (remoteServer != null && !remoteServer.isClosed()) {
                    remoteServer.close();
                }
                if (receiver != null) {
                    receiver.close();
                }
                if (sender != null) {
                    sender.close();
                }
            } catch (Exception ex) {
                System.out.println("me> Error: " + ex.getMessage());
            }
        }
    }
}

