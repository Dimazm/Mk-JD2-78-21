package by.it_academy.jd2.web.servlets;

import by.it_academy.jd2.core.Persona;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@WebServlet(name = "PersonaServlet", urlPatterns = "/persona")
public class PersonaServlet extends HttpServlet {
    private String TYPE_OF_DATA = "TYPE_OF_DATA";
    private String FIRST_NAME = "firstName";
    private String LAST_NAME = "lastName";
    private String AGE = "age";
    private String IS_COOKIE = "cookie";
    private String IS_SESSION = "session";

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        String header = request.getHeader(TYPE_OF_DATA);
        Persona user = new Persona("", "", "");
        String[] headerValues = request.getParameterMap().get(header);

        for (String value : headerValues) {
            if (value.equals(IS_COOKIE)) {
                user.setFirstName(getCookiesValue(request, response, FIRST_NAME));
                user.setSecondName(getCookiesValue(request, response, LAST_NAME));
                user.setAge(getCookiesValue(request, response, AGE));
                writer.println("Take from Cookies\n" + user);
            }
            else if (value.equals(IS_SESSION)) {
                user.setFirstName(getSessionsValue(request, FIRST_NAME));
                user.setSecondName(getSessionsValue(request, LAST_NAME));
                user.setAge(getSessionsValue(request, AGE));
                writer.println("Take from Session\n" + user);
            }
        }
    }

    public static String getCookiesValue(HttpServletRequest request, HttpServletResponse response, String param) {
        String value = request.getParameter(param);
        Cookie cookieValue = new Cookie(param, value);
        cookieValue.setMaxAge(Math.toIntExact(TimeUnit.DAYS.toSeconds(1)));

        if (value == null) {
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                value = Arrays.stream(cookies)
                        .filter(c -> param.equalsIgnoreCase(c.getName()))
                        .map(Cookie::getValue)
                        .findFirst()
                        .orElse(null);
            }
        } else {
            response.addCookie(cookieValue);
        }
        if (value == null) {
            throw new IllegalArgumentException("No Data found in cookies");
        }
        return value;
    }

    public static String getSessionsValue(HttpServletRequest request, String param) {
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
