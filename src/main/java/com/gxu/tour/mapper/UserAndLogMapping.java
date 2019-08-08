package com.gxu.tour.mapper;

import com.gxu.tour.entity.FromTerminal;
import com.gxu.tour.entity.Sex;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserAndLogMapping {

    // 查询当月的访问来源统计数据
    public FromTerminal getFromTerminalStatistic();

    /**
     * 更新访问来源数据
     *
     * @param choose true:更新当月的数据
     *               false:重新统计，更新全部数据。
     * @return 返回影响的行数
     */
    public int refreshFromTerminalStatistic(@Param("choose") boolean choose);


    public List<Sex> getSexByMonthStatistic();


    public int refreshSexByMonthStatistic();
}
