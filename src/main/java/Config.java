import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Config {
    private static String data;
    private static String logs;
    private static int strLength;
    private static boolean lettuce;
    private static boolean[] mode=new boolean[11];
    private static String host;
    private static int socket;
    private static String hashKeyPre;
    private static String hashFieldPre;
    private static String hashValuePre;
    private static String setKeyPre;
    private static String setValuePre;
    private static String listKeyPre;
    private static String listValuePre;
    private static String stringKeyPre;
    private static String stringValuePre;
    private static String zsetKeyPre;
    private static String zsetValuePre;
    private static boolean scanKey;
    private static int keyCount;
    private static int mCount;
    private static int client;
    private static int request;
    private static boolean jedis;
    public void getConfig() throws IOException {
        Properties properties = new Properties();
        // 使用InPutStream流读取properties文件
        BufferedReader bufferedReader = new BufferedReader(new FileReader("E:/config.properties"));
        properties.load(bufferedReader);
        // 获取key对应的value值
        setData(properties.getProperty("data"));
        setLogs(properties.getProperty("logs"));
        setLettuce(Boolean.valueOf(properties.getProperty("lettuce")));
        setMode(properties);
        setHost(properties.getProperty("host"));
        setSocket(Integer.valueOf(properties.getProperty("socket")));
        setHashKeyPre(properties.getProperty("hashKeyPre"));
        setHashFieldPre(properties.getProperty("hashFieldPre"));
        setHashValuePre(properties.getProperty("hashValuePre"));
        setSetValuePre(properties.getProperty("ValuePre"));
        setSetKeyPre(properties.getProperty("keyPre"));
        setListKeyPre(properties.getProperty("listKeyPre"));
        setListValuePre(properties.getProperty("listValuePre"));
        setStringKeyPre(properties.getProperty("stringKeyPre"));
        setStringValuePre(properties.getProperty("stringvaluePre"));
        setZsetKeyPre(properties.getProperty("zsetKeyPre"));
        setZsetValuePre(properties.getProperty("zsetValuePre"));
        setScanKey(Boolean.valueOf(properties.getProperty("scanKey")));
        setKeyCount(Integer.valueOf(properties.getProperty("keyCount")));
        setmCount(Integer.valueOf(properties.getProperty("mCount")));
        setClient(Integer.valueOf(properties.getProperty("client")));
        setRequest(Integer.valueOf(properties.getProperty("request")));
        setJedis(Boolean.valueOf(properties.getProperty("jedis")));
        setStrLength(Integer.valueOf(properties.getProperty("strLength")));
    }
    public static boolean isLettuce() {
        return lettuce;
    }

    public static void setLettuce(boolean lettuce) {
        Config.lettuce = lettuce;
    }

    public static int getStrLength() {
        return strLength;
    }

    public static void setStrLength(int length) {
        Config.strLength = length;
    }

    public static boolean[] getMode() {
        return mode;
    }

    public static String getHost() {
        return host;
    }

    public static int getSocket() {
        return socket;
    }

    public static String getHashKeyPre() {
        return hashKeyPre;
    }

    public static String getHashFieldPre() {
        return hashFieldPre;
    }

    public static String getHashValuePre() {
        return hashValuePre;
    }

    public static String getSetKeyPre() {
        return setKeyPre;
    }

    public static String getSetValuePre() {
        return setValuePre;
    }

    public static String getListKeyPre() {
        return listKeyPre;
    }

    public static String getListValuePre() {
        return listValuePre;
    }

    public static String getStringKeyPre() {
        return stringKeyPre;
    }

    public static String getStringValuePre() {
        return stringValuePre;
    }

    public static String getZsetKeyPre() {
        return zsetKeyPre;
    }

    public static String getZsetValuePre() {
        return zsetValuePre;
    }

    public static boolean isScanKey() {
        return scanKey;
    }

    public static int getKeyCount() {
        return keyCount;
    }

    public static int getmCount() {
        return mCount;
    }

    public static int getClient() {
        return client;
    }

    public static int getRequest() {
        return request;
    }

    public static boolean isJedis() {
        return jedis;
    }


    public static String getData() {
        return data;
    }

    public static String getLogs() {
        return logs;
    }
    public static void setData(String data) {
        Config.data = data;
    }

    public static void setLogs(String logs) {
        Config.logs = logs;
    }



    public static void setMode(Properties properties) {
        mode[0]=Boolean.valueOf(properties.getProperty("hmset"));
        mode[1]=Boolean.valueOf(properties.getProperty("hmget"));
        mode[2]=Boolean.valueOf(properties.getProperty("hset"));
        mode[3]=Boolean.valueOf(properties.getProperty("hget"));
        mode[4]=Boolean.valueOf(properties.getProperty("hgetall"));
        mode[5]=Boolean.valueOf(properties.getProperty("set"));
        mode[6]=Boolean.valueOf(properties.getProperty("get"));
        mode[7]=Boolean.valueOf(properties.getProperty("mset"));
        mode[8]=Boolean.valueOf(properties.getProperty("mget"));
        mode[9]=Boolean.valueOf(properties.getProperty("lpush"));
        mode[10]=Boolean.valueOf(properties.getProperty("lrange"));
    }

    public static void setHost(String host) {
        Config.host = host;
    }

    public static void setSocket(int socket) {
        Config.socket = socket;
    }

    public static void setHashKeyPre(String hashKeyPre) {
        Config.hashKeyPre = hashKeyPre;
    }

    public static void setHashFieldPre(String hashFieldPre) {
        Config.hashFieldPre = hashFieldPre;
    }

    public static void setHashValuePre(String hashValuePre) {
        Config.hashValuePre = hashValuePre;
    }

    public static void setSetKeyPre(String setKeyPre) {
        Config.setKeyPre = setKeyPre;
    }

    public static void setSetValuePre(String setValuePre) {
        Config.setValuePre = setValuePre;
    }

    public static void setListKeyPre(String listKeyPre) {
        Config.listKeyPre = listKeyPre;
    }

    public static void setListValuePre(String listValuePre) {
        Config.listValuePre = listValuePre;
    }

    public static void setStringKeyPre(String stringKeyPre) {
        Config.stringKeyPre = stringKeyPre;
    }

    public static void setStringValuePre(String stringValuePre) {
        Config.stringValuePre = stringValuePre;
    }

    public static void setZsetKeyPre(String zsetKeyPre) {
        Config.zsetKeyPre = zsetKeyPre;
    }

    public static void setZsetValuePre(String zsetValuePre) {
        Config.zsetValuePre = zsetValuePre;
    }

    public static void setScanKey(boolean scanKey) {
        Config.scanKey = scanKey;
    }

    public static void setKeyCount(int keyCount) {
        Config.keyCount = keyCount;
    }

    public static void setmCount(int mCount) {
        Config.mCount = mCount;
    }

    public static void setClient(int client) {
        Config.client = client;
    }

    public static void setRequest(int request) {
        Config.request = request;
    }

    public static void setJedis(boolean jedis) {
        Config.jedis = jedis;
    }

}
