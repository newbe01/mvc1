package springmvc.mvc.basic.requestmapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class MappingController {

    @RequestMapping(value = {"/tmp-basic", "/mapping-get-v1"}, method = RequestMethod.GET)
    public String tmpBasic() {
        log.info("tmp basic");
        return "ok";
    }

    @GetMapping("/mapping-get-v2")
    public String mappingGetV2() {
        log.info("mapping-get-v2");
        return "ok";
    }

    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String userId) {
        log.info("mapping path userId : {}", userId);
        return "ok";
    }

    @GetMapping("mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable("userId") String userId, @PathVariable("orderId") String orderId) {
        log.info("mapping path userId : {}, orderId : {}", userId, orderId);
        return "ok";
    }

    /**
     * 파라미터로 추가매핑
     * params="mode"
     * params="!mode"
     * ...
     */
    @GetMapping(value = "/mapping-param", params = "mode=debug")
    public String mappingParam() {
        log.info("mappingParam");
        return "ok";
    }

    /**
     * 특정헤더로 추가매핑
     * params="mode"
     * params="!mode"
     * ...
     */
    @GetMapping(value = "mapping-header", headers = "mode=debug")
    public String mappingHeader() {
        log.info("mappingParam");
        return "ok";
    }

    /**
     * Content-Type header 기반 추가 매핑
     * consumes="application/json"
     * consumes="!application/json"
     * consumes="*\/*"
     * MediaType.APPLICATION_JSON_VALUE
     * ...
     */
    @GetMapping(value = "mapping-consume", consumes = "application/json")
    public String mappingConsumes() {
        log.info("mappingConsumes");
        return "ok";
    }

    /**
     * Accept header 기반
     * produces="text/html"
     * produces="!text/html"
     * consumes="*\/*"
     * ...
     */
    @GetMapping(value = "mapping-produce", produces = "text/html")
    public String mappingProduces() {
        log.info("mappingProduces");
        return "ok";
    }

}
