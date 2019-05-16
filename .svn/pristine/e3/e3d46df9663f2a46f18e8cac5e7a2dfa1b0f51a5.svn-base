package cn.com.yajiaotong.wface.jedis;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Response;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPipeline;
import redis.clients.jedis.ShardedJedisPool;
import redis.clients.jedis.Tuple;

/**
 * 操作redis帮助类
 * @author meizhiwen
 *
 */
@Component("jedisHelper")
public class JedisHelper {

	private static final String DEFAULT_INCR_VALUE = "1";
	private static final int DEFAULT_EXPIRE_TIME = 3600 * 24;
	private static final int AUTHLOGINCODE_EXPIRE_TIME = 60 * 5;

	//private static final int LOGIN_EXPIRE_TIME = 360000 * 24;  //默认登陆过期1天
	private static final double maxTime = 9999999999999d;

	@Autowired
	private ShardedJedisPool shardedJedisPool;

	/**
	 * 如果不存在就添加到缓存
	 * @param key
	 * @return
	 */
	public boolean setIfNotExists(String key) {
		ShardedJedis jedis = shardedJedisPool.getResource();
		try {
			Long result = jedis.setnx(key, DEFAULT_INCR_VALUE);
			jedis.expire(key, DEFAULT_EXPIRE_TIME);
			if (result == 0) {
				return false;
			}
		} finally {
			shardedJedisPool.returnResource(jedis);
		}
		return true;
	}

	/**
	 * 计数加1
	 * @param key
	 * @return
	 */
	public int incr(String key) {
		ShardedJedis jedis = shardedJedisPool.getResource();
		try {
			return jedis.incr(key).intValue();
		} finally {
			shardedJedisPool.returnResource(jedis);
		}
	}

	/**
	 * 判断key是不是存在
	 * @param key
	 * @return
	 */
	public boolean keyExists(String key) {
		ShardedJedis jedis = shardedJedisPool.getResource();
		try {
			return jedis.exists(key);
		} finally {
			shardedJedisPool.returnResource(jedis);
		}
	}

	/**
	 * 获取key对应的值
	 * @param key
	 * @return
	 */
	public String get(String key) {
		ShardedJedis jedis = shardedJedisPool.getResource();
		try {
			return jedis.get(key);
		} finally {
			shardedJedisPool.returnResource(jedis);
		}
	}

	/**
	 * 普通set
	 * @param key
	 * @param value
	 */
	public void set(String key, String value) {
		ShardedJedis jedis = shardedJedisPool.getResource();
		try {
			jedis.set(key, value);
		} finally {
			shardedJedisPool.returnResource(jedis);
		}
	}

	/**
	 * 保存注册认证码或登陆随机码
	 * 或者手机验证码
	 * 通过用户输入的与redis取得值进行比较
	 * 默认保存5分钟
	 * @param key
	 * @param value
	 */
	public void setAuthLoginCode(String key, String value) {
		ShardedJedis jedis = shardedJedisPool.getResource();
		try {
			jedis.set(key, value);
			jedis.expire(key, AUTHLOGINCODE_EXPIRE_TIME);
		} finally { 
			shardedJedisPool.returnResource(jedis);
		}
	}

	/**
	 * 对某个key设置过期时间
	 * @param key
	 * @param expireAt
	 */
	public void expire(String key,int expireAt){
		ShardedJedis jedis = shardedJedisPool.getResource();
		try {
			jedis.expire(key, expireAt);
		} finally { 
			shardedJedisPool.returnResource(jedis);
		}
	}

	/**
	 * 删除某个key
	 * @param key
	 * @return
	 */
	public long delete(String key) {
		ShardedJedis jedis = shardedJedisPool.getResource();
		try {
			return jedis.del(key);
		} finally {
			shardedJedisPool.returnResource(jedis);
		}
	}

	/**
	 * 从List中取出所有数据
	 */
	public List<String> getValuesFromList(String key) {
		ShardedJedis jedis = shardedJedisPool.getResource();
		try {
			return jedis.lrange(key, 0, -1);
		} finally {
			shardedJedisPool.returnResource(jedis);
		}
	}

	/**
	 * 从List中取出所有数据指定范围的item
	 */
	public List<String> getValuesFromList(String key,long start,long end) {
		ShardedJedis jedis = shardedJedisPool.getResource();
		try {
			return jedis.lrange(key,start,end);
		} finally {
			shardedJedisPool.returnResource(jedis);
		}
	}


	/**
	 * 将新增数据放到List的left头,并保留listSize个元素
	 * 缓存应用场景，将list里面始终只放n个元素，将最新的值放到list的最开头.多余的老的数据就被清掉
	 */
	public void setValueToListHead(int listSize,String key,String ... value) {
		ShardedJedis jedis = shardedJedisPool.getResource();
		try {
			jedis.lpush(key,value);
			jedis.ltrim(key,0,listSize-1); //保留0到listSize的元素，删除其它元素
		} finally {
			shardedJedisPool.returnResource(jedis);
		}
	}
	
	/**
	 * 将数据添加到list当中去
	 * @param key
	 * @param value
	 */
	public void setValueToList(String key,String ... value){
		ShardedJedis jedis = shardedJedisPool.getResource();
		try {
			jedis.lpush(key,value);
		} finally {
			shardedJedisPool.returnResource(jedis);
		}
	}

	/**
	 * 将新增数据放到List的left头,并返回指定lindex的Item,并保留listSize个元素
	 * lpush
	 * ltrim
	 * lindex
	 */
	public String setValueToListHeadAndGetLindexItem(int listSize,String key,String value,int lindex) {
		ShardedJedis jedis = shardedJedisPool.getResource();
		try {
			jedis.lpush(key,value);
			jedis.ltrim(key,0,listSize-1); //保留0到listSize的元素，删除其它元素
			return jedis.lindex(key,lindex);
		} finally {
			shardedJedisPool.returnResource(jedis);
		}
	}

	/**
	 * 获取指定key的SortedSet集合大小
	 */
	public long getSortedSetSizeFromShard(String key) {
		ShardedJedis jedis = shardedJedisPool.getResource();
		try {
			return jedis.zcard(key);
		} finally {
			shardedJedisPool.returnResource(jedis);
		}
	}

	/**
	 * 获取指定key的大于start的SortedSet集合 in shard,倒序
	 */
	public Set<String> getSortedSetFromShardByDesc(String key,long start) {
		ShardedJedis jedis = shardedJedisPool.getResource();
		try {
			return jedis.zrevrangeByScore(key,maxTime,start);
		} finally {
			shardedJedisPool.returnResource(jedis);
		}
	}

	/**
	 * 获取指定key的SortedSet集合 in shard,倒序
	 */
	public Set<String> getSortedSetFromShardByDesc(String key) {
		ShardedJedis jedis = shardedJedisPool.getResource();
		try {
			return jedis.zrevrange(key, 0, -1);
		} finally {
			shardedJedisPool.returnResource(jedis);
		}
	}

	/**
	 * 获取指定key的SortedSet集合 in shard,倒序
	 */
	public Set<String> getSortedSetFromShardByDesc(String key,long start,long end) {
		ShardedJedis jedis = shardedJedisPool.getResource();
		try {
			return jedis.zrevrange(key,start,end);
		} finally {
			shardedJedisPool.returnResource(jedis);
		}
	}
	
	public Set<Tuple> getSortedSetFromShard(String key,long start,long end){
		ShardedJedis jedis = shardedJedisPool.getResource();
		try {
			Set<Tuple> zs = jedis.zrangeWithScores(key, start, end);
			return zs;
		} finally {
			shardedJedisPool.returnResource(jedis);
		}
	}

	/**
	 * 获取指定key的Set集合
	 */
	public Set<String> getSetFromShard(String key) {
		ShardedJedis jedis = shardedJedisPool.getResource();
		try {
			return jedis.smembers(key);
		} finally {
			shardedJedisPool.returnResource(jedis);
		}
	}

	/**
	 * 将新增数据放到指定key的SortedSet集合
	 * 
	 */
	public void setValueToSortedSetInShard(String key,double score,String value) {
		ShardedJedis jedis = shardedJedisPool.getResource();
		try {
			jedis.zadd(key, score, value);
		} finally {
			shardedJedisPool.returnResource(jedis);
		}
	}

	/**
	 * 将新增数据放到指定key的SortedSet集合,删除超过sortCount的值,并返回returnIndex指定的item
	 * 
	 */
	public Set<String> setValueToSortedSetAndDelReturnInShard(String key,double score,String value, int sortCount,int returnIndex) {
		ShardedJedis jedis = shardedJedisPool.getResource();
		try {
			jedis.zadd(key, score, value);
			long sortedSetSize = getSortedSetSizeFromShard(key);
			Set<String> returnValue = null;
			if(sortedSetSize>sortCount){
				jedis.zremrangeByRank(key,0,sortedSetSize-sortCount-1); //删除sortCount以后的所有set值
				returnValue = jedis.zrevrange(key,returnIndex,returnIndex);
			}
			else if(sortedSetSize>returnIndex){ //返回第returnIndex个值
				returnValue = jedis.zrevrange(key,returnIndex,returnIndex);
			}
			return returnValue;
		} finally {
			shardedJedisPool.returnResource(jedis);
		}
	}

	/**
	 * 删除sortedSet指定key的指定元素
	 * 
	 */
	public long deleteSortedSetItemFromShard(String key,String ... value) {
		ShardedJedis jedis = shardedJedisPool.getResource();
		try {
			return jedis.zrem(key,value);
		} finally {
			shardedJedisPool.returnResource(jedis);
		}
	}

	/**
	 * 将新增数据放到指定key的Set集合
	 * 
	 */
	public void setValueToSetInShard(String key,String ... value) {
		ShardedJedis jedis = shardedJedisPool.getResource();
		try {
			jedis.sadd(key,value);
		} finally {
			shardedJedisPool.returnResource(jedis);
		}
	}

	/**
	 * 删除set指定key的指定元素
	 * 
	 */
	public long deleteSetItemFromShard(String key,String ... value) {
		ShardedJedis jedis = shardedJedisPool.getResource();
		try {
			return jedis.srem(key,value);
		} finally {
			shardedJedisPool.returnResource(jedis);
		}
	}

	/**
	 * 删除指定key的Set
	 * 
	 */
	public long deleteSetFromShard(String key) {
		ShardedJedis jedis = shardedJedisPool.getResource();
		try {
			return jedis.del(key);
		} finally {
			shardedJedisPool.returnResource(jedis);
		}
	}

	/**
	 * 判断value是否指定set的成员in shard
	 * 
	 */
	public boolean isSetMemberInShard(String key,String member) {
		ShardedJedis jedis = shardedJedisPool.getResource();
		try {
			return jedis.sismember(key, member);
		} finally {
			shardedJedisPool.returnResource(jedis);
		}
	}

	/**
	 * 判断value是否指定sortedset的成员in shard
	 * 
	 */
	public Double isSortedSetMemberInShard(String key,String member) {
		ShardedJedis jedis = shardedJedisPool.getResource();
		try {
			return jedis.zscore(key, member);
		} finally {
			shardedJedisPool.returnResource(jedis);
		}
	}

	/**
	 * 将值放入Map
	 * 
	 * @param key
	 * @param detailKey
	 * @param value
	 */
	public void setValueToMap(String key, String detailKey, String value) {
		ShardedJedis jedis = shardedJedisPool.getResource();
		try {
			jedis.hset(key, detailKey, value);
		} finally {
			shardedJedisPool.returnResource(jedis);
		}
	}

	/**
	 * 将map存入缓存
	 * @param key
	 * @param map
	 */
	public void setValueToMap(String key,Map<String,String> map) {
		ShardedJedis jedis = shardedJedisPool.getResource();
		try {
			jedis.hmset(key, map);
		} finally {
			shardedJedisPool.returnResource(jedis);
		}
	}

//	/**
//	 * 将map存入缓存
//	 * @param key
//	 * @param map
//	 */
//	public void setLoginValueToMap(String key,Map<String,String> map) {
//		ShardedJedis jedis = shardedJedisPool.getResource();
//		try {
//			jedis.hmset(key,map);
//			jedis.expire(key,loginExpireTime);
//		} finally {
//			shardedJedisPool.returnResource(jedis);
//		}
//	}

	/**
	 * 从map取值
	 * 
	 * @param key
	 * @param detailKey
	 * return value
	 */
	public String getValueFromMap(String key, String detailKey) {
		ShardedJedis jedis = shardedJedisPool.getResource();
		try {
			return jedis.hget(key, detailKey);
		} finally {
			shardedJedisPool.returnResource(jedis);
		}
	}

	/**
	 * 从map取值自增
	 * 
	 * @param key
	 * @param detailKey
	 * return value
	 */
	public long getIncrValueFromMap(String key, String detailKey) {
		ShardedJedis jedis = shardedJedisPool.getResource();
		try {
			return jedis.hincrBy(key, detailKey,1);
		} finally {
			shardedJedisPool.returnResource(jedis);
		}
	}

	/**
	 * 取得map所有值
	 * 
	 * @param key
	 * return map对象
	 */
	public Map<String,String> getMapByKey(String key) {
		ShardedJedis jedis = shardedJedisPool.getResource();
		try {
			return jedis.hgetAll(key);
		} finally {
			shardedJedisPool.returnResource(jedis);
		}
	}

	/**
	 * 删除map中指定detailKey
	 * @param key
	 * return long
	 */
	public long deleteValueFromMap(String key,String ...detailKey) {
		ShardedJedis jedis = shardedJedisPool.getResource();
		try {
			return jedis.hdel(key, detailKey);
		} finally {
			shardedJedisPool.returnResource(jedis);
		}
	}

	/**
	 * 从map取值并进行加减计算
	 * @param key
	 * @param detailKey
	 * @param step 步长，加或减
	 * return value
	 */
	public long getIncrValueFromMap(String key, String detailKey,long step) {
		ShardedJedis jedis = shardedJedisPool.getResource();
		try {
			return jedis.hincrBy(key, detailKey,step);
		} finally {
			shardedJedisPool.returnResource(jedis);
		}
	}

	/**
	 * 返回hash中元素的个数
	 * 
	 * @param key
	 *            key值
	 * @return 元素个数
	 */
	public long getLength(String key) {
		ShardedJedis jedis = shardedJedisPool.getResource();
		try {
			return jedis.hlen(key);
		} finally {
			shardedJedisPool.returnResource(jedis);
		}
	}

	/**
	 * PipeLine批量get操作获取map数据
	 * @param keys
	 * @param fields
	 * @return
	 */
	public List<Response<List<String>>> pipeLineFromMap(String[] keys,String[] fields) {
		ShardedJedis jedis = shardedJedisPool.getResource();
		ShardedJedisPipeline pipeLine = jedis.pipelined();

		List<Response<List<String>>> responseList = new ArrayList<Response<List<String>>>();
		try {
			for (String key : keys) {
				Response<List<String>> r= pipeLine.hmget(key, fields);
				responseList.add(r);
			}
			pipeLine.sync();
			return responseList;
		} finally {
			shardedJedisPool.returnResource(jedis);
		}
	}


	public List<Response<Set<String>>> pipleGetFriendBlack(String key,List<String> uIdList){
		ShardedJedis jedis = shardedJedisPool.getResource();
		ShardedJedisPipeline pipeLine = jedis.pipelined();

		List<Response<Set<String>>> responseList = new ArrayList<Response<Set<String>>>();
		try {
			for (String uid : uIdList) {
				Response<Set<String>> response = pipeLine.smembers(key+uid);

				responseList.add(response);
			}
			pipeLine.sync();
			return responseList;
		} finally {
			shardedJedisPool.returnResource(jedis);
		}


	}

	/**
	 * 模糊查询某个key的数量
	 * @param key
	 * @return
	 */
	public int getKeyCount(String key) {
		int userCount = 0;
		ShardedJedis jedis = shardedJedisPool.getResource();
		try {	
			Collection<Jedis> jedisColl = jedis.getAllShards();
			for(Jedis jedisInfo:jedisColl){
				Set<String> set = jedisInfo.keys(key);
				if(set!=null){
					userCount+=set.size();
				}
			}
			return userCount;
		} finally {
			shardedJedisPool.returnResource(jedis);
		}
	}
	/**
	 * 验证某key是否存在
	 * 
	 * @param key
	 * @return
	 */
	public boolean ifKeyExists(String key) {
		ShardedJedis jedis = shardedJedisPool.getResource();
		try {
			return jedis.exists(key);
		} finally {
			shardedJedisPool.returnResource(jedis);
		}
	}
	public boolean isKeyExistsInMap(String key,String field){
		ShardedJedis jedis = shardedJedisPool.getResource();
		try {	
			return jedis.hexists(key, field);
		} finally {
			shardedJedisPool.returnResource(jedis);
		}
	}
	
	public void pipleLineDelListValue(String key,List<String> idList){
		ShardedJedis jedis = shardedJedisPool.getResource();
		ShardedJedisPipeline pipeLine = jedis.pipelined();
		try {
			for (String id : idList) {
				pipeLine.lrem(key, 0, id);
			}
			pipeLine.sync();
		} finally {
			shardedJedisPool.returnResource(jedis);
		}
	}
	
}
