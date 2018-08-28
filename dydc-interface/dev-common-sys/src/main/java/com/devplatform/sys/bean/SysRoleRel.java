package com.devplatform.sys.bean;

@SuppressWarnings("serial")
public class SysRoleRel extends BaseBean {

	private String roleId;// 角色主键 sys_role.id
	private String objId;// 关联主键 type=0管理sys_menu.id, type=1关联sys_user.id
	private Integer relType;// 关联类型 0=菜单,1=用户

	/**
	 * 枚举
	 * 
	 * @author
	 * 
	 */
	public static enum RelType {
		MENU(0, "菜单"), USER(1, "用户"), BTN(2, "按钮");
		public int key;
		public String value;

		private RelType(int key, String value) {
			this.key = key;
			this.value = value;
		}

		public static RelType get(int key) {
			RelType[] values = RelType.values();
			for (RelType object : values) {
				if (object.key == key) {
					return object;
				}
			}
			return null;
		}
	}

	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getObjId() {
		return this.objId;
	}

	public void setObjId(String objId) {
		this.objId = objId;
	}

	public Integer getRelType() {
		return this.relType;
	}

	public void setRelType(Integer relType) {
		this.relType = relType;
	}
}
