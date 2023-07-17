package lection4;

import lection4.chat.Client;
import lection4.chat.Server;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean flag = true;
        while (flag) {
            String ipStr;
            int port;
            System.out.println("\n1. accept");
            System.out.println("2. connect");
            System.out.println("3. exit");
            System.out.print("Choice: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> {
                    System.out.print("IP: ");
                    ipStr = scanner.nextLine();
                    System.out.print("Port: ");
                    port = Integer.parseInt(scanner.nextLine());
                    Server.runServer(ipStr, port, scanner);
                }
                case "2" -> {
                    System.out.print("IP server: ");
                    ipStr = scanner.nextLine();
                    System.out.print("Port server: ");
                    port = Integer.parseInt(scanner.nextLine());
                    Client.runClient(ipStr, port, scanner);
                }
                case "3" -> flag = false;
            }
        }
    }
}
