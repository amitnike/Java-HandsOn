package com.amit.handson.adv_hashing;

//Given a string B, find if it is possible to re-order the characters of the string B so that it can be represented as a concatenation of A similar strings.
//
//Eg: B = aabb and A = 2, then it is possible to re-arrange the string as "abab" which is a concatenation of 2 similar strings "ab".
//
//If it is possible, return 1, else return -1.

import java.util.HashMap;
import java.util.Set;

public class ReplicationSubStrings {
    public static  void main(String[] args){
        int A =2;
        String B = "ababa";
        System.out.println(replicationSubString(A,B));
    }

    private static int replicationSubString(int A,String B) {
        int ret = 0;

        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<B.length();i++){
            if(map.containsKey(B.charAt(i))){
                map.replace(B.charAt(i),map.get(B.charAt(i)) + 1);
            }
            else{
                map.put(B.charAt(i),1);
            }
        }

       for(Character key : map.keySet()){
           if(map.get(key) % A !=0){
               return -1;
           }
       }

       return ret;
    }

}
