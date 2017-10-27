package cn.jsdz.buyer.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.jsdz.common.utils.*;
import cn.jsdz.manager.mapper.JsdzBuyerOrderMapper;
import cn.jsdz.manager.po.JsdzBuyerOrder;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import cn.jsdz.buyer.interfaces.BuyerService;
import cn.jsdz.manager.mapper.JsdzBuyerMapper;
import cn.jsdz.manager.po.JsdzBuyer;
import cn.jsdz.manager.po.JsdzBuyerExample;

import javax.annotation.Resource;
import javax.jms.*;

@Service
public class BuyerServiceImpl implements BuyerService {

    private static final long serialVersionUID = 5527330312925515139L;
    @Autowired
    private JsdzBuyerMapper buyerMapper;

    //用户注册
    @Override
    public JsdzResult register(JsdzBuyer buyer) {
        JsdzBuyerExample example = new JsdzBuyerExample();
        JsdzBuyerExample.Criteria criteria = example.createCriteria();
        //验证手机号唯一性
        criteria.andPhoneEqualTo(buyer.getPhone());
        List<JsdzBuyer> list = buyerMapper.selectByExample(example);
        if (list.size() > 0) {
            return JsdzResult.build(500, "手机号已经注册");
        }
        //清理criteria
        example.clear();
        try {
            byte[] md5s = MessageDigest.getInstance("md5").digest(buyer.getPassword().getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("没有md5这个算法！");
        }
        String md5Pwd = Md5Utils.MD5Encode(buyer.getPassword(), "utf-8", false);
        String uName = IDUtils.genUserId();
        //生成随机数nickname
        buyer.setNickname("b" + uName);
        buyer.setPassword(md5Pwd);
        buyer.setCreateTime(new Date());
        buyer.setUpdateTime(new Date());
        buyer.setIsDelete(0);
        buyer.setIsVip(0);
        System.out.println(buyer);
        int insert = buyerMapper.insert(buyer);
        return JsdzResult.build(200, "注册成功");
    }

    /**
     * 用户登录
     *
     * @param buyer
     * @return
     */
    @Override
    public JsdzResult login(JsdzBuyer buyer) {
        JsdzBuyerExample example = new JsdzBuyerExample();
        JsdzBuyerExample.Criteria criteria = example.createCriteria();
        criteria.andPhoneEqualTo(buyer.getPhone());
        List<JsdzBuyer> list = buyerMapper.selectByExample(example);
        //验证用户名是否存在
        //不存在
        if (list == null || list.size() == 0) {
            return JsdzResult.build(500, "手机号不存在，请确认后输入");
            //存在
        } else {
            System.out.println(list);
            JsdzBuyer b1 = list.get(0);
            System.out.println(b1);
            //验证密码正确
            //不正确
            String md5Pwd = Md5Utils.MD5Encode(buyer.getPassword(), "utf-8", false);
            if (!md5Pwd.equals(b1.getPassword())) {
                return JsdzResult.build(500, "密码错误，请核实后在输入");
                //正确 登陆成功
            } else {
                return JsdzResult.build(200, "登录成功", b1);
            }
        }
    }

    /**
     * 用户提交仁恒
     *
     * @param buyer
     * @return
     */
    @Override
    public JsdzResult authentication(JsdzBuyer buyer) {
        /*
         * 0--> 未认证
         * 1--> 认证中
         * 2--> 已认证
         * 3--> 认证失败
         */
        buyer.setIsVip(1);
        int flag = buyerMapper.updateByPrimaryKey(buyer);
        if (flag == 1) {
            return JsdzResult.build(200, "提交成功，后台审核中，请耐心等待");
        }
        return JsdzResult.build(500, "认证异常，请重新填写表格");
    }

    /**
     * 更新用户信息
     *
     * @param buyer
     * @return
     */
    @Override
    public JsdzResult update(JsdzBuyer buyer) {
        int flag = buyerMapper.updateByPrimaryKey(buyer);
        if (flag == 1) {
            return JsdzResult.build(200, "修改成功");
        } else {
            return JsdzResult.build(500, "修改失败，请重试");
        }
    }

    @Override
    public JsdzResult delete(JsdzBuyer buyer) {
        buyer.setIsDelete(1);
        int flag = buyerMapper.updateByPrimaryKey(buyer);
        if (flag == 1) {
            return JsdzResult.build(200, "删除成功");
        }
        return JsdzResult.build(500, "删除失败，请重试");
    }

    @Override
    public JsdzResult findByPhone(String phone) {
        JsdzBuyerExample example = new JsdzBuyerExample();
        JsdzBuyerExample.Criteria criteria = example.createCriteria();
        criteria.andPhoneEqualTo(phone);
        List<JsdzBuyer> list = buyerMapper.selectByExample(example);
        if (list == null || list.size() == 0) {
            return JsdzResult.build(500, "没有对应账户");
        }
        return JsdzResult.build(200, "查找成功", list.get(0));
    }

    @Override
    public JsdzResult findById(Integer id) {
        return null;
    }

    @Override
    public JsdzResult findByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<JsdzBuyer> pages = buyerMapper.selectByExample(new JsdzBuyerExample());
        PageInfo<JsdzBuyer> pageInfo = new PageInfo<>(pages);
        return JsdzResult.build(200, "查询成功", pageInfo);
    }

    @Override
    public JsdzResult findAll() {
        JsdzBuyerExample example = new JsdzBuyerExample();
        List<JsdzBuyer> list = buyerMapper.selectByExample(example);
        return JsdzResult.build(200, "查询成功", list);
    }

    @Autowired
    private JsdzBuyerOrderMapper buyerOrderMapper;
    @Autowired
    private JmsTemplate jmsTemplate;

    @Value("${imgBaseUrl}")
    private String imgBaseUrl;

    @Resource(name = "orderTopic")
    private Destination orderTopic;

    @Override
    public String genOrder(final JsdzBuyerOrder buyerOrder) {
        Long id = IDUtils.genItemId();
        buyerOrder.setState(0);
        buyerOrder.setId(id);
        int flag = buyerOrderMapper.insert(buyerOrder);
        System.out.println("flag-->" + flag);
        //利用activemq发送消息
        if (flag == 1) {
            jmsTemplate.send(orderTopic, new MessageCreator() {
                @Override
                public Message createMessage(Session session) throws JMSException {
                    String toJson = JsonUtils.objectToJson(buyerOrder);
                    TextMessage message = session.createTextMessage(toJson);
                    System.out.println("message-->" + message);
                    return message;
                }
            });
            return "success";
        }
        try {
            int result = FastDFSUtils.deleteFile(buyerOrder.getPic());
            if (result == 0) {
                return "failed";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "failed";
    }
}
