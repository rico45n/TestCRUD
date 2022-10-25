package ru.company.CRUDtest.DBFunction.CRUDController;
import ru.company.CRUDtest.DBFunction.DBFun.DBFun;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CRUDController implements DBFun {
    @Override
    public Connection connection_to_db(String dbname, String user, String pass) {
        Connection conn = null;
        try {

            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbname , user , pass);
            if (conn!=null){
                System.out.println("Конект установлен");
            }else {
                System.out.println("Ошибка конекта");
            }

        }catch (Exception e){
            System.out.println(e);
        }
        return conn;
    }

    @Override
    public void createTable(Connection conn, String table_name) {
        Statement statement;
        try {
            String query = "create table " + table_name + "(id SERIAL,name varchar(200),surname varchar(200),email varchar(200),primary key(id));";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Таблица создана");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public void insert_row(Connection conn, String table_name, String name, String surname, String email) {
        Statement statement;
        try {

            String query = String.format("insert into %s(name,surname,email) values('%s','%s','%s');",table_name , name , surname , email);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Данные внесены");

        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public void read_data(Connection conn, String table_name) {
        Statement statement;
        ResultSet rs = null;
        try {
            String query = String.format("select * from %s" , table_name);
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()){
                System.out.print(rs.getString("id") + " ");
                System.out.print(rs.getString("name") + " ");
                System.out.print(rs.getString("surname") + " ");
                System.out.println(rs.getString("email") + " ");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public void update_name(Connection conn, String table_name, String old_name, String new_name) {
        Statement statement;
        try {
            String query = String.format("update %s set name='%s' where name='%s'",table_name , new_name , old_name);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Значения обновлены");

        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public void search_by_id(Connection connection, String table_name, Integer id) {
        Statement statement;
        ResultSet resultSet = null;
        try {
            String query = String.format("select * from %s where id = '%s'" , table_name , id);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                System.out.print(resultSet.getString("id") + " ");
                System.out.print(resultSet.getString("name") + " ");
                System.out.print(resultSet.getString("surname") + " ");
                System.out.println(resultSet.getString("email") + " ");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public void delete_row_by_id(Connection connection, String table_name, Integer id) {
        Statement statement;
        try {
            String query = String.format("delete from %s where id='%s'" , table_name , id);
            statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Данные удалены");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public void delete_table(Connection connection, String table_name) {
        Statement statement;
        try {
            String query = String.format("drop table %s" , table_name);
            statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Таблица удалена");
        }catch (Exception e){
            System.out.println(e);
        }
    }

}
