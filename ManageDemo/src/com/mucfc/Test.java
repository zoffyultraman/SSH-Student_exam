package com.mucfc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

/**
 *@author linbingwen
 *@2015年5月18日9:14:21
 */
public class Test {
	private static Logger logger = (Logger) LogManager.getLogger(Test.class);  

    /** 
     * @param args 
     */  
    public static void main(String[] args) {  
        // System.out.println("This is println message.");  
    	 logger.entry();   //trace级别的信息，单独列出来是希望你在某个方法或者程序逻辑开始的时候调用，和logger.trace("entry")基本一个意思
         logger.error("Did it again!");   //error级别的信息，参数就是你输出的信息
         logger.info("我是info信息");    //info级别的信息
         logger.debug("我是debug信息");
         logger.warn("我是warn信息");
         logger.fatal("我是fatal信息");
    }  

}