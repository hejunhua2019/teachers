package cn.com.yajiaotong.wface.service.impl;

import java.util.List;

import cn.com.yajiaotong.wface.dao.WBaseDao;
import cn.com.yajiaotong.wface.entity.WBaseEntity;
import cn.com.yajiaotong.wface.service.WBaseService;

/**
 * 
 * @author tonyyuan
 * @email yuantao6699@hotmail.com
 * @param <T>
 */
public class WBaseServiceImpl<T extends WBaseEntity> implements WBaseService<T> {

private WBaseDao<T> baseDao;
	
	public void setBaseDao(WBaseDao<T> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public void add(T entity) {
		baseDao.add(entity, null);		
	}

	@Override
	public void addBatch(List<T> list) {
		baseDao.addBatch(list, null);
	}

	@Override
	public void delete(Long id) {
		baseDao.delete(id);
	}

	@Override
	public void deleteUpdate(T entity) {
		baseDao.deleteUpdate(entity);
	}

	@Override
	public void deleteAll(List<Long> ids) {
		baseDao.deleteAll(ids);
	}

	@Override
	public void deleteUpdateAll(List<Long> ids, Long uid) {
		baseDao.deleteUpdateAll(ids, uid);
	}

	@Override
	public void update(T entity) {
		baseDao.update(entity, null);
	}

	@Override
	public List<T> find(T entity) {
		return baseDao.find(entity,null);
	}

	@Override
	public List<Long> findIds(T entity) {
		return baseDao.findIds(entity);
	}

	@Override
	public List<T> batchFindByIds(List<Long> ids) {
		return baseDao.batchFindByIds(ids);
	}

	@Override
	public T findById(Long id) {
		return baseDao.findById(id);
	}

	@Override
	public List<T> listPage(T entity) {
		return baseDao.listPage(entity, null);
	}
	
}
