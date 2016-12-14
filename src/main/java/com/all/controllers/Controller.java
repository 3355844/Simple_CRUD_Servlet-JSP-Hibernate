package com.all.controllers;

import com.all.dao.UserDao;
import com.all.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by 33558 on 04.12.2016.
 */
//@WebServlet(name = "Controller")
public class Controller extends HttpServlet {

    private static String METHOD_POST = "POST";
    private static String METHOD_UPDATE = "UPDATE";
    private static String METHOD_DELETE = "DELETE";
    private static String ALL = "all.jsp";
    private static UserDao userDao = new UserDao();

    public static UserDao getUserDao() {
        return userDao;
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String methods = req.getParameter("methods");
        String method = req.getMethod();
        if (METHOD_POST.equals(method)) {
            doPost(req, resp);
        } else if (METHOD_DELETE.equalsIgnoreCase(methods)) {
            doDelete(req, resp);
        } else if (METHOD_UPDATE.equals(methods)) {
            doPut(req, resp);
        } else {
            doGet(req, resp);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> userList = getUserDao().getAllUsers();
        request.setAttribute("userList", userList);
        request.getRequestDispatcher(ALL).forward(request, response);
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        String userName = request.getParameter("userName");
        String userCreatedBy = request.getParameter("createdBy");
        User user = getUserDao().returnById(userId);
        user.setUserName(userName);
        user.setCreatedBy(userCreatedBy);
        user.setCreatedDate(new Date());
        getUserDao().update(user);
        request.setAttribute("user", user);
        doGet(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String createdBy = request.getParameter("createdBy");
        createNewUser(userName, createdBy);
        doGet(request, response);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = getUserDao().returnById(Integer.parseInt(request.getParameter("userId")));
        getUserDao().deleteUser(user);
        doGet(request, response);
    }

    private void createNewUser(String userName, String createdBy) {
        User user = new User();
        user.setUserName(userName);
        user.setCreatedBy(createdBy);
        user.setCreatedDate(new Date());
        getUserDao().addUserToDb(user);
    }
}
