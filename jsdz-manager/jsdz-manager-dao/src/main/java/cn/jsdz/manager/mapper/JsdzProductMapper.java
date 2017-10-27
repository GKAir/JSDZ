package cn.jsdz.manager.mapper;

import cn.jsdz.manager.po.JsdzProduct;
import cn.jsdz.manager.po.JsdzProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JsdzProductMapper {
    int countByExample(JsdzProductExample example);

    int deleteByExample(JsdzProductExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(JsdzProduct record);

    int insertSelective(JsdzProduct record);

    List<JsdzProduct> selectByExample(JsdzProductExample example);

    JsdzProduct selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") JsdzProduct record, @Param("example") JsdzProductExample example);

    int updateByExample(@Param("record") JsdzProduct record, @Param("example") JsdzProductExample example);

    int updateByPrimaryKeySelective(JsdzProduct record);

    int updateByPrimaryKey(JsdzProduct record);
}