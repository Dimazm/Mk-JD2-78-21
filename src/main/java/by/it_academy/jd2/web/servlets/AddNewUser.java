package by.it_academy.jd2.web.servlets;

import by.it_academy.jd2.core.dto.PersonUser;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@WebServlet(name = "AddNewUser", urlPatterns = "/signUp")

public class AddNewUser extends HttpServlet {

    private String FIRST_NAME = "firstName";
    private String LAST_NAME = "lastName";
    private String MIDDLE_NAME = "middleName";
    private String DATE_BIRTH = "date";
    private String LOGIN_NAME = "login";
    private String PASSWORD = "password";
    private List<PersonUser> userList = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        //ServletContext context = getServletContext();
        //context.getRequestDispatcher("/index.jsp").forward(request, response);//пример редиректа. уходим по исполнению
        // String contextPath = request.getContextPath();
        // response.sendRedirect(contextPath + "/helloP");

        PersonUser user = new PersonUser("", "", "", "", "", "");

        user.setFirstName(getValueFromSession(request, FIRST_NAME));
        user.setLastName(getValueFromSession(request, LAST_NAME));
        user.setMiddleName(getValueFromSession(request, MIDDLE_NAME));
        user.setDateOfBirth(getValueFromSession(request, DATE_BIRTH));
        user.setLogin(getValueFromSession(request, LOGIN_NAME));
        user.setPassword(getValueFromSession(request, PASSWORD));

        userList.add(user);
        HttpSession session = request.getSession();
        session.setAttribute("users", userList);

        //  writer.println("user was created with parameters :" + "\n" + session.getAttribute("users") + "объект " + user);
        String contextPath = request.getContextPath();
        response.sendRedirect(contextPath + "/signIn.jsp");
    }

    public static String getValueFromSession(HttpServletRequest request, String param) {
        String value = request.getParameter(param);
        HttpSession session = request.getSession();
        if (value == null) {
            if (!session.isNew()) {
                value = (String) session.getAttribute(param);
            }
        } else {
            session.setAttribute(param, value);
        }
        if (value == null) {
            throw new IllegalArgumentException("Please fill parameters");
        }
        return value;
    }
}
