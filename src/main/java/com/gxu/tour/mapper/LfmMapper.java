package com.gxu.tour.mapper;


import com.gxu.tour.entity.Log;
import com.gxu.tour.entity.Route;
import com.gxu.tour.entity.RouteCount;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Ceate By LLM 2019 08-29
 * Function: 日志数据操作
 */

@Repository
public interface LfmMapper {

    //获取最近一年的路线组合产品日志数据
    public List<Log> getLfmData();

    //根据路线组合产品ID，获取具体信息
    public Route getRouteRecById(@Param("routeID") String routeID);

    //获取前10的路线组合产品ID和名称
    public List<RouteCount> getRouteByTop();
}
