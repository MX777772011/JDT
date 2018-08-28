package com.devplatform.supplier.bean;

import com.devplatform.common.bean.BaseBean;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * EcCompany Mapper
 * 用于ec_company的数据库对应文件
 * @author zsb
 *
 */
@Table(name = "ec_company")
@SuppressWarnings("serial")
public class EcCompany extends BaseBean {
	
	
	//当需要有字段不参与数据库操作的时候，请在字段上加入@Transient
	@Id
	@GeneratedValue(generator = "JDBC")
	private Long id;//主键//
	
	 
	@Column(name = "name")
	private java.lang.String name;//公司名称//
	
	 
	@Column(name = "business_license")
	private java.lang.String businessLicense;//营业执照号//
	
	 
	@Column(name = "contact_name")
	private java.lang.String contactName;//联系人//
	
	 
	@Column(name = "contact_phone")
	private java.lang.String contactPhone;//联系电话//
	
	 
	@Column(name = "address")
	private java.lang.String address;//公司地址//
	
	 
	@Column(name = "source")
	private java.lang.String source;//来源0自主注册1各局推荐3后台添加4广联达//
	
	 
	@Column(name = "type")
	private Integer type;//公司类型；0：采购商；1：供应商//
	
	 
	@Column(name = "del_flag")
	private Integer delFlag;////
	
	 
	@Column(name = "uuid")
	private Long uuid;////
	
	 
	@Column(name = "creater_user")
	private Integer createrUser;//创建人//
	
	 
	@Column(name = "creater_date")
	private java.util.Date createrDate;//创建时间//日期类型，支持 yyyy/MM/dd 和 yyyy/MM/dd HH:mm:ss格式输入，其他格式需要自定义，建议不要改
	
	 
	@Column(name = "status")
	private Integer status;//审核状态1待审核2审核通过 3审核不通过4审核中//
	
	 
	@Column(name = "parent_id")
	private Long parentId;//上级公司id//
	
	 
	@Column(name = "parent_path")
	private java.lang.String parentPath;//公司路径; 如id,id,id，例 12,28,95//
	
	 
	@Column(name = "company_no")
	private java.lang.String companyNo;////
	
	 
	@Column(name = "update_time")
	private java.util.Date updateTime;//更新时间//日期类型，支持 yyyy/MM/dd 和 yyyy/MM/dd HH:mm:ss格式输入，其他格式需要自定义，建议不要改
	
	 
	@Column(name = "inquiry_check")
	private java.lang.String inquiryCheck;//询价审核。1：审核；0 ；不审核//
	
	 
	@Column(name = "update_date")
	private java.util.Date updateDate;////日期类型，支持 yyyy/MM/dd 和 yyyy/MM/dd HH:mm:ss格式输入，其他格式需要自定义，建议不要改
	
	 
	@Column(name = "create_time")
	private java.util.Date createTime;//创建时间//日期类型，支持 yyyy/MM/dd 和 yyyy/MM/dd HH:mm:ss格式输入，其他格式需要自定义，建议不要改
	
	 
	@Column(name = "create_user_id")
	private Long createUserId;//创建人id//
	
	 
	@Column(name = "update_user_id")
	private Long updateUserId;//更新用户id//
	
	 
	@Column(name = "remarks")
	private java.lang.String remarks;//备注//
	
	 
	@Column(name = "fixed_phone")
	private java.lang.String fixedPhone;//固定电话//
	
	 
	@Column(name = "email")
	private java.lang.String email;//公司邮箱//
	
	 
	@Column(name = "fax_number")
	private java.lang.String faxNumber;//传真号//
	
	 
	@Column(name = "employed")
	private java.lang.String employed;//是否自营  0是 1 否//
	
	 
	@Column(name = "company_path")
	private java.lang.String companyPath;//公司地址在地图上展示用//

	/**
	 * id/主键的getter方法
	 */
	public Long getId(){
		return id;
	}
	/**
	 * id/主键的setter方法
	 */
	public void setId(Long id){
		this.id = id;
	}
	/**
	 * name/公司名称的getter方法
	 */
	public java.lang.String getName(){
		return name;
	}
	/**
	 * name/公司名称的setter方法
	 */
	public void setName(java.lang.String name){
		this.name = name;
	}
	/**
	 * businessLicense/营业执照号的getter方法
	 */
	public java.lang.String getBusinessLicense(){
		return businessLicense;
	}
	/**
	 * businessLicense/营业执照号的setter方法
	 */
	public void setBusinessLicense(java.lang.String businessLicense){
		this.businessLicense = businessLicense;
	}
	/**
	 * contactName/联系人的getter方法
	 */
	public java.lang.String getContactName(){
		return contactName;
	}
	/**
	 * contactName/联系人的setter方法
	 */
	public void setContactName(java.lang.String contactName){
		this.contactName = contactName;
	}
	/**
	 * contactPhone/联系电话的getter方法
	 */
	public java.lang.String getContactPhone(){
		return contactPhone;
	}
	/**
	 * contactPhone/联系电话的setter方法
	 */
	public void setContactPhone(java.lang.String contactPhone){
		this.contactPhone = contactPhone;
	}
	/**
	 * address/公司地址的getter方法
	 */
	public java.lang.String getAddress(){
		return address;
	}
	/**
	 * address/公司地址的setter方法
	 */
	public void setAddress(java.lang.String address){
		this.address = address;
	}
	/**
	 * source/来源0自主注册1各局推荐3后台添加4广联达的getter方法
	 */
	public java.lang.String getSource(){
		return source;
	}
	/**
	 * source/来源0自主注册1各局推荐3后台添加4广联达的setter方法
	 */
	public void setSource(java.lang.String source){
		this.source = source;
	}
	/**
	 * type/公司类型；0：采购商；1：供应商的getter方法
	 */
	public Integer getType(){
		return type;
	}
	/**
	 * type/公司类型；0：采购商；1：供应商的setter方法
	 */
	public void setType(Integer type){
		this.type = type;
	}
	/**
	 * delFlag/的getter方法
	 */
	public Integer getDelFlag(){
		return delFlag;
	}
	/**
	 * delFlag/的setter方法
	 */
	public void setDelFlag(Integer delFlag){
		this.delFlag = delFlag;
	}
	/**
	 * uuid/的getter方法
	 */
	public Long getUuid(){
		return uuid;
	}
	/**
	 * uuid/的setter方法
	 */
	public void setUuid(Long uuid){
		this.uuid = uuid;
	}
	/**
	 * createrUser/创建人的getter方法
	 */
	public Integer getCreaterUser(){
		return createrUser;
	}
	/**
	 * createrUser/创建人的setter方法
	 */
	public void setCreaterUser(Integer createrUser){
		this.createrUser = createrUser;
	}
	/**
	 * createrDate/创建时间的getter方法
	 */
	public java.util.Date getCreaterDate(){
		return createrDate;
	}
	/**
	 * createrDate/创建时间的setter方法
	 */
	public void setCreaterDate(java.util.Date createrDate){
		this.createrDate = createrDate;
	}
	/**
	 * status/审核状态1待审核2审核通过 3审核不通过4审核中的getter方法
	 */
	public Integer getStatus(){
		return status;
	}
	/**
	 * status/审核状态1待审核2审核通过 3审核不通过4审核中的setter方法
	 */
	public void setStatus(Integer status){
		this.status = status;
	}
	/**
	 * parentId/上级公司id的getter方法
	 */
	public Long getParentId(){
		return parentId;
	}
	/**
	 * parentId/上级公司id的setter方法
	 */
	public void setParentId(Long parentId){
		this.parentId = parentId;
	}
	/**
	 * parentPath/公司路径; 如id,id,id，例 12,28,95的getter方法
	 */
	public java.lang.String getParentPath(){
		return parentPath;
	}
	/**
	 * parentPath/公司路径; 如id,id,id，例 12,28,95的setter方法
	 */
	public void setParentPath(java.lang.String parentPath){
		this.parentPath = parentPath;
	}
	/**
	 * companyNo/的getter方法
	 */
	public java.lang.String getCompanyNo(){
		return companyNo;
	}
	/**
	 * companyNo/的setter方法
	 */
	public void setCompanyNo(java.lang.String companyNo){
		this.companyNo = companyNo;
	}
	/**
	 * updateTime/更新时间的getter方法
	 */
	public java.util.Date getUpdateTime(){
		return updateTime;
	}
	/**
	 * updateTime/更新时间的setter方法
	 */
	public void setUpdateTime(java.util.Date updateTime){
		this.updateTime = updateTime;
	}
	/**
	 * inquiryCheck/询价审核。1：审核；0 ；不审核的getter方法
	 */
	public java.lang.String getInquiryCheck(){
		return inquiryCheck;
	}
	/**
	 * inquiryCheck/询价审核。1：审核；0 ；不审核的setter方法
	 */
	public void setInquiryCheck(java.lang.String inquiryCheck){
		this.inquiryCheck = inquiryCheck;
	}
	/**
	 * updateDate/的getter方法
	 */
	public java.util.Date getUpdateDate(){
		return updateDate;
	}
	/**
	 * updateDate/的setter方法
	 */
	public void setUpdateDate(java.util.Date updateDate){
		this.updateDate = updateDate;
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
	 * createUserId/创建人id的getter方法
	 */
	public Long getCreateUserId(){
		return createUserId;
	}
	/**
	 * createUserId/创建人id的setter方法
	 */
	public void setCreateUserId(Long createUserId){
		this.createUserId = createUserId;
	}
	/**
	 * updateUserId/更新用户id的getter方法
	 */
	public Long getUpdateUserId(){
		return updateUserId;
	}
	/**
	 * updateUserId/更新用户id的setter方法
	 */
	public void setUpdateUserId(Long updateUserId){
		this.updateUserId = updateUserId;
	}
	/**
	 * remarks/备注的getter方法
	 */
	public java.lang.String getRemarks(){
		return remarks;
	}
	/**
	 * remarks/备注的setter方法
	 */
	public void setRemarks(java.lang.String remarks){
		this.remarks = remarks;
	}
	/**
	 * fixedPhone/固定电话的getter方法
	 */
	public java.lang.String getFixedPhone(){
		return fixedPhone;
	}
	/**
	 * fixedPhone/固定电话的setter方法
	 */
	public void setFixedPhone(java.lang.String fixedPhone){
		this.fixedPhone = fixedPhone;
	}
	/**
	 * email/公司邮箱的getter方法
	 */
	public java.lang.String getEmail(){
		return email;
	}
	/**
	 * email/公司邮箱的setter方法
	 */
	public void setEmail(java.lang.String email){
		this.email = email;
	}
	/**
	 * faxNumber/传真号的getter方法
	 */
	public java.lang.String getFaxNumber(){
		return faxNumber;
	}
	/**
	 * faxNumber/传真号的setter方法
	 */
	public void setFaxNumber(java.lang.String faxNumber){
		this.faxNumber = faxNumber;
	}
	/**
	 * employed/是否自营  0是 1 否的getter方法
	 */
	public java.lang.String getEmployed(){
		return employed;
	}
	/**
	 * employed/是否自营  0是 1 否的setter方法
	 */
	public void setEmployed(java.lang.String employed){
		this.employed = employed;
	}
	/**
	 * companyPath/公司地址在地图上展示用的getter方法
	 */
	public java.lang.String getCompanyPath(){
		return companyPath;
	}
	/**
	 * companyPath/公司地址在地图上展示用的setter方法
	 */
	public void setCompanyPath(java.lang.String companyPath){
		this.companyPath = companyPath;
	}
}
