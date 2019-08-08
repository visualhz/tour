package com.gxu.tour.service;

import com.gxu.tour.entity.FromTerminal;
import com.gxu.tour.entity.Sex;

import java.util.List;

public interface UserAndLogService {

    //返回当月访问来源数据
    public FromTerminal getFormTerminalStatistic();

    //更新访问来源数据
    public int refreshFromTerminalStatistic();

    public List<Sex> getSexByMonthStatistic();

    public int refreshSexByMonthStatistic();
}
