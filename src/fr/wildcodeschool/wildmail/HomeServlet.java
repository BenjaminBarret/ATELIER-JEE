package fr.wildcodeschool.wildmail;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

@WebServlet(name = "HomeServlet", urlPatterns = {"/home"})
public class HomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
            request.getSession().setAttribute("email", email);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MailBean mailBean = new MailBean();
        mailBean.setFrom("la Réunion");
        mailBean.setContent("Salut mamène !!!!");
        mailBean.setTo("Toulouse");
        request.setAttribute("mail", mailBean);
        this.getServletContext().getRequestDispatcher("/maillist.jsp").forward(request,response);
    }
}
