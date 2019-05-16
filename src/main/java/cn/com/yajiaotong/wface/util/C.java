package cn.com.yajiaotong.wface.util;

/**
 * 普通常量类
 * @author meizhiwen
 *
 */
public class C {

	//============================mybatis 通用映射文件命名空间===================================
	public static final String NAMESPACE_COMMON="common";
	
	//===================mybatis mapper文件通用的方法名称id=========================
	public static final String METHOD_ADD="add";
	public static final String METHOD_ADDBATCH="addBatch";
	public static final String METHOD_UPDATE="update";
	public static final String METHOD_AUDITUPDATE="auditUpdate";
	public static final String METHOD_DELETE="delete";
	public static final String METHOD_FIND="find";
	public static final String METHOD_FINDINEFFECT="findInEffect";
	public static final String METHOD_FINDBYID="findById";
	public static final String METHOD_IDBATCHFIND="idBatchFind";
	public static final String METHOD_AUDITFINDBYID="auditfindbyid";
	public static final String METHOD_GETRECORDIDBYAUDITID="getRecordIdsByAuditId";
	public static final String METHOD_LISTPAGE="listPage";
	public static final String METHOD_AUDITLISTPAGE="auditListPage";
	public static final String METHOD_FINDALL="findAll";
	public static final String METHOD_DELETEALL="deleteAll";
	public static final String METHOD_DELETEALL2="deleteAll2";
	public static final String METHOD_DELETEALL3="deleteAll3";
	public static final String METHOD_FINDIPANDNAME="findIdAndName";
	
	
	public static final String USER_ALLUSERLISTPAGE="allUserListPage";
	public static final String USER_UPDATELASTLOGINDATE="updateLastLoginDate";
	public static final String USER_UPDATEPASSWORD="updatePassword";
	
	public static final String USER_ROLE_FINDROLE_IDBYUSER_ID="findRole_idByUser_id";
	public static final String USER_ROLE_DELETEROLEIDBYUSERID="deleteRoleIdByUserId";
	public static final String USER_ROLE_FINDPERMISSIONIDBYUSERID="findPermissionIdByUserId";
	
	public static final String ROLE_FINDSHOWPERMISSION = "findShowPermission";
	public static final String ROLE_DELETEPERMISSIONIDBYROLEID = "deletePermissionIdByRoleId";
	public static final String ROLE_FINDPERMISSIONIDBYROLEID = "findPermissionIdByRoleId";
	
	
	public static final String PERMISSION_FINDALLPERMISSION = "findAllPermission";
	
	public static final String BLACKLIST_UPDATECACHESYNC = "updateCacheSync";
	
	
	
	
	//============================session key=======================================
	public static final String UID="uid";
	public static final String DEPTID="deptId";
	public static final String UNAME="uname";
	public static final String LOGINNAME="loginName";
	public static final String LASTLOGINDATE="lastLoginDate";
	public static final String USERCREATEDATE="userCreateDate";
	public static final String UPLIST="upList";
	public static final String FLIST="fList";
	public static final String SMAP="sMap";
	
	//==============================表名==============================================
	public static final String T_DEPARTMENT="department";

	//==============================其它=================================================
	
	public static final Object TXT = "txt";

	public static final Object XLS = "xls";

	public static final Object XLSX = "xlsx";

	public static final int CAPTCHA_EXPIRETIME = 5*60;//5 分钟，手机验证码5分钟失效

	public static final String TITLE = "title";
	
	public static final String CONTENT = "content";
	
	//======================================系统配置属性=======================================
	
	public static final String SIGN="sign";  //系统签名
	
	public static final String SMSSAVETIME="smssavetime";  //短信保存时间
	
	public static final String LOGSAVETIME="logsavetime";  //日志保存时间
	

}
