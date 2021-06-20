import io.lettuce.core.KeyScanArgs;
import io.lettuce.core.ScanCursor;
import io.lettuce.core.api.sync.RedisCommands;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.util.ArrayList;

public class Scan {
    private ArrayList<String> keyList = new ArrayList<>();
    public void scan(Jedis jedis, RedisCommands<String, String> syncCommands) throws IOException {
        FileUtil fileUtil=new FileUtil();
        String curosr = "0";
        if (Config.isJedis()) {
            keyList.addAll(jedis.scan(curosr).getResult());
            curosr = jedis.scan(curosr).getCursor();
            while (curosr != "0") {
                keyList.addAll(jedis.scan(curosr).getResult());
                curosr = jedis.scan(curosr).getCursor();
            }
            for(int i=0;i<keyList.size();i++){
                String type=jedis.type(keyList.get(i));
                switch (type){
                    case "hash":fileUtil.setFile(keyList.get(i),Config.getData()+"hash-key.txt");
                    for(String str:jedis.hkeys(keyList.get(i))){
                        fileUtil.setFile(str,Config.getData()+"hash-field.txt");
                    };break;
                    case "string":fileUtil.setFile(keyList.get(i),Config.getData()+"string-key.txt");break;
                    case "set":fileUtil.setFile(keyList.get(i),Config.getData()+"set-key.txt");break;
                    case "list":fileUtil.setFile(keyList.get(i),Config.getData()+"list-key.txt");break;
                    case "zset":fileUtil.setFile(keyList.get(i),Config.getData()+"zset-key.txt");break;
                }
            }
        } else {
            keyList.addAll(syncCommands.scan(ScanCursor.of(curosr)).getKeys());
            curosr = syncCommands.scan(ScanCursor.of(curosr)).getCursor();
            while (curosr != "0") {
                keyList.addAll(syncCommands.scan(ScanCursor.of(curosr)).getKeys());
                curosr = syncCommands.scan(ScanCursor.of(curosr)).getCursor();
            }
            for(int i=0;i<keyList.size();i++){
                String type=syncCommands.type(keyList.get(i));
                switch (type){
                    case "hash":fileUtil.setFile(keyList.get(i),Config.getData()+"hash-key.txt");
                        for(String str:syncCommands.hkeys(keyList.get(i))){
                            fileUtil.setFile(str,Config.getData()+"hash-field.txt");
                        };break;
                    case "string":fileUtil.setFile(keyList.get(i),Config.getData()+"string-key.txt");break;
                    case "set":fileUtil.setFile(keyList.get(i),Config.getData()+"set-key.txt");break;
                    case "list":fileUtil.setFile(keyList.get(i),Config.getData()+"list-key.txt");break;
                    case "zset":fileUtil.setFile(keyList.get(i),Config.getData()+"zset-key.txt");break;
                }
            }
        }
    }
}
