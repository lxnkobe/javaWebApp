package com.ning.services;

import com.ning.dao.Tool;
import com.xiaomi.platform.xmybatis.plugins.Pagination;

import java.util.List;

/**
 * Created by ning on 2016-11-10.
 */


public interface IToolService {
     List<Tool> getTools();

     List<Tool> getToolsbyPage(Pagination page, Tool tool);

     void insertTool(Tool tool, String user) throws Exception;

     int deleteTool(Integer id);

     Integer updateTool(Tool tool);

     Tool getTool(Integer id);
}
