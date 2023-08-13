package org.top.communication;


import java.io.*;
import java.net.Socket;

// класс для считывания данных через сокет
public class Receiver implements Closeable {

    private BufferedReader in; // поток для чтения данных

    // конструктор
    public Receiver(Socket socket) throws IOException {
        in = new BufferedReader(
                new InputStreamReader(
                        socket.getInputStream()
                )
        );
    }

    // закрытие
    @Override
    public void close() throws IOException {
        if (in != null) {
            in.close();
            in = null;
        }
    }

    // получение сообщения
    public String receiveMsg() throws IOException {
        //добавить выброс исключения при in == null (IOException)
        String msg;
        if (in != null) {
            msg = in.readLine();
        } else {
            throw new IOException("Error: in == null!");
        }
        return msg;
    }
}
