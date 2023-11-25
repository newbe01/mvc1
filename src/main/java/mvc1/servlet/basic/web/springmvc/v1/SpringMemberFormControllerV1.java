package mvc1.servlet.basic.web.springmvc.v1;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//@Component
//@RequestMapping   @Controller 와 동일함ㅁ
@Controller // spring bean 등록
public class SpringMemberFormControllerV1 {

    @RequestMapping("springmvc/v1/members/new-form")
    public ModelAndView process() {
        return new ModelAndView("new-form");
    }

}
