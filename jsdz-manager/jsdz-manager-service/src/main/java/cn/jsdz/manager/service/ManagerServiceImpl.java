package cn.jsdz.manager.service;

import java.util.Date;
import java.util.List;

import cn.jsdz.common.utils.IDUtils;
import cn.jsdz.common.utils.JsdzResult;
import cn.jsdz.common.utils.Md5Utils;
import cn.jsdz.manager.mapper.JsdzManagerMapper;
import cn.jsdz.manager.po.JsdzManagerExample;
import cn.jsdz.manager.po.JsdzManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jsdz.manager.interfaces.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private JsdzManagerMapper managerMapper;

    @Override
    public JsdzResult register(JsdzManager manager) {
        JsdzManagerExample example = new JsdzManagerExample();
        JsdzManagerExample.Criteria criteria = example.createCriteria();
        //验证手机号唯一性
        criteria.andUsernameEqualTo(manager.getUsername());
        List<JsdzManager> list = managerMapper.selectByExample(example);
        if(list.size() > 0){
            return JsdzResult.build(500, "用户名已经注册");
        }
        //清理criteria
        example.clear();
        String md5Pwd = Md5Utils.MD5Encode(manager.getPassword(), "utf-8", false);
        String bName = IDUtils.genUserId();
        //生成随机数nickname
        manager.setPassword(md5Pwd);
        manager.setCreateTime(new Date());
        manager.setUpdateTime(new Date());
        manager.setRole(3);
        return JsdzResult.build(200, "注册成功");
    }

    @Override
    public JsdzResult login(JsdzManager manager) {
        JsdzManagerExample example = new JsdzManagerExample();
        JsdzManagerExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(manager.getUsername());
        List<JsdzManager> list = managerMapper.selectByExample(example);
        //验证用户名是否存在
        //不存在
        if(list == null || list.size() == 0){
            return JsdzResult.build(500, "用户不存在，请确认后输入");
            //存在
        }else {
            JsdzManager m1 = list.get(0);
            //验证密码正确
            //不正确
            String md5Pwd = Md5Utils.MD5Encode(manager.getPassword(), "utf-8", false);
            if(!md5Pwd.equals(m1.getPassword())){
                return JsdzResult.build(500, "密码错误，请核实后在输入");
                //正确 登陆成功
            }else {
                return JsdzResult.build(200, "登录成功",m1);
            }
        }
    }
}
