package NineMarch;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer extends Thread {

    private ServerSocket ss;

    public EchoServer(int port) {
        try {
            ss = new ServerSocket(port); //открытие сервака на порту;

            // ServerSocket ss = new ServerSocket(777);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {

            System.out.println("Waiting for clients...");
            try {
                final Socket soc = ss.accept(); //низкоуровневіе клиенты
                new Thread() {
                    @Override
                    public void run() {
                        try {
                            saveFile(soc);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }.start();

            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Connection completed");
        }
    }

    private void saveFile(Socket soc) throws IOException {
        OutputStream out = soc.getOutputStream();
        InputStream in = soc.getInputStream();

        DataInputStream din = new DataInputStream(in);

        Long size = din.readLong();
        System.out.println("size "+size);

    }


    public static void main(String[] args) {
        new EchoServer(8081).start();
    }
}
