import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.Random;

public class RandomUtil {
    public static ArrayList<String> createRandomString(int length, int count, String pre){//获取随机字符串
        ArrayList<String> list=new ArrayList<>(count);
        for(int i=0;i<count;i++){
            list.add(pre+RandomStringUtils.random(length-pre.length()));
        }
        return list;
    }
    public static int getRandomIndex(int range){//获取随机下标
        return new Random().nextInt(range);
    }
}