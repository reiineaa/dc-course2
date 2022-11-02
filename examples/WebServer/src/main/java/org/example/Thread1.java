package org.example;
import java.io.BufferedReader;
import java.net.Socket;

public class Thread1 {
    protected Socket socket;
    protected BufferedReader bufferedReader;

    public Thread1(Socket socket, BufferedReader bufferedReader) {
        this.socket = socket;
        this.bufferedReader = bufferedReader;
    }
}
