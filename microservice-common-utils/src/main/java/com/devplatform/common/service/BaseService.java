package com.devplatform.common.service;

import com.devplatform.common.base.BaseMapper;

public abstract class BaseService<T> {

	public abstract BaseMapper<T> getDao();

	public void add(T t) throws Exception {
		getDao().insert(t);
	}

	public void update(T t) throws Exception {
		getDao().updateByPrimaryKey(t);
	}

	public void updateBySelective(T t) throws Exception {
		getDao().updateByPrimaryKeySelective(t);
	}

	public void delete(Object[] ids) throws Exception {
		if (ids == null || ids.length < 1) {
			return;
		}
		for (Object id : ids) {
			getDao().deleteByPrimaryKey(id);
		}
	}

	public void delete(Object id) throws Exception {
		getDao().deleteByPrimaryKey(id);
	}

//	public void deleteFlagById(Object[] ids) throws Exception {
//		if (ids == null || ids.length < 1) {
//			return;
//		}
//		for (Object id : ids) {
//			getDao().deleteFlagById(id);
//		}
//	}
//
//	public void deleteFlagById(Object id) throws Exception {
//		getDao().deleteFlagById(id);
//	}

//	public int queryByCount(T t) throws Exception {
//		return getDao().selectCount(t);
//	}
//
//	public List<T> queryByList(BaseModel model) throws Exception {
//		Integer rowCount = queryByCount(model);
//		model.getPager().setRowCount(rowCount);
//		Object example;
//		RowBounds rowBounds ;
//		return getDao().selectByExampleAndRowBounds(example, rowBounds );
//	}

	public T queryById(Object id) throws Exception {
		return getDao().selectByPrimaryKey(id);
	}
}
