package mvc1.servlet.basic.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "responseHeaderServlet" , urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //status-line
        response.setStatus(HttpServletResponse.SC_OK);

        //response-headers
//        response.setHeader("Content-Type", "text/plain;charset=utf-8");
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("tmp-header", "tmp");    // 없을경우 만들어줌

        //header utils
        content(response);
        cookie(response);
        redirect(response);

        //message body
        response.getWriter().println("ok");
    }


    private void content(HttpServletResponse response) {
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
//        response.setContentLength(4); 생략시 자동생성

    }

    private void cookie(HttpServletResponse response) {
//      response.setHeader("Set-Cookie", "tmpCookie=good; Max-Age=600");

        Cookie cookie = new Cookie("tmpCookie", "tmp");
        cookie.setMaxAge(600);
        response.addCookie(cookie);
    }

    private void redirect(HttpServletResponse response) throws IOException {
        // status code : 302
//        response.setStatus(HttpServletResponse.SC_FOUND);
//        response.setHeader("Location", "/basic/tmp-form.html");

        response.sendRedirect("/basic/tmp-form.html");

    }
}
