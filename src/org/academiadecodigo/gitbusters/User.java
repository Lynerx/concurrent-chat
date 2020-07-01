package org.academiadecodigo.gitbusters;

import java.io.*;
import java.net.Socket;

public class User implements Runnable {

    private static final String USERNAME = "User";
    private static final String SERVER_NAME = "localhost";
    private Socket userSocket;

    private BufferedReader readMessageFromConsole;
    private BufferedWriter sendMessageToServer;


    public static void main(String[] args) {

//        new User(SERVER_NAME, 8080);
    }


//    public User(String server, int portNumber) {
//
//        try {
//
//            userSocket = new Socket(server, portNumber);
//            System.out.println(server + " has connected to " + portNumber);
//
//            Thread thread = new Thread();
//            thread.start();
//
//            sendMessage();
//        } catch (IOException e) {
//            e.getStackTrace();
//        }
//    }
//
//    private void sendMessage() {
//
//        try {
//
//            sendMessageToServer = new BufferedWriter(new OutputStreamWriter(userSocket.getOutputStream()));
//            readMessageFromConsole = new BufferedReader(new InputStreamReader(System.in));
//
//            while (!userSocket.isClosed()) {
//
//                String message = readMessageFromConsole.readLine();
//
//                if (message != null) {
//
//                    sendMessageToServer.write(message);
//                    sendMessageToServer.newLine();
//                    sendMessageToServer.flush();
//                } else {
//
//                    sendMessageToServer.close();
//                    readMessageFromConsole.close();
//                    userSocket.close();
//                }
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//

    @Override
    public void run() {

        try {

            BufferedReader readMessageFromServerToConsole = new BufferedReader(new InputStreamReader(userSocket.getInputStream()));

            while (!userSocket.isClosed()) {

                String message = readMessageFromServerToConsole.readLine();

                if (message != null) {

                    System.out.println(message);

                } else {

                    System.out.println("Exiting chat...");
                    readMessageFromServerToConsole.close();
                    userSocket.close();
                }
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
