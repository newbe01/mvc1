package mvc1.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        getParameter()는 GET URL 쿼리파라미터 형식과, POST FORM 형식 둘다 지원한다. 구분없이 사용할 수 있다.
//        System.out.println("RequestParamServlet.service");

        System.out.println("--all params st");
        request.getParameterNames()
                .asIterator()
                .forEachRemaining(paramName -> System.out.println(paramName + " : " + request.getParameter(paramName)));
        System.out.println("all params ed");
        System.out.println();

        System.out.println("--single param st");
        String username = request.getParameter("username");
        String age = request.getParameter("age");

        System.out.println("username = " + username);
        System.out.println("age = " + age);
        System.out.println("single param ed");
        System.out.println();

        System.out.println("--duple named param st");
        String[] usernames = request.getParameterValues("username");

        for (String name : usernames) {
            System.out.println("name = " + name);
        }
        System.out.println("duple named param ed");

    }
}
