package service;

import db.UserDao;
import model.User;

import java.util.List;

public class UserService {

    private UserDao userDao = UserDao.getInstance();

    public List<User> getUsersListByFacilityManager(String string) {
       return userDao.getUsersListByFacilityManager(string);
    }
}


