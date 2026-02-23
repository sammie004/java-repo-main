package generics;

import exceptions.absent;

import java.util.HashMap;
import java.util.Map;

class myDictionary<K,V>{
    Map<K,V>values = new HashMap<>();



    public void containsKey(K key){
        if(values.containsKey(key)){
            System.out.println("The key is present in the map");
        }else {
            throw new absent("The key is not present in the map");
        }
    }
    public void containsValue(V value){
        if(values.containsValue(value)){
            System.out.println("The value is present in the map");
        }else{
            throw new absent("The value is not present in the map");
        }
    }

    public int countKeys(){
        return values.size();
    }
}