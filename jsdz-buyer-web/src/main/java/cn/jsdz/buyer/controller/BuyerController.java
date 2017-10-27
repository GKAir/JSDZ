package cn.jsdz.buyer.controller;

import cn.jsdz.buyer.interfaces.BuyerService;
import cn.jsdz.common.utils.FastDFSUtils;
import cn.jsdz.common.utils.JsdzResult;
import cn.jsdz.common.utils.JsonUtils;
import cn.jsdz.manager.po.JsdzBuyerOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.jsdz.manager.po.JsdzBuyer;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping("/buyer")
public class BuyerController {
    @Autowired
    private BuyerService buyerService;

    /**
     * 用户认证表单提交
     * @param buyer
     * @return
     */
    @RequestMapping("/authentication")
    @ResponseBody
    public JsdzResult authentication(JsdzBuyer buyer) {
        if (buyer == null) {
            return JsdzResult.build(500, "提交失败，请重新检查表格再提交");
        }
        return buyerService.authentication(buyer);
    }

    @Value("${imgBaseUrl}")
    private String imgBaseUrl;

    //生成订单
    @RequestMapping(value = "/genOrder", method = RequestMethod.POST)
    @ResponseBody
    public String genOrder(@RequestParam(value = "file", required = false) MultipartFile file, JsdzBuyerOrder buyerOrder, HttpServletResponse response) throws IOException {
        String typeId = buyerOrder.getTypeId();
        String thickId = buyerOrder.getThickId();
        String province = buyerOrder.getProvince();
        String city = buyerOrder.getCity();
        String district = buyerOrder.getDistrict();
        response.setContentType("text/html; charset=UTF-8"); //转码
        PrintWriter out = response.getWriter();
        //验证厚度：厚度都得有
        if (thickId == null || thickId.equals("请选择")) {
            out.flush();
            out.println("<script>");
            out.println("alert('厚度不能为空');");
            out.println("history.back();");
            out.println("</script>");
            return null;
        }
        //验证省市区
        System.out.println("1" + province);
        System.out.println("2" + city);
        System.out.println("3" + district);
        if (province == null || city == null || province.equals("") || city.equals("")) {
            out.flush();
            out.println("<script>");
            out.println("alert('收货地址书写不正确！');");
            out.println("history.back();");
            out.println("</script>");
            return null;
        }
        //验证特定类型的耐磨层厚度
        if (typeId.equals("1") || typeId.equals("2") || typeId.equals("4")) {
            if (buyerOrder.getNmcThickId() == null || buyerOrder.getNmcThickId().equals("请选择")) {
                out.flush();
                out.println("<script>");
                out.println("alert('耐磨层厚度未选择！');");
                out.println("history.back();");
                out.println("</script>");
                return null;
            }
        }
        System.out.println("file-->" + file);
        Map<String, Object> map = new HashMap<>();
        //验证图片上传
        if (file == null) {
            out.flush();
            out.println("<script>");
            out.println("alert('图片不能为空！');");
            out.println("history.back();");
            out.println("</script>");
            return null;
        }
        String originalFilename = file.getOriginalFilename();
        //图片文件名验证
        if (StringUtils.isEmpty(originalFilename)) {
            out.flush();
            out.println("<script>");
            out.println("alert('上传图片不能为空！');");
            out.println("history.back();");
            out.println("</script>");
            return null;
        }
        //获取图片扩展名
        String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        //图片格式验证
        if (!(extName.toUpperCase().contains("JPG") || (extName.toUpperCase().contains("PNG") || (extName.toUpperCase().contains("PNG"))))) {
            out.flush();
            out.println("<script>");
            out.println("alert('上传文件必须为JPG、PNG或者GIF格式！');");
            out.println("history.back();");
            out.println("</script>");
            return null;
        }
        //上传指定文件，并获得上传路径
        try {
            response.reset();
            response.setContentType("text/html; charset=UTF-8"); //转码
            String imgUrl = FastDFSUtils.uploadFile(file.getBytes(), extName);
            String url = imgBaseUrl + imgUrl;
            System.out.println(url);
            buyerOrder.setPic(url);
            String result = buyerService.genOrder(buyerOrder);
            if (result.equals("success")) {
                out.flush();
                out.println("<script>");
                out.println("alert('订单生成成功！');");
                out.println("location.href='https://www.baidu.com/'");
                out.println("</script>");
                return null;
            } else {
                out.flush();
                out.println("<script>");
                out.println("alert('订单提交失败！');");
                out.println("history.back();");
                out.println("</script>");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setContentType("text/html; charset=UTF-8"); //转码
            out.flush();
            out.println("<script>");
            out.println("alert('上传图片失败，请稍后再试！');");
            out.println("history.back();");
            out.println("</script>");
            return null;
        }
    }

    @RequestMapping("genData")
    public void genData() {
        JsdzBuyerOrder buyerOrder = new JsdzBuyerOrder();
        buyerOrder.setBuyerId("15114565130");
        buyerOrder.setTypeId("1");
        buyerOrder.setThickId("2");
        buyerOrder.setNmcThickId("1");
        buyerOrder.setBack(1);
        buyerOrder.setRequireTime(3);
        buyerOrder.setProvince("北京");
        buyerOrder.setCity("北京");
        buyerOrder.setDistrict("紫禁城");
        buyerOrder.setArea(20F);
        int i = 0;
        while (i < 200) {
            buyerService.genOrder(buyerOrder);
            i++;
        }
    }
}
