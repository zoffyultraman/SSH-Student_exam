package com.ite.smvcDemo.controller.stuTi;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ite.smvcDemo.common.vo.examStuTi.ExamStuTiVO;
import com.ite.smvcDemo.controller.base.JsonMapper;
import com.ite.smvcDemo.service.examStu.IStuTiService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping(value="/exam")
public class stuTiController {
	
	@Autowired
	private IStuTiService iStuTiService;
	
	
	
	

	//跳转返回到考试页面的方法
	@SuppressWarnings("unused")
	@RequestMapping(value="/Return",method={RequestMethod.POST,RequestMethod.GET})
	public String Return(HttpSession session,Model model,HttpServletRequest req)throws Exception{
		String subjectid=(String) session.getAttribute("subjectid");
		List<ExamStuTiVO> examStuTi=new ArrayList<ExamStuTiVO>();
		ExamStuTiVO examStuTiVO=new ExamStuTiVO();
		examStuTi=iStuTiService.findExamTi(subjectid,examStuTiVO);
		System.out.println("-----");
		System.out.println(examStuTi.size());
		System.out.println("-----");
		
		Integer subjectTotaltime=examStuTi.get(0).getExam_subject_totaltime();
		
		session.setAttribute("examStuTi", examStuTi);
		session.setAttribute("subjectTotaltime",examStuTi.get(0).getExam_subject_totaltime());
		session.setAttribute("subjectName", examStuTi.get(Integer.parseInt(subjectid)).getExam_ti_name());
		Map<Integer, Integer> Map=new HashMap<Integer, Integer>();
		Map<Integer, String>  keyMap=new HashMap<Integer, String>();
		for(int i=0;i<20;i++){
			Map.put(i, 0);
		}
		for(int j=0;j<20;j++){
			keyMap.put(j,"");
		}
		session.setAttribute("keyMap", keyMap);
		session.setAttribute("Map",Map);
		return "exam/examTest";
	}
	
	@RequestMapping(value="/ExamTest",method=RequestMethod.POST)
	public void EnterExam(Model model,HttpSession session,HttpServletRequest req,PrintWriter writer){
		String subjectid =req.getParameter("subjectid");
		session.setAttribute("subjectid", subjectid);
		writer.write("1");
		writer.flush();
		writer.close();
	}

	
	//根据左边按钮可以选择题目
	@SuppressWarnings({ "unchecked","unused" })
	@RequestMapping(value="/TiNumber",method=RequestMethod.POST)
	public void  ExamLast(Model model,HttpSession session,HttpServletRequest request, HttpServletResponse response,PrintWriter writer ) throws IOException{
		Integer TiId=Integer.parseInt(request.getParameter("TiId"));
		Integer nextTiId=Integer.parseInt(request.getParameter("nextTiId"));
		Integer TiNumber=Integer.parseInt(request.getParameter("TiNumber"));
		
		String  color=request.getParameter("color");
		List<ExamStuTiVO> examStuTiTest=(List<ExamStuTiVO>) session.getAttribute("examStuTi");
		
		String Answsers=examStuTiTest.get(TiId).getExam_ti_key();
		String topic=examStuTiTest.get(TiId).getExam_ti_name();
		String optiona=examStuTiTest.get(TiId).getExam_ti_optiona();
		String optionb=examStuTiTest.get(TiId).getExam_ti_optionb();
		String optionc=examStuTiTest.get(TiId).getExam_ti_optionc();
		String optiond=examStuTiTest.get(TiId).getExam_ti_optiond();
	
		Map<Integer, String> keyMap=(Map<Integer, String>) session.getAttribute("keyMap");
		
    	String Type=examStuTiTest.get(TiId).getExam_ti_type();
        System.out.println("我是选项类型");
        System.out.println(Type);
       
		String key=keyMap.get(TiId);
		System.out.println("---------------");
		
		ExamStuTiVO examStuTiVO=new ExamStuTiVO();
		examStuTiVO=examStuTiTest.get(TiId);
		String examStuTest=JsonMapper.getInstance().toJson(examStuTiVO);
		
        
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("examStuTiVO", examStuTest);
        jsonObject.put("key", key);
		jsonObject.put("eTiId", TiId);
		jsonObject.put("topic", topic);
		jsonObject.put("optiona", optiona);
		jsonObject.put("optionb", optionb);
		jsonObject.put("optionc", optionc);
		jsonObject.put("optiond", optiond);
		jsonObject.put("nextTiId", nextTiId);
		jsonObject.put("TiNumber", TiNumber);
		jsonObject.put("Type", Type);
		jsonObject.put("color", color);
		jsonObject.put("Answsers",Answsers);
		
		
		
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(jsonObject.toString());
		
		
	}
	
	
	
	//题目选项选择并保存数据的方法
	@SuppressWarnings({"unchecked" })
	@RequestMapping(value="/Answers",method=RequestMethod.POST)
	public void Answers(HttpServletRequest request,HttpSession session,HttpServletResponse response) throws IOException{
		
//		String color=request.getParameter("color");
		List<ExamStuTiVO> examStuTiTest=(List<ExamStuTiVO>) session.getAttribute("examStuTi");
		
		String Answers=request.getParameter("Answers");
		Integer idd=Integer.parseInt(request.getParameter("idd"));
		Map<Integer,Integer> map =(Map<Integer, Integer>) session.getAttribute("Map");
		Map<Integer, String> keyMap=(Map<Integer, String>) session.getAttribute("keyMap");
 		ExamStuTiVO examStuTiVO2=new ExamStuTiVO();
		System.out.println("选中选项："+Answers);
		System.out.println("本题正确答案："+examStuTiTest.get(idd).getExam_ti_key());
		if(Answers.equalsIgnoreCase(examStuTiTest.get(idd).getExam_ti_key())){
			examStuTiVO2.setExam_ti_point(examStuTiTest.get(idd).getExam_ti_point());
			map.put(idd,(Integer)examStuTiTest.get(idd).getExam_ti_point());
			keyMap.put(idd,Answers);  //插入答案，无论正确与否
			System.out.println(examStuTiTest.get(idd).getExam_ti_point());
			System.out.println("正确选项");
		}else{
			examStuTiVO2.setExam_ti_point(0);
			keyMap.put(idd,Answers);//插入答案，无论正确与否
			System.out.println("错误选项");
			map.put(idd, 0);
		}
		session.setAttribute("keyMap", keyMap);
    	session.setAttribute("map", map);
    	
    	Map<Integer, String> keyMap2=(Map<Integer, String>) session.getAttribute("keyMap");
    	String key = keyMap2.get(idd);
    	System.out.println(key);
    	JSONObject jsonObject=new JSONObject();
    	jsonObject.put("key", key);        
    	
		
		
	}
	

	
	
	
	//提交题目，计算总分
	@SuppressWarnings({ "unchecked" })
	@RequestMapping(value="/submit",method=RequestMethod.GET)
	public String  SubmitTi(HttpSession session,HttpServletResponse response) throws IOException{
		HashMap<Integer,Integer> map= (HashMap<Integer,Integer>) session.getAttribute("map");
	    
		int count=0;
//		System.out.println(map.values());
	    for(Integer a:map.keySet()){
	    	System.out.println(map.get(a));
	    if(map.get(a)!=null){
	    	count=count+(Integer)map.get(a);
	     }
	    }
		System.out.println(count);
		
		String subjectid=(String) session.getAttribute("subjectid");
		Integer stuid=(Integer) session.getAttribute("stuid");
		Integer subid=Integer.parseInt(subjectid);
		iStuTiService.updatePoint(count,subid,stuid);
		iStuTiService.updatestats(subid);
		
		
	    
		session.setAttribute("count", count);
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("count", count);
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(jsonObject.toString());
		
		
		return "exam/success";
		
	}
	
	//下一题的方法
	@SuppressWarnings({ "unchecked"})
	@RequestMapping(value="/nextTi",method=RequestMethod.POST)
	public void NextTi(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		Integer a=Integer.parseInt(request.getParameter("a"))-1;
		List<ExamStuTiVO> examStuTiTest=(List<ExamStuTiVO>) session.getAttribute("examStuTi");
		Map<Integer, String> keyMap=(Map<Integer, String>) session.getAttribute("keyMap");
		String topic=examStuTiTest.get(a).getExam_ti_name();
		String optiona=examStuTiTest.get(a).getExam_ti_optiona();
		String optionb=examStuTiTest.get(a).getExam_ti_optionb();
		String optionc=examStuTiTest.get(a).getExam_ti_optionc();
		String optiond=examStuTiTest.get(a).getExam_ti_optiond();
		String tiType=examStuTiTest.get(a).getExam_ti_type();
		String key=keyMap.get(a);
		System.out.println(tiType);
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("key", key);
		jsonObject.put("tiType", tiType);
		jsonObject.put("aa", a);
		jsonObject.put("topic", topic);
		jsonObject.put("optiona", optiona);
		jsonObject.put("optionb", optionb);
		jsonObject.put("optionc", optionc);
		jsonObject.put("optiond", optiond);
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(jsonObject.toString());
		
		
		
	}
	//切换到上一题
	@SuppressWarnings({ "unchecked" })
	@RequestMapping(value="/upTi",method=RequestMethod.POST)
	public void UpTi(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		Integer upa=Integer.parseInt(request.getParameter("upa"));
		List<ExamStuTiVO> examStuTiTest=(List<ExamStuTiVO>) session.getAttribute("examStuTi");
		
		String topic=examStuTiTest.get(upa).getExam_ti_name();
		String optiona=examStuTiTest.get(upa).getExam_ti_optiona();
		String optionb=examStuTiTest.get(upa).getExam_ti_optionb();
		String optionc=examStuTiTest.get(upa).getExam_ti_optionc();
		String optiond=examStuTiTest.get(upa).getExam_ti_optiond();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("aa", upa);
		jsonObject.put("topic", topic);
		jsonObject.put("optiona", optiona);
		jsonObject.put("optionb", optionb);
		jsonObject.put("optionc", optionc);
		jsonObject.put("optiond", optiond);
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(jsonObject.toString());
		
		
		
	}
	
}
