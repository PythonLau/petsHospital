package com.coco.mapper;

import com.coco.pojo.TbFlowAchievementReport;
import com.coco.pojo.TbFlowAchievementReportExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbFlowAchievementReportMapper {
    int countByExample(TbFlowAchievementReportExample example);

    int deleteByExample(TbFlowAchievementReportExample example);

    int insert(TbFlowAchievementReport record);

    int insertSelective(TbFlowAchievementReport record);

    List<TbFlowAchievementReport> selectByExample(TbFlowAchievementReportExample example);

    int updateByExampleSelective(@Param("record") TbFlowAchievementReport record, @Param("example") TbFlowAchievementReportExample example);

    int updateByExample(@Param("record") TbFlowAchievementReport record, @Param("example") TbFlowAchievementReportExample example);
}