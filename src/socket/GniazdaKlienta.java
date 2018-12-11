package socket;

import java.io.*;
import java.net.*;
import java.util.*;

public class GniazdaKlienta {
    public static void main(String[] args) throws IOException {
        try (Socket s = new Socket("localhost", 8189);
             Scanner in = new Scanner(s.getInputStream(), "UTF-8"); Scanner scanner = new Scanner(System.in))
        {
            PrintWriter writer = new PrintWriter(s.getOutputStream());
            writer.write("sprawdzam");
            writer.flush();

            while (in.hasNextLine()) {
                String line = in.nextLine();
                System.out.println(line);
                System.out.println("ASD");
            }
            System.out.println("Skończyłem");
        }

    }
}
