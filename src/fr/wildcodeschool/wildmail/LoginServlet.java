package fr.wildcodeschool.wildmail;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String emailValue = (String) request.getSession().getAttribute("email");
        if (emailValue != null && !emailValue.isEmpty())  {
            this.getServletContext().getRequestDispatcher("/home").forward(request,response);
        } else {
            this.getServletContext().getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }
}
