import java.util.Vector;

public class TimeUtil {
    public static Vector<Long> hashList=new Vector<>();
    public static Vector<Long> stringList=new Vector<>();
    public static Vector<Long> listList=new Vector<>();
    public static Vector<Long> setList=new Vector<>();
    public static Vector<Long> zsetList=new Vector<>();
    public Long getTime(Vector<Long> list){
        long min=Long.MAX_VALUE;
        long max=Long.MIN_VALUE;
        for(int i=0;i<list.size();i++){
            if(list.get(i)>max){
                max=list.get(i);
            }
            if(list.get(i)<min){
                min=list.get(i);
            }
        }
        return max-min;
    }
}
