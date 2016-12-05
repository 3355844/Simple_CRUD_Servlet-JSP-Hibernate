package com.all.controllers;

import com.all.dao.UserDao;
import com.all.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by user on 22.11.2016.
 */
//@WebServlet(name = "ServletAll", urlPatterns = "/all")
public class ServletAll extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("come to doPost void");
//        UserDao userDao = new UserDao();
//        List<User> userList = userDao.getAllUsers();
//        request.setAttribute("userList", userList);
//        request.getRequestDispatcher("all.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
