package com.example.jakartafilrouge.servlets;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(urlPatterns = UserList.URL)
public class UserList extends HttpServlet {

    public static final String URL = "/users";



}