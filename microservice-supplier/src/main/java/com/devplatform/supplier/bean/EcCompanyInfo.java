package com.devplatform.supplier.bean;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.devplatform.common.bean.BaseBean;


/**
 * EcCompanyInfo Mapper
 * 用于ec_company_info的数据库对应文件
 * @author zsb
 *
 */
@Table(name = "ec_company_info")
@SuppressWarnings("serial")
public class EcCompanyInfo  extends BaseBean   {
	
	
	//当需要有字段不参与数据库操作的时候，请在字段上加入@Transient
	@Id
	@GeneratedValue(generator = "JDBC")
	private Long id;////
	
	 
	@Column(name = "company_id")
	private Long companyId;//公司id//
	
	 
	@Column(name = "province_code")
	private java.lang.String provinceCode;//省id//
	
	 
	@Column(name = "city_code")
	private java.lang.String cityCode;//市id//
	
	 
	@Column(name = "area_code")
	private java.lang.String areaCode;//县id//
	
	 
	@Column(name = "postal_code")
	private Integer postalCode;//邮政编码//
	
	 
	@Column(name = "company_base_account")
	private java.lang.String companyBaseAccount;//机构基本账户账号(开户账户)//
	
	 
	@Column(name = "invoice_address")
	private java.lang.String invoiceAddress;//发票地址//
	
	 
	@Column(name = "invoice_tel")
	private java.lang.String invoiceTel;//发票联系电话（财务电话）//
	
	 
	@Column(name = "invoice_person")
	private java.lang.String invoicePerson;//发票联系人//
	
	 
	@Column(name = "tax_type")
	private java.lang.String taxType;//发票类型：1，专用，2，普通//
	
	 
	@Column(name = "tax_point")
	private java.math.BigDecimal taxPoint;//抵扣税点 0.17 ，其他目前都为0//
	
	 
	@Column(name = "tax_no")
	private java.lang.String taxNo;//税务号码（自2016年1月三证合一使用新号）//
	
	 
	@Column(name = "bank_account")
	private java.lang.String bankAccount;//银行账号//
	
	 
	@Column(name = "legal_person_name")
	private java.lang.String legalPersonName;//法人姓名//
	
	 
	@Column(name = "legal_person_id")
	private java.lang.String legalPersonId;//法人身份证件编号//
	
	 
	@Column(name = "legal_person_path1")
	private java.lang.String legalPersonPath1;//法人身份证正面//
	
	 
	@Column(name = "legal_person_path2")
	private java.lang.String legalPersonPath2;//法人身份证反面//
	
	 
	@Column(name = "institutional_bank")
	private java.lang.String institutionalBank;//机构开户银行//
	
	 
	@Column(name = "account_permit_number")
	private java.lang.String accountPermitNumber;//开户许可证编号//
	
	 
	@Column(name = "account_permit_path")
	private java.lang.String accountPermitPath;//开户许可证地址//
	
	 
	@Column(name = "business_license_path")
	private java.lang.String businessLicensePath;//营业执照地址//
	
	 
	@Column(name = "three_in_one")
	private java.lang.String threeInOne;//三证合一 0：否， 1：是//
	
	 
	@Column(name = "tax_registration_number")
	private java.lang.String taxRegistrationNumber;//税务登记证编号//
	
	 
	@Column(name = "tax_registration_path")
	private java.lang.String taxRegistrationPath;//税务登记证地址//
	
	 
	@Column(name = "company_qualification_number")
	private java.lang.String companyQualificationNumber;//企业资质编号//
	
	 
	@Column(name = "company_qualification_path")
	private java.lang.String companyQualificationPath;//企业资质地址//
	
	 
	@Column(name = "organization_certificate_code")
	private java.lang.String organizationCertificateCode;//组织机构代码证编号//
	
	 
	@Column(name = "organization_certificate_path")
	private java.lang.String organizationCertificatePath;//组织机构代码证地址//
	
	 
	@Column(name = "registered_capital")
	private Double registeredCapital;//注册资本金额//
	
	 
	@Column(name = "company_logo_path")
	private java.lang.String companyLogoPath;//公司logo地址//
	
	 
	@Column(name = "recommend_person_name")
	private java.lang.String recommendPersonName;//推荐人姓名//
	
	 
	@Column(name = "recommend_person_phone")
	private java.lang.String recommendPersonPhone;//推荐人联系方式//
	
	 
	@Column(name = "company_url")
	private java.lang.String companyUrl;//公司网址//
	
	 
	@Column(name = "operating_model")
	private java.lang.String operatingModel;//经营模式//
	
	 
	@Column(name = "main_business")
	private java.lang.String mainBusiness;//主营商品id -1为自填//
	
	 
	@Column(name = "main_business2")
	private java.lang.String mainBusiness2;//其他主营商品//
	
	 
	@Column(name = "create_time")
	private java.util.Date createTime;////日期类型，支持 yyyy/MM/dd 和 yyyy/MM/dd HH:mm:ss格式输入，其他格式需要自定义，建议不要改
	
	 
	@Column(name = "update_time")
	private java.util.Date updateTime;////日期类型，支持 yyyy/MM/dd 和 yyyy/MM/dd HH:mm:ss格式输入，其他格式需要自定义，建议不要改
	
	 
	@Column(name = "update_user_id")
	private Long updateUserId;////
	
	 
	@Column(name = "recommended_units_id")
	private Long recommendedUnitsId;//推荐单位id//
	
	 
	@Column(name = "factory_type")
	private Integer factoryType;//厂家类型 1厂家 2集成商//
	
	 
	@Column(name = "else_main_bussiness")
	private java.lang.String elseMainBussiness;//其他主营行业(手动输入）//
	
	 
	@Column(name = "vat_payer_path")
	private java.lang.String vatPayerPath;//增值税一般纳税人证明//
	
	 
	@Column(name = "financial_situation")
	private java.lang.String financialSituation;//财务状况说明1审计公司2公司自行//
	
	 
	@Column(name = "financial_situation_path")
	private java.lang.String financialSituationPath;//财务状况说明文件路径//
	
	 
	@Column(name = "authorizer")
	private java.lang.String authorizer;//授权人姓名//
	
	 
	@Column(name = "authorizer_number")
	private java.lang.String authorizerNumber;//授权人身份证件号//
	
	 
	@Column(name = "authorizer_path")
	private java.lang.String authorizerPath;//授权人身份证图片路径//
	
	 
	@Column(name = "legal_authorization_path")
	private java.lang.String legalAuthorizationPath;//法人授权书扫描件//
	
	 
	@Column(name = "authorizer_type")
	private java.lang.String authorizerType;//授权类型//
	
	 
	@Column(name = "financial_situation_name")
	private java.lang.String financialSituationName;//财务状况文件名称//
	
	 
	@Column(name = "legal_authorization_name")
	private java.lang.String legalAuthorizationName;//授权文件名称//
	
	 
	@Column(name = "business_start_time")
	private java.lang.String businessStartTime;//执照有效期开始时间//
	
	 
	@Column(name = "business_end_time")
	private java.lang.String businessEndTime;//执照有效期结束时间//
	
	 
	@Column(name = "authorizer_number_type")
	private java.lang.String authorizerNumberType;//授权人证件类型1身份证2护照//
	
	 
	@Column(name = "legal_person_id_type")
	private java.lang.String legalPersonIdType;//法人证件类型1身份证2护照//
	
	 
	@Column(name = "legal_person_passport")
	private java.lang.String legalPersonPassport;//法人护照号码//
	
	 
	@Column(name = "authorizer_passport")
	private java.lang.String authorizerPassport;//被授权人护照号码//
	
	 
	@Column(name = "old_company_name")
	private java.lang.String oldCompanyName;//原公司名//
	
	 
	@Column(name = "export_qualification")
	private Integer exportQualification;//出口资质 1是 2否//
	
	 
	@Column(name = "create_user_id")
	private Long createUserId;//创建人id//
	
	 
	@Column(name = "remarks")
	private java.lang.String remarks;//备注//
	
	 
	@Column(name = "business_license_code")
	private java.lang.String businessLicenseCode;//营业执照编号//
	
	 
	@Column(name = "taxpayer_attribute")
	private Integer taxpayerAttribute;//纳税人属性 0一般纳税人 1小规模纳税人//
	
	 
	@Column(name = "tax_eligibility_path")
	private java.lang.String taxEligibilityPath;//纳税证明地址//
	
	 
	@Column(name = "legal_passport_path")
	private java.lang.String legalPassportPath;//法人护照地址//
	
	 
	@Column(name = "clarification_name")
	private java.lang.String clarificationName;//澄清文件名称//
	
	 
	@Column(name = "clarification_path")
	private java.lang.String clarificationPath;//澄清文件地址//
	
	 
	@Column(name = "del_flag")
	private Integer delFlag;//删除标识 0 未删除  1删除//
	
	 
	@Column(name = "is_export_qualification")
	private Integer isExportQualification;//出口资质  0有 1无//
	
	 
	@Column(name = "id_type")
	private Integer idType;//证件类型   0、身份证；1、护照//
	
	 
	@Column(name = "sales_area_id")
	private java.lang.String salesAreaId;//销售区域id 以逗号拼接的方式添加省和区域的id//
	
	 
	@Column(name = "isLicenseLong")
	private Integer islicenselong;//执照是否长期   0是1否//
	
	 
	@Column(name = "isRegisteredCapital")
	private Integer isregisteredcapital;//有无注册资本  0有1无//

	/**
	 * id/的getter方法
	 */
	public Long getId(){
		return id;
	}
	/**
	 * id/的setter方法
	 */
	public void setId(Long id){
		this.id = id;
	}
	/**
	 * companyId/公司id的getter方法
	 */
	public Long getCompanyId(){
		return companyId;
	}
	/**
	 * companyId/公司id的setter方法
	 */
	public void setCompanyId(Long companyId){
		this.companyId = companyId;
	}
	/**
	 * provinceCode/省id的getter方法
	 */
	public java.lang.String getProvinceCode(){
		return provinceCode;
	}
	/**
	 * provinceCode/省id的setter方法
	 */
	public void setProvinceCode(java.lang.String provinceCode){
		this.provinceCode = provinceCode;
	}
	/**
	 * cityCode/市id的getter方法
	 */
	public java.lang.String getCityCode(){
		return cityCode;
	}
	/**
	 * cityCode/市id的setter方法
	 */
	public void setCityCode(java.lang.String cityCode){
		this.cityCode = cityCode;
	}
	/**
	 * areaCode/县id的getter方法
	 */
	public java.lang.String getAreaCode(){
		return areaCode;
	}
	/**
	 * areaCode/县id的setter方法
	 */
	public void setAreaCode(java.lang.String areaCode){
		this.areaCode = areaCode;
	}
	/**
	 * postalCode/邮政编码的getter方法
	 */
	public Integer getPostalCode(){
		return postalCode;
	}
	/**
	 * postalCode/邮政编码的setter方法
	 */
	public void setPostalCode(Integer postalCode){
		this.postalCode = postalCode;
	}
	/**
	 * companyBaseAccount/机构基本账户账号(开户账户)的getter方法
	 */
	public java.lang.String getCompanyBaseAccount(){
		return companyBaseAccount;
	}
	/**
	 * companyBaseAccount/机构基本账户账号(开户账户)的setter方法
	 */
	public void setCompanyBaseAccount(java.lang.String companyBaseAccount){
		this.companyBaseAccount = companyBaseAccount;
	}
	/**
	 * invoiceAddress/发票地址的getter方法
	 */
	public java.lang.String getInvoiceAddress(){
		return invoiceAddress;
	}
	/**
	 * invoiceAddress/发票地址的setter方法
	 */
	public void setInvoiceAddress(java.lang.String invoiceAddress){
		this.invoiceAddress = invoiceAddress;
	}
	/**
	 * invoiceTel/发票联系电话（财务电话）的getter方法
	 */
	public java.lang.String getInvoiceTel(){
		return invoiceTel;
	}
	/**
	 * invoiceTel/发票联系电话（财务电话）的setter方法
	 */
	public void setInvoiceTel(java.lang.String invoiceTel){
		this.invoiceTel = invoiceTel;
	}
	/**
	 * invoicePerson/发票联系人的getter方法
	 */
	public java.lang.String getInvoicePerson(){
		return invoicePerson;
	}
	/**
	 * invoicePerson/发票联系人的setter方法
	 */
	public void setInvoicePerson(java.lang.String invoicePerson){
		this.invoicePerson = invoicePerson;
	}
	/**
	 * taxType/发票类型：1，专用，2，普通的getter方法
	 */
	public java.lang.String getTaxType(){
		return taxType;
	}
	/**
	 * taxType/发票类型：1，专用，2，普通的setter方法
	 */
	public void setTaxType(java.lang.String taxType){
		this.taxType = taxType;
	}
	/**
	 * taxPoint/抵扣税点 0.17 ，其他目前都为0的getter方法
	 */
	public java.math.BigDecimal getTaxPoint(){
		return taxPoint;
	}
	/**
	 * taxPoint/抵扣税点 0.17 ，其他目前都为0的setter方法
	 */
	public void setTaxPoint(java.math.BigDecimal taxPoint){
		this.taxPoint = taxPoint;
	}
	/**
	 * taxNo/税务号码（自2016年1月三证合一使用新号）的getter方法
	 */
	public java.lang.String getTaxNo(){
		return taxNo;
	}
	/**
	 * taxNo/税务号码（自2016年1月三证合一使用新号）的setter方法
	 */
	public void setTaxNo(java.lang.String taxNo){
		this.taxNo = taxNo;
	}
	/**
	 * bankAccount/银行账号的getter方法
	 */
	public java.lang.String getBankAccount(){
		return bankAccount;
	}
	/**
	 * bankAccount/银行账号的setter方法
	 */
	public void setBankAccount(java.lang.String bankAccount){
		this.bankAccount = bankAccount;
	}
	/**
	 * legalPersonName/法人姓名的getter方法
	 */
	public java.lang.String getLegalPersonName(){
		return legalPersonName;
	}
	/**
	 * legalPersonName/法人姓名的setter方法
	 */
	public void setLegalPersonName(java.lang.String legalPersonName){
		this.legalPersonName = legalPersonName;
	}
	/**
	 * legalPersonId/法人身份证件编号的getter方法
	 */
	public java.lang.String getLegalPersonId(){
		return legalPersonId;
	}
	/**
	 * legalPersonId/法人身份证件编号的setter方法
	 */
	public void setLegalPersonId(java.lang.String legalPersonId){
		this.legalPersonId = legalPersonId;
	}
	/**
	 * legalPersonPath1/法人身份证正面的getter方法
	 */
	public java.lang.String getLegalPersonPath1(){
		return legalPersonPath1;
	}
	/**
	 * legalPersonPath1/法人身份证正面的setter方法
	 */
	public void setLegalPersonPath1(java.lang.String legalPersonPath1){
		this.legalPersonPath1 = legalPersonPath1;
	}
	/**
	 * legalPersonPath2/法人身份证反面的getter方法
	 */
	public java.lang.String getLegalPersonPath2(){
		return legalPersonPath2;
	}
	/**
	 * legalPersonPath2/法人身份证反面的setter方法
	 */
	public void setLegalPersonPath2(java.lang.String legalPersonPath2){
		this.legalPersonPath2 = legalPersonPath2;
	}
	/**
	 * institutionalBank/机构开户银行的getter方法
	 */
	public java.lang.String getInstitutionalBank(){
		return institutionalBank;
	}
	/**
	 * institutionalBank/机构开户银行的setter方法
	 */
	public void setInstitutionalBank(java.lang.String institutionalBank){
		this.institutionalBank = institutionalBank;
	}
	/**
	 * accountPermitNumber/开户许可证编号的getter方法
	 */
	public java.lang.String getAccountPermitNumber(){
		return accountPermitNumber;
	}
	/**
	 * accountPermitNumber/开户许可证编号的setter方法
	 */
	public void setAccountPermitNumber(java.lang.String accountPermitNumber){
		this.accountPermitNumber = accountPermitNumber;
	}
	/**
	 * accountPermitPath/开户许可证地址的getter方法
	 */
	public java.lang.String getAccountPermitPath(){
		return accountPermitPath;
	}
	/**
	 * accountPermitPath/开户许可证地址的setter方法
	 */
	public void setAccountPermitPath(java.lang.String accountPermitPath){
		this.accountPermitPath = accountPermitPath;
	}
	/**
	 * businessLicensePath/营业执照地址的getter方法
	 */
	public java.lang.String getBusinessLicensePath(){
		return businessLicensePath;
	}
	/**
	 * businessLicensePath/营业执照地址的setter方法
	 */
	public void setBusinessLicensePath(java.lang.String businessLicensePath){
		this.businessLicensePath = businessLicensePath;
	}
	/**
	 * threeInOne/三证合一 0：否， 1：是的getter方法
	 */
	public java.lang.String getThreeInOne(){
		return threeInOne;
	}
	/**
	 * threeInOne/三证合一 0：否， 1：是的setter方法
	 */
	public void setThreeInOne(java.lang.String threeInOne){
		this.threeInOne = threeInOne;
	}
	/**
	 * taxRegistrationNumber/税务登记证编号的getter方法
	 */
	public java.lang.String getTaxRegistrationNumber(){
		return taxRegistrationNumber;
	}
	/**
	 * taxRegistrationNumber/税务登记证编号的setter方法
	 */
	public void setTaxRegistrationNumber(java.lang.String taxRegistrationNumber){
		this.taxRegistrationNumber = taxRegistrationNumber;
	}
	/**
	 * taxRegistrationPath/税务登记证地址的getter方法
	 */
	public java.lang.String getTaxRegistrationPath(){
		return taxRegistrationPath;
	}
	/**
	 * taxRegistrationPath/税务登记证地址的setter方法
	 */
	public void setTaxRegistrationPath(java.lang.String taxRegistrationPath){
		this.taxRegistrationPath = taxRegistrationPath;
	}
	/**
	 * companyQualificationNumber/企业资质编号的getter方法
	 */
	public java.lang.String getCompanyQualificationNumber(){
		return companyQualificationNumber;
	}
	/**
	 * companyQualificationNumber/企业资质编号的setter方法
	 */
	public void setCompanyQualificationNumber(java.lang.String companyQualificationNumber){
		this.companyQualificationNumber = companyQualificationNumber;
	}
	/**
	 * companyQualificationPath/企业资质地址的getter方法
	 */
	public java.lang.String getCompanyQualificationPath(){
		return companyQualificationPath;
	}
	/**
	 * companyQualificationPath/企业资质地址的setter方法
	 */
	public void setCompanyQualificationPath(java.lang.String companyQualificationPath){
		this.companyQualificationPath = companyQualificationPath;
	}
	/**
	 * organizationCertificateCode/组织机构代码证编号的getter方法
	 */
	public java.lang.String getOrganizationCertificateCode(){
		return organizationCertificateCode;
	}
	/**
	 * organizationCertificateCode/组织机构代码证编号的setter方法
	 */
	public void setOrganizationCertificateCode(java.lang.String organizationCertificateCode){
		this.organizationCertificateCode = organizationCertificateCode;
	}
	/**
	 * organizationCertificatePath/组织机构代码证地址的getter方法
	 */
	public java.lang.String getOrganizationCertificatePath(){
		return organizationCertificatePath;
	}
	/**
	 * organizationCertificatePath/组织机构代码证地址的setter方法
	 */
	public void setOrganizationCertificatePath(java.lang.String organizationCertificatePath){
		this.organizationCertificatePath = organizationCertificatePath;
	}
	/**
	 * registeredCapital/注册资本金额的getter方法
	 */
	public Double getRegisteredCapital(){
		return registeredCapital;
	}
	/**
	 * registeredCapital/注册资本金额的setter方法
	 */
	public void setRegisteredCapital(Double registeredCapital){
		this.registeredCapital = registeredCapital;
	}
	/**
	 * companyLogoPath/公司logo地址的getter方法
	 */
	public java.lang.String getCompanyLogoPath(){
		return companyLogoPath;
	}
	/**
	 * companyLogoPath/公司logo地址的setter方法
	 */
	public void setCompanyLogoPath(java.lang.String companyLogoPath){
		this.companyLogoPath = companyLogoPath;
	}
	/**
	 * recommendPersonName/推荐人姓名的getter方法
	 */
	public java.lang.String getRecommendPersonName(){
		return recommendPersonName;
	}
	/**
	 * recommendPersonName/推荐人姓名的setter方法
	 */
	public void setRecommendPersonName(java.lang.String recommendPersonName){
		this.recommendPersonName = recommendPersonName;
	}
	/**
	 * recommendPersonPhone/推荐人联系方式的getter方法
	 */
	public java.lang.String getRecommendPersonPhone(){
		return recommendPersonPhone;
	}
	/**
	 * recommendPersonPhone/推荐人联系方式的setter方法
	 */
	public void setRecommendPersonPhone(java.lang.String recommendPersonPhone){
		this.recommendPersonPhone = recommendPersonPhone;
	}
	/**
	 * companyUrl/公司网址的getter方法
	 */
	public java.lang.String getCompanyUrl(){
		return companyUrl;
	}
	/**
	 * companyUrl/公司网址的setter方法
	 */
	public void setCompanyUrl(java.lang.String companyUrl){
		this.companyUrl = companyUrl;
	}
	/**
	 * operatingModel/经营模式的getter方法
	 */
	public java.lang.String getOperatingModel(){
		return operatingModel;
	}
	/**
	 * operatingModel/经营模式的setter方法
	 */
	public void setOperatingModel(java.lang.String operatingModel){
		this.operatingModel = operatingModel;
	}
	/**
	 * mainBusiness/主营商品id -1为自填的getter方法
	 */
	public java.lang.String getMainBusiness(){
		return mainBusiness;
	}
	/**
	 * mainBusiness/主营商品id -1为自填的setter方法
	 */
	public void setMainBusiness(java.lang.String mainBusiness){
		this.mainBusiness = mainBusiness;
	}
	/**
	 * mainBusiness2/其他主营商品的getter方法
	 */
	public java.lang.String getMainBusiness2(){
		return mainBusiness2;
	}
	/**
	 * mainBusiness2/其他主营商品的setter方法
	 */
	public void setMainBusiness2(java.lang.String mainBusiness2){
		this.mainBusiness2 = mainBusiness2;
	}
	/**
	 * createTime/的getter方法
	 */
	public java.util.Date getCreateTime(){
		return createTime;
	}
	/**
	 * createTime/的setter方法
	 */
	public void setCreateTime(java.util.Date createTime){
		this.createTime = createTime;
	}
	/**
	 * updateTime/的getter方法
	 */
	public java.util.Date getUpdateTime(){
		return updateTime;
	}
	/**
	 * updateTime/的setter方法
	 */
	public void setUpdateTime(java.util.Date updateTime){
		this.updateTime = updateTime;
	}
	/**
	 * updateUserId/的getter方法
	 */
	public Long getUpdateUserId(){
		return updateUserId;
	}
	/**
	 * updateUserId/的setter方法
	 */
	public void setUpdateUserId(Long updateUserId){
		this.updateUserId = updateUserId;
	}
	/**
	 * recommendedUnitsId/推荐单位id的getter方法
	 */
	public Long getRecommendedUnitsId(){
		return recommendedUnitsId;
	}
	/**
	 * recommendedUnitsId/推荐单位id的setter方法
	 */
	public void setRecommendedUnitsId(Long recommendedUnitsId){
		this.recommendedUnitsId = recommendedUnitsId;
	}
	/**
	 * factoryType/厂家类型 1厂家 2集成商的getter方法
	 */
	public Integer getFactoryType(){
		return factoryType;
	}
	/**
	 * factoryType/厂家类型 1厂家 2集成商的setter方法
	 */
	public void setFactoryType(Integer factoryType){
		this.factoryType = factoryType;
	}
	/**
	 * elseMainBussiness/其他主营行业(手动输入）的getter方法
	 */
	public java.lang.String getElseMainBussiness(){
		return elseMainBussiness;
	}
	/**
	 * elseMainBussiness/其他主营行业(手动输入）的setter方法
	 */
	public void setElseMainBussiness(java.lang.String elseMainBussiness){
		this.elseMainBussiness = elseMainBussiness;
	}
	/**
	 * vatPayerPath/增值税一般纳税人证明的getter方法
	 */
	public java.lang.String getVatPayerPath(){
		return vatPayerPath;
	}
	/**
	 * vatPayerPath/增值税一般纳税人证明的setter方法
	 */
	public void setVatPayerPath(java.lang.String vatPayerPath){
		this.vatPayerPath = vatPayerPath;
	}
	/**
	 * financialSituation/财务状况说明1审计公司2公司自行的getter方法
	 */
	public java.lang.String getFinancialSituation(){
		return financialSituation;
	}
	/**
	 * financialSituation/财务状况说明1审计公司2公司自行的setter方法
	 */
	public void setFinancialSituation(java.lang.String financialSituation){
		this.financialSituation = financialSituation;
	}
	/**
	 * financialSituationPath/财务状况说明文件路径的getter方法
	 */
	public java.lang.String getFinancialSituationPath(){
		return financialSituationPath;
	}
	/**
	 * financialSituationPath/财务状况说明文件路径的setter方法
	 */
	public void setFinancialSituationPath(java.lang.String financialSituationPath){
		this.financialSituationPath = financialSituationPath;
	}
	/**
	 * authorizer/授权人姓名的getter方法
	 */
	public java.lang.String getAuthorizer(){
		return authorizer;
	}
	/**
	 * authorizer/授权人姓名的setter方法
	 */
	public void setAuthorizer(java.lang.String authorizer){
		this.authorizer = authorizer;
	}
	/**
	 * authorizerNumber/授权人身份证件号的getter方法
	 */
	public java.lang.String getAuthorizerNumber(){
		return authorizerNumber;
	}
	/**
	 * authorizerNumber/授权人身份证件号的setter方法
	 */
	public void setAuthorizerNumber(java.lang.String authorizerNumber){
		this.authorizerNumber = authorizerNumber;
	}
	/**
	 * authorizerPath/授权人身份证图片路径的getter方法
	 */
	public java.lang.String getAuthorizerPath(){
		return authorizerPath;
	}
	/**
	 * authorizerPath/授权人身份证图片路径的setter方法
	 */
	public void setAuthorizerPath(java.lang.String authorizerPath){
		this.authorizerPath = authorizerPath;
	}
	/**
	 * legalAuthorizationPath/法人授权书扫描件的getter方法
	 */
	public java.lang.String getLegalAuthorizationPath(){
		return legalAuthorizationPath;
	}
	/**
	 * legalAuthorizationPath/法人授权书扫描件的setter方法
	 */
	public void setLegalAuthorizationPath(java.lang.String legalAuthorizationPath){
		this.legalAuthorizationPath = legalAuthorizationPath;
	}
	/**
	 * authorizerType/授权类型的getter方法
	 */
	public java.lang.String getAuthorizerType(){
		return authorizerType;
	}
	/**
	 * authorizerType/授权类型的setter方法
	 */
	public void setAuthorizerType(java.lang.String authorizerType){
		this.authorizerType = authorizerType;
	}
	/**
	 * financialSituationName/财务状况文件名称的getter方法
	 */
	public java.lang.String getFinancialSituationName(){
		return financialSituationName;
	}
	/**
	 * financialSituationName/财务状况文件名称的setter方法
	 */
	public void setFinancialSituationName(java.lang.String financialSituationName){
		this.financialSituationName = financialSituationName;
	}
	/**
	 * legalAuthorizationName/授权文件名称的getter方法
	 */
	public java.lang.String getLegalAuthorizationName(){
		return legalAuthorizationName;
	}
	/**
	 * legalAuthorizationName/授权文件名称的setter方法
	 */
	public void setLegalAuthorizationName(java.lang.String legalAuthorizationName){
		this.legalAuthorizationName = legalAuthorizationName;
	}
	/**
	 * businessStartTime/执照有效期开始时间的getter方法
	 */
	public java.lang.String getBusinessStartTime(){
		return businessStartTime;
	}
	/**
	 * businessStartTime/执照有效期开始时间的setter方法
	 */
	public void setBusinessStartTime(java.lang.String businessStartTime){
		this.businessStartTime = businessStartTime;
	}
	/**
	 * businessEndTime/执照有效期结束时间的getter方法
	 */
	public java.lang.String getBusinessEndTime(){
		return businessEndTime;
	}
	/**
	 * businessEndTime/执照有效期结束时间的setter方法
	 */
	public void setBusinessEndTime(java.lang.String businessEndTime){
		this.businessEndTime = businessEndTime;
	}
	/**
	 * authorizerNumberType/授权人证件类型1身份证2护照的getter方法
	 */
	public java.lang.String getAuthorizerNumberType(){
		return authorizerNumberType;
	}
	/**
	 * authorizerNumberType/授权人证件类型1身份证2护照的setter方法
	 */
	public void setAuthorizerNumberType(java.lang.String authorizerNumberType){
		this.authorizerNumberType = authorizerNumberType;
	}
	/**
	 * legalPersonIdType/法人证件类型1身份证2护照的getter方法
	 */
	public java.lang.String getLegalPersonIdType(){
		return legalPersonIdType;
	}
	/**
	 * legalPersonIdType/法人证件类型1身份证2护照的setter方法
	 */
	public void setLegalPersonIdType(java.lang.String legalPersonIdType){
		this.legalPersonIdType = legalPersonIdType;
	}
	/**
	 * legalPersonPassport/法人护照号码的getter方法
	 */
	public java.lang.String getLegalPersonPassport(){
		return legalPersonPassport;
	}
	/**
	 * legalPersonPassport/法人护照号码的setter方法
	 */
	public void setLegalPersonPassport(java.lang.String legalPersonPassport){
		this.legalPersonPassport = legalPersonPassport;
	}
	/**
	 * authorizerPassport/被授权人护照号码的getter方法
	 */
	public java.lang.String getAuthorizerPassport(){
		return authorizerPassport;
	}
	/**
	 * authorizerPassport/被授权人护照号码的setter方法
	 */
	public void setAuthorizerPassport(java.lang.String authorizerPassport){
		this.authorizerPassport = authorizerPassport;
	}
	/**
	 * oldCompanyName/原公司名的getter方法
	 */
	public java.lang.String getOldCompanyName(){
		return oldCompanyName;
	}
	/**
	 * oldCompanyName/原公司名的setter方法
	 */
	public void setOldCompanyName(java.lang.String oldCompanyName){
		this.oldCompanyName = oldCompanyName;
	}
	/**
	 * exportQualification/出口资质 1是 2否的getter方法
	 */
	public Integer getExportQualification(){
		return exportQualification;
	}
	/**
	 * exportQualification/出口资质 1是 2否的setter方法
	 */
	public void setExportQualification(Integer exportQualification){
		this.exportQualification = exportQualification;
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
	 * businessLicenseCode/营业执照编号的getter方法
	 */
	public java.lang.String getBusinessLicenseCode(){
		return businessLicenseCode;
	}
	/**
	 * businessLicenseCode/营业执照编号的setter方法
	 */
	public void setBusinessLicenseCode(java.lang.String businessLicenseCode){
		this.businessLicenseCode = businessLicenseCode;
	}
	/**
	 * taxpayerAttribute/纳税人属性 0一般纳税人 1小规模纳税人的getter方法
	 */
	public Integer getTaxpayerAttribute(){
		return taxpayerAttribute;
	}
	/**
	 * taxpayerAttribute/纳税人属性 0一般纳税人 1小规模纳税人的setter方法
	 */
	public void setTaxpayerAttribute(Integer taxpayerAttribute){
		this.taxpayerAttribute = taxpayerAttribute;
	}
	/**
	 * taxEligibilityPath/纳税证明地址的getter方法
	 */
	public java.lang.String getTaxEligibilityPath(){
		return taxEligibilityPath;
	}
	/**
	 * taxEligibilityPath/纳税证明地址的setter方法
	 */
	public void setTaxEligibilityPath(java.lang.String taxEligibilityPath){
		this.taxEligibilityPath = taxEligibilityPath;
	}
	/**
	 * legalPassportPath/法人护照地址的getter方法
	 */
	public java.lang.String getLegalPassportPath(){
		return legalPassportPath;
	}
	/**
	 * legalPassportPath/法人护照地址的setter方法
	 */
	public void setLegalPassportPath(java.lang.String legalPassportPath){
		this.legalPassportPath = legalPassportPath;
	}
	/**
	 * clarificationName/澄清文件名称的getter方法
	 */
	public java.lang.String getClarificationName(){
		return clarificationName;
	}
	/**
	 * clarificationName/澄清文件名称的setter方法
	 */
	public void setClarificationName(java.lang.String clarificationName){
		this.clarificationName = clarificationName;
	}
	/**
	 * clarificationPath/澄清文件地址的getter方法
	 */
	public java.lang.String getClarificationPath(){
		return clarificationPath;
	}
	/**
	 * clarificationPath/澄清文件地址的setter方法
	 */
	public void setClarificationPath(java.lang.String clarificationPath){
		this.clarificationPath = clarificationPath;
	}
	/**
	 * delFlag/删除标识 0 未删除  1删除的getter方法
	 */
	public Integer getDelFlag(){
		return delFlag;
	}
	/**
	 * delFlag/删除标识 0 未删除  1删除的setter方法
	 */
	public void setDelFlag(Integer delFlag){
		this.delFlag = delFlag;
	}
	/**
	 * isExportQualification/出口资质  0有 1无的getter方法
	 */
	public Integer getIsExportQualification(){
		return isExportQualification;
	}
	/**
	 * isExportQualification/出口资质  0有 1无的setter方法
	 */
	public void setIsExportQualification(Integer isExportQualification){
		this.isExportQualification = isExportQualification;
	}
	/**
	 * idType/证件类型   0、身份证；1、护照的getter方法
	 */
	public Integer getIdType(){
		return idType;
	}
	/**
	 * idType/证件类型   0、身份证；1、护照的setter方法
	 */
	public void setIdType(Integer idType){
		this.idType = idType;
	}
	/**
	 * salesAreaId/销售区域id 以逗号拼接的方式添加省和区域的id的getter方法
	 */
	public java.lang.String getSalesAreaId(){
		return salesAreaId;
	}
	/**
	 * salesAreaId/销售区域id 以逗号拼接的方式添加省和区域的id的setter方法
	 */
	public void setSalesAreaId(java.lang.String salesAreaId){
		this.salesAreaId = salesAreaId;
	}
	/**
	 * islicenselong/执照是否长期   0是1否的getter方法
	 */
	public Integer getIslicenselong(){
		return islicenselong;
	}
	/**
	 * islicenselong/执照是否长期   0是1否的setter方法
	 */
	public void setIslicenselong(Integer islicenselong){
		this.islicenselong = islicenselong;
	}
	/**
	 * isregisteredcapital/有无注册资本  0有1无的getter方法
	 */
	public Integer getIsregisteredcapital(){
		return isregisteredcapital;
	}
	/**
	 * isregisteredcapital/有无注册资本  0有1无的setter方法
	 */
	public void setIsregisteredcapital(Integer isregisteredcapital){
		this.isregisteredcapital = isregisteredcapital;
	}
}
