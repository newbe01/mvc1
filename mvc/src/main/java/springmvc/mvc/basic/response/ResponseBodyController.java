package springmvc.mvc.basic.response;

import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import springmvc.mvc.basic.TmpData;

import java.io.IOException;

@Slf4j
@Controller
public class ResponseBodyController {

    @GetMapping("response-body-String-v1")
    public void responseBodyV1(HttpServletResponse response) throws IOException {
        response.getWriter().write("ok");
    }

    @GetMapping("response-body-String-v2")
    public ResponseEntity<String> responseBodyV2() throws IOException {
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping("response-body-String-v3")
    public String responseBodyV3() throws IOException {
        return "ok";
    }

    @GetMapping("response-body-json-v1")
    public ResponseEntity<TmpData> responseBodyJsonV1() {
        TmpData tmpData = new TmpData();
        tmpData.setUsername("name");
        tmpData.setAge(20);

        return new ResponseEntity<>(tmpData, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @GetMapping("response-body-json-v2")
    public TmpData responseBodyJsonV2() {
        TmpData tmpData = new TmpData();
        tmpData.setUsername("name");
        tmpData.setAge(20);

        return tmpData;
    }



}
