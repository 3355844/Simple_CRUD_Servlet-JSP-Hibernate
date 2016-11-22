package com.all.controllers;

import com.all.dao.UserDao;
import com.all.hibernate.HibernateUtil;
import com.all.models.User;
import org.hibernate.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by user on 22.11.2016.
 */

public class ServletEnter extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("come to servlet");
        String userName = request.getParameter("userName");
        String createdBy = request.getParameter("createdBy");
        System.out.println(userName + " " + createdBy);
        UserDao userDao = new UserDao();
        User user;
        user = userDao.findUserByNameAndCreator(userName, createdBy);
        if (user !=null) {
            request.getRequestDispatcher("/all").forward(request, response);
        } else {
            user = new User();
            user.setUsername(userName);
            user.setCreatedBy(createdBy);
            user.setCreatedDate(new Date());
            userDao.addUserToDb(user);
            request.getRequestDispatcher("/all").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
