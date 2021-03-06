package com.ning.mapper;


import com.ning.domain.BlogSubtype;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogSubtypeMapper {
    int deleteByPrimaryKey(Short id);

    int insert(BlogSubtype record);

    int insertSelective(BlogSubtype record);

    BlogSubtype selectByPrimaryKey(Short id);

    int updateByPrimaryKeySelective(BlogSubtype record);

    int updateByPrimaryKey(BlogSubtype record);

    List<BlogSubtype> getsublist(@Param("type") int type);

}