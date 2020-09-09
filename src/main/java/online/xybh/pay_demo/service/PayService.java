package online.xybh.pay_demo.service;

public interface PayService {
    /**
     *  @param total    订单总金额
     * @param subject   订单标题
     * @param body      订单详情
     * @param goodsId   商品id
     * @param goodsName 商品名
     * @param quantity  数量
     * @param price     单价
     * @return  支付表单
     */
    String pay(double total, String subject, String body, String goodsId, String goodsName, int quantity, double price);
}
