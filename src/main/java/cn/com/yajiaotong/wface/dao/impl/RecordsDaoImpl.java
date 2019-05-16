package cn.com.yajiaotong.wface.dao.impl;

import org.springframework.stereotype.Repository;

import cn.com.yajiaotong.wface.dao.RecordsDao;
import cn.com.yajiaotong.wface.entity.Records;

/**
 * 
 * @author hejunhua
 * @date 2019-04-30
 */
@Repository("recordsDao")
public class RecordsDaoImpl extends WBaseDaoImpl<Records> implements RecordsDao {
}