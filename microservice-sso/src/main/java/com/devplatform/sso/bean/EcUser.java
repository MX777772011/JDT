package com.devplatform.sso.bean;

import com.devplatform.common.bean.BaseBean;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.persistence.Table;


/**
 * EcUser Mapper
 * 用于ec_user的数据库对应文件
 * @author liyinchu
 *
 */
@Table(name = "ec_user")
@SuppressWarnings("serial")
public class EcUser extends BaseBean {
	
	
	//当需要有字段不参与数据库操作的时候，请在字段上加入@Transient
	@Id
	@GeneratedValue(generator = "JDBC")
	private Integer id;//主键用户id//
	
	//当需要有字段不参与数据库操作的时候，请在字段上加入@Transient
	@Column(name = "create_user_id")
	private Integer createUserId;//创建人id//
	
	//当需要有字段不参与数据库操作的时候，请在字段上加入@Transient
	@Column(name = "update_user_id")
	private Integer updateUserId;////
	
	//当需要有字段不参与数据库操作的时候，请在字段上加入@Transient
	@Column(name = "create_time")
	private java.util.Date createTime;//创建时间//日期类型，支持 yyyy/MM/dd 和 yyyy/MM/dd HH:mm:ss格式输入，其他格式需要自定义，建议不要改
	
	//当需要有字段不参与数据库操作的时候，请在字段上加入@Transient
	@Column(name = "update_time")
	private java.util.Date updateTime;//修改时间//日期类型，支持 yyyy/MM/dd 和 yyyy/MM/dd HH:mm:ss格式输入，其他格式需要自定义，建议不要改
	
	//当需要有字段不参与数据库操作的时候，请在字段上加入@Transient
	@Column(name = "remark")
	private java.lang.String remark;//审核不通过理由//
	
	//当需要有字段不参与数据库操作的时候，请在字段上加入@Transient
	@Column(name = "user_type")
	private Integer userType;////
	
	//当需要有字段不参与数据库操作的时候，请在字段上加入@Transient
	@Column(name = "username")
	private java.lang.String username;//用户名//
	
	//当需要有字段不参与数据库操作的时候，请在字段上加入@Transient
	@Column(name = "password")
	private java.lang.String password;//密码//
	
	//当需要有字段不参与数据库操作的时候，请在字段上加入@Transient
	@Column(name = "del_flag")
	private Integer delFlag;//删除标识（0为正常，1为删除）//
	
	//当需要有字段不参与数据库操作的时候，请在字段上加入@Transient
	@Column(name = "company_id")
	private Integer companyId;//公司id//
	
	//当需要有字段不参与数据库操作的时候，请在字段上加入@Transient
	@Column(name = "email")
	private java.lang.String email;//邮箱//
	
	//当需要有字段不参与数据库操作的时候，请在字段上加入@Transient
	@Column(name = "phone")
	private java.lang.String phone;//手机号//
	
	//当需要有字段不参与数据库操作的时候，请在字段上加入@Transient
	@Column(name = "uuid")
	private Integer uuid;////
	
	//当需要有字段不参与数据库操作的时候，请在字段上加入@Transient
	@Column(name = "original_password")
	private java.lang.String originalPassword;//原始密码//
	
	//当需要有字段不参与数据库操作的时候，请在字段上加入@Transient
	@Column(name = "verify")
	private java.lang.String verify;//审核状态0：待审核，1审核中，2审核通过，3审核不通过//
	
	//当需要有字段不参与数据库操作的时候，请在字段上加入@Transient
	@Column(name = "state")
	private java.lang.String state;//状态0：停用  1：启用//

	/**
	 * id/主键用户id的getter方法
	 */
	public Integer getId(){
		return id;
	}
	/**
	 * id/主键用户id的setter方法
	 */
	public void setId(Integer id){
		this.id = id;
	}
	/**
	 * createUserId/创建人id的getter方法
	 */
	public Integer getCreateUserId(){
		return createUserId;
	}
	/**
	 * createUserId/创建人id的setter方法
	 */
	public void setCreateUserId(Integer createUserId){
		this.createUserId = createUserId;
	}
	/**
	 * updateUserId/的getter方法
	 */
	public Integer getUpdateUserId(){
		return updateUserId;
	}
	/**
	 * updateUserId/的setter方法
	 */
	public void setUpdateUserId(Integer updateUserId){
		this.updateUserId = updateUserId;
	}
	/**
	 * createTime/创建时间的getter方法
	 */
	public java.util.Date getCreateTime(){
		return createTime;
	}
	/**
	 * createTime/创建时间的setter方法
	 */
	public void setCreateTime(java.util.Date createTime){
		this.createTime = createTime;
	}
	/**
	 * updateTime/修改时间的getter方法
	 */
	public java.util.Date getUpdateTime(){
		return updateTime;
	}
	/**
	 * updateTime/修改时间的setter方法
	 */
	public void setUpdateTime(java.util.Date updateTime){
		this.updateTime = updateTime;
	}
	/**
	 * remark/审核不通过理由的getter方法
	 */
	public java.lang.String getRemark(){
		return remark;
	}
	/**
	 * remark/审核不通过理由的setter方法
	 */
	public void setRemark(java.lang.String remark){
		this.remark = remark;
	}
	/**
	 * userType/的getter方法
	 */
	public Integer getUserType(){
		return userType;
	}
	/**
	 * userType/的setter方法
	 */
	public void setUserType(Integer userType){
		this.userType = userType;
	}
	/**
	 * username/用户名的getter方法
	 */
	public java.lang.String getUsername(){
		return username;
	}
	/**
	 * username/用户名的setter方法
	 */
	public void setUsername(java.lang.String username){
		this.username = username;
	}
	/**
	 * password/密码的getter方法
	 */
	public java.lang.String getPassword(){
		return password;
	}
	/**
	 * password/密码的setter方法
	 */
	public void setPassword(java.lang.String password){
		this.password = password;
	}
	/**
	 * delFlag/删除标识（0为正常，1为删除）的getter方法
	 */
	public Integer getDelFlag(){
		return delFlag;
	}
	/**
	 * delFlag/删除标识（0为正常，1为删除）的setter方法
	 */
	public void setDelFlag(Integer delFlag){
		this.delFlag = delFlag;
	}
	/**
	 * companyId/公司id的getter方法
	 */
	public Integer getCompanyId(){
		return companyId;
	}
	/**
	 * companyId/公司id的setter方法
	 */
	public void setCompanyId(Integer companyId){
		this.companyId = companyId;
	}
	/**
	 * email/邮箱的getter方法
	 */
	public java.lang.String getEmail(){
		return email;
	}
	/**
	 * email/邮箱的setter方法
	 */
	public void setEmail(java.lang.String email){
		this.email = email;
	}
	/**
	 * phone/手机号的getter方法
	 */
	public java.lang.String getPhone(){
		return phone;
	}
	/**
	 * phone/手机号的setter方法
	 */
	public void setPhone(java.lang.String phone){
		this.phone = phone;
	}
	/**
	 * uuid/的getter方法
	 */
	public Integer getUuid(){
		return uuid;
	}
	/**
	 * uuid/的setter方法
	 */
	public void setUuid(Integer uuid){
		this.uuid = uuid;
	}
	/**
	 * originalPassword/原始密码的getter方法
	 */
	public java.lang.String getOriginalPassword(){
		return originalPassword;
	}
	/**
	 * originalPassword/原始密码的setter方法
	 */
	public void setOriginalPassword(java.lang.String originalPassword){
		this.originalPassword = originalPassword;
	}
	/**
	 * verify/审核状态0：待审核，1审核中，2审核通过，3审核不通过的getter方法
	 */
	public java.lang.String getVerify(){
		return verify;
	}
	/**
	 * verify/审核状态0：待审核，1审核中，2审核通过，3审核不通过的setter方法
	 */
	public void setVerify(java.lang.String verify){
		this.verify = verify;
	}
	/**
	 * state/状态0：停用  1：启用的getter方法
	 */
	public java.lang.String getState(){
		return state;
	}
	/**
	 * state/状态0：停用  1：启用的setter方法
	 */
	public void setState(java.lang.String state){
		this.state = state;
	}
}
