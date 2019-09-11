package com.gxu.tour.LFM;

import com.gxu.tour.entity.Log;
import com.gxu.tour.entity.Route;
import com.gxu.tour.entity.RouteCount;
import com.gxu.tour.entity.Scene;
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

//    List<Log> list=lfmMapper.getSceneData();
//        System.out.println(list.size());

        List<Scene> list=lfmService.getSceneByTop();
        for(Scene scene:list)
            System.out.println(scene.getSceneName());
    }


}
