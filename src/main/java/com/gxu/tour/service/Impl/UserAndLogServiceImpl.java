package com.gxu.tour.service.Impl;

import com.gxu.tour.entity.FromTerminal;
import com.gxu.tour.entity.Sex;
import com.gxu.tour.mapper.UserAndLogMapping;
import com.gxu.tour.service.UserAndLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.List;


@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class UserAndLogServiceImpl implements UserAndLogService {
    Calendar calendar = Calendar.getInstance();
    // 返回更新影响的行数
    int affect;
    @Autowired
    UserAndLogMapping userAndLogMapping;

    /**
     * 获取访问来源数据
     *
     * @return 返回当月访问来源数据
     */
    @Override
    public FromTerminal getFormTerminalStatistic() {
        // 默认为0。
        affect = 0;
        FromTerminal fromTerminalStatistic = userAndLogMapping.getFromTerminalStatistic();

        //获取当前年月
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
//        System.out.println(year + "," + month);

        //判断查询的数据是否为空，是则执行，是否为当前年月，不是则执行。
        if (fromTerminalStatistic == null || fromTerminalStatistic.getYear() != year || fromTerminalStatistic.getMonth() != month) {
            //统计当月的统计数据，并添加到结果表中
            affect = userAndLogMapping.refreshFromTerminalStatistic(true);
//            System.out.println(affect);
            //判断是否由数据更新，无数据更新则返回0，否则再次查询数据库获取最新数据返回。
            if (affect == 0)
                return new FromTerminal(year, month, 0, 0, 0);
            else
                return userAndLogMapping.getFromTerminalStatistic();
        }
        return fromTerminalStatistic;
    }

    //重新统计数据
    @Override
    public int refreshFromTerminalStatistic() {
        return userAndLogMapping.refreshFromTerminalStatistic(false);
    }

    @Override
    public List<Sex> getSexByMonthStatistic() {
        List<Sex> sexByMonthStatistic = userAndLogMapping.getSexByMonthStatistic();
        return sexByMonthStatistic;
    }

    @Override
    public int refreshSexByMonthStatistic() {
        return userAndLogMapping.refreshSexByMonthStatistic();
    }
}
