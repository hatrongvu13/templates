package com.jax.javafxboot.service;

import com.jax.javafxboot.controllers.ApplicationController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MainService {

    private final ApplicationController applicationController;

    private final ApplicationContext applicationContext;

    private final String APPLICATION_VIEWS = "/views/Application.fxml";

//    @Value("classpath:/views/Application.fxml")
//    private Resource resource;

    @Value("${application.title}")
    private String applicationTitle;

    private Stage stage;

    public MainService(ApplicationController applicationController,
                       ApplicationContext applicationContext) {
        this.applicationController = applicationController;
        this.applicationContext = applicationContext;
    }

    public void showViews() {
        stage.setScene(new Scene(fxmlLoad()));
        stage.setTitle(applicationTitle);
        stage.show();
    }

    private Parent fxmlLoad() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(APPLICATION_VIEWS));
        loader.setControllerFactory(aClass -> applicationContext.getBean(aClass));
        try {
            loader.load();
        } catch (IOException e) {
            System.out.println("Error when load "+ APPLICATION_VIEWS);
            e.printStackTrace();
        }
        Parent root = loader.getRoot();

        return root;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
