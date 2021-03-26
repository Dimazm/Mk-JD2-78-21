package by.it_academy.jd2.web.servlets;

import by.it_academy.jd2.core.dto.PersonUser;
import by.it_academy.jd2.view.HistoryView;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import javax.swing.text.DateFormatter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static by.it_academy.jd2.core.constants.MessengerConstants.*;

@WebServlet(name = "SendMessageServlet", urlPatterns = "/send")
public class SendMessageServlet extends HttpServlet {
private  final HistoryView history = new HistoryView();

    @Override
    protected void doPost(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession();
        LocalDateTime time = LocalDateTime.now();

        String messageTime = time.format(DateTimeFormatter.ofPattern("dd.MM.yyy HH:mm:ss"));
        String userName = request.getParameter(USER_NAME);
        String message = request.getParameter(MESSAGE + messageTime);
        history.addMessage(userName,message);







    }
}