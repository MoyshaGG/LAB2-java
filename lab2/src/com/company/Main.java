package com.company;

import lab2.test.TestByConsol;
import lab2.test.testApp;

public class Main {


    public static void main(String[] args)
    {
        testApp app = new testApp();
        app.startApp();
        TestByConsol testConsole = new TestByConsol();
        testConsole.startAppConsole();

    }

}
