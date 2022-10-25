package ru.company.CRUDtest.DBFunction;

import ru.company.CRUDtest.DBFunction.CRUDController.CRUDController;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String... args) {
        CRUDController crudController = new CRUDController();
        Connection conn = crudController.connection_to_db("TestDevOps" , "rico45" , "0201");
        crudController.createTable(conn , "client" );
        crudController.insert_row(conn , "client" , "Roman" , "Pregerg" , "rpesnin@mail.ru");
        crudController.insert_row(conn , "client" , "RomanKTK" , "PreFEWFgerg" , "rpesnin@mail.ru");
        crudController.insert_row(conn , "client" , "RomanKTK" , "PreFEWFgerg" , "rpesnin@mail.ru");
        crudController.insert_row(conn , "client" , "RomanKTK" , "PreFEWFgerg" , "rpesnin@mail.ru");
        crudController.read_data(conn , "client");
//        //db.update_name(conn ,"client" , "Roman2" , "Pushinka" );
//        crudController.read_data(conn , "client");
//        System.out.println("___________________________________");
//        crudController.search_by_id(conn , "client" , 2);
//        System.out.println("___________________________________");
//        //db.delete_row_by_id(conn , "client" , 2);
//        //db.read_data(conn , "client");
//       // System.out.println("___________________________________");
        Scanner sc = new Scanner(System.in);
        System.out.println("Вы хотите удалить таблицу?");
        int yes = sc.nextInt();
        if (1 == yes){
            crudController.delete_table(conn , "client");
        }
    }
}
