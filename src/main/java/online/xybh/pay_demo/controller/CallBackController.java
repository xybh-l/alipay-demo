package online.xybh.pay_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CallBackController {

    @GetMapping("CallBack/alipay_back")
    public String callback(){
        return "/callback";
    }
}
