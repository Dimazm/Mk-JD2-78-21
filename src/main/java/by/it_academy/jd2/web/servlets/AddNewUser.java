package by.it_academy.jd2.web.servlets;

import by.it_academy.jd2.core.dto.PersonUser;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddNewUser", urlPatterns = "/signUp")

public class AddNewUser extends HttpServlet {

    private String FIRST_NAME = "firstName";
    private String LAST_NAME = "lastName";
    private String MIDDLE_NAME = "middleName";
    private String DATE_BIRTH = "date";
    private String LOGIN_NAME = "login";
    private String PASSWORD = "password";

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        PersonUser user = new PersonUser("", "", "","","","");
            user.setFirstName(getValueFromSession(request, FIRST_NAME));
            user.setLastName(getValueFromSession(request, LAST_NAME));
            user.setMiddleName(getValueFromSession(request, MIDDLE_NAME));
            user.setDateOfBirth(getValueFromSession(request, DATE_BIRTH));
            user.setLogin(getValueFromSession(request, LOGIN_NAME));
            user.setPassword(getValueFromSession(request, PASSWORD));
            writer.println("userwas created with parameters :" + "\n" + user);

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
            throw new IllegalArgumentException("No Data found in session");
        }
        return value;
    }
}
