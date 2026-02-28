package org.example.dsa;

import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;

public class dsacheck {

    public Map occuranceMap(String s){
        Map<String, Integer> map=new HashMap<>();
        String[] arr=s.split("");
        for(String a:arr){
            if(map.get(a)!=null){
                map.put(a,map.get(a)+1);
            }else {
                map.put(a,1);
            }
        }
        return map;
    }

    public List<Map.Entry<String, Integer>> remove_duplicate(String s){
        Map<String, Integer> map=occuranceMap(s);
        return map.entrySet().stream().filter(entry->entry.getValue()>1)
                .collect(Collectors.toList());
    }

    @Test
    public void reverse_a_string(){
        String s= "daisy day";
        String tmp="";
        String[] arr=s.split("");
        for(int j= arr.length-1;j>=0;j--){
            tmp=tmp+arr[j];
        }
        System.out.println(tmp);
    }
    @Test
    public void check_palindrome(){
        String s= "najfgidan";
        String tmp="";
        String[] arr=s.split("");
        for(int j= arr.length-1;j>=0;j--){
            tmp=tmp+arr[j];
        }
        if(tmp.equals(s)) {
            System.out.println("palindrome");
        }else{
            System.out.println(" not palindrome");
        }
    }

    @Test
    public void count_characters(){
        String s="kahdfliglkkbafvkkhksdf";
        System.out.println(occuranceMap(s));

    }
    @Test
    public void removeduplicate(){
         String s="kahdfliglkkbafvkkhksdf";
        for(Map.Entry en:remove_duplicate(s)){
            s=s.replace(en.getKey().toString(),"");
        }
        System.out.println(s);
    }
    @Test
    public void non_repeating_char(){
        Set<String> s1= new LinkedHashSet<>();

        String s="hhhfhhhhhssjejjjjeubbbd";
        for(String c:s.split("")){
            s1.add(c);
            s=s.replace(c,"");
        }
        List<String> l=s1.stream().collect(Collectors.toList());

        for(String n: l){
            if (!s.contains(n)){
                System.out.println("first no repeating char"+n);
                break;
            }
        }
    }
    @Test
    public void compress_string(){
        String s="aaabhhhrrjjsnnbbeb";
        Map<String, Integer> m1=occuranceMap(s);
        String s1="";
        for(Map.Entry<String, Integer> e:m1.entrySet()){
            s1=s1+e.getKey()+e.getValue();
        }
        System.out.println(s1);

    }
    @Test
    public void validate_parenthesis(){
        String[] par="(((((()()))".split("");
        Stack<String> st=new Stack<String>();
        for (int i=0;i<par.length;i++){
            if(par[i].equals("(")){
                st.push(par[i]);
            }else if(par[i].equals(")")){
                if(st.size()>0 && st.peek().equals("(")){
                    st.pop();
                }
                else{
                    System.out.println("Invalid");
                    return;
                }
            }
        }
        if(st.size()>0){
            System.out.println("Invalid");
            return;
        }
        System.out.println("valid");
    }

    @Test
    public void merge_sortedList(){

    }
}
































