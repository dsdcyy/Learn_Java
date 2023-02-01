package com.ljw.start;

import com.ljw.Client.LoginView;

import java.io.IOException;

/**
 * @author ljw
 * @version 1.0
 */
public class ClientFrame {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        new LoginView().mainMenu();
    }
}
