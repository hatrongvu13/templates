package com.jax.javafxboot;

import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavafxbootApplication {

    public static void main(String[] args) {
        Application.launch(GuiApplication.class, args);
    }

}
