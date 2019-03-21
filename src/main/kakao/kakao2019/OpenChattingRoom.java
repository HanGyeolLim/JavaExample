package kakao.kakao2019;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//채팅방 접속 유저 확인
public class OpenChattingRoom {
	public static String[] solution(String[] record) {
        String[] answer = {};
        Map<String,String> map = new HashMap<>();
        List<String> list = new ArrayList<String>();
        
        int count = 0;
        
        //Enter - RoomConnect, Change - NickNameChange, Else - RoomLeave
        //Key - ID, Value - NickName
        for(String result : record) {
			String[] str = result.split(" ");
			if(str[0].equals("Enter")) {
				map.put(str[1], str[2]);
				list.add(str[1]);
			}else if(str[0].equals("Change")) {
				map.put(str[1], str[2]);
			}else {
				list.add(str[1]);
			}
		}
        answer = new String[list.size()];
        
        //Enter,Leave Message
        for(String result : record) {
        	String[] str = result.split(" ");
        	if(str[0].equals("Enter")) {
        		answer[count] = map.get(list.get(count))+"님이 들어왔습니다.";
			}else if(str[0].equals("Leave")) {
				answer[count] = map.get(list.get(count))+"님이 나갔습니다.";
			}
        	count++;
		}
        
        return answer;
    }
	
	public static void main(String[] args) throws Exception{
		String[] info = {
				"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"
		};
		
		String[] result = solution(info);
		for(String str : result) {
			System.out.println(str);
		}
		
	}
}
