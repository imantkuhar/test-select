package converter;

import model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResultSetToUsersListConverter {

    public static List<User> getUsersListFromResultList(ResultSet resultSet) {
        List<User> resultList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String department = resultSet.getString(3);
                String job = resultSet.getString(4);
                String location = resultSet.getString(5);
                resultList.add(new User(id, name, department, job, location));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }
}
