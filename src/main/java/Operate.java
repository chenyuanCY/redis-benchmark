import io.lettuce.core.api.sync.RedisCommands;
import redis.clients.jedis.Jedis;

public class Operate {
    public static void hmset(Jedis jedis, RedisCommands<String, String> syncCommands,int startKeyIndex,int endKeyIndex){
        if(Config.isJedis()){
            jedis.hmset();
        }else{
            syncCommands.hmset();
        }
    }
    public static void hmget(Jedis jedis, RedisCommands<String, String> syncCommands,int randomKeyIndex){
        if(Config.isJedis()){
            jedis.hmset();
        }else{
            syncCommands.hmset();
        }
    }
    public static void hset(Jedis jedis, RedisCommands<String, String> syncCommands,){
        if(Config.isJedis()){
            jedis.hmset();
        }else{
            syncCommands.hmset();
        }
    }
    public static void hget(Jedis jedis, RedisCommands<String, String> syncCommands,int index){
        if(Config.isJedis()){
            jedis.hmset();
        }else{
            syncCommands.hmset();
        }
    }
    public static void hgetall(Jedis jedis, RedisCommands<String, String> syncCommands,int index){
        if(Config.isJedis()){
            jedis.hmset();
        }else{
            syncCommands.hmset();
        }
    }
    public static void mset(Jedis jedis, RedisCommands<String, String> syncCommands){
        if(Config.isJedis()){
            jedis.hmset();
        }else{
            syncCommands.hmset();
        }
    }
    public static void mget(Jedis jedis, RedisCommands<String, String> syncCommands,int index){
        if(Config.isJedis()){
            jedis.hmset();
        }else{
            syncCommands.hmset();
        }
    }
    public static void set(Jedis jedis, RedisCommands<String, String> syncCommands){
        if(Config.isJedis()){
            jedis.hmset();
        }else{
            syncCommands.hmset();
        }
    }
    public static void get(Jedis jedis, RedisCommands<String, String> syncCommands,int index){
        if(Config.isJedis()){
            jedis.hmset();
        }else{
            syncCommands.hmset();
        }
    }
    public static void lpush(Jedis jedis, RedisCommands<String, String> syncCommands){
        if(Config.isJedis()){
            jedis.hmset();
        }else{
            syncCommands.hmset();
        }
    }
    public static void lrange(Jedis jedis, RedisCommands<String, String> syncCommands,int index){
        if(Config.isJedis()){
            jedis.hmset();
        }else{
            syncCommands.hmset();
        }
    }
}
