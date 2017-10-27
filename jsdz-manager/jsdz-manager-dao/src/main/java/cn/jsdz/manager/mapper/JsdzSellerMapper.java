package cn.jsdz.manager.mapper;

import cn.jsdz.manager.po.JsdzSeller;
import cn.jsdz.manager.po.JsdzSellerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JsdzSellerMapper {
    int countByExample(JsdzSellerExample example);

    int deleteByExample(JsdzSellerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(JsdzSeller record);

    int insertSelective(JsdzSeller record);

    List<JsdzSeller> selectByExample(JsdzSellerExample example);

    JsdzSeller selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") JsdzSeller record, @Param("example") JsdzSellerExample example);

    int updateByExample(@Param("record") JsdzSeller record, @Param("example") JsdzSellerExample example);

    int updateByPrimaryKeySelective(JsdzSeller record);

    int updateByPrimaryKey(JsdzSeller record);
}