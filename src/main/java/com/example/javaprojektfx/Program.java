package com.example.javaprojektfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class Program extends Application {
    @Override
    public void start(Stage stage) throws IOException, SQLException {

        /* Table.create(User.class);
        Table.create(Bench.class);
        Table.create(Appointment.class);
        Table.create(Category.class);
        Table.create(Dish.class);
        Table.create(Reservation.class);/*/

        FXMLLoader fxmlLoader = new FXMLLoader(Program.class.getResource("intro-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 940, 530);
        stage.setTitle("Dobrodošli na sustav!");
        stage.setScene(scene);
        stage.show();
    }

    public static void swapScene (Stage stage, String viewName, String title){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Program.class.getResource(viewName));
            Scene scene = new Scene(fxmlLoader.load(), 940, 530);
            stage.setTitle(title);
            stage.setScene(scene);
        } catch (IOException e) {
            // e.printStackTrace();
            System.out.println("Nastala je pogreška: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch();
    }
}