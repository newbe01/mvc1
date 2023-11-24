package mvc1.servlet.basic.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mvc1.servlet.basic.domain.member.MemberRepository;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "memberFormServlet", urlPatterns = "/servlet/members/new-form")
public class MemberFormServlet extends HttpServlet {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        PrintWriter writer = response.getWriter();
        writer.write("<!DOCTYPE html> \n" +
                "<html> \n" +
                "<head> \n" +
                "   <meta charset=\"UTF-8\"> \n" +
                "   <title> title </title> \n" +
                "</head> \n" +
                "<body> \n" +
                "<form action=\"/servlet/members/save\" method=\"post\"> \n" +
                "   username : <input type=\"text\" name=\"username\" /> <br> \n" +
                "   age      : <input type=\"text\" name=\"age\" /> <br> \n" +
                "   <button type=\"submit\"> submit </button> \n" +
                "</form> \n" +
                "</body> \n" +
                "</html> \n");

    }
}
