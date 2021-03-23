package by.it_academy.jd2.web.servlets;

import by.it_academy.jd2.core.dto.Person;
import by.it_academy.jd2.core.dto.PersonUser;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static by.it_academy.jd2.core.constant.MessengerConstants.*;

@WebServlet(name = "LoginUserServlet", urlPatterns = "/login")

public class LoginUserServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession();
        String login = request.getParameter(LOGIN_NAME);
        String password = request.getParameter(PASSWORD);

        List<PersonUser> usersList = (List<PersonUser>) session.getAttribute("users");
        if (isUserRegistered(usersList, login, password) == null) {
            writer.println("<p><span style='color: red;'>User doesn't exist or Login/Password is incorrect</span></p>");
        } else {
            String currentUser = isUserRegistered(usersList, login, password);
            session.setAttribute("currentUser", currentUser );
            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath + "/welcome.jsp");
        }
    }


    public String isUserRegistered(List<PersonUser> usersList, String login, String password) {
        String user = "";
        if (usersList != null) {
            for (PersonUser u : usersList) {
                if (u.getLogin().equals(login) && u.getPassword().equals(password)) {
                     user = u.getFirstName() + " " + u.getMiddleName();

                }
            }
        } else {
            throw new IllegalArgumentException("No Data found, please register any user");
        }

        return user;
    }
}
