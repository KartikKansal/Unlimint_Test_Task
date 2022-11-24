package com.example;

import io.cucumber.java.Before;

public class Main extends BaseClass {
    @Before
    public void startDriver(){
        initializeDriver();
    }
}
