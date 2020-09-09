package online.xybh.pay_demo.pay.alipay;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.request.AlipayTradePagePayRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author: xybh
 * @Description:
 * @Date: Created in 13:01 2020/9/9
 * @Modified:
 */

@Slf4j
@Component
public class AlipayTrade {

    public String trade(Map<String, String> content){
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.RETURN_URL);

        alipayRequest.setBizContent(JSON.toJSONString(content));

        String form = "";
        try {
             form = AlipayConfig.getInstance().pageExecute(alipayRequest).getBody();
        } catch (AlipayApiException e) {
            log.error("支付宝构建表单失败", e);
        }
        log.debug("支付宝构建表单"+form);
        return form;

    }
}
