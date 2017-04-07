package com.coco.service.impl;

import com.coco.mapper.TbSliderMapper;
import com.coco.pojo.TbSlider;
import com.coco.pojo.TbSliderExample;
import com.coco.service.SliderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/4/8 0008.
 */
@Service
public class SliderServiceImpl implements SliderService {
    @Autowired
    private TbSliderMapper sliderMapper;
    public List<TbSlider> getSliderList(){
        TbSliderExample sliderExample = new TbSliderExample();
        List<TbSlider> sliders = sliderMapper.selectByExample(sliderExample);
        return sliders;
    }
}
