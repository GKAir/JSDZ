package cn.jsdz.buyer.controller;

import cn.jsdz.common.utils.FastDFSUtils;
import cn.jsdz.common.utils.JsdzResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * Author:  Air
 * Date  :  2017-07-28.
 */
@Controller
@RequestMapping("/pic")
public class PicController {

    @Value("${imgBaseUrl}")
    private String imgBaseUrl;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public JsdzResult upload(@RequestParam(value = "testfile", required = false) MultipartFile file, HttpServletRequest request) {
        if (file == null) {
            return JsdzResult.build(500, "上传文件不能为空");
        }
        String originalFilename = file.getOriginalFilename();
        System.out.println("originalFilename-->" + originalFilename);
        if (StringUtils.isEmpty(originalFilename)) {
            return JsdzResult.build(500, "上传文件名不能为空");
        }
        String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        if (!(extName.toUpperCase().equals("JPG") || extName.toUpperCase().equals("PNG"))) {
            return JsdzResult.build(500, "上传文件必须为JPG或者PNG格式");
        }
        //上传指定文件，并获得上传路径
        try {
            String imgUrl = FastDFSUtils.uploadFile(file.getBytes(), extName);
            String url = imgBaseUrl + imgUrl;
            System.out.println(url);
            return JsdzResult.build(200, "上传成功", url);
        } catch (Exception e) {
            e.printStackTrace();
            return JsdzResult.build(500, "上传异常，请重试", e.getMessage());
        }
    }
}
