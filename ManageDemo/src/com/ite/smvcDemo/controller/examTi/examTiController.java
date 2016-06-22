package com.ite.smvcDemo.controller.examTi;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ite.smvcDemo.common.page.PagerModel;
import com.ite.smvcDemo.common.vo.ti.TiVO;
import com.ite.smvcDemo.common.vo.tidifficulty.TidifficultyVO;
import com.ite.smvcDemo.common.vo.titype.TiTypeVO;
import com.ite.smvcDemo.entity.ExamTi;
import com.ite.smvcDemo.service.ti.ITiService;
import com.ite.smvcDemo.service.tidifficulty.IDifficultyService;
import com.ite.smvcDemo.service.titype.ITitype;

@Controller
@RequestMapping("/ti")	
public class examTiController {

	@Autowired
	private ITiService iTiService;
	
	@Autowired
	private IDifficultyService iDifficultyService;
	
	@Autowired
	private ITitype iTitype;
	
	
	@RequestMapping(value="/Ti",method={RequestMethod.GET,RequestMethod.POST})
	public String TiList(Model model,ExamTi examTi){
		PagerModel<TiVO> page =iTiService.findAllByPage();
		
		model.addAttribute("page",page);
		return "ti/tiList";
	}
	
	@RequestMapping(value="/TiDelete/{examTiId}",method={RequestMethod.GET})
	public String TiDelete(@PathVariable String examTiId,RedirectAttributes redirectAttributes){
		ExamTi examTi=new ExamTi();
		examTi.setExamTiId(new Integer(examTiId));
		iTiService.delete(examTi);
		redirectAttributes.addFlashAttribute("message", "Delete successfully. ");
		return "redirect:/ti/Ti";
	}
	//题目难度外键表
	protected Map<Integer,String> getDifficulty() throws Exception {
		Map<Integer,String> DifficultyLabel = new HashMap<Integer,String>();
		List<TidifficultyVO> list = iDifficultyService.findAll();
//		System.out.println(list.get(1).getExamTiDifficultyName());
		for(TidifficultyVO tidifficultyVO : list){
			DifficultyLabel.put(tidifficultyVO.getExamTiDifficulty(), tidifficultyVO.getExamTiDifficultyName());
		}
		return DifficultyLabel;
	}
	//题目类型外检表
	protected Map<Integer , String > getType() throws Exception {
		Map<Integer, String > TypeLabel=new HashMap<Integer,String>();
		List<TiTypeVO> list=iTitype.findAll();
		for(TiTypeVO tiTypeVO:list){
			TypeLabel.put(tiTypeVO.getExamTiType(), tiTypeVO.getExamTiTypeName());
		}
		return TypeLabel;
	}
	
	@RequestMapping(value="/tiAdd" ,method={RequestMethod.GET})
	public String StudentAdd(Model model) throws Exception{
		TiVO tiVO=new TiVO();
		model.addAttribute("tiVO", tiVO);
    	Map<Integer, String>  Type=this.getType();
     	Map<Integer, String> difficult=this.getDifficulty();
		model.addAttribute("tiDifficulty", difficult);
		model.addAttribute("tiType",Type);
		return "ti/tiAdd";
	}
	
	@RequestMapping(value="/TiAdd" ,method={RequestMethod.POST})
	public String TiSava(@Validated TiVO tiVO,BindingResult bindingResult,RedirectAttributes redirectAttributes){
		if(bindingResult.hasErrors()){
			return "ti/tiAdd";
		}
		ExamTi examTi=new ExamTi();
		BeanUtils.copyProperties(tiVO, examTi);
		System.out.println(tiVO.getExamTiName());
		iTiService.save(examTi);
		redirectAttributes.addFlashAttribute("message", "Add successfully. ");
		return "redirect:/ti/Ti";
	}
	
	@RequestMapping(value="/TiEdit/{examTiId}",method=RequestMethod.GET)
	public String TiEdit(@PathVariable String examTiId,Model model) throws Exception{
		TiVO tiVO=new TiVO();
		tiVO.setExamTiId(new Integer(examTiId));
		tiVO=iTiService.findByKey(tiVO);
		model.addAttribute("tiVO",tiVO);
		return "/ti/tiEdit";
	}
	
	@RequestMapping(value="/TiEdit/{examTiId}",method=RequestMethod.POST)
	public String TiUpdate(@PathVariable String examTiId,@Validated TiVO tiVO,BindingResult bindingResult,RedirectAttributes redirectAttributes){
		if(bindingResult.hasErrors()){
			return "ti/tiEdit";
		}
		TiVO tiVO2=iTiService.findByKey(tiVO);
		ExamTi ti = new ExamTi();
		tiVO2.setExamSubjectId(tiVO.getExamSubjectId());
		tiVO2.setExamTiName(tiVO.getExamTiName());
		tiVO2.setExamTiOptiona(tiVO.getExamTiOptiona());
		tiVO2.setExamTiOptiona(tiVO.getExamTiOptionb());
		tiVO2.setExamTiOptiona(tiVO.getExamTiOptionc());
		tiVO2.setExamTiOptiona(tiVO.getExamTiOptiond());
		tiVO2.setExamTiKey(tiVO.getExamTiKey());
		tiVO2.setExamTiPoint(tiVO.getExamTiPoint());
		tiVO2.setExamTiDifficulty(tiVO.getExamTiDifficulty());
		tiVO2.setExamTiType(tiVO.getExamTiType());
		BeanUtils.copyProperties(tiVO2, ti);
		iTiService.update(ti);
		redirectAttributes.addFlashAttribute("message", "Update successfully. ");
		return "redirect:/ti/Ti";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
