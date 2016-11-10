package com.ning.mapper;

import com.ning.dao.Tool;
import com.ning.dao.ToolExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ToolMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tools
     *
     * @mbggenerated
     */
    int countByExample(ToolExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tools
     *
     * @mbggenerated
     */
    @Delete({
        "delete from tools",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tools
     *
     * @mbggenerated
     */
    @Insert({
        "insert into tools (id, type, tool_name, ",
        "tool_icon, tool_url, ",
        "create_time, update_time, ",
        "create_person)",
        "values (#{id,jdbcType=INTEGER}, #{type,jdbcType=CHAR}, #{toolName,jdbcType=VARCHAR}, ",
        "#{toolIcon,jdbcType=VARCHAR}, #{toolUrl,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{createPerson,jdbcType=VARCHAR})"
    })
    int insert(Tool record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tools
     *
     * @mbggenerated
     */
    int insertSelective(Tool record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tools
     *
     * @mbggenerated
     */
    List<Tool> selectByExample(ToolExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tools
     *
     * @mbggenerated
     */
    @Select({
        "select",
        "id, type, tool_name, tool_icon, tool_url, create_time, update_time, create_person",
        "from tools",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    Tool selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tools
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Tool record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tools
     *
     * @mbggenerated
     */
    @Update({
        "update tools",
        "set type = #{type,jdbcType=CHAR},",
          "tool_name = #{toolName,jdbcType=VARCHAR},",
          "tool_icon = #{toolIcon,jdbcType=VARCHAR},",
          "tool_url = #{toolUrl,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "create_person = #{createPerson,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Tool record);
}