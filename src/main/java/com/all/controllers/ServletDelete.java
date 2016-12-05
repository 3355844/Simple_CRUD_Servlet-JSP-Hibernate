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

/**
 * Created by user on 03.12.2016.
 */
//@WebServlet(name = "ServletDelete")
public class ServletDelete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        HttpSession session = request.getSession(true);
//        UserDao userDao = new UserDao();
//        User user = (User) session.getAttribute("user");
//        String check = request.getParameter("check");
//        if (check.equalsIgnoreCase(user.getCreatedBy())) {
//            userDao.deleteUser(user);
//            request.getRequestDispatcher("/").forward(request,response);
//        } else {
//            request.getRequestDispatcher("/all").forward(request, response);
//        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("word", "enter here created By for checking");
        request.getRequestDispatcher("delete.jsp").forward(request, response);
    }
}
