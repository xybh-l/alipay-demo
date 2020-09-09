package online.xybh.pay_demo.controller;

import online.xybh.pay_demo.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class PayController {

    @Autowired
    private PayService payService;

    @PostMapping("/pay")
    public String pay(@RequestParam String subject,
                      @RequestParam String body,
                      @RequestParam String goodsId,
                      @RequestParam String goodsName,
                      @RequestParam int quantity,
                      @RequestParam double price,
                      HttpServletResponse response){
        String form = payService.pay(quantity*price, subject, body, goodsId, goodsName, quantity, price);
        response.setContentType("text/html;charset=" + "UTF8");
        try {
            response.getWriter().write(form);
            response.getWriter().flush();
            response.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "callback";
    }

}
