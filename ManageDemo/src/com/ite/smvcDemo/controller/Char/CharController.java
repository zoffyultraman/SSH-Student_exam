package com.ite.smvcDemo.controller.Char;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ite.smvcDemo.common.vo.Char.CharVO;
import com.ite.smvcDemo.service.Char.ICharService;

import net.sf.json.JSONObject;


@Controller
@RequestMapping(value="/charP")
public class CharController {
	
	@Autowired
	private ICharService CharSevice;
	
	@RequestMapping(value="/Char", method= {RequestMethod.GET , RequestMethod.POST})
	public String CharList(){
		return "CharL/charList";
	}
	
	
	
	  @RequestMapping(value="/charD",method=RequestMethod.POST)
      public void CharFind(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException{
		  List<CharVO> charVO=CharSevice.findChar();
		  JSONObject jsonObject = new JSONObject();
			for(int i=0;i<charVO.size();i++){
				if(charVO.get(i).getArea().equals("珠海市")){
					jsonObject.put("zhuhai", charVO.get(i).getNum());
					jsonObject.put("zhuhaiName", charVO.get(i).getCompany());
				}else if(charVO.get(i).getArea().equals("市辖市")){
					jsonObject.put("shixia", charVO.get(i).getNum());
					jsonObject.put("shixiaName", charVO.get(i).getCompany());
				}else if(charVO.get(i).getArea().equals("香洲区")){
					jsonObject.put("xiangzhou", charVO.get(i).getNum());
					jsonObject.put("xiangzhouName", charVO.get(i).getCompany());
				}else if(charVO.get(i).getArea().equals("斗门区")){
					jsonObject.put("doumen", charVO.get(i).getNum());
					jsonObject.put("doumenName", charVO.get(i).getCompany());
				}else if(charVO.get(i).getArea().equals("金湾区")){
					jsonObject.put("jinwan", charVO.get(i).getNum());
					jsonObject.put("jinwanName", charVO.get(i).getCompany());
				}
			}
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(jsonObject.toString());
    	  
      }
}
