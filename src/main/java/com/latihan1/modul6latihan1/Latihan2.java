package com.latihan1.modul6latihan1;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.text.SimpleDateFormat;

public class Latihan2 extends Application {
    private TableView table = new TableView();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());

        stage.setTitle("Test Availabe");
        stage.setWidth(450);
        stage.setHeight(550);

        final Label label = new Label("Daftar Mahasiswa");
        label.setFont(new Font("Arial",30));

        table.setEditable(true);

        TableColumn nameCol = new TableColumn("Nama");
        TableColumn nimCol = new TableColumn("NIM");
        TableColumn emailCol = new TableColumn("Email");

        table.getColumns().addAll(nameCol,nimCol,emailCol);

        final VBox vBox = new VBox();
        vBox.setSpacing(8);
        vBox.setPadding(new Insets(20,10,10,10));
        vBox.getChildren().addAll(label,table);

        ((Group) scene.getRoot()).getChildren().addAll(vBox);

        stage.setScene(scene);
        stage.show();

        nameCol.setCellValueFactory(
                new PropertyValueFactory<>("name")
        );
        nimCol.setCellValueFactory(
                new PropertyValueFactory<>("nim")
        );
        emailCol.setCellValueFactory(
                new PropertyValueFactory<>("email")
        );


        final ObservableList<Mahasiswa> data = FXCollections.observableArrayList(
                new Mahasiswa("Larynt", "202210370311189", "laryntsa@gmail.com"),
                new Mahasiswa("Ahya", "202210370311187", "ayaa@gmail.com")
        );

        table.setItems(data);

        final TextField Addname = new TextField();
        Addname.setMaxWidth(nameCol.getPrefWidth());
        Addname.setPromptText("Nama Mahasiswa");

        final TextField Addnim = new TextField();
        Addnim.setMaxWidth(nameCol.getPrefWidth());
        Addnim.setPromptText("Nim Mahasiswa");

        final TextField Addemail = new TextField();
        Addemail.setMaxWidth(nameCol.getPrefWidth());
        Addemail.setPromptText("Email Mahasiswa");

        final Button addbutton = new Button("add");
        addbutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                data.add(new Mahasiswa(
                        Addname.getText(),
                        Addnim.getText(),
                        Addemail.getText()
                ));
            }
        });
        final HBox hboxInput = new HBox();
        hboxInput.getChildren().addAll(Addname,Addnim,Addemail,addbutton);
        hboxInput.setSpacing(10);

        vBox.getChildren().addAll(hboxInput);
    }
    public static class Mahasiswa {

        private final SimpleStringProperty name;
        private final SimpleStringProperty nim;

        private final SimpleStringProperty email;

        private Mahasiswa(String name, String nim, String email) {
            this.name = new SimpleStringProperty(name);
            this.nim = new SimpleStringProperty(nim);
            this.email = new SimpleStringProperty(email);
        }

        public String getName() {
            return name.get();
        }

        public void setName(String fname) {
            this.name.set(fname);
        }

        public String getNim() {
            return nim.get();
        }


        public void setNim(String fnim) {
            this.nim.set(fnim);
        }

        public String getEmail() {
            return email.get();
        }

        public void setEmail(String femail) {
            this.email.set(femail);
        }

    }
}