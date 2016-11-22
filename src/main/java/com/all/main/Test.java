package com.all.main;

import com.all.dao.UserDao;
import com.all.models.User;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by 33558 on 21.11.2016.
 */
public class Test {
    public static void main(String[] args) {

        UserDao userDao = new UserDao();
//        User user = new User();
//        user.setUsername("3355844 refactoring");
//        user.setCreatedBy("PsiHe");
//        user.setCreatedDate(new Date());
//        userDao.addUserToDb(user);
//        userDao.deleteUser(6);
        User user1 = userDao.findUserByNameAndCreator("user Name", "created By");
//        user1.setUsername("updated user 2");
//        userDao.update(user1);
        System.out.println(user1);
//        ArrayList<User> users = userDao.getAllUsers();
//        System.out.println(users.toString());
    }
}
