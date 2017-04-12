package com.coco.controller;

import com.coco.pojo.TbArticle;
import com.coco.pojo.TbSlider;
import com.coco.service.ArticleService;
import com.coco.service.SliderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 页面跳转controller
 * <p>Title: PageController</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.com</p> 
 * @author	入云龙
 * @date	2015年9月2日上午11:11:41
 * @version 1.0
 */
@Controller
public class PageController {

	@Autowired
	private ArticleService articleService;
	@Autowired
	private SliderService sliderService;

	/**
	 * 打开首页
	 */
	@RequestMapping("/")
	public String showIndexController(Model model) {
		boolean isPaging = true;
		List<TbArticle> list = articleService.getArticleTitleList(isPaging);
		List<TbSlider> sliders = sliderService.getSliderList();
		model.addAttribute("sliders",sliders);
		model.addAttribute("list",list);
		return "index";
	}

	/**
	 * 展示其他页面
	 * <p>Title: showpage</p>
	 * <p>Description: </p>
	 * @param page
	 * @return
	 */
	@RequestMapping("/manager/{page}")
	public String showManagerPage(@PathVariable String page) {
		return "/manager/" + page;
	}

	@RequestMapping("/doctor/{page}")
	public String showDoctorPage(@PathVariable String page) {
		return "/doctor/" + page;
	}

	@RequestMapping("/{page}")
	public String showManagerpage(@PathVariable String page) {
		return page;
	}

	@RequestMapping("/user/{page}")
	public String showUserpage(@PathVariable String page){
		return "/user/" + page;
	}

	@RequestMapping("/report/{page}")
	public String showReportPage(@PathVariable String page){
		return "/report/" + page;
	}
}
