package lection4.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Receiver {

    private BufferedReader in;

    public Receiver(Socket socket) throws IOException {
        in =  new BufferedReader(
                new InputStreamReader(socket.getInputStream())
        );
    }

    public String receive() throws IOException {
        if (in == null) {
            throw new IOException("Error: in = null");
        }
        return in.readLine();
    }

    public void close() throws IOException {
        if (in != null) {
            in.close();
            in = null;
        }

    }
}
