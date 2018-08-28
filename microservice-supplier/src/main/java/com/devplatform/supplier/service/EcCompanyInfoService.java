package com.devplatform.supplier.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Example;

import com.devplatform.common.utils.db.Pager;
import com.devplatform.supplier.bean.EcCompanyInfo;
import com.devplatform.supplier.dao.EcCompanyInfoDao;

/**
 * ec_company_info的业务实现类
 * <br>
 * <b>功能：</b>EcCompanyInfoService<br>
 * @author zsb
 */
@Service("ecCompanyInfoService")
public class EcCompanyInfoService{
	protected final static Logger log= LoggerFactory.getLogger(EcCompanyInfoService.class);

	@Autowired
	private EcCompanyInfoDao dao;



	public void add(EcCompanyInfo t) throws Exception {
		dao.insert(t);//insert 以后，可以直接getid，获取到生成的id；
	}

	public void update(EcCompanyInfo t) throws Exception {
		dao.updateByPrimaryKey(t);
	}

	public void updateBySelective(EcCompanyInfo t) throws Exception {
		dao.updateByPrimaryKeySelective(t);
	}

	public void delete(Object... ids) throws Exception {
		if (ids == null || ids.length < 1) {
			return;
		}
		for (Object id : ids) {
			dao.deleteByPrimaryKey(id);
		}
	}


	public void deleteFlagById(Object... ids) throws Exception {
		if (ids == null || ids.length < 1) {
			return;
		}
		for (Object id : ids) {
			dao.deleteFlagById(id);
		}
	}

	public int queryByCount(EcCompanyInfo t) throws Exception {
		return dao.selectCount(t);
	}

	public List<EcCompanyInfo> queryByList(EcCompanyInfo model) throws Exception {
		//TODO 这个方法不完善，需要开发重新写
		Integer rowCount = queryByCount(model);
		Pager p = new Pager();
		p.setPageSize(10);
		p.setRowCount(rowCount);
		Example example = new Example(EcCompanyInfo.class);
		RowBounds rowBounds = new RowBounds(p.getPageOffset(), p.getPageSize());
		return dao.selectByExampleAndRowBounds(example, rowBounds );
	}

	public EcCompanyInfo queryById(long id) throws Exception {
		return dao.selectByPrimaryKey(id);
	}

}
