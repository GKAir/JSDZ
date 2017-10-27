package cn.jsdz.seller.listener;

import cn.jsdz.common.utils.JsonUtils;
import cn.jsdz.manager.po.JsdzBuyerOrder;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Author:  Air
 * Date  :  2017-09-01.
 */
public class MyListener implements MessageListener{
    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            JsdzBuyerOrder buyerOrder = JsonUtils.jsonToPojo(textMessage.getText(), JsdzBuyerOrder.class);
            System.out.println(buyerOrder);
            System.out.println("json-->" + textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
