package cn.com.yajiaotong.wface.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.yajiaotong.wface.dao.WBaseDao;
import cn.com.yajiaotong.wface.entity.StudentsInformation;
import cn.com.yajiaotong.wface.service.StudentsInformationService;

/**
 * 
 * @author hejunhua
 * @date 2019-03-15
 * @param <T>
 */
@Service("studentsInformationService")
public class StudentsInformationServiceImpl extends WBaseServiceImpl<StudentsInformation> implements StudentsInformationService{

	@Resource(name="studentsInformationDao")
	@Override
	public void setBaseDao(WBaseDao<StudentsInformation> baseDao) {
		super.setBaseDao(baseDao);
	}
}
