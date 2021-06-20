import io.lettuce.core.api.sync.RedisCommands;
import redis.clients.jedis.Jedis;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Threads implements Runnable{
    private Jedis jedis;
    private RedisCommands<String, String> syncCommands;

    public Threads(Jedis jedis, RedisCommands<String, String> syncCommands, CountDownLatch countDownLatchMain, CountDownLatch[] countDownLatches) {
        this.jedis = jedis;
        this.syncCommands = syncCommands;
        this.countDownLatchMain = countDownLatchMain;
        this.countDownLatches = countDownLatches;
    }

    private CountDownLatch countDownLatchMain;
    private CountDownLatch[] countDownLatches;

    @Override
    public void run() {
        for(int i=0;i<Config.getMode().length;i++){
            switch (i){
                case 0:Operate.hmset(jedis,syncCommands);
                case 1:Operate.hmget(jedis,syncCommands,RandomUtil.getRandomIndex(Initialize.getHashKeyList.size()));
                case 2:Operate.hset(jedis,syncCommands);
                case 3:Operate.hget(jedis,syncCommands,RandomUtil.getRandomIndex(Initialize.getHashKeyList.size()));
                case 4:Operate.hgetall(jedis,syncCommands,RandomUtil.getRandomIndex(Initialize.getHashKeyList.size()));
                case 5:Operate.set(jedis,syncCommands);
                case 6:Operate.get(jedis,syncCommands,RandomUtil.getRandomIndex(Initialize.getStringKeyList.size()));
                case 7:Operate.mset(jedis,syncCommands);
                case 8:Operate.mget(jedis,syncCommands,RandomUtil.getRandomIndex(Initialize.getStringKeyList.size()));
                case 9:Operate.lpush(jedis,syncCommands);
                case 10:Operate.lrange(jedis,syncCommands,RandomUtil.getRandomIndex(Initialize.getListKeyList.size()));
            }
        }
    }
}
