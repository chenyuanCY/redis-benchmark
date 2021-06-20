
import io.lettuce.core.api.sync.RedisCommands;

import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.util.ArrayList;
public class Initialize {
    private FileUtil fileUtil=new FileUtil();
    private Config config=new Config();
    public static ArrayList<String> getHashKeyList;
    public static ArrayList<String> getHashFieldList;
    public static ArrayList<String> getStringKeyList;
    public static ArrayList<String> getListKeyList;
    public static ArrayList<String> getSetKeyList;
    public static ArrayList<String> getZsetKeyList;

    public static ArrayList<String> setHashKeyList;
    public static ArrayList<String> setHashFieldList;
    public static ArrayList<String> setHashValueList;

    public static ArrayList<String> setStringKeyList;
    public static ArrayList<String> setStringValueList;

    public static ArrayList<String> setListKeyList;
    public static ArrayList<String> setListValueList;

    public static ArrayList<String> setSetKeyList;
    public static ArrayList<String> setSetValueList;

    public static ArrayList<String> setZsetKeyList;
    public static ArrayList<String> setZsetValueList;
    private ArrayList<String> keyList=new ArrayList<String>();
    public void Init(Jedis jedis, RedisCommands<String, String> syncCommands) throws IOException {
        config.getConfig();
        if(Config.isScanKey()){
            Scan scan=new Scan();
            scan.scan(jedis,syncCommands);
        }
        initList();
    }
    private void initList() throws IOException {
        for(int i=0;i<Config.getMode().length;i++){
            if(Config.getMode()[i]){
                switch (i){
                    case 0:case 2: setHashKeyList=RandomUtil.createRandomString(Config.getStrLength(),Config.getRequest()/Config.getKeyCount(),Config.getHashKeyPre());
                        setHashFieldList=RandomUtil.createRandomString(Config.getStrLength(),Config.getRequest(),Config.getHashFieldPre());
                        setHashValueList=RandomUtil.createRandomString(Config.getStrLength(),Config.getRequest(),Config.getHashValuePre());break;
                    case 1:case 3: case 4:getHashKeyList=fileUtil.getFile(Config.getData()+"hash-key.txt");
                        getHashFieldList=fileUtil.getFile(Config.getData()+"hash-value.txt");break;

                    case 5: case 7:setStringKeyList=RandomUtil.createRandomString(Config.getStrLength(),Config.getRequest(),Config.getStringKeyPre());
                    setStringValueList=RandomUtil.createRandomString(Config.getStrLength(),Config.getRequest(),Config.getStringValuePre());
                    break;
                    case 6: case 8:getStringKeyList=fileUtil.getFile(Config.getData()+"string-key.txt");break;

                    case 9:setListKeyList=RandomUtil.createRandomString(Config.getStrLength(),Config.getRequest()/Config.getKeyCount(),Config.getListKeyPre());
                    setListValueList=RandomUtil.createRandomString(Config.getStrLength(),Config.getRequest(),Config.getListKeyPre());break;
                    case 10:getListKeyList=fileUtil.getFile(Config.getData()+"list-key.txt");break;
                }
            }
        }
    }

}

