package online.xybh.pay_demo.pay.alipay;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import org.springframework.stereotype.Component;

@Component
public class AlipayConfig {

    /**
     * 支付宝网关(https://openapi.alipay.com/gateway.do)
     * 沙盒网关(https://openapi.alipaydev.com/gateway.do)
     */
    public static String URL = "https://openapi.alipaydev.com/gateway.do";

    /**
     * 创建应用时产生的应用号
     */
    public static String APP_ID = "你的APPID";

    /**
     * 开发者私钥
     */
    public static String APP_PRIVATE_KEY = "你的开发者私钥";

    /**
     * 参数返回格式, 只支持json
     */
    public static String FORMAT = "json";

    /**
     * 编码集,支持GBK/UTF-8,根据自己工程编码进行调整
     */
    public static String CHARSET = "UTF-8";

    /**
     * 支付宝公钥
     */
    public static String ALIPAY_PUBLIC_KEY = "你的支付宝公钥";

    /**
     * 签名算法类型
     */
    public static String SIGN_TYPE = "RSA2";

    /**
     * 回调地址
     */
    public static String RETURN_URL = "你的回调地址";

    /**
     * 异步通知地址
     */
    public static String NOTIFY_URL;

    /**
     * 私有化构造方法
     */
    private AlipayConfig(){}

    private volatile static AlipayClient instance = null;

    /**
     * 双重校验锁,单例模式
     * @return 支付宝请求客户端实例
     */
    public static AlipayClient getInstance(){
        if(instance == null){
            synchronized (AlipayConfig.class){
                if(instance == null){
                    instance = new DefaultAlipayClient(URL, APP_ID, APP_PRIVATE_KEY, FORMAT, CHARSET, ALIPAY_PUBLIC_KEY, SIGN_TYPE);
                }
            }
        }
        return instance;
    }
}
