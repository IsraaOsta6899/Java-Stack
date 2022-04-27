package fundamentals.MapOfTheHashmatique;
import java.util.*;
public class Test {
    public static void main(String []args){
        HashMap<String,String> myHash= new HashMap<String,String>();
        myHash.put("song1", "first song");
        myHash.put("song2", "second song");
        myHash.put("song3", "theird song");
        myHash.put("song4", "last song");
        myHash.remove("song4");
        Set<String> keys=myHash.keySet();
        for(String key : keys){
            System.out.println(key +":"+ myHash.get(key));
        }

    }
    
}
