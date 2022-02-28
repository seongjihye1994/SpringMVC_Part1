package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

    /**
     * ModelAndView 로 반환하는 경우
     *
     */
    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1() {
        ModelAndView mav = new ModelAndView("response/hello").addObject("data", "hello!");
        // View: response/hello, Model: 키=data, value=hello!

        return mav;
    }

    /**
     * String 로 반환하는 경우
     * @Controller 인 경우, ModelAttribute 사용시 String으로 반환하면 뷰 템플릿을 반환한다.
     */
    @RequestMapping("/response-view-v2")
    public String responseViewV2(Model model) {
        model.addAttribute("data", "hello!!");
        return "response/hello";
    }

    /**
     * void 로 반환하는 경우
     * 컨트롤러 매핑 경로와 뷰 템플릿 경로가 같을 경우
     * 모델을 해당 탬플릿으로 랜더링 해준다.
     *
     * 컨트롤러만 봤을 때 모호하기 때문에 권장하지 않는다.
     */
    @RequestMapping("/response/hello")
    public void responseViewV3(Model model) {
        model.addAttribute("data", "hello!!");
    }
}
