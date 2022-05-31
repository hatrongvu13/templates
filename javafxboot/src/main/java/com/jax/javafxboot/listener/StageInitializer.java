package com.jax.javafxboot.listener;

import com.jax.javafxboot.GuiApplication;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class StageInitializer implements ApplicationListener<GuiApplication.StageReadyEvent> {

    @Value("views.application")
    private String fxmlUrl;

    @Override
    public void onApplicationEvent(GuiApplication.StageReadyEvent event) {
        Stage stage = event.getStage();
        stage.setScene(this.getScene(fxmlUrl));
        stage.show();
    }

    private Scene getScene(String url) {
        try {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource(url));
            Parent root = loader.load();
            return new Scene(root);
        } catch (IOException e) {
            e.printStackTrace();
            Platform.exit();
        }
        return null;
    }

}
