package container;

import db.TableDao;

public class TableContainer {

    private TableDao tableDao = TableDao.getInstance();

    public static final String CREATE_LOCATION_TABLE = "CREATE TABLE IF NOT EXISTS locations" +
            " (id INTEGER not NULL AUTO_INCREMENT, " +
            " PRIMARY KEY (id)," +
            " location VARCHAR(25) not NULL," +
            " facility_manager VARCHAR(25) not NULL)";

    public static final String CREATE_INTERNAL_USER_TABLE = "CREATE TABLE IF NOT EXISTS internalUsers" +
            " (id INTEGER not NULL AUTO_INCREMENT, " +
            " PRIMARY KEY (id)," +
            " user_name VARCHAR(25) not NULL," +
            " department VARCHAR(25) not NULL," +
            " job_title VARCHAR(25) not NULL," +
            " phone_number INTEGER not NULL," +
            " mail_address VARCHAR(25) not NULL," +
            " location_id INTEGER DEFAULT NULL, " +
            " FOREIGN KEY (location_id) REFERENCES locations(id))";

    public static final String CREATE_EXTERNAL_USER_TABLE = "CREATE TABLE IF NOT EXISTS externalUsers" +
            " (id INTEGER not NULL AUTO_INCREMENT, " +
            " PRIMARY KEY (id)," +
            " user_name VARCHAR(25) not NULL," +
            " phone_number INTEGER not NULL," +
            " location_id INTEGER DEFAULT NULL, " +
            " FOREIGN KEY (location_id) REFERENCES locations(id))";

    public static final String FILL_UP_LOCATION_TABLE = "INSERT INTO locations (location, facility_manager) VALUES " +
            "('Kiev', 'Artem'), ('Lviv', 'Igor'), " +
            "('Harkiv', 'Alpha'), ('Odessa', 'Alex')";

    public static final String FILL_UP_INTERNAL_USER_TABLE = "INSERT INTO internalUsers " +
            "(user_name, department, job_title, phone_number, mail_address, location_id) VALUES " +
            "('Dima', 'Education', 'VNTU', '0636850201', 'first@gmail.com', 3), " +
            "('Ivan', 'Finances', 'Bank', '0636850202', 'second@gmail.com', 2), " +
            "('Andrey', 'Logistics', 'Port', '0636850203', 'third@gmail.com', 4), " +
            "('Oleg', 'Judicature', 'Tribunal', '0636850204', 'fourth@gmail.com', 3), " +
            "('Denis', 'Logistics', 'Airport', '0636850205', 'fifth@gmail.com', 1), " +
            "('Mukola', 'Finances', 'Bank', '0636850206', 'sixtht@gmail.com', 3), " +
            "('Anatoliy', 'Science', 'VNTU', '0636850207', 'seventh@gmail.com', 2), ";

    public static final String FILL_UP_EXTERNAL_USER_TABLE = "INSERT INTO externalUsers " +
            "(user_name, phone_number, location_id) VALUES " +
            "('Andrey', '0636850210', 3), ('Inna', '0636850220', 2), ('Alex', '0636850230', 3), " +
            "('Evgen', '0636850240', 1), ('Viktor', '0636850250', 1), ('Ryslan', '0636850260', 3), " +
            "('Dima', '0636850270', 4), ('Vova', '0636850280', 4)";


    public void initAllTables() {
        createLocationTable();
        createInternalUserTable();
        createExternalUserTable();
    }

    public void fillUpAllTables() {
        fillUpLocationTable();
        fillUpInternalUserTable();
        fillUpExternalUserTable();
    }

    private void createLocationTable() {
        tableDao.createTableByRequest(CREATE_LOCATION_TABLE);
    }

    private void createInternalUserTable() {
        tableDao.createTableByRequest(CREATE_INTERNAL_USER_TABLE);
    }

    private void createExternalUserTable() {
        tableDao.createTableByRequest(CREATE_EXTERNAL_USER_TABLE);
    }

    public void fillUpLocationTable() {
        tableDao.fillUpTableByRequest(FILL_UP_LOCATION_TABLE);
    }

    public void fillUpInternalUserTable() {
        tableDao.fillUpTableByRequest(FILL_UP_INTERNAL_USER_TABLE);
    }

    public void fillUpExternalUserTable() {
        tableDao.fillUpTableByRequest(FILL_UP_EXTERNAL_USER_TABLE);
    }
}
