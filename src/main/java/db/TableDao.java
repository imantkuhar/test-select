package db;

import utils.ConnectionService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TableDao {

    private static TableDao instance;

    public static TableDao getInstance() {
        if (instance == null)
            instance = new TableDao();
        return instance;
    }

    public void createTableByRequest(String request) {
        try (Connection connection = ConnectionService.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(request)) {
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void fillUpTableByRequest(String request) {
        try (Connection connection = ConnectionService.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(request)) {
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}