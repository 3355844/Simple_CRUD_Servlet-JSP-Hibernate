package com.all.controllers;

import com.all.dao.UserDao;
import com.all.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by 33558 on 04.12.2016.
 */
//@WebServlet(name = "MainController")
public class MainController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("come doPost");
        String userName = request.getParameter("userName");
        String createdBy = request.getParameter("createdBy");
        UserDao userDao = new UserDao();
        User user = userDao.findUserByNameAndCreator(userName, createdBy);
        if (user != null) {
            HttpSession session = request.getSession(true);
            session.setAttribute("user", user);
            doGet(request, response);
        } else {
            doPut(request, response);
        }
    }


    protected void doUpdate (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        User user = (User) session.getAttribute("user");
        UserDao userDao = new UserDao();
        System.out.println(user.toString() + " do post void ");
        user.setUserName(request.getParameter("userNameUpdate"));
        user.setCreatedBy(request.getParameter("createdByUpdate"));
        user.setCreatedDate(new Date());
        userDao.update(user);
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("come do Get");
        UserDao userDao = new UserDao();
        List<User> userList = userDao.getAllUsers();
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("all.jsp").forward(request, response);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        String userName = req.getParameter("userName");
        String createdBy = req.getParameter("createdBy");
        createNewUser(userName, createdBy, userDao);
        doGet(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        UserDao userDao = new UserDao();
        User user = (User) session.getAttribute("user");
        String check = req.getParameter("check");
        if (check.equalsIgnoreCase(user.getCreatedBy())) {
            userDao.deleteUser(user);
            doGet(req, resp);
        } else {
            doGet(req, resp);
        }
    }

    private void createNewUser(String userName, String createdBy, UserDao userDao) {
        User user;
        user = new User();
        user.setUserName(userName);
        user.setCreatedBy(createdBy);
        user.setCreatedDate(new Date());
        userDao.addUserToDb(user);
    }
}
