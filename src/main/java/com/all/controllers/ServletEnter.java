package com.all.controllers;

import com.all.dao.UserDao;
import com.all.hibernate.HibernateUtil;
import com.all.models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.mortbay.jetty.servlet.AbstractSessionManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by user on 22.11.2016.
 */

public class ServletEnter extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String userName = request.getParameter("userName");
//        String createdBy = request.getParameter("createdBy");
//        UserDao userDao = new UserDao();
//        User user = userDao.findUserByNameAndCreator(userName, createdBy);
//        if (user != null) {
//            HttpSession session = request.getSession(true);
//            session.setAttribute("user", user);
//            request.getRequestDispatcher("/all").forward(request, response);
//        } else {
//            createNewUser(userName, createdBy, userDao);
//            request.getRequestDispatcher("/enter").forward(request, response);
//        }
//    }
//
//    private void createNewUser(String userName, String createdBy, UserDao userDao) {
//        User user;
//        user = new User();
//        user.setUserName(userName);
//        user.setCreatedBy(createdBy);
//        user.setCreatedDate(new Date());
//        userDao.addUserToDb(user);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("servlet enter doGet");
    }
}
