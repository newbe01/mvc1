package mvc1.servlet.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "tmpServlet", urlPatterns = "/tmp")
public class TmpServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("TmpServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        System.out.println("request.getParameter(\"username\") = " + request.getParameter("username"));

        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("tmp " + request.getParameter("username"));


    }
}
