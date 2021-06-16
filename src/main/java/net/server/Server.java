package net.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

    public static final int SERVER_PORT = 54321;

    public static void main(String[] args) {
        System.out.println("server started");
        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            while (true) {

                try (Socket socket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                ) {
                    System.out.println("New connection accepted");
                    out.println("Write your name:");
                    final String name = in.readLine();

                    out.println("Are you child? (yes/no)");
                    if (in.readLine().equals("yes")) {
                        out.println(String.format("Welcome to the kids area, %s Let's play! (Press \"Enter\" to continue)"
                                , name));
                        in.readLine();
                        out.println("What game do you want to play?");
                        final String game = in.readLine();
                        out.println(String.format("%s is a great game! (Press \"Enter\" to finish)", game));
                    } else {
                        out.println(String.format("Welcome to the adult zone, %s Have a good rest, or a good working day!" +
                                "(Press \"Enter\" to continue)", name));
                        in.readLine();
                        out.println("How do you prefer to spend your free time?");
                        final String freeTime = in.readLine();
                        out.println(String.format("I also like to %s (Press \"Enter\" to finish)", freeTime));
                    }
                    in.readLine();
                    out.println("end");
                    System.out.println("session ends");

                } catch (Exception e) {
                    e.printStackTrace();
                }
                ;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ;

    }
}
