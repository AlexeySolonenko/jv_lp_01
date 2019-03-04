package ContactList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    /**
     * TODO a useful way for improvement is to make the cells editable - but to study first the doc on table view\
     * TODO to add confirmations for deletion and to proceed to the next chapter 
     *
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("basewindow.fxml"));
        primaryStage.setTitle("Contacts Manager");
        primaryStage.setScene(new Scene(root, 640, 480));
        primaryStage.show();
        primaryStage.setMaximized(true);
    }


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws Exception {
        //super.init();
        //Contact contact = new Contact("1","1","1","1");
        //ContactData.getInstance().addContact(contact);
        //ContactData.getInstance().saveContacts();
        ContactData.getInstance().loadContacts();
    }

    @Override
    public void stop() throws Exception {
//        try {
            ContactData.getInstance().saveContacts();
//        } catch()
//        }catch(IOException e){
//            System.out.println(e.getMessage());
//        }
//        super.stop();
    }
}
