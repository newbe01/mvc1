package springmvc.mvc.basic.request;

import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

@Slf4j
@Controller
public class RequestBodyStringController {

    @PostMapping("/request-body-string-v1")
    public void requestBodyString(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletInputStream inputStream = request.getInputStream();
        String body = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        log.info("body : {} ", body);

        response.getWriter().write("ok");
    }

    @PostMapping("/request-body-string-v2")
    public void requestBodyStringV2(InputStream inputStream, Writer writer) throws IOException {
        String body = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        log.info("body : {} ", body);

        writer.write("ok");
    }

    @PostMapping("/request-body-string-v3")
//    public HttpEntity<String> requestBodyStringV3(HttpEntity<String> entity) throws IOException {
    public HttpEntity<String> requestBodyStringV3(RequestEntity<String> entity) throws IOException {

        log.info("body : {} ", entity.getBody());
//        return new HttpEntity<>("ok");
        return new ResponseEntity<String>("ok", HttpStatus.OK);
    }

    @ResponseBody
    @PostMapping("/request-body-string-v4")
    public String requestBodyStringV4(@RequestBody String body) throws IOException {

        log.info("body : {} ", body);
        return "ok";
    }

}
