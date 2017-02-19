package com.springmvc;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorld {
	private static final Log log =LogFactory.getLog(HelloWorld.class);
	@RequestMapping("/helloworld")
    public ModelAndView hello(HttpServletRequest request){
        System.out.println("hello world");     
       
        String p1 = "Charles";
        String p2 = "Michael";
        Vector personList = new Vector();
        personList.addElement(p1);
        personList.addElement(p2);
        log.info("我的服务查询开始.....................................");
        
        String str="中文123abc,./";
        System.out.println("原始字符串为："+str);

        //MD5加密
        String md5Str=DigestUtils.md5Hex(str);
        System.out.println("MD5加密为："+md5Str);
        //SHA1加密
        String sha1Str=DigestUtils.shaHex(str);
        System.out.println("Sha1加密为："+sha1Str);
        
      //Base64加密
        byte[] base64Byte=null;
        String base64Str="";
        try {
        base64Byte = Base64.encodeBase64(str.getBytes("utf-8"), true);
        base64Str=new String(base64Byte);
        System.out.println("Base64加密为："+base64Str);
        } catch (UnsupportedEncodingException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        }
        //Base64解密
        byte[] base64ByteBack=null;
        String base64StrBack="";
        try {
        base64ByteBack= Base64.decodeBase64(base64Str.getBytes("utf-8"));
        base64StrBack=new String(base64ByteBack);
        System.out.println("Base64解密为："+base64StrBack);
        } catch (UnsupportedEncodingException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        }
        
        return new ModelAndView("success1", "theList", personList);
    }
	
	@ResponseBody 
	@RequestMapping(value="/hello")
	public List<Object>  hello1(HttpServletRequest request){
		    System.out.println("hello world2");
		    String s=request.getContextPath();
		    
		    
		    System.out.println(s);
	        Map<String,String> result = new HashMap<String,String>();	
	        List<Object> res=new ArrayList<Object>();
	        System.out.println("12354");
	        
	        DataTable node=new DataTable();
	        node.setCol1("1");
	        node.setCol2("1");
	        node.setCol3("1");
	        node.setCol4("1");
	        node.setCol5("1");
	        node.setCol6("1");
	        res.add(node);
	       
	        //校验 代码...
	        /*result.put("col1", "1");
	        result.put("col2", "2");
	        result.put("col3", "3");
	        result.put("col4", "4");
	        result.put("col5", "5");
	        result.put("col6", "6");
	        */
	      /*  List list=new ArrayList();  
	        Iterator it=result.keySet().iterator();  
	        while(it.hasNext()){  
	        	List node=new ArrayList()
	            String key=it.next().toString(); 
	        	node.add(key);
	        	node.add(":");
	        	node.add(result.get(key).toString());
	        	list.add(node);
	            list.add(key+":"+result.get(key).toString()); 	     
	        }  */
	        
	        return res;
	}
	

}
