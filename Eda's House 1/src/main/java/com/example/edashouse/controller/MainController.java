package com.example.edashouse.controller;

import com.example.edashouse.view.Layout;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainController extends Application {
    //TODO    Розібратися з сценою для проведення маніпуляцій
    //TODO    Встановити сцену 32х32, та поставити на неї головного героя
    //TODO    Дати можливість головному героя рухатися
    //TODO    Поставити Статичні об'єкти на поле
    //TODO    Ввести зміни щодо можливості руху героя (неможна рухатися через об'єкти)

    private Layout layout;

    @Override
    public void start(Stage stage) throws Exception {
        layout = new Layout(stage);
    }
}
