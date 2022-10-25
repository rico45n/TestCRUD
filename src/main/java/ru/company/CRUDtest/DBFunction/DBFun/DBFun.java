package ru.company.CRUDtest.DBFunction.DBFun;

import java.sql.Connection;

public interface DBFun {
    Connection connection_to_db(String dbname , String user , String pass);
    void createTable(Connection conn, String table_name);
    void insert_row(Connection conn ,String table_name, String name, String surname, String email);
    void read_data(Connection conn, String table_name);
    void update_name(Connection conn ,String table_name, String old_name , String new_name);
    void search_by_id(Connection connection , String table_name , Integer id);
    void delete_row_by_id(Connection connection , String table_name , Integer id);
    void delete_table(Connection connection , String table_name);
}
