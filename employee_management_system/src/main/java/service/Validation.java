package service;

import entity.User;
import repository.UserDao;

public class Validation {

    public static String checkCredentials(String userName, String password){
        User u = UserDao.getUser(userName, password);
        if (u.getIsAdmin()) {
            return "admin";
        }
        return UserDao.checkPassword(userName, password);
    }
}
