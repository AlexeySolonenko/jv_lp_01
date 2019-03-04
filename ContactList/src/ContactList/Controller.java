package ContactList;


import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

public class Controller {

    @FXML
    private TextField addFirstName = new TextField();
    @FXML
    private TextField addLastName = new TextField();
    @FXML
    private TextField addNotes = new TextField();
    @FXML
    private TextField addPhoneNumber = new TextField();

    @FXML
    private BorderPane mainBorderPain;
    @FXML
    private TableColumn firstName;
    @FXML
    private TableColumn lastName;
    @FXML
    private TableColumn notes;
    @FXML
    private TableColumn phoneNumber;
    @FXML
    private TableView<Contact> tableView;


    public void initialize(){
//        firstName.prefWidthProperty().bind(tableView.widthProperty().divide(5));
//        lastName.prefWidthProperty().bind(tableView.widthProperty().divide(5));
//        phoneNumber.prefWidthProperty().bind(tableView.widthProperty().divide(5));
//        notes.prefWidthProperty().bind(tableView.widthProperty().divide(2.5));

        firstName.prefWidthProperty().bind(tableView.widthProperty().divide(5));
        lastName.prefWidthProperty().bind(tableView.widthProperty().divide(5));
        phoneNumber.prefWidthProperty().bind(tableView.widthProperty().divide(5));
        notes.prefWidthProperty().bind(tableView.widthProperty().divide(2.5));

        firstName.setCellValueFactory(new PropertyValueFactory<Contact,String>("firstName"));
        lastName.setCellValueFactory(new PropertyValueFactory<Contact,String>("lastName"));
        phoneNumber.setCellValueFactory(new PropertyValueFactory<Contact,String>("phoneNumber"));
        notes.setCellValueFactory(new PropertyValueFactory<Contact,String>("notes"));
        /* items list binding */

        tableView.setItems(ContactData.getInstance().getContacts());

        addFirstName.setPromptText("First Name");
        //addFirstName.setMaxWidth(firstName.getWidth());
        addLastName.setPromptText("Last Name");
        //addLastName.setMaxWidth(firstName.getWidth());
        addNotes.setPromptText("Notes");
        //addNotes.setMaxWidth(firstName.getWidth());
        addPhoneNumber.setPromptText("Phone Number");
        //addPhoneNumber.setMaxWidth(firstName.getWidth());



    }



    @FXML
    public void addContact(){
        Contact newContact = new Contact(
                addFirstName.getText(),
                addLastName.getText(),
                addNotes.getText(),
                addPhoneNumber.getText()
        );
        //newContact = new Contact("2","2","2","2");
        if(
                addFirstName.getText().isEmpty()
                        || addLastName.getText().isEmpty()
                        || addPhoneNumber.getText().isEmpty()
                        || addNotes.getText().isEmpty()
        ){
            (new Alert(Alert.AlertType.INFORMATION,"Please, please, fill in all the fields"))
                    .showAndWait()
                    .filter(response -> response==ButtonType.OK)
                    .ifPresent(response -> {});
            return;
        }
        tableView.getItems().add(newContact);
        ContactData.getInstance().saveContacts();
        System.out.println("Adding contact");
    }

    @FXML
    public void editContact(){
        Contact editedContact = (Contact)tableView.getSelectionModel().getSelectedItem();
        if(editedContact == null){
            (new Alert(Alert.AlertType.INFORMATION,"Please, select a contact"))
                    .showAndWait()
                    .filter(response -> response==ButtonType.OK)
                    .ifPresent(response -> {});
            return;
        }
        addFirstName.setText(editedContact.getFirstName());
        addLastName.setText(editedContact.getLastName());
        addPhoneNumber.setText(editedContact.getPhoneNumber());
        addNotes.setText(editedContact.getNotes());
    }


    @FXML
    public void saveContact(){
        Contact editedContact = (Contact)tableView.getSelectionModel().getSelectedItem();
        if(editedContact == null){
            (new Alert(Alert.AlertType.INFORMATION,"Please, select a contact"))
                    .showAndWait()
                    .filter(response -> response==ButtonType.OK)
                    .ifPresent(response -> {});
            return;
        }
        if(
                addFirstName.getText().isEmpty()
                || addLastName.getText().isEmpty()
                || addPhoneNumber.getText().isEmpty()
                || addNotes.getText().isEmpty()
        ){
            (new Alert(Alert.AlertType.INFORMATION,"Please, please, fill in all the fields"))
                    .showAndWait()
                    .filter(response -> response==ButtonType.OK)
                    .ifPresent(response -> {});
            return;
        }
//        addFirstName.setText(editedContact.getFirstName());
//        addLastName.setText(editedContact.getLastName());
//        addPhoneNumber.setText(editedContact.getPhoneNumber());
//        addNotes.setText(editedContact.getNotes());

        editedContact.setFirstName(addFirstName.getText());
        editedContact.setLastName(addLastName.getText());
        editedContact.setPhoneNumber(addPhoneNumber.getText());
        editedContact.setNotes(addNotes.getText());
        ContactData.getInstance().saveContacts();
    }

    @FXML
    public void deleteContact(){
        Contact editedContact = (Contact)tableView.getSelectionModel().getSelectedItem();
        if(editedContact == null){
            (new Alert(Alert.AlertType.INFORMATION,"Please, select a contact"))
                    .showAndWait()
                    .filter(response -> response==ButtonType.OK)
                    .ifPresent(response -> {});
            return;
        }
        tableView.getItems().remove(editedContact);
        ContactData.getInstance().saveContacts();
        (new Alert(Alert.AlertType.INFORMATION,"Contact deleted!")).showAndWait();

    }

    @FXML
    public void exitApplication(){
        (new Alert(Alert.AlertType.INFORMATION,"Thank you for using contact Manager!"))
                .showAndWait()
                .filter(response -> response==ButtonType.OK)
                .ifPresent(response -> {});

        Platform.exit();
    }

}
