/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;

import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class ConsumeData
{
    HttpURLConnection connection=null;
    
    void createConnection(String method)
    {
        try
        {
              URL url=new URL("https://reqres.in/api/users?per_page=10");
              
              connection=(HttpURLConnection) url.openConnection();
              
              //important properties to set
              connection.setConnectTimeout(5000);
              
              //compulsary properties
              connection.setRequestMethod(method);  //default is GET
              
              connection.setRequestProperty("User-Agent", "Mozilla/5.0");
              connection.setRequestProperty("Content-Type","application/json; charset=UTF-8");
              connection.setRequestProperty("Accept", "application/json");//only accept data which is in json form
              
        }catch(IOException ex)
        {
            System.err.println("Exception : " + ex.getMessage());
        }
    }
    
    void getHeaderInformation() //meta data of response thast service gave to me
    {
        Map<String, List<String>> headerFields = connection.getHeaderFields();
        for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            System.out.println(key + " : " + value);
        }
        
         //Accessing individual header information//
        System.out.println("Content Type : " + connection.getRequestProperty("Content-Type"));//c capital na ho chalega but isse type me hoa chate content-type
    }
    
    void getData()
    {
        if(connection != null)
        {
            try{
                  connection.connect();  //abitk connection created but connect nhi kiya 
                   getHeaderInformation();                 //connect ke bad hi header inf ayegi
                   
                   if(connection.getResponseCode() == 200)//resp code 200 means resp is proper , jaise 404 means page not found
                   {
                       Scanner scanner = new Scanner(connection.getInputStream(),"UTF-8");
                       String response="";
                       while(scanner.hasNext())
                       {
                           response += scanner.next();
                       }
                           System.out.println(response);
                           
                           //parse json
                           JSONObject jsonObj=new JSONObject(response);
                           JSONArray jsonArray=jsonObj.getJSONArray("data");//key string is case sensitive
                           
                           for(int i=0;i<jsonArray.length();i++)
                           {
                               JSONObject userObj=jsonArray.getJSONObject(i);
                               String name=userObj.getString("first_name")+ " "
                                       + userObj.getString("last_name");
                               System.out.println(name);
                           }
                   }
                   
            }catch(IOException ex)
            {
                System.err.println("Exception : " + ex.getMessage());
            } catch (JSONException ex) {
                Logger.getLogger(ConsumeData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
    }
    
    void postData()
    {
        if(connection!=null)
        {
            try
            {
                connection.setDoOutput(true);//compulsary property for sending out information with the request
                connection.connect();
                
                //send data
                JSONObject userObj=new JSONObject();//json type ki ob send krni hai toa pna json objrect bnaya
                userObj.put("name","Xavier");
                userObj.put("job","Actor");
                
                OutputStream outStream=connection.getOutputStream();
                outStream.write(userObj.toString().getBytes());//convert json obj into bytes
                outStream.close();
                
            //    getHeaderInformation();
                
                //read response
                if(connection.getResponseCode() == 201)
                   {
                       Scanner scanner = new Scanner(connection.getInputStream(),"UTF-8");
                       String response="";
                       while(scanner.hasNext())
                       {
                           response += scanner.next();
                       }
                           System.out.println(response);
                           
                           //parse Json
                           JSONObject jsonObj=new JSONObject(response);
                           System.out.println("ID : " + jsonObj.getString("id"));//hmne id aur date ko read kiya
                           System.out.println("DATE : " + jsonObj.getString("createdAt"));
                   }
            }catch(IOException e)
            {
                System.out.println("Exception : " + e.getMessage());
            } catch (JSONException ex) {
                Logger.getLogger(ConsumeData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

public class ConsumingWebServices {

    
    public static void main(String[] args) {
        // TODO code application logic here
        ConsumeData cd = new ConsumeData();
        //cd.createConnection("GET");
        //cd.getData();
          cd.createConnection("POST");//now i want to run post so instead of get use post
          cd.postData();
    }
    
}