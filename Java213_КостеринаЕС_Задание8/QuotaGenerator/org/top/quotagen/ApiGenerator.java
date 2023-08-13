package org.top.quotagen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiGenerator implements IGenerator {
    @Override
    public String getRandomQuota() {
        try {
            URL url = new URL("https://zenquotes.io/api/random");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("accept", "application/json");
            InputStream responseStream = connection.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(responseStream));
            return in.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
