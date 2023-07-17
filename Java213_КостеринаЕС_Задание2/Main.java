package lection1;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        String serverIpAddress = "127.0.0.1";
        int port = 1024;

        //создать потоки
        Thread serverThread = new Thread(() -> runServer(serverIpAddress, port));
        Thread clientThread = new Thread(() -> runClient(serverIpAddress, port));

        //запустить потоки
        serverThread.start();
        clientThread.start();

        System.out.println("\n" +
                "Во дворике у подъезда на лавочке сидят бабульки. Тут к подъезду" +
                " подруливает крутой джип, выходит из него новый русский, видит бабулек и начинает наезжать:");
        try {
            //ожидание завершения потоков
            serverThread.join();
            clientThread.join();
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        System.out.println("Thread main: работа завершена");
    }

    public static void runServer(String ipAddressSrt, int port) {
        // 8080
        // 1. Создать сокет сервера
        ServerSocket server = null;
        Socket client = null;
        PrintWriter out = null;
        BufferedReader in = null;
        try {
    // 1. создать сокет сервера
            InetAddress ipAddress = InetAddress.getByName(ipAddressSrt); // преобразование строки адреса в объект
            server = new ServerSocket(port, 1, ipAddress);
            System.out.println("s: server complete!");
    // 2. ожидаем входящее подключение
            System.out.println("s: accept connection...");
            client = server.accept(); // ожидание подключения клиента
            System.out.println("s: client connection - " + client.getInetAddress() + ":" + client.getPort());
            out = new PrintWriter(
                    new BufferedWriter(
                            new OutputStreamWriter(client.getOutputStream())
                    ), true
            );
            String msg = "Hello from server, connection time: " + LocalDateTime.now();
            out.println(msg); // отправка сообщения клиенту
            in =  new BufferedReader(
                    new InputStreamReader(client.getInputStream())
            );

            msg = in.readLine();
            System.out.println("\t client> '" + msg + "'");
            msg = "Что ж ты, сынок, на нас ругаисси? Совсем старость не уважаешь. Я вот внучку своему " +
                    "на тебя пожалуюсь, он мене в обиду не дасть.";
            out.println(msg);

            msg = in.readLine();
            System.out.println("\t client> '" + msg + "'");
            msg = "Ладноть, передам.";
            out.println(msg);

            msg = in.readLine();
            System.out.println("\t client> '" + msg + "'");
            msg = "Да где-то здеся. А где – хто ж его знаеть, он же у меня снайпер.";
            out.println(msg);

        } catch (Exception ex) {
            System.out.println("server> Error: " + ex.getMessage());
        } finally {
            try {
                if (server != null && !server.isClosed()) {
                    server.close();
                }
                if (client != null && !client.isClosed()) {
                    client.close();
                }
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (Exception ex) {
                System.out.println("server> Error finally> " + ex.getMessage());
            }
        }
    }

    //метод запуска клиента
    // метод запуска клиента (содержит весь алгоритм работы клиента)
    public static void runClient(String serverIpAddressStr, int serverPort) {
        Socket remoteServer = null;
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            remoteServer = new Socket(serverIpAddressStr, serverPort);
            // 1. создать сокет для подключения к серверу и подключится к серверу
            System.out.println("client: client complete, isConnected:"
                    + remoteServer.isConnected());
            in =  new BufferedReader(
                    new InputStreamReader(remoteServer.getInputStream())
            );

            out = new PrintWriter(
                    new BufferedWriter(
                            new OutputStreamWriter(remoteServer.getOutputStream())
                    ), true
            );


            String msg = "Чего расселись, старые кошелки, у моего подъезда, в натуре?";
            out.println(msg);
            msg = in.readLine();
            System.out.println("server> '" + msg + "'");

            msg = "Что?! Какому-такому внучку? Что, конкретный пацан? " +
                    "Так пусть завтра на разборку подваливает, побазарим. Короче, бабка, передай внучку, " +
                    "завтра в пять на этом месте стрелка.";
            out.println(msg);
            msg = in.readLine();
            System.out.println("\t server> '" + msg + "'");

            msg = "Ну что, бабка, где твой внучок-то?";
            out.println(msg);
            msg = in.readLine();
            System.out.println("\t server> '" + msg + "'");

            msg = in.readLine();
            System.out.println("\t server> '" + msg + "'");

        } catch (Exception ex) {
            System.out.println("c> Error: " + ex.getMessage());
        } finally {
            try {
                if (remoteServer != null && !remoteServer.isClosed()) {
                    remoteServer.close();
                }
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (Exception ex) {
                System.out.println("c> Error: " + ex.getMessage());
            }
        }
    }
}