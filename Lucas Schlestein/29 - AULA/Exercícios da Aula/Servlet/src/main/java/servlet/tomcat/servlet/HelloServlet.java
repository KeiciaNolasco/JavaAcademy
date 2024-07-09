package servlet.tomcat.servlet;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet({"/index", "/login", "/addNewUser"})
public class HelloServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getServletPath();
        if (action.equals("/login")) {
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            request.setAttribute("email", email);
            if(email.equals("lucas@mail.com") && password.equals("123")){
                request.getRequestDispatcher("welcome.jsp").forward(request, response);
            } else{
                request.getRequestDispatcher("loginFail.jsp").forward(request, response);
            }
        }
    }
}
