package com.gxu.tour.LFM;

import com.gxu.tour.entity.Route;
import com.gxu.tour.entity.RouteCount;
import com.gxu.tour.mapper.LfmMapper;
import com.gxu.tour.service.LfmService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName LfmMain
 * @Description TODO
 * @Author LLM
 * @Date 2019/8/29 17:27
 * @Version 1.0
 **/

@RunWith(SpringRunner.class)
@SpringBootTest
public class LfmMain {
    @Autowired
    private LfmMapper lfmMapper;
    @Autowired
    private LfmService lfmService;


    @Test
    public void getData()
    {

//        String[] datas= lfmService.getRouteRecID("103404");
//        for(int i=0;i<datas.length;i++)
//            System.out.println(datas[i].trim());
        List<Route> list=new ArrayList<Route>();
        list=lfmService.getRouteByTop();
        for(Route value:list)
            System.out.println(value.getRouteName());
    }


}
