package mvc1.servlet.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mvc1.servlet.basic.TmpData;

import java.io.IOException;

@WebServlet(name="ResponseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //content-type : application/json
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");

        TmpData tmp = TmpData.builder()
                .username("name")
                .age(30)
                .build();

        // json mapping
        String result = objectMapper.writeValueAsString(tmp);
        response.getWriter().write(result);

    }
}
