package com.sample.todolist;

import com.sample.todolist.datamodel.TodoItem;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private List<TodoItem> todoItems;

    @FXML
    private ListView todoListView;

    public void initialize(){
        prepareSampleTodoItems();
        todoListView.getItems().setAll(todoItems);
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

    }


    public void prepareSampleTodoItems(){
        TodoItem item1 = new TodoItem("mail birthday Card","Bu a 30th Birhtday card for Johsn", LocalDate.of(2019, Month.MARCH,30));

        TodoItem item2 = new TodoItem("Doctors appointment","See Doctor Igor at 123 street ", LocalDate.of(2019, Month.MAY,21));

        TodoItem item3 = new TodoItem("Finish design proposal for client","A proposal is required in new format ", LocalDate.of(2019, Month.APRIL,11));

        TodoItem item4 = new TodoItem("Pickup Ivan at the train station","Arriving at 4 April 17:18", LocalDate.of(2019, Month.APRIL,4));

        TodoItem item5 = new TodoItem("Pick up dry cleaning","The clothes should be ready by Wednesday", LocalDate.of(2019, Month.MARCH,5));

        todoItems = new ArrayList<TodoItem>();
        todoItems.add(item1);
        todoItems.add(item2);
        todoItems.add(item3);
        todoItems.add(item4);
        todoItems.add(item5);

    }
}
