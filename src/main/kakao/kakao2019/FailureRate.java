package kakao.kakao2019;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//실패율 = 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
public class FailureRate {
    public static int[] solution(int N, int[] stages) {
        int[] answer = {};
        int go = 0; // stage fail
        int count = 0; //stage success
        Double stage = 0.0;
        Map<Integer,Double> map = new HashMap<>();
        
        for(int i=1 ;i<=N; i++) {
        	for(int j : stages) {
        		if(j == i || j < i) {
        			count++;
        			if(j == i) {
        				count--;
        				go++;
        			}
        		}
        	}
        	stage = (double)stages.length-count;
        	map.put(i, go/stage);
        	
        	go = 0;
        	count = 0;
        	stage = 0.0;
        }
        
        //sort of value -> return list
        List<Integer> list = FailureRate.sort(map);

        int temp = 0;
        
        //list -> if -> sort
        for(int i=0; i<list.size(); i++) {
        	if(i != list.size()-1) {
	        	for(int j=i+1; j<list.size(); j++) {
	        		if(map.get(list.get(i)).equals(map.get(list.get(j)))) {
	        			if(list.get(i) > list.get(j)) {
	        				temp = list.get(i);
	        				list.set(i, list.get(j));
	        				list.set(j, temp);
	        			}
	        		}
	        	}
        	}        	
        	list.get(i);
        }
        
        answer = new int[list.size()];
        
        for(int i=0; i<list.size(); i++) {
        	answer[i] = list.get(i);
        }
        
        return answer;
    } 
    
    public static List<Integer> sort(Map<Integer, Double> map){
        List<Integer> list = new ArrayList<Integer>();
        list.addAll(map.keySet());
         
        Collections.sort(list,(i,j) -> {
                Double str1 = map.get(i);
                Double str2 = map.get(j);

                return ((Comparable<Double>) str1).compareTo(str2);
        });
        
        Collections.reverse(list);
        
        return list;
    }
        
    
    public static void main(String[] args) throws Exception{
    	int[] stages = {2, 1, 2, 6, 2, 4, 3, 3}; //5
    	int[] stages2 = {4, 4, 4, 4, 4}; //4
    	int[] result = solution(5,stages);
    	
    	for(int i : result) {
    		System.out.println(i);
    	}
    }
}
