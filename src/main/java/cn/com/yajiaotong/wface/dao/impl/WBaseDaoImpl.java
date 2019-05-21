package cn.com.yajiaotong.wface.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.yajiaotong.wface.dao.WBaseDao;
import cn.com.yajiaotong.wface.entity.WBaseEntity;

/**
 * @author TonyYuan
 * @email yuantao6699@hotmail.com
 * @param <T>
 */
public class WBaseDaoImpl<T extends WBaseEntity> extends SqlSessionDaoSupport implements WBaseDao<T> {

	/**
	 * mapper文件的命名空间名称，默认值 为接口的包名+类名
	 */
	protected String mapperName;
	
	/**
	 * @author meizhiwen
	 */
	public WBaseDaoImpl(){
		
		Type type = getClass().getGenericSuperclass();
        Type[] parameterizedType = ((ParameterizedType) type)
                .getActualTypeArguments();
        @SuppressWarnings("unchecked")
		String entityName=((Class<T>) parameterizedType[0]).getSimpleName().toLowerCase();
		this.mapperName=entityName;
	}
	
	protected void setMapperName(String mapperName){
		this.mapperName=mapperName;
	}

	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public void add(T entity,String methodName) {
		methodName = methodName==null? "add":methodName;
		getSqlSession().insert(mapperName+"."+methodName,entity);
	}

	@Override
	public void addBatch(List<T> list,String methodName) {
		methodName = methodName==null? "addBatch":methodName;		
		int pageSize = WBaseDao.ADD_DELETE_LIMIT;
		int totalCount = list.size();
		int totalPage =  (totalCount+pageSize-1)/pageSize;
		for(int i=0;i<totalPage;i++){
			List<T> sub = list.subList(i*pageSize, (i+1)*pageSize>totalCount? totalCount:((i+1)*pageSize));
			getSqlSession().insert(mapperName+"."+methodName,sub);
		}		
	}

	@Override
	public void delete(Long id) {
		getSqlSession().delete(mapperName+".delete",id);
	}

	@Override
	public void deleteUpdate(T entity) {
		getSqlSession().update(mapperName+".deleteUpdate",entity);
	}

	@Override
	public void deleteAll(List<Long> ids) {
		
		int pageSize = WBaseDao.ADD_DELETE_LIMIT;
		int totalCount = ids.size();
		int totalPage =  (totalCount+pageSize-1)/pageSize;
		for(int i=0;i<totalPage;i++){
			List<Long> sub = ids.subList(i*pageSize, (i+1)*pageSize>totalCount? totalCount:((i+1)*pageSize));
			getSqlSession().delete(mapperName+".deleteAll",sub);
		}			
	}

	@Override
	public void deleteUpdateAll(List<Long> ids,Long uid) {
		
		int pageSize = WBaseDao.ADD_DELETE_LIMIT;
		int totalCount = ids.size();
		int totalPage =  (totalCount+pageSize-1)/pageSize;
		for(int i=0;i<totalPage;i++){
			List<Long> sub = ids.subList(i*pageSize, (i+1)*pageSize>totalCount? totalCount:((i+1)*pageSize));
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("uid", uid);
			map.put("ids", sub);
			getSqlSession().update(mapperName+".deleteUpdateAll",map);
		}	
	}

	@Override
	public void update(T entity, String methodName) {
		methodName = methodName==null? "update":methodName;
		getSqlSession().update(mapperName+"."+methodName,entity);		
	}

	@Override
	public List<T> find(T entity,String methodName) {
		methodName = (methodName==null)? "find":methodName;
		List<T> result = new ArrayList<T>();
		int start = 0;
		int size = WBaseDao.QUERY_LIMIT;
		entity.setSize(size);
		List<T> t = null;
		int queryCount = 0;
		do{
			entity.setStart(start);				
			t = getSqlSession().selectList(mapperName+"."+methodName,entity);
			if(t!=null){
				result.addAll(t);
				queryCount = t.size();
				t.clear();
			}else{
				queryCount = 0;
			}
			start += size;				
			}while(t!=null && queryCount>0);
		
		return result;
	}
	
	@Override
	public List<T> findTeacher(T entity,String methodName) {
		methodName = (methodName==null)? "findteacher":methodName;
		List<T> result = new ArrayList<T>();
		int start = 0;
		int size = WBaseDao.QUERY_LIMIT;
		entity.setSize(size);
		List<T> t = null;
		int queryCount = 0;
		do{
			entity.setStart(start);				
			t = getSqlSession().selectList(mapperName+"."+methodName,entity);
			if(t!=null){
				result.addAll(t);
				queryCount = t.size();
				t.clear();
			}else{
				queryCount = 0;
			}
			start += size;				
			}while(t!=null && queryCount>0);
		
		return result;
	}

	@Override
	public List<Long> findIds(T entity) {		
		List<Long> result = new ArrayList<Long>();
		int start = 0;
		int size = WBaseDao.QUERY_LIMIT;
		entity.setSize(size);
		List<Long> t = null;
		int queryCount = 0;
		do{
			entity.setStart(start);				
			t = getSqlSession().selectList(mapperName+".findIds",entity);
			if(t!=null){
				result.addAll(t);
				queryCount = t.size();
				t.clear();
			}else{
				queryCount = 0;
			}
			start += size;				
			}while(t!=null && queryCount>0);
		
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> batchFindByIds(List<Long> ids) {
		List<T> result = new ArrayList<T>();
		int pageSize = WBaseDao.QUERY_LIMIT;
		int totalCount = ids.size();
		int totalPage =  (totalCount+pageSize-1)/pageSize;
		for(int i=0;i<totalPage;i++){
			List<Long> sub = ids.subList(i*pageSize, (i+1)*pageSize>totalCount? totalCount:((i+1)*pageSize));
			List<Object> tmp = getSqlSession().selectList(mapperName+".batchFindByIds",sub);
			for(Object obj:tmp){
				result.add((T)obj);
			}
		}			
		return result;
	}

	@Override
	public T findById(Long id) {
		return getSqlSession().selectOne(mapperName+".findById",id);
	}
	
	@Override
	public T findmaxId(Long id) {
		return getSqlSession().selectOne(mapperName+".findmaxId",id);
	}

	@Override
	public List<T> listPage(T entity,String methodName) {
		methodName = methodName==null? "listPage":methodName;
		return getSqlSession().selectList(mapperName+"."+methodName,entity);
	}

}
