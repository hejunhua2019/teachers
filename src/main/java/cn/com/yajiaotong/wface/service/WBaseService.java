package cn.com.yajiaotong.wface.service;

import java.util.List;

import cn.com.yajiaotong.wface.entity.WBaseEntity;

/**
 * 
 * @author TonyYuan
 * @email yuantao6699@hotmail.com
 * @param <T>
 */
public interface WBaseService<T extends WBaseEntity> {

void add(T entity);
	
	void addBatch(List<T> list);
	
	void delete(Long id);

	void deleteUpdate(T entity);
	
	void deleteAll(List<Long> ids);
	
	void deleteUpdateAll(List<Long> ids,Long uid);
	
	void update(T entity);
	
	List<T> find(T entity);
	
	List<T> findteacher(T entity);
	
	List<Long> findIds(T entity);
	
	List<T> batchFindByIds(List<Long> ids);
	
	T findById(Long id);
	 
    List<T> listPage(T entity);  
    
	T findmaxId(Long id);  
    
}
