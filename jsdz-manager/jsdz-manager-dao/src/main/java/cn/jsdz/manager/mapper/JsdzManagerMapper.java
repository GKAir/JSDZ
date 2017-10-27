package cn.jsdz.manager.mapper;

import cn.jsdz.manager.po.JsdzManager;
import cn.jsdz.manager.po.JsdzManagerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JsdzManagerMapper {
    int countByExample(JsdzManagerExample example);

    int deleteByExample(JsdzManagerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(JsdzManager record);

    int insertSelective(JsdzManager record);

    List<JsdzManager> selectByExample(JsdzManagerExample example);

    JsdzManager selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") JsdzManager record, @Param("example") JsdzManagerExample example);

    int updateByExample(@Param("record") JsdzManager record, @Param("example") JsdzManagerExample example);

    int updateByPrimaryKeySelective(JsdzManager record);

    int updateByPrimaryKey(JsdzManager record);
}