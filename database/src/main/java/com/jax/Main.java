package com.jax;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main extends Application {
    private static final Logger logger = LogManager.getLogger(Main.class);
    @Override
    public void start(Stage stage) throws Exception {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/Application.fxml"));

            loader.load();
            Parent root = loader.getRoot();

            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception exception) {
            logger.error(exception);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
