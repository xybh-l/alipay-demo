package online.xybh.pay_demo.service.impl;

import com.alipay.api.AlipayApiException;
import online.xybh.pay_demo.pay.alipay.AlipayTrade;
import online.xybh.pay_demo.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.UUID;

@Service
public class PayServiceImpl implements PayService {

    @Autowired
    private AlipayTrade alipayTrade;

    @Override
    public String pay(double total, String subject, String body, String goodsId, String goodsName, int quantity, double price){
        HashMap<String, String> content = new HashMap<>();
        content.put("out_trade_no", UUID.randomUUID().toString());
        content.put("product_code", "FAST_INSTANT_TRADE_PAY");
        content.put("total_amount", String.valueOf(total));
        content.put("subject", subject);
        content.put("body", body);
        content.put("goods_id", goodsId);
        content.put("goods_name", goodsName);
        content.put("quantity", String.valueOf(quantity));
        content.put("price", String.valueOf(price));
        return alipayTrade.trade(content);
    }
}
