package org.top.server;


import org.top.communication.Receiver;
import org.top.communication.Sender;
import org.top.quotagen.IGenerator;
import org.top.quotagen.Parsed;

import java.io.IOException;
import java.net.Socket;

import static org.top.quotagen.Parsed.parseQuota;

// класс-обработчик одного клиента
// запускается в отдельном потоке и работает с клиентом
public class ClientProcessor {

    // поля
    // TODO: добавить механизмы синхронизации при работе с isFree
    private boolean isFree;     // поле, которое указывает, свободен ли обработчик в данный момент
    public boolean isFree() {
        return isFree;
    }

    // сокета клиента, с которым работаем обработчик
    private Socket remoteClient;
    // генератор цитат
    private final IGenerator generator;

    // конструктор
    public ClientProcessor(IGenerator generator) {
        isFree = true;
        remoteClient = null;
        this.generator = generator;
    }

    // подготовка работы с клиентом
    public void prepareClient(Socket socket) throws Exception {
        if (!isFree) {
            throw new Exception("Not free clientProcessor!");
        }
        remoteClient = socket;
        isFree = false;
    }

    // работа с клиентом
    public void processClient() throws IOException {
        // объект для отправки сообщений
        // объект для получения сообщений

        try (Sender sender = new Sender(remoteClient); Receiver receiver = new Receiver(remoteClient)) {
            // объекты для отправки и получения данных

            // цикл работы с клиентом
            while (true) {
                // TODO: добавить логи работы с клиентом
                // 1. читаем сообщение
                String msg = receiver.receiveMsg();

                // 2. анализируем сообщение
                if (msg.equals("quota")) {
                    // то отправить цитату

                    sender.sendMsg(parseQuota(generator.getRandomQuota()));
                } else if (msg.equals("exit")) {
                    sender.sendMsg("bye");
                    break;
                } else {
                    sender.sendMsg("invalid command");
                }
            }
        } catch (Exception ex) {
            System.out.println("Something wrong during processing client: " + ex.getMessage());
        } finally {
            // по окончанию цикла
            if (remoteClient != null && !remoteClient.isClosed()) {
                remoteClient.close();
            }

            // освободить исполнителя
            remoteClient = null;
            isFree = true;
        }
    }
}
