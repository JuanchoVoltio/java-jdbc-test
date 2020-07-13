package com.heading.example.jdbc;

import com.heading.example.jdbc.model.TestObjectPlayer;

import java.sql.* ;
import java.util.ArrayList;
import java.util.Collection;

public class Main {
    public static void main(String[] args){

        // [1] Registrar el Controlador
        try {
            Class.forName ("org.h2.Driver");
        }
        catch(ClassNotFoundException ex) {
            System.out.println("Error: unable to load driver class!");
            System.exit(1);
        }

        String URL = "jdbc:h2:~/test";
        String USER = "sa";
        String PASS = "";

        // [2] - Establecer la conexión utilizando la URL y los datos de autenticación (opciones)
        // [3] - Obtener una instancia de Statement para poder ejecutar sentencias nativas de la base de datos
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             Statement st = conn.createStatement();) {

//            System.out.println("Creating table in given database...");
//            String sql =  "CREATE TABLE IF NOT EXISTS TEST2(ID INT PRIMARY KEY,"
//                        + "NAME VARCHAR(255));";
//            st.executeUpdate(sql);
//            st.executeUpdate("INSERT INTO TEST2 VALUES(1, 'Bla');");
//            st.executeUpdate("INSERT INTO TEST2 VALUES(2, 'Bla');");
//
//            System.out.println("Created table in given database...");


//            System.out.println("Creating table in given database...");
//
//            String createTable = "CREATE TABLE IF NOT EXISTS TABLEPLAYER(Name VARCHAR(255) PRIMARY KEY,"
//                                + "Position VARCHAR(255),"
//                                + "Number INT,"
//                                + "Age INT,"
//                                + "Salary INT);";

//            st.executeUpdate(createTable);
//            int borrarColum = st.executeUpdate("ALTER TABLE TABLEPLAYER DROP COLUMN Phone_Number;");
//            int actualizar = st.executeUpdate("UPDATE TABLEPLAYER SET Age = 27 WHERE Number = 3;");
//            System.out.println("Registros modificados: " + actualizar);

//            System.out.println("Created table in given database...");

            //[4] - Utilizar ResultSet para obtener los datos provenientes de una consulta SQL
            ResultSet rs = st.executeQuery("SELECT * FROM TABLEPLAYER;");
//            Collection<TestObject> collection = new ArrayList<>();
//
//            while (rs.next()) {
//                TestObject current = new TestObject();
//                current.id = rs.getString(1);
//                current.name = rs.getString("NAME");
//                collection.add(current);
//                System.out.print(rs.getString(1));
//                System.out.print("-");
//                System.out.println(rs.getString("NAME"));
//
//            }
            Collection<TestObjectPlayer> collectionPlayer = new ArrayList<>();
            while (rs.next()){
                TestObjectPlayer current = new TestObjectPlayer();
                current.name = rs.getString("Name");
                current.position = rs.getString("Position");
                current.number = rs.getInt("Number");
                current.age = rs.getInt("Age");
                current.salary = rs.getInt("Salary");
                collectionPlayer.add(current);
                System.out.println(current);

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
