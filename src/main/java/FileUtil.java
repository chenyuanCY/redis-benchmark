import java.io.*;
import java.util.ArrayList;

public class FileUtil {
    public ArrayList<String> getFile(String path) throws IOException {
        ArrayList<String> list=new ArrayList<>();
        //打开待读取的文件
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        String line=null;
        while((line=bufferedReader.readLine())!=null) {
            list.add(line);
        }
        bufferedReader.close();
        return list;
    }
    public void setFile(String text,String path) throws IOException {
        BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(path));
        bufferedWriter.write(text);
        bufferedWriter.newLine();
        bufferedWriter.close();
    }

}
