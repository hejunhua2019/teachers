package cn.com.yajiaotong.wface.dao;

import java.util.List;

import cn.com.yajiaotong.wface.entity.WBaseEntity;

/**
 * 
 * @author TonyYuan
 * @email yuantao6699@hotmail.com
 * @param <T>
 */
public interface WBaseDao<T extends WBaseEntity> {
	
	int ADD_DELETE_LIMIT = 9000;
	int QUERY_LIMIT = 1000000;
	
	void add(T entity,String methodName);
	
	void addBatch(List<T> list,String methodName);
	
	void delete(Long id);

	void deleteUpdate(T entity);
	
	void deleteAll(List<Long> ids);
	
	void deleteUpdateAll(List<Long> ids,Long uid);
	
	void update(T entity,String methodName);
	
	List<T> find(T entity,String methodName);
	
	List<Long> findIds(T entity);
	
	List<T> batchFindByIds(List<Long> ids);
	
	T findById(Long id);
	 
    List<T> listPage(T entity,String methodName);    
}
