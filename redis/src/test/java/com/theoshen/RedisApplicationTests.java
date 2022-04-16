package com.theoshen;

import com.alibaba.fastjson.JSON;
import com.theoshen.entity.UserEntity;
import com.theoshen.mapper.MybatisMapper;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;


@SpringBootTest
@MapperScan("com.theoshen.mapper")
class RedisApplicationTests {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Autowired
    private RedisTemplate<String, Serializable> serializableRedisTemplate;
    @Resource
    private MybatisMapper mybatisMapper;

    @Test
    public void testString() {
        redisTemplate.opsForValue().set("strKey", "DeepinTest");
        System.out.println(redisTemplate.opsForValue().get("strKey"));
    }

    @Test
    public void testSerializable() {
        List<UserEntity> userList = mybatisMapper.queryByMysql();
        System.out.println(userList);
        for (UserEntity userEntity : userList) {
            serializableRedisTemplate.opsForList().rightPush("user", JSON.toJSONString(userEntity));
        }
    }

    /**
     * @Description 测试在sql查询需要多少时间
     * @author chensihua
     * @param
     * @createTime 9:35 PM 2022/4/16
     * @return void
     * @version 1.0.0
     */
    @Test
    public void sqlTime(){
        long startTime = System.currentTimeMillis();
        List<UserEntity> userList = mybatisMapper.queryByMysql();
        System.out.println(userList);
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");

    }

    /**
     * @Description 测试在redis查询需要多少时间
     * @author chensihua
     * @param
     * @createTime 9:35 PM 2022/4/16
     * @return void
     * @version 1.0.0
     */
    @Test
    public void redisTime(){
        long startTime = System.currentTimeMillis();
        List<Serializable> user = serializableRedisTemplate.opsForList().range("user", 0, -1);
        System.out.println(user);
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }

    /**
     * @Description 测试1s内能在sql查询多少次
     * @author chensihua
     * @param
     * @createTime 9:35 PM 2022/4/16
     * @return void
     * @version 1.0.0
     */
    @Test
    public void sqlTimeTest2(){
        int sum=0;
        long startTime=System.currentTimeMillis();
        while (true)
        {
            long endTime=System.currentTimeMillis();
            if (endTime-startTime>1000)
            {
                break;
            }else
            {
                sum++;

                List<UserEntity> userList = mybatisMapper.queryByMysql();
            }
        }
        System.out.println("MySQL数据库每秒执行"+sum+"次查询");
    }

    /**
     * @Description 测试1s内能在redis查询多少次
     * @author chensihua
     * @param
     * @createTime 9:35 PM 2022/4/16
     * @return void
     * @version 1.0.0
     */
    @Test
    public void redisTimeTest2() {
        int sum = 0;
        long startTime = System.currentTimeMillis();
        while (true) {
            long endTime = System.currentTimeMillis();
            if (endTime - startTime > 1000) {
                break;
            } else {
                sum++;
                List<Serializable> user = serializableRedisTemplate.opsForList().range("user", 0, -1);
            }
        }
        System.out.println("redis每秒执行" + sum + "次查询");
    }

}
