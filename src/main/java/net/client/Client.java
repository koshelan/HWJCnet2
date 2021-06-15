package net.client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static final int SERVER_PORT = 54321;
    public static final String host = "netology.homework";

    public static void main(String[] args) {
        try (
                Socket socket = new Socket(host, SERVER_PORT);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ) {
            Scanner scanner = new Scanner(System.in);
            String message = "";

            while (!(message = in.readLine()).equals("end")) {
                System.out.println(message);
                out.println(scanner.nextLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ;
        System.out.println("Game over");

    }

}
