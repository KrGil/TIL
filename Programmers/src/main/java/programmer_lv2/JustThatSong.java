package programmer_lv2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class JustThatSong {
    public static void main(String[] args) {

        JustThatSong justThatSong = new JustThatSong();
//        String m = "ABCDEFG";
//        String[] musicinfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        String m = "ABC";
        String[] musicinfos = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        justThatSong.solution(m, musicinfos);
        System.out.println("result: "+ justThatSong.solution(m, musicinfos));
    }
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        long[] totalPlayTime = new long[musicinfos.length];
        long[] totalCharCnt = new long[musicinfos.length];
        String musicName = "";
        String musicNote = "";
        // 1. 앞, 뒤 시간 계산
        String firstTime = "";
        String secondTime = "";
        SimpleDateFormat format = new SimpleDateFormat("mm:ss") ;
        int cnt = 0;
        for (String info : musicinfos) {
            System.out.println("musicInfo: "+ info);
            firstTime = info.split(",")[0].trim();
            secondTime = info.split(",")[1].trim();
            musicName = info.split(",")[2].trim();
            musicNote = info.split(",")[3].trim();
            try {
                Date date1 = format.parse(firstTime);
                Date date2 = format.parse(secondTime);
                totalPlayTime[cnt] = (date2.getTime() - date1.getTime())/1000;
                totalCharCnt[cnt] = info.split(",")[3].trim().length();
                System.out.println("time: "+ totalPlayTime[cnt]);

                // 2. 글자 수 계산
                System.out.println("음표 수 : "+totalCharCnt[cnt]);

                // 예외 잘린 음표 제일 끝에 #이 붙어있으면 추가해 주기
//                if(musicNote.indexOf()){
//
//                }

                // 3. 앞 뒤 시간이 14 일 경우 글자 수 그만큼 출력
                String[] musicNoteList = new String[(int) totalPlayTime[cnt]];
                Arrays.fill(musicNoteList, "");
                int idx = 0;
                for (int i = 0; i < totalPlayTime[cnt]; i++) {
                    if(idx == totalCharCnt[cnt]){
                        idx = 0;
                    }
                    musicNoteList[cnt] += musicNote.charAt(idx);
                    idx++;
                }
                System.out.println("musicNoteList: "+musicNoteList[cnt]);
                // 4. 그 후 m과 동일한 글자가 있는지 확인.
                if (musicNoteList[cnt].contains(m)) {
                    if(!musicNoteList[cnt].contains(m+"#")){
                        answer = musicName;
                        System.out.println("포함된 문자 "+ musicName);
                    }
                }
                System.out.println();
            } catch (ParseException e) {
                e.printStackTrace();
            }
            cnt++;
        }


        return answer;
    }
}
