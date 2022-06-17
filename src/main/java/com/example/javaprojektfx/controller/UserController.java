package com.example.javaprojektfx.controller;

import com.example.javaprojektfx.Program;
import com.example.javaprojektfx.model.User;
import com.example.javaprojektfx.model.Table;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class UserController implements Initializable {
    @FXML
    TextField nameTxt;
    @FXML
    TextField surnameTxt;
    @FXML
    TextField uidTxt;
    @FXML
    TextField roleTxt;

    @FXML
    TableColumn tableColumnID;
    @FXML
    TableColumn tableColumnName;
    @FXML
    TableColumn tableColumnLastname;
    @FXML
    TableColumn tableColumnUid;
    @FXML
    TableColumn tableColumnRole;

    @FXML
    TableView tableViewUsers;


    @FXML
    Button deleteBtn;

    User selectedUser;


    @FXML
    protected void selectUser (){
        this.selectedUser = (User) this.tableViewUsers.getSelectionModel().getSelectedItem();
        this.deleteBtn.setDisable(false);
        this.nameTxt.setText(this.selectedUser.getName());
        this.surnameTxt.setText(this.selectedUser.getLastname());
        this.uidTxt.setText(this.selectedUser.getUid());
        this.roleTxt.setText(this.selectedUser.getRole());
    }
    @FXML
    protected void backBtn (ActionEvent evt){
        Stage stage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
        Program.swapScene(stage, "intro-view.fxml", "Administracija korisnika");
    }

    @FXML
    protected void deleteUser() throws Exception {
        if(this.selectedUser != null){
            this.selectedUser.delete();
            this.fillUsers();
        }
    }

    @FXML
    protected void saveUser() throws Exception {
        if(this.selectedUser == null) {
            User newUser = new User();
            newUser.setName(this.nameTxt.getText());
            newUser.setLastname(this.surnameTxt.getText());
            newUser.setUid(this.uidTxt.getText());
            newUser.setRole(this.roleTxt.getText());
            newUser.save();
        } else{
            this.selectedUser.setName(this.nameTxt.getText());
            this.selectedUser.setLastname(this.surnameTxt.getText());
            this.selectedUser.setUid(this.uidTxt.getText());
            this.selectedUser.setRole(this.roleTxt.getText());
            this.selectedUser.update();
            this.selectedUser = null;
        }
        this.deleteBtn.setDisable(true);
        this.fillUsers();
        this.nameTxt.setText("");
        this.surnameTxt.setText("");
        this.uidTxt.setText("");
        this.roleTxt.setText("");
    }


    private void fillUsers(){
        try {
            ObservableList<User> users = (ObservableList<User>) FXCollections.observableArrayList(Table.list(User.class));
            this.tableViewUsers.setItems(users);
        } catch (Exception e) {
            System.out.println("Nastala je pogreška: " + e.getMessage());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.tableColumnID.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        this.tableColumnLastname.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        this.tableColumnUid.setCellValueFactory(new PropertyValueFactory<>("uid"));
        this.tableColumnRole.setCellValueFactory(new PropertyValueFactory<>("role"));
        fillUsers();

    }

}