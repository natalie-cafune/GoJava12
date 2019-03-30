package NineMarch;
import java.io.*;
import java.net.Socket;

public class EchoClient {
    private final String PATH = "";
    private Socket soc;
    private OutputStream out;

    public EchoClient(String ip, int port) {
        try {
            soc = new Socket(ip,port);
            out = soc.getOutputStream();
            //File file = new File(PATH);
            //sendFileSize(file,out);
            //sendFile(file,out);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendFileSize(File file, OutputStream stream) {
        Long size = file.length();
        DataOutputStream out  = new DataOutputStream(stream);
        try {
            out.writeLong(size);
            stream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendFile(File file, OutputStream stream) throws IOException {
        FileInputStream in = new FileInputStream(file);
        DataOutputStream out = new DataOutputStream(stream);
        byte[] buffer = new byte[4096];
        while (in.read(buffer) > 0) {
            stream.write(buffer);
            stream.flush();
        }
        in.close();
    }


   /* public static void main(String[] args) {

        EchoClient client = new EchoClient("192.168.90.3", 8081);

        *//*try {
            System.out.println("Cliente started");
            //Socket - стрим между ip

            OutputStream out = soc.getOutputStream();
            new EchoClient();
            sendFileSize();
            line

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*//*
    }*/
}


