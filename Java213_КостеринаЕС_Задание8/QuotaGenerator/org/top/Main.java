package org.top;

import org.top.quotagen.ApiGenerator;
import org.top.quotagen.PlugGenerator;
import org.top.server.Server;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Server server = new Server("127.0.0.1", 1024, 3, new ApiGenerator());
        server.run();
    }
}
