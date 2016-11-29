package com.all.controllers;

import com.all.dao.UserDao;
import com.all.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

/**
 * Created by user on 29.11.2016.
 */
//@WebServlet(name = "ServletUpdate")
public class ServletUpdate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        UserDao userDao = new UserDao();
        User user = (User) session.getAttribute("user");
        user.setUserName(request.getParameter("userName"));
        user.setCreatedBy(request.getParameter("createdBy"));
        user.setCreatedDate(new Date());
        userDao.update(user);
        request.getRequestDispatcher("/all").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        UserDao userDao = new UserDao();
        User user = (User) session.getAttribute("user");
        String createdByCheck = request.getParameter("createdByCheck");
        if (user.getCreatedBy().equals(createdByCheck)) {
            userDao.deleteUser(user);
            session.invalidate();
            request.getRequestDispatcher("/");
        } else {
            request.getRequestDispatcher("/all");
        }
    }
}
