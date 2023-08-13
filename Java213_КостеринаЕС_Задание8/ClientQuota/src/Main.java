import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QuotaClient.runClient("127.0.0.1", 1024, scanner);
    }
}