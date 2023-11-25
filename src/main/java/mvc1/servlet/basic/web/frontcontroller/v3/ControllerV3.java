package mvc1.servlet.basic.web.frontcontroller.v3;

import mvc1.servlet.basic.web.frontcontroller.ModelView;

import java.util.Map;

public interface ControllerV3 {

    ModelView process(Map<String, String> paramMap);
}
