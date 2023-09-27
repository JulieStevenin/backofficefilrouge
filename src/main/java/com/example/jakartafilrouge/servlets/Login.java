package com.example.jakartafilrouge.servlets;





import com.example.jakartafilrouge.dao.UserJpaDAO;
import com.example.jakartafilrouge.model.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class Login extends HttpServlet {

    public static final String URL = "/login";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("username") != null) {
            resp.sendRedirect(UserList.URL);
        } else {
            req.getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mail = req.getParameter("mail");
        String password = req.getParameter("password");


        UserJpaDAO userjpaDAO = new UserJpaDAO();
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        Optional<User> u = userjpaDAO.findByMail(mail);
        if (u.isPresent() && passwordEncoder.matches(password, u.get().getPassword())) {
            // Get existing session or create one if not exist
            HttpSession session = req.getSession(true);

            session.setAttribute("mail", mail);
            // Expiration after 30 minutes
            session.setMaxInactiveInterval(30 * 60);

            Cookie cookieU = new Cookie("mail", mail);
            resp.addCookie(cookieU);

            resp.sendRedirect(UserList.URL);
        } else {
            req.setAttribute("loginFail", true);
            doGet(req, resp);
        }

    }
}