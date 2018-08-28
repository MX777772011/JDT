package com.devplatform.supplier.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Example;

import com.devplatform.common.utils.db.Pager;
import com.devplatform.supplier.bean.EcCompany;
import com.devplatform.supplier.dao.EcCompanyDao;

/**
 * ec_company的业务实现类
 * <br>
 * <b>功能：</b>EcCompanyService<br>
 * @author zsb
 */
@Service("ecCompanyService")
public class EcCompanyService{
	protected final static Logger log= LoggerFactory.getLogger(EcCompanyService.class);

	@Autowired
	private EcCompanyDao dao;



	public void add(EcCompany t) throws Exception {
		dao.insert(t);//insert 以后，可以直接getid，获取到生成的id；
	}

	public void update(EcCompany t) throws Exception {
		dao.updateByPrimaryKey(t);
	}

	public void updateBySelective(EcCompany t) throws Exception {
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

	public int queryByCount(EcCompany t) throws Exception {
		return dao.selectCount(t);
	}

	public List<EcCompany> queryByList(EcCompany model) throws Exception {
		//TODO 这个方法不完善，需要开发重新写
		Integer rowCount = queryByCount(model);
		Pager p = new Pager();
		p.setPageSize(10);
		p.setRowCount(rowCount);
		Example example = new Example(EcCompany.class);
		RowBounds rowBounds = new RowBounds(p.getPageOffset(), p.getPageSize());
		return dao.selectByExampleAndRowBounds(example, rowBounds );
	}

	public EcCompany queryById(long id) throws Exception {
		return dao.selectByPrimaryKey(id);
	}
    
	
	
}
