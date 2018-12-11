package socket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

class ThreadedEchoHandler implements Runnable {
    private Socket incoming;
    private Socket incoming2;


    public ThreadedEchoHandler(Socket incomingSocket, Socket incomingSocket2) {
        incoming = incomingSocket;
        incoming2 = incomingSocket2;
    }

    public void run() {
        try (
                InputStream inStream = incoming.getInputStream();
                OutputStream outStream = incoming.getOutputStream();
                OutputStream outStream2 = incoming2.getOutputStream();
        ) {

            Scanner in = new Scanner(inStream, "UTF-8");
            PrintWriter out = new PrintWriter(
                    new OutputStreamWriter(outStream, "UTF-8"), true);
            PrintWriter out2 = new PrintWriter(
                    new OutputStreamWriter(outStream2, "UTF-8"), true);
            out.println("Witaj! Wpisz BYE by Zakończyć.");
            boolean done = false;

            while (!done && in.hasNextLine()) {
                String line;
                line = in.nextLine();
                out.println(line);
                out2.println(line);

                if (line.trim().equals("BYE")) done = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

