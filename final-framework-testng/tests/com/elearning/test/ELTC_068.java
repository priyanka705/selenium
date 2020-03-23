package com.elearning.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.training.bean.AdduserBean;
import com.training.connection.GetConnection;
import com.training.utility.LoadDBDetails;

public class ELTC_068 {
	public static void main(String args[]) throws IOException {
        List<AdduserBean> list = getdata();
        
        Object[][] result = new Object[list.size()][]; 
        int count = 0; 
        for(AdduserBean temp : list){
            Object[]  obj = new Object[7]; 
            obj[0] = temp.getFirstName(); 
            obj[1] = temp.getLastName(); 
            obj[2] = temp.getEmail();
            obj[3] = temp.getPhoneNumberl();
            obj[4] = temp.getLoginNamel();
            obj[5] = temp.getPasswordl();
            obj[6] = temp.getcredentials();
            
            result[count ++] = obj; 
        }
        System.out.println(result);
        for (Object[] a:result)
        {
        	for(Object b: a)
        		System.out.println(b);
        }
    }
        
        
    static List<AdduserBean> getdata() throws IOException {
    Properties properties = new Properties();
    FileInputStream inStream = new FileInputStream("./resources/sql.properties");
    properties.load(inStream);
    String sql = properties.getProperty("get.testdata"); 
    
    GetConnection gc  = new GetConnection(); 
    List<AdduserBean> list = null;
    try {
        gc.ps1 = GetConnection.getMySqlConnection(LoadDBDetails.getDBDetails()).prepareStatement(sql); 
        list = new ArrayList<AdduserBean>(); 
        
        gc.rs1 = gc.ps1.executeQuery(); 
        
        while(gc.rs1.next()) {
        
        	AdduserBean temp = new AdduserBean(); 
            temp.setFirstName(gc.rs1.getString(1));
            temp.setlastName(gc.rs1.getString(2));
            temp.setEmail(gc.rs1.getString(3));
            temp.setPhoneNumber(gc.rs1.getString(4));
            temp.setLoginName(gc.rs1.getString(5));
            temp.setPassword(gc.rs1.getString(6));
            temp.setcredentials(gc.rs1.getString(7));
 
list.add(temp); 
            
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    return list; 
    }

}
