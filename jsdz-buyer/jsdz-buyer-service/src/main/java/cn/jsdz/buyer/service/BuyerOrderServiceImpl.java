package cn.jsdz.buyer.service;

import cn.jsdz.buyer.interfaces.BuyerOrderService;
import cn.jsdz.common.utils.JsdzResult;
import cn.jsdz.manager.mapper.JsdzBuyerOrderMapper;
import cn.jsdz.manager.po.JsdzBuyer;
import cn.jsdz.manager.po.JsdzBuyerOrder;
import cn.jsdz.manager.po.JsdzBuyerOrderExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author:  Air
 * Date  :  2017-09-04.
 */
@Service
public class BuyerOrderServiceImpl implements BuyerOrderService {

    @Autowired
    private JsdzBuyerOrderMapper buyerOrderMapper;

    @Override
    public JsdzResult findByPage(String phone, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        JsdzBuyerOrderExample example = new JsdzBuyerOrderExample();
        JsdzBuyerOrderExample.Criteria criteria = example.createCriteria();
        System.out.println("pageNum-->" + pageNum);
        System.out.println("pageSize-->" + pageSize);
        System.out.println("phone-->" + phone);
        criteria.andBuyerIdEqualTo(phone);
        List<JsdzBuyerOrder> pages = buyerOrderMapper.selectByExample(example);
        PageInfo<JsdzBuyerOrder> pageInfo = new PageInfo<>(pages);
        return JsdzResult.build(200, "查询成功", pageInfo);
    }
}
