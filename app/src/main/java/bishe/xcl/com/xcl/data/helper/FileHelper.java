package bishe.xcl.com.xcl.data.helper;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileHelper {

    private final static String FileDir =Environment.getExternalStorageDirectory().getPath() + "/xcl/";

    public static void save(Bitmap bitmap, String name){
        String sdStatus = Environment.getExternalStorageState();
        if (!sdStatus.equals(Environment.MEDIA_MOUNTED)) { // 检测sd是否可用
            return;
        }
        FileOutputStream b = null;
        File file = new File(FileDir);
        file.mkdirs();
        String fileName = FileDir + name + ".jpg";
        File dir = new File(fileName);
        if (!dir.exists()) {
            try {
                //在指定的文件夹中创建文件
                dir.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            b = new FileOutputStream(fileName);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, b);// 把数据写入文件
        } catch (Exception e) {
            Log.i("xcl", "file : faile : log : " + e.toString());
            e.printStackTrace();
        } finally {
            try {
                if (b != null) {
                    b.flush();
                    b.close();
                } else {
                    Log.i("xcl", "null");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static Bitmap getPhoto(String name){
        return BitmapFactory.decodeFile(FileDir + name + ".jpg");
    }
}
