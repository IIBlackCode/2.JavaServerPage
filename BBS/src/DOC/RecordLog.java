package DOC;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RecordLog {

    private static FileWriter writer = null; // 파일 출력
    private static File dir = null;
    String fileName = null;
    String filePath = null;

    public void log(String logPath,String msg){

        SimpleDateFormat ymdFmt = new SimpleDateFormat ("yyyyMMdd");
        SimpleDateFormat ymdhmsFmt = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");

        String ymd= ymdFmt.format(new Date());
        String ymdhms = ymdhmsFmt.format(new Date());

        dir = new File(logPath);
        if(!dir.isDirectory()){
            // 디렉토리가 없으면 생성
            dir.mkdirs();
        }

        // 디렉토리에 파일 생성
        filePath = logPath+File.separator+ymd+"_test.log";
		// 로그 내용
        String description = "["+ymdhms+"]" +msg;

        try{
            writer = new FileWriter(filePath, true);
            writer.write(description);
            writer.write("\r\n");
            writer.flush();
        }catch(IOException e){
            e.printStackTrace();
        }
        finally{
            try {
                fileName = null;
                filePath = null;
                dir = null;
                if(writer != null){
                    writer.close();
                }
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
}