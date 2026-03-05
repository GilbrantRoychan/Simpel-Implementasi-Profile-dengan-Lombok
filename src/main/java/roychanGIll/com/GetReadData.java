package roychanGIll.com;

import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import roychanGIll.com.connections.HikariConnections;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

@Slf4j
public class GetReadData {

    private static HikariConnections hikariConnections = new HikariConnections();


    static  void readData(){
        try {
            Connection connection = hikariConnections.getConnect();

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT  * FROM  Profile");
            while (resultSet.next()){
                log.info("nama {}", resultSet.getString("Nama"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        readData();
    }


}
