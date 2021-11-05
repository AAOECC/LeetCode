import solution.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 * 测试主程序
 */
public class Run{

    private static int[] sum = {-1,0,1,2,-1,-4};
    private static String solutionPath = "./solution";
    private static String readmePath = "./README.md";
    private static String listBegin = ".*已记录题目.*";
    private static String listReg = "^\\* \\[\\d+\\]\\(.*\\)";
    private static String queNumStr = "[0-9]{3,4}";

    public static void main(String[] args) {
        try {
            System.out.println("本次新增题解个数为："+updateReadme());
        } catch (IOException | InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        T_1218 solution = new T_1218();
        int result = solution.longestSubsequence(sum, 1);
        System.out.println(result);
    }
    
    /**
     * 更新readme中已添加题解列表
     */
    public static int updateReadme() throws IOException, InterruptedException{
        //读取文件内容
        File readmFile = new File(readmePath);
        FileReader fr = new FileReader(readmFile);
        BufferedReader br = new BufferedReader(fr);
        //写文件内容
        FileWriter fw = new FileWriter(readmFile+".temp");
        BufferedWriter bw = new BufferedWriter(fw);
        int countBef = 0, countNew = 0;
        String line;
        //写入文件列表之前内容
        while((line = br.readLine()) != null){
            //System.out.println(line);
            bw.write(line);
            bw.newLine();
            if(Pattern.matches(listBegin, line)){
                break;
            }
        }
        //对列表进行更换
        File[] files = getFiles(solutionPath);
        Pattern compile = Pattern.compile(queNumStr);
    
        for (File file : files) {
            String fileName = file.getName();
            Matcher matcher = compile.matcher(fileName);
            if(matcher.find()){
                String numStr = fileName.substring(matcher.start(), matcher.end());
                bw.write("* ["+numStr+"]("+solutionPath+"/T_"+numStr+".java)");
                bw.newLine();
                countNew++;
            }
        }

        //后续内容写入
        while((line = br.readLine()) != null){
            if(Pattern.matches(listReg, line)){
                countBef++;
                continue;
            }
            bw.write(line);
            bw.newLine();
        }
        
        br.close();
        bw.close();
        //文件更名替换
        readmFile.delete();
        new File(readmePath+".temp").renameTo(new File(readmePath));

        return countNew-countBef;
    }
    
    public static File[] getFiles(String path){
        File file = new File(path);
        if(file.isDirectory()){
            return file.listFiles(); 
        }else{
            return new File[]{file};
        }
    }

   
}
