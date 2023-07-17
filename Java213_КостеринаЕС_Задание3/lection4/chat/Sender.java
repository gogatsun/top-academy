package lection4.chat;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Sender {

    private PrintWriter out; // поток записи

    public Sender(Socket socket) throws IOException {
        //создать поток из сокета
        out = new PrintWriter(
                new BufferedWriter(
                        new OutputStreamWriter(socket.getOutputStream(), "cp1251")
                ), true
        );
    }

    public void send(String message) throws IOException {
        if (out == null) {
            throw new IOException("Error: out = null");
        }
        out.println(message);
    }


    public void close() throws IOException {
        if (out != null) {
            out.close();
            out = null;
        }

    }

}
