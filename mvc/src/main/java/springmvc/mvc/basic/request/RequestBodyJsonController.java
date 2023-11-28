package springmvc.mvc.basic.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import springmvc.mvc.basic.TmpData;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Slf4j
@Controller
public class RequestBodyJsonController {

    ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping("request-body-json-v1")
    public void requestBodyJsonV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletInputStream inputStream = request.getInputStream();
        String body = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        log.info("body : {} ", body);
        TmpData tmpData = objectMapper.readValue(body, TmpData.class);
        log.info("tmpData : {} ", tmpData.toString());

        response.getWriter().write("ok");
    }

    @ResponseBody
    @PostMapping("request-body-json-v2")
    public String requestBodyJsonV2(@RequestBody String body) throws IOException {
        log.info("body : {} ", body);
        TmpData tmpData = objectMapper.readValue(body, TmpData.class);
        log.info("tmpData : {} ", tmpData.toString());

        return "ok";
    }

    @ResponseBody
    @PostMapping("request-body-json-v3")
    public String requestBodyJsonV3(HttpEntity<TmpData> tmp) throws IOException {
        TmpData tmpData = tmp.getBody();
        log.info("tmpData : {} ", tmpData);

        return "ok";
    }

    @ResponseBody
    @PostMapping("request-body-json-v4")
    public String requestBodyJsonV4(@RequestBody TmpData tmpData) throws IOException {
        log.info("tmpData : {} ", tmpData.toString());

        return "ok";
    }

    @ResponseBody
    @PostMapping("request-body-json-v5")
    public TmpData requestBodyJsonV5(@RequestBody TmpData tmpData) throws IOException {
        log.info("tmpData : {} ", tmpData.toString());

        return tmpData;
    }

}
