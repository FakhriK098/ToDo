import java.io.*;
import java.util.*;

public class JSONManipulation {

    //nomer 1
    public static findItemInMeeting(JSONObject jo){
        Map placment = ((Map)jo.get("placement"));
        Iterator<Map.Entry> itr1 = placment.entrySet().iterator();
        while(itr1.hasNext()){
            Map.Entry pair = itr1.next();
            if(pair.getKey() == "Meeting Room"){
                System.out.println((String) jo.get("name"));
            }
        }
    }

    //nomer 2
    public static allElectronicDevice(JSONObject jo){
        if(jo.get("type") == "electronic"){
            System.out.println((String) jo.get("name"));
        }

    }

    //nomer 3
    public static allFunitures(JSONObject jo){
        if(jo.get("type") == "funiture"){
            System.out.println((String) jo.get("name"));
        }

    }    

    //nomer 5
    public static allItemBrown(JSONObject jo){
        JSONArray jsonArray = (JSONArray) jo.get("tags");
        Iterator<String> iterator = jsonArray.interator();
        while(iterator.hasNext()){
            if(iterator.next() == "brown"){
                System.out.println(jo.get("name"))
            }
        }
    }
    
    public static void main(String[] args){
        Object obj = new JSONParser().parse(new FileReader("data.json"));
        JSONArray jo = (JSONArray) obj;

        //nomer 1
        jo.forEach(j -> findItemInMeeting((JSONObject) jo));

        //nomer 2
        jo.forEach(j -> allElectronicDevice((JSONObject) jo));

        //nomer 3
        jo.forEach(j -> allFunitures((JSONObject) jo));

        //nomer 5
        jo.forEach(j -> allItemBrown((JSONObject) jo));

    }
}
