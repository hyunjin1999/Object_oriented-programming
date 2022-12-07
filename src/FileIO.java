import java.util.*;
import java.io.*;

public class FileIO {
    public List<List<String>> fileRead(String type){    // 주석8: 파일 입/출력 사용
        List<List<String>> csvList = new ArrayList<>(); // 주석7: 컬렉션 프레임워크
        File csv = new File("C:\\Users\\USER\\IdeaProjects\\Assignment\\src\\"+type+".csv");
        BufferedReader br = null;
        String line = "";

        try{    // 주석4: 예외 처리
            br = new BufferedReader(new FileReader(csv));
            while ((line = br.readLine()) != null){
                List<String> aLine;
                String[] lineArr = line.split(",");
                aLine = Arrays.asList(lineArr);
                csvList.add(aLine);
            }

        } catch(IOException e){
            e.printStackTrace();
        } finally {
            try{
                if(br != null){
                    br.close();
                }
            } catch(IOException e){
                e.printStackTrace();
            }
        }
        return csvList;

    }

    public void fileWrite(String type, String fir, String sec, String thr ){    // 주석8: 파일 입/출력 사용
        File csv = new File("C:\\Users\\USER\\IdeaProjects\\Assignment\\src\\"+type+".csv");
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(csv, true));

            String aData = "";
            aData = fir + "," + sec + "," + thr;
            bw.write(aData);
            bw.newLine();

        } catch (IOException e){
            e.printStackTrace();
        } finally{
            try{
                if(bw != null){
                    bw.flush();
                    bw.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}

