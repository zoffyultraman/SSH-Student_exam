package com.ite.smvcDemo.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ite.smvcDemo.common.vo.user.UsersVO;

public class ExcelUtil {

	
	public List<UsersVO> readExcel(String path) throws IOException {
          if (path == null || Common.EMPTY.equals(path)) {
              return null;
          } else {
              String postfix = getPostfix(path);
              if (!Common.EMPTY.equals(postfix)) {
                  if (Common.OFFICE_EXCEL_2003_POSTFIX.equals(postfix)) {
                      return readXls(path);
                  } else if (Common.OFFICE_EXCEL_2010_POSTFIX.equals(postfix)) {
                      return readXlsx(path);
                  }
              } else {
                  System.out.println(path + Common.NOT_EXCEL_FILE);
              }
         }
          return null;
      }
	
	/**
	       * Read the Excel 2010
	       * @param path the path of the excel file
	       * @return
	       * @throws IOException
	       */
	      @SuppressWarnings("resource")
		public List<UsersVO> readXlsx(String path) throws IOException {
	          System.out.println(Common.PROCESSING + path);
	          InputStream is = new FileInputStream(path);
	          XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
	          UsersVO usersVO = null;
	          List<UsersVO> list = new ArrayList<UsersVO>();
	          // Read the Sheet
	          for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
	              XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
	              if (xssfSheet == null) {
	                  continue;
	              }
	              // Read the Row
	              for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
	                  XSSFRow xssfRow = xssfSheet.getRow(rowNum);
	                  if (xssfRow != null) {
	                	  usersVO = new UsersVO();
	                      XSSFCell userName = xssfRow.getCell(0);
	                      XSSFCell password = xssfRow.getCell(1);
	                      XSSFCell age = xssfRow.getCell(2);
	                      XSSFCell sex = xssfRow.getCell(3);
	                      XSSFCell email = xssfRow.getCell(4);
	                      XSSFCell remark = xssfRow.getCell(5);
	                      
	                      usersVO.setUserName(getValue(userName));
	                      usersVO.setPassword(getValue(password));
	                      usersVO.setAge(new Integer(getValue(age)));
	                      usersVO.setSex(getValue(sex));
	                      usersVO.setEmail(getValue(email));
	                      usersVO.setRemark(getValue(remark));
	                      
	                      list.add(usersVO);
	                  }
	              }
	          }
	          return list;
	      }
	 
	 
		/**
       * Read the Excel 2003-2007
       * @param path the path of the Excel
       * @return
       * @throws IOException
       */
      @SuppressWarnings("resource")
	public List<UsersVO> readXls(String path) throws IOException {
         System.out.println(Common.PROCESSING + path);
         InputStream is = new FileInputStream(path);
         HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
         UsersVO usersVO = null;
         List<UsersVO> list = new ArrayList<UsersVO>();
         // Read the Sheet
         for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
             HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
             if (hssfSheet == null) {
                 continue;
             }
             // Read the Row
             for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                 HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                 if (hssfRow != null) {
                	 usersVO = new UsersVO();
                     HSSFCell userName = hssfRow.getCell(0);
                     HSSFCell password = hssfRow.getCell(1);
                     HSSFCell age = hssfRow.getCell(2);
                     HSSFCell sex = hssfRow.getCell(3);
                     HSSFCell email = hssfRow.getCell(4);
                     HSSFCell remark = hssfRow.getCell(5);

                     usersVO.setUserName(getValue(userName));
                     usersVO.setPassword(getValue(password));
                     usersVO.setAge(new Integer(getValue(age)));
                     usersVO.setSex(getValue(sex));
                     usersVO.setEmail(getValue(email));
                     usersVO.setRemark(getValue(remark));
                     
                     list.add(usersVO);
                 }
             }
         }
         return list;
     }
	
       @SuppressWarnings("static-access")
       private String getValue(XSSFCell xssfRow) {
    	   if(xssfRow == null){
    		   return "";
    	   }
    	   
           if (xssfRow.getCellType() == xssfRow.CELL_TYPE_BOOLEAN) {
               return String.valueOf(xssfRow.getBooleanCellValue());
           } else if (xssfRow.getCellType() == xssfRow.CELL_TYPE_NUMERIC) {
        	   DecimalFormat df = new DecimalFormat("0");  
        	   return df.format(xssfRow.getNumericCellValue()); 
               //return String.valueOf(xssfRow.getNumericCellValue());
           } else {
               return String.valueOf(xssfRow.getStringCellValue());
           }
       }
   
       @SuppressWarnings("static-access")
       private String getValue(HSSFCell hssfCell) {
    	   if(hssfCell == null){
    		   return "";
    	   }
    	   
           if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
               return String.valueOf(hssfCell.getBooleanCellValue());
           } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
        	   DecimalFormat df = new DecimalFormat("0"); 
        	   return df.format(hssfCell.getNumericCellValue()); 
               //return String.valueOf(hssfCell.getNumericCellValue());
           } else {
               return String.valueOf(hssfCell.getStringCellValue());
           }
       }
	
       public  String getPostfix(String path) {
            if (path == null || Common.EMPTY.equals(path.trim())) {
                return Common.EMPTY;
            }
            if (path.contains(Common.POINT)) {
                return path.substring(path.lastIndexOf(Common.POINT) + 1, path.length());
            }
            return Common.EMPTY;
        }
	
}
