package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

import java.time.LocalDateTime;

public class EmployeeService extends Service<ObservableList<String>> {
    @Override
    protected Task<ObservableList<String>> createTask() {
        return new Task<ObservableList<String>>(){
            @Override
            protected ObservableList<String> call() throws Exception {
                String[] names = {"Ivan",
                        "Igor",
                        "Jak",
                        "Jan",
                        "Oleg",
                        LocalDateTime.now().toString()};


                ObservableList<String> employees =  FXCollections.observableArrayList();

                for(int i = 0; i < 6; i++){
                    employees.add(names[i]);
                    updateMessage("Added " + names[i] + " to the list");
                    updateProgress(i+1,6);
                    Thread.sleep(200);
                }

                /* not recommended way! use binding!*/
//                Platform.runLater(new Runnable() {
//                    @Override
//                    public void run() {
//                        ObservableList<String> temp = listView.getItems();
//                        temp.addAll(employees);
//                        listView.setItems(temp);
//                    }
//                });

                return employees;
            }
        };
    }
}
