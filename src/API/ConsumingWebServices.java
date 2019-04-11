/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;

class consumedata{
    HttpURLConnection con = null;
        void createconnection(String link,String method){
            try {
                URL url = new URL(link);
                con = (HttpURLConnection) url.openConnection();
                //important properties to set
                con.setConnectTimeout(1000);
                //compulsary properties
                con.setRequestMethod(method);
                con.setRequestProperty("User-Agent", "Mozilla/5.0");
                con.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
                con.setRequestProperty("Accept", "application/json");
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        //Get all the Header Feilds
        void getHeaderinfo(){           
            Map<String,List<String>> headerFeilds = con.getHeaderFields();
            for (Map.Entry<String, List<String>> entry : headerFeilds.entrySet()) {
                String key = entry.getKey();
                List<String> value = entry.getValue();
                System.out.println(key+" : "+value);
            }
        }
        void getHeaderinfo(String headername){
        //Accessing individual header information//
        System.out.println("Content Type : " + con.getHeaderField(headername));//c capital na ho chalega but isse type me hoa chate content-type
        }
        void getData(){
        try {
            //con.connect();
           if(con.getResponseCode()==200){
               Scanner sc = new Scanner(con.getInputStream(),"UTF-8");
               String response="";
               while(sc.hasNext()){
                   response += sc.nextLine();
               }
               System.out.println(response);
               //now parse string to json
               JSONObject jsonobj = new JSONObject(response);
               JSONArray jsonarr =jsonobj.getJSONArray("data");
               for(int i = 0;i < jsonarr.length();i++){
                   JSONObject jsonuser = jsonarr.getJSONObject(i);
                   String name = jsonuser.getString("first_name") + "  "+ jsonuser.getString("last_name");
                   System.out.println(name);
               }
           }
        } catch (Exception ex) {
            System.out.println(ex);
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
      consumedata cd = new consumedata();
        cd.createconnection("https://reqres.in/api/users?per_page=10", "GET");
        //cd.getHeaderinfo();
        //cd.getHeaderinfo("Date");
        //cd.getData();
          cd.postData();
    }
    
}
