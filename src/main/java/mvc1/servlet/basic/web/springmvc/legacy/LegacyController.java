package mvc1.servlet.basic.web.springmvc.legacy;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

@Component("/springmvc/legacy-controller")
public class LegacyController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("LegacyController.handleRequest");
/**
 *  HandlerMapping
 *
 *  핸들러에서 컨트롤러를 찾을수 있어야 한다. (spring bean 이름으로 핸들러를 찾을 수 있는 매핑이 필요)
 *
 *  HandlerAdapter
 *  HandlerMapping을 통해 찾은 핸들러를 실행할 수 있는 핸들러 어댑터가 필요하다
 *
 * */
        return new ModelAndView("new-form");
    }

}
