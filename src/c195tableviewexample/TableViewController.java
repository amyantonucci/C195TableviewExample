/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c195tableviewexample;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 *
 * @author amy.antonucci
 */
public class TableViewController implements Initializable {

    @FXML
    private TableView<Fruit> fruitTable;

    @FXML
    private TableColumn<Fruit, String> colType;

    @FXML
    private TableColumn<Fruit, Integer> colAge;

    @FXML
    private TableColumn<Fruit, LocalDateTime> colDate;

    ObservableList<Fruit> fruitList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colType.setCellValueFactory(cellData -> {
            return new ReadOnlyStringWrapper(cellData.getValue().getType());
        });
        colAge.setCellValueFactory(cellData -> {
            return new ReadOnlyObjectWrapper(cellData.getValue().getAge());
        });
        colDate.setCellValueFactory(cellData -> {
            return new ReadOnlyObjectWrapper(cellData.getValue().getDate());
        });
        LocalDateTime now = LocalDateTime.now();
        //Option 1: add one object at a time
        Fruit apple = new Fruit("apple", 10, now.plusDays(1));
        fruitTable.getItems().add(apple);
        Fruit banana = new Fruit("banana", 20, now.plusWeeks(1));
        fruitTable.getItems().add(banana);

        //Option 2: add an entire list at once
        fruitList.add(apple);
        fruitList.add(banana);
        fruitTable.getItems().addAll(fruitList);

    }

}
