package db;

import converter.ResultSetToUsersListConverter;
import model.User;
import utils.ConnectionService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    private static UserDao instance;

    public static final String GET_USERS_LIST_BY_FACILITY_MANAGER = "SELECT iu.id, iu.user_name, iu.department, iu.job_title, l.location FROM internalUsers iu " +
            "INNER JOIN locations l ON iu.location_id=l.id WHERE l.facility_manager = ? " +
            "union SELECT eu.id, eu.user_name, null as department, null as job_title, l.location FROM externalUsers eu " +
            "INNER JOIN locations l ON eu.location_id = l.id WHERE l.facility_manager = ?";

    public static UserDao getInstance() {
        if (instance == null)
            instance = new UserDao();
        return instance;
    }

    public List<User> getUsersListByFacilityManager(String string) {
        List<User> usersList = new ArrayList<>();
        try (Connection connection = ConnectionService.createConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(GET_USERS_LIST_BY_FACILITY_MANAGER)) {
            preparedStatement.setString(1, string);
            preparedStatement.setString(2, string);

            ResultSet resultSet = preparedStatement.executeQuery();
            usersList = ResultSetToUsersListConverter.getUsersListFromResultList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usersList;
    }
}
