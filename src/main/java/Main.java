import container.TableContainer;
import model.User;
import service.UserService;

import java.util.List;


public class Main {
    public static void main(String[] args) {

//        testData();

        UserService service = new UserService();
        String facilityManager = "Alpha";
        List<User> usersList = service.getUsersListByFacilityManager(facilityManager);
    }

    private static void testData() {
        TableContainer tableContainer = new TableContainer();
        tableContainer.initAllTables();
        tableContainer.fillUpAllTables();
    }
}
