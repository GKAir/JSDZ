package cn.jsdz.seller.service;

import cn.jsdz.common.utils.JsdzResult;
import cn.jsdz.common.utils.Md5Utils;
import cn.jsdz.manager.mapper.JsdzSellerMapper;
import cn.jsdz.manager.mapper.JsdzSellerOrderMapper;
import cn.jsdz.manager.po.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jsdz.seller.interfaces.SellerService;

import java.util.Date;
import java.util.List;

@Service
public class SellerServiceImpl implements SellerService {
    @Autowired
    private JsdzSellerMapper sellerMapper;

    //用户注册
    @Override
    public JsdzResult register(JsdzSeller seller) {
        JsdzSellerExample example = new JsdzSellerExample();
        JsdzSellerExample.Criteria criteria = example.createCriteria();
        //验证手机号唯一性
        criteria.andPhoneEqualTo(seller.getPhone());
        List<JsdzSeller> list = sellerMapper.selectByExample(example);
        if (list.size() > 0) {
            return JsdzResult.build(500, "手机号已经注册");
        }
        //清理criteria
        example.clear();
        //利用工具类对密码加密
        String md5Pwd = Md5Utils.MD5Encode(seller.getPassword(), "utf-8", false);
        seller.setPassword(md5Pwd);
        seller.setCreateTime(new Date());
        seller.setUpdateTime(new Date());
        seller.setIsDelete(0);
        seller.setIsVip(0);
        return JsdzResult.build(200, "注册成功");
    }

    //用户登录
    @Override
    public JsdzResult login(JsdzSeller seller) {
        JsdzSellerExample example = new JsdzSellerExample();
        JsdzSellerExample.Criteria criteria = example.createCriteria();
        criteria.andPhoneEqualTo(seller.getPhone());
        List<JsdzSeller> list = sellerMapper.selectByExample(example);
        //验证用户名是否存在
        //不存在
        if (list == null || list.size() == 0) {
            return JsdzResult.build(500, "手机号不存在，请确认后输入");
            //存在
        } else {
            JsdzSeller b1 = list.get(0);
            //验证密码正确
            //不正确
            String md5Pwd = Md5Utils.MD5Encode(seller.getPassword(), "utf-8", false);
            if (!md5Pwd.equals(b1.getPassword())) {
                return JsdzResult.build(500, "密码错误，请核实后在输入");
                //正确 登陆成功
            } else {
                return JsdzResult.build(200, "登录成功", b1);
            }
        }
    }

    @Override
    public JsdzResult authentication(JsdzSeller seller) {
        int flag = sellerMapper.updateByPrimaryKey(seller);
        if (flag == 1) {
            return JsdzResult.build(200, "提交成功，后台审核中，请耐心等待");
        }
        return JsdzResult.build(500, "认证异常，请重新填写表格");
    }

    @Autowired
    private JsdzSellerOrderMapper sellerOrderMapper;

    @Override
    public JsdzResult sendMsg(JsdzBuyerOrder buyerOrder) {
        JsdzSellerOrderExample example = new JsdzSellerOrderExample();
        JsdzSellerOrderExample.Criteria criteria = example.createCriteria();
        criteria.andTypeIdEqualTo(buyerOrder.getTypeId());
        List<JsdzSellerOrder> list = sellerOrderMapper.selectByExample(example);

        for (JsdzSellerOrder sellerOrder : list) {
            System.out.println(sellerOrder.getBuyerOrderId());
        }
        return null;
    }
}
