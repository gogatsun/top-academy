package lection4.chat;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    static final String EXIT = "exit";

    public static void runServer(String ipAddressSrt, int port, Scanner scanner) {
        // 1. Создать сокет сервера
        ServerSocket server = null;
        Socket remoteClient = null;
        Sender sender = null;
        Receiver receiver = null;
        try {
            // 1. создать сокет сервера
            InetAddress ipAddress = InetAddress.getByName(ipAddressSrt); // преобразование строки адреса в объект
            server = new ServerSocket(port, 1, ipAddress);
            System.out.println("s> server complete!");
            // 2. ожидаем входящее подключение
            System.out.println("s> wait...");
            remoteClient = server.accept(); // ожидание подключения клиента

            String me = remoteClient.getInetAddress() + ":" + remoteClient.getPort() + "(me)";
            System.out.println("s> client - " + me);
            
            sender = new Sender(remoteClient);
            receiver = new Receiver(remoteClient);
            
            while (true) {
                String msg = receiver.receive();
                System.out.println("\t" + me + "> '" + msg + "'");
                // TODO: сделать "exit" именованной константой
                if (msg.equals(EXIT)) {
                    System.out.println("s> client exit...");
                    break;
                }
                System.out.print("s> Введите сообщение: ");
                msg = scanner.nextLine();
                sender.send(msg);
                if (msg.equals("exit")) {
                    System.out.println("s> server closed...");
                    break;
                }
            }
            
        } catch (Exception e) {
            System.out.println();
        } finally {
            try {
                if (server != null && !server.isClosed()) {
                    server.close();
                }
                if (remoteClient != null && !remoteClient.isClosed()) {
                    remoteClient.close();
                }
                if (sender != null) {
                    sender.close();
                }
                if (receiver != null) {
                    receiver.close();
                }
            } catch (Exception ex) {
                System.out.println("s> Error - " + ex.getMessage());
            }
        }
    }
}
