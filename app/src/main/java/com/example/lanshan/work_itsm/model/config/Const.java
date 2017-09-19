package com.example.lanshan.work_itsm.model.config;

/**
 * @Description:
 * @author: ragkan
 * @time: 2016/7/5 14:06
 */
public interface Const {

    String domain = "http://10.114.72.190:8098/CD-ITSMXT/service/rest/";

    String UPDATEAPKPATH = "api/user/getVersionInfo";

    String ACacheDomain = "aCacheDomain";

    String TYPE_LOGIN_INPUT = "input";
    String TYPE_LOGIN_SCAN = "scan";

    //String BASE_URL = domain + "api/";

    //服务器端存放异常日志路径
    String SERVER_CRASH_PATH = "C:\\xczy\\appCrash\\$date{yyyy}\\$date{MM}";
    //fileDown
    String fileName = "xczy_file";



    //缓存有效期 10个小时
    int cache_time = 1000 * 60 * 60 * 10;
    int cache_location_time = 1000 * 60 * 15;
    //attach
//    String attachUrl = domain + "attach/downloadAttach.do?attachId=";

    //photo
    int UPLOAD_PHOTO_NUM = 6;
    String DEFAULT_PHOTO_PATH = "000000";

    //需要地刷新
    int REFRESH = 100;
    //跳转
    int SKIP = 300;
    //不需要地刷新
    int NO_REFRESH = 200;
    String IS_REFRESH = "is_refresh";

    //刷卡审批提交
    String TYPE_SWIPE = "swipe";

    //保存本地用户信息key
    String ACACHE_UPLOAD_JS = "acacheUploadJS";
    String ACACHE_UPLOAD_JS_POSITION = "acacheUploadJSPosition";
    String ACACHE_USER = "acacheUser";
    String ACACHE_ACCOUNT = "acacheAccount";
    //保存列表信息key
    String ACACHE_ToDoList = "acacheToDoList";
    String ACACHE_DoneList = "acacheDoneList";
    String ACACHE_ApplyList = "acacheApplyList";
    String ACACHE_ApplyFindList = "acacheApplyFindList";
    String ACACHE_IllegalList = "acacheIllegalList";
    String ACACHE_SearchTodoList = "acacheSerrchTodoList";
    String ACACHE_SearchDoneList = "acacheSearchDoneList";
    String ACACHE_SearchOrderList = "acacheSearchOrderList";
    String ACACHE_SearchApplyList = "acacheSearchApplyList";
    String ACACHE_SafeJoinList = "acacheSafeJoinList";
    String ACACHE_UserMgrList = "acacheUserMgrList";
    String ACACHE_ApproveLicenceList = "acacheApproveLicenceList";//缓存审批信息

    String ACACHE_SubWorkList = "acacheSubWorkList";
    String ACACHE_EneIsolationList = "acacheEneIsolationList";
    String ACACHE_JSAList = "acacheJSAList";
    String ACACHE_WorkOrderList = "acacheWorkOrderList";
    String ACACHE_UserMgrSearchList = "acacheUserMgrSearchList";
    String ACACHE_LOCATION_TIME = "locationTime";
    String ACACHE_LOCATION_POINT = "locationPoint";

    String ACACHE_SCAN_TYPE = "scanType";
    String SCAN_TYPE_LOGIN = "scanLogin";
    String SCAN_TYPE_USER_INPUT = "userInputCode";

    String SCAN_TYPE_7 = "bigApprovePagesCheck";//审查
    String SCAN_TYPE_1 = "bigApproveView";//批准人现场确认-措施确认人
    String SCAN_TYPE_6 = "bigApproveAffectedSign";//相关方改变
    String SCAN_TYPE_2 = "bigApproveConfirm";//现场操作-属地单位现场操作人员
    String SCAN_TYPE_3 = "bigApprovePremit";//作业许可批准-作业批准人
    String SCAN_TYPE_4 = "bigApproveTest";//检测分析结果-确认人
    String SCAN_TYPE_5 = "bigApproveConfirmchange";//现场确认人改变

    String SCAN_TYPE_F1 = "fireApproveCheck";//审查-
    String SCAN_TYPE_F10 = "fireApproveConfirm";//现场确认-属地单位确认人
    String SCAN_TYPE_F14 = "fireApproveWorkConfirm";//现场确认-作业单位确认人
    String SCAN_TYPE_F2 = "fireApproveWorkUser";//作业人-作业人
    String SCAN_TYPE_F3 = "fireApproveWorkMonitor";//作业监护-作业单位监护人
    String SCAN_TYPE_F4 = "fireApprovePMonitor";//作业监护-属地单位监护人
    String SCAN_TYPE_F5 = "fireApproveHSE";//监护-属地单位HSE工程师
    String SCAN_TYPE_F6 = "fireApprovePremit";//批准-动火作业批准人
    String SCAN_TYPE_F7 = "fireApproveTest";//检测分析结果-属地单位确认人
    String SCAN_TYPE_F11 = "fireApproveWorkMonitorChange";//作业单位监护人-变更
    String SCAN_TYPE_F12 = "fireApprovePMonitorChange";//属地单位监护人-变更
    String SCAN_TYPE_F13 = "fireApprovePAffectedsign";//相关方会签

    String SCAN_TYPE_P1 = "powerApproveWorkShopConfirm";//审查-电气车间确认人
    String SCAN_TYPE_P2 = "powerApproveCheckUser";//审核-电气车间审核人
    String SCAN_TYPE_P3 = "powerApprovePremit";//批准-临时用户批准人
    String SCAN_TYPE_P4 = "powerApproveOperatorUserName";//接线-接线人
    String SCAN_TYPE_P5 = "powerApproveSend";//送电-送电人
    String SCAN_TYPE_P6 = "powerApproveOrgConfirm";//送电-送电人

    //高处作业
    String SCAN_Height_TYPE_1 = "heightApproveExzame";//审查
    String SCAN_Height_TYPE_2 = "heightApproveJobUser";//作业人人审批
    String SCAN_Height_TYPE_3 = "heightApproveMonitor";//监护人审批
    String SCAN_Height_TYPE_4 = "heightApproveCommiter";//属地单位现场确认
    String SCAN_Height_TYPE_5 = "heightApproveAprrove";//审批
    String SCAN_Height_TYPE_6 = "heightApproveGetUse";
    String SCAN_Height_TYPE_7 = "heightApproveChooseMonitorU";//监护人变更
    String SCAN_Height_TYPE_8 = "heightApproveXiangGuanFang";//相关方会审
    String SCAN_Height_TYPE_9 = "heightApproveCommiterZuoYe";//作业单位现场确认

    String SCAN_TYPE_C1 = "commonApproveCheck";//审查-
    String SCAN_TYPE_C2 = "commonApproveTConfirm";//现场确认-属地单位确认人
    String SCAN_TYPE_C3 = "commonApproveWorkConfirm";//现场确认-作业单位确认人
    String SCAN_TYPE_C4 = "commonApproveWorkUser";//作业人-作业人
    String SCAN_TYPE_C5 = "commonApproveWorkMonitor";//作业监护-作业单位监护人
    String SCAN_TYPE_C6 = "commonApprovePMonitor";//作业监护-属地单位监护人
    String SCAN_TYPE_C7 = "commonApproveHSE";//监护-属地单位HSE工程师
    String SCAN_TYPE_C8 = "commonApproveTAffectedsign";//属地单位会签
    String SCAN_TYPE_C9 = "commonApproveUnitAffectedsign";//相关方会签
    String SCAN_TYPE_C10 = "commonApprovePremit";//批准-作业批准人
    String SCAN_TYPE_C11 = "commonApproveTest";//检测分析结果-属地单位确认人
    String SCAN_TYPE_C12 = "commonApproveWorkUserOk";//作业人ok
    String SCAN_TYPE_C13 = "commonApproveTAffectedSignOk";//属地单位会签ok
    String SCAN_TYPE_C14 = "commonApproveUnitAffectedsignOk";//相关方会签ok
    String SCAN_TYPE_C15 = "commonApproveWorkMonitorChange";//作业单位监护人-变更
    String SCAN_TYPE_C16 = "commonApprovePMonitorChange";//属地单位监护人-变更

    //吊装作业
    String SCAN_HOISTING_TYPE_1 = "hoistingApproveExzame";//审查
    String SCAN_HOISTING_TYPE_2 = "hoistingApproveCommiter";//属地单位现场确认
    String SCAN_HOISTING_TYPE_3 = "hoistingApproveCommiterZuoYe";//作业单位现场确认
    String SCAN_HOISTING_TYPE_4 = "hoistingApproveJobUserQZJ";//起重机操作人审批
    String SCAN_HOISTING_TYPE_5 = "hoistingApproveJobUserSS";//司索人员审批
    String SCAN_HOISTING_TYPE_6 = "hoistingApproveMonitor";//监护人审批
    String SCAN_HOISTING_TYPE_7 = "hoistingApproveSuDiHuiQian";//属地单位会签
    String SCAN_HOISTING_TYPE_8 = "hoistingApproveXiangGuanFang";//相关方会审
    String SCAN_HOISTING_TYPE_9 = "hoistingApproveAprrove";//批准
    String SCAN_HOISTING_TYPE_10 = "hoistingApproveChooseMonitorU";//监护人变更

    //能量隔离刷卡选人
    String SCAN_ENE_TYPE_ZUOYEMAN = "scanEneTypeZuoYeMan";
    String SCAN_ENE_TYPE_CESHIMAN = "scanEneTypeCeShiMan";
    //待办
    int TODO_TYPE = 1;
    //已办
    int DONE_TYPE = 2;
    //管理
    int MGR_TYPE = 3;

    //添加
    int ADD = 1;
    //修改
    int UPDATE = 2;
    //添加 后跳转
    int ADD_SKIP = 6;
    //详情
    int INFO = 3;
    int DELETE = 4;
    int APPROVE = 5;
    int TOINFO = 7;
    //刷卡
    int SCAN = 10;
    //变更
    int MODIFY = 11;
    //录入气体检测结果
    int INPUT = 12;
    //发起紧急作业流程
    int URGENCY = 13;
    int FIRES = 14;//动火
    int SPACES = 15;//受限空间
    int SAFEJOIN = 16;
    //刷卡确认
    int USECARDCOMMIT = 8;
    int INFOPASS = 9;//通过
    //菜单权限
    String TYPE_URGENCY = "urgency";
    String TYPE_JSA = "jsa";
    String TYPE_CHECK = "check";

    //菜单权限
    String MENU_OPERATION = "OPERATION_MENU";
    String MENU_SUBSCRIBE = "SUBSCRIBE_MENU";
    String MENU_JSABO = "JSABO_MENU";
    String MENU_ISOLATION = "ISOLATION_MENU";
    String MENU_MOR = "ILLegal_RECORD_MOR";
    String MENU_URGENCY_ADD = "jobSlipApply_urgency";
    String MENU_SAFE_JOIN = "Safety_RECORD_saf";//安全交底
    String MENU_USER_MRG = "userMrg";//用户管理

    //待办任务状态
    String TYPE_DONE_FINISH = "已完成";
    String TYPE_DONE_UNFINISH = "未通过";

    //是否需要判断权限(0否，1是)
    String TYPE_SCAN_USER = "1";
    String TYPE_GET_USER = "0";

    /**
     * 流程状态 JobSlipType
     **/
    //ZyxkzPermit:作业许可证
    String TYPE_OPERATION = "ZyxkzPermit";
    //YjdhPermit:1级动火许可证
    String TYPE_FIRST_FIRE = "YjdhPermit";
    //EjdhPermit:2级动火许可证
    String TYPE_SECOND_FIRE = "EjdhPermit";
    //TsdhPermit:特级动火许可证
    String TYPE_SPECIAL_FIRE = "TsdhPermit";
    String TYPE_WORK_SUB = "ZYYY";//作业预约
    String TYPE_WORK_ENE = "NLGL";//能量隔离
    String TYPE_HEIGHT = "GczyPermit";//高处作业
    String TYPE_POWER = "LsydPermit";//临时用电
    String TYPE_SCAFFOLD = "JsjzyPermit";

    String TYPE_PIPELINE = "SbgxPermit";//管线/设备
    String TYPE_HOISTING = "DzzyPermit";//吊装
    String TYPE_STAGING = "JsjzyPermit";//脚手架
    String TYPE_SPACE = "SxkjPermit";//受限空间
    String TYPE_EXCAVATE = "WjzyPermit";//挖掘
    String TYPE_GRILLING = "GszyPermit";//格栅
    String TYPE_RAY = "SxzyPermit";//射线

    /**
     * status
     * 流程审批状态 0:未送审 1:审批中 2:通过 3:未通过
     **/
    int STATUS_NOT_AUDIT = 0;
    int STATUS_AUDITING = 1;
    int STATUS_PASS = 2;
    int STATUS_NOT_PASS = 3;

    /**
     * 安全分析 状态 0:暂存 2:已提交
     **/
    int STATUS_UN = 0;
    int STATUS_SUBMIT = 2;

    /**
     * 作业预约状态 0:未发起 1:审批中 2:通过 3:驳回
     **/
    int SUB_STATUS_UN = 0;
    int SUB_STATUS_DOING = 1;
    int SUB_STATUS_PASS = 2;
    int SUB_STATUS_UNPASS = 3;

    /**
     * perStatus
     * 作业票状态 0:紧急 1:申请 2:延期 3:取消 4:关闭
     **/
    int PER_STATUS_URGRNCY = 0;
    int PER_STATUS_APPROVAL = 1;
    int PER_STATUS_DELAY = 2;
    int PER_STATUS_CANCEL = 3;
    int PER_STATUS_CLOSE = 4;

    /**
     * operationSubscribe/getCommonDevice
     * 基础信息请求的类型：
     * 装置：equipment 作业位置:location
     * 所属区域：zone,审批人：userFlow
     **/
    String TYPE_COMMON_EQUI = "equipment";
    String TYPE_COMMON_LOC = "location";
    String TYPE_COMMON_ZONE = "zone";
    String TYPE_COMMON_USER = "userFlow";
    String TYPE_COMMON_USER_ALL = "allUser";
    String TYPE_COMMON_USER1 = "userFlow";
    String TYPE_COMMON_USER2 = "userFlow";
    String TYPE_COMMON_ORG = "org";
    String TYPE_COMMON_DEPT = "dept";
    String TYPE_COMMON_RISK = "risk";
    String TYPE_COMMON_ZONE_ORG = "zoneOrg";

    /**
     * 参数值：作业预约 ZYYYSPR 能量隔离 NLGLSDQYSPR
     */
    String TYPE_COMMON_SUB = "ZYYYSPR";
    String TYPE_COMMON_JSA = "AQFXSPR";
    String TYPE_COMMON_ENE = "NLGLSDQYSPR";
    String TYPE_COMMON_URGENCY = "JJZYPZ";
    String TYPE_COMMON_ANALYSIS = "AQFXFZR";

    /**
     * 发起流程 processDefineCode参数值
     */
    String TYPE_PROCESS_URGENCY = "jobSlipJj";
    String TYPE_PROCESS_SUB = "operationSubscribe";
    String TYPE_PROCESS_ENE = "isolationChange";

    /**
     * bpmType
     * 流程类型 1:申请 2:关闭 3:取消 4:延期
     **/
    String BPM_TYPE_SHENQING = "shenqing";
    String BPM_TYPE_GUANBI = "guanbi";
    String BPM_TYPE_QUXIAO = "quxiao";
    String BPM_TYPE_YANQI = "yanqi";

    /**
     * type
     * 流程审批类型 shenhe:审批（一个用户） huiqian:会签（多用户）
     **/
    String TYPE_SHENHE = "shenhe";
    String TYPE_HUIQIAN = "huiqian";

    /**
     * category
     * 界面不同的分类
     **/
    //jbxx  基础信息
    //String CATEGORY_BASE = "jbxx";

    //未开始审批流程
    String BPM_NODE_NONE = "none";

    //流程名称：书面审查
    String BPM_NODE_B1_SMSC = "smsc";
    //批准人现场有确认
    String BPM_NODE_B2_PZRXCQR = "pzrxcqr";
    //受影响相关方会签
    String BPM_NODE_B3_SYXXGFHG = "syxxgfhq";
    //现场操作
    String BPM_NODE_B4_XCCZ = "xccz";
    //作业许可批准
    String BPM_NODE_B5_ZYXKPZ = "sp";//zyxkpz
    //作业许可申请结束
    String BPM_NODE_APPLY_FINISH = "apply_finish";

    //取消
    String BPM_NODE_QXFQ = "qxfq";//取消发起
    String BPM_NODE_QXSC = "qxsc";//取消审查
    String BPM_NODE_QXHQ = "qxhq";//取消会签
    //结束
    String BPM_NODE_CANCEL_FINISH = "cancel_finish";

    //关闭
    String BPM_NODE_GBFQ = "gbfq";//关闭发起
    String BPM_NODE_GBSC = "gbsc";//关闭审查
    String BPM_NODE_GBHQ = "gbhq";//关闭会签
    //结束
    String BPM_NODE_CLOSE_FINISH = "close_finish";

    //延期与续签
    String BPM_NODE_YQFQ = "yqfq";//延期发起
    String BPM_NODE_YQSC = "yqsc";//延期审查
    String BPM_NODE_YQHQ = "yqhq";//延期会签
    //作业许可申请结束
    String BPM_NODE_DELAY_FINISH = "delay_finish";

    //    String dateFormate1 = "yyyy年MM月dd日HH时mm分";
    String dateFormate2 = "yyyy-MM-dd HH:mm";
    String dateFormate3 = "yyyy-MM-dd HH:mm:ss";
    String dateFormate4 = "yyyy-MM-dd";

    //动火
    //流程名称：动火作业许可证申请
    // 批准人 书面审查
    String BPM_NODE_F1_PZRSC = "dhpzrsc";
    //属地单位现场确认
    String BPM_NODE_F2_SDDWXCQR = "dhsddwxcqr";
    //作业单位现场确认
    String BPM_NODE_F3_ZYDWXCQR = "dhzydwxcqr";
    // 作业人
    String BPM_NODE_F4_ZYRSP = "dhzyrsp";
    // 作业监护 作业单位监护人
    String BPM_NODE_F5_ZYJHRSP = "dhzyjhrsp";
    //受影响相关方会签
    String BPM_NODE_F6_SYXXGFHG = "dhxgfhq";
    //作业监护 属地单位监护人确认
    String BPM_NODE_F7_SDDWJHRQR = "dhsddwjhrqr";
    //监督
    String BPM_NODE_F8_JD = "dhjd";
    //批准人授权
    String BPM_NODE_F9_PZRSQ = "dhpzrsq";
    //作业许可申请结束
    String BPM_NODE_F_APPLY_FINISH = "fire_apply_finish";

    //动火作业许可证延期
    //批准人审核
    String BPM_NODE_F1_DELAY = "dhyqpzrsh";
    //监护人审核
    String BPM_NODE_F2_DELAY = "dhyqjhrsh";
    //批准人授权
    String BPM_NODE_F3_DELAY = "dhyqpzrsq";
    //结束标识
    String BPM_NODE_F_FINISH_DELAY = "f_finish_delay";

    //动火作业许可证关闭
    //监护人审核
    String BPM_NODE_F1_CLOSE = "dhgbjhrsh";
    //批准人审核
    String BPM_NODE_F2_CLOSE = "dhgbpzrsh";
    //结束标识
    String BPM_NODE_F_FINISH_COLSE = "f_finish_close";

    //动火作业许可证取消
    //批准人审核
    String BPM_NODE_F1_CANCEL = "dhqxpzrsh";
    //结束标识
    String BPM_NODE_F_FINISH_CANCEL = "f_finish_cancel";

    //高处作业-------------------------------------------
    //流程名称：高处作业许可证申请
    // 批准人审查
    String BPM_NODE_H1_PZRSC = "gcpzrsc";
    // 作业人
    String BPM_NODE_H2_ZYRSP = "gczyrsp";
    // 作业监护
    String BPM_NODE_H3_ZYJHRSP = "gcjhrsp";
    //属地单位现场确认
    String BPM_NODE_H4_SDDWXCQR = "gcsddwxcqr";
    //受影响相关方会签
    String BPM_NODE_H5_SYXXGFHG = "gcxgfhq";
    //批准人授权
    String BPM_NODE_H6_PZRSQ = "gcpzrsq";
    //作业单位现场确认
    String BPM_NODE_H7_ZYDWXCQR = "gczydwxcqr";
    //作业许可申请结束
    String BPM_NODE_H_APPLY_FINISH = "height_apply_finish";

    //高处作业许可证延期
    //批准人审核
    String BPM_NODE_H1_DELAY = "gcyqpzrsh";
    //监护人审核
    String BPM_NODE_H2_DELAY = "gcyqjhrsh";
    //批准人授权
    String BPM_NODE_H3_DELAY = "gcyqpzrsq";
    //结束标识
    String BPM_NODE_H_FINISH_DELAY = "height_finish_delay";

    //高处作业许可证关闭
    //现场确认- 正常关闭时才有此步骤
    String BPM_NODE_H1_CLOSE = "gcgbxcqr";
    //批准人审核
    String BPM_NODE_H2_CLOSE = "gcgbpzrsh";
    //结束标识
    String BPM_NODE_H_FINISH_COLSE = "height_finish_close";

    //高处作业许可证取消
    //批准人审核
    String BPM_NODE_H1_CANCEL = "gcqxpzrsh";
    //结束标识
    String BPM_NODE_H_FINISH_CANCEL = "height_finish_cancel";

    //临时用电作业-------------------------------------------
    //流程名称：临时用电许可证申请
    // 批准人审查
    String BPM_NODE_P1_QJSC = "lsdqcjsc";
    //现场确认
    String BPM_NODE_P2_DQCJXCQR = "lsdqcjxcqr";//电气车间现场确认
    //批准
    String BPM_NODE_P3_PZRSQ = "lspzrsq";
    //接线
    String BPM_NODE_P4_JXRQR = "lsjxrqr";
    //送电
    String BPM_NODE_P5_SDRQR = "lssdrqr";

    String BPM_NODE_P6_ZYDWXCQR = "lszydwxcqr";//作业单位现场确认
    //作业许可申请结束
    String BPM_NODE_p_APPLY_FINISH = "power_apply_finish";

    //临时用电作业许可证延期
    //电气车间确认人审核
    String BPM_NODE_P1_DELAY = "lsyqdqcjsh";
    //属地单位批准人审核
    String BPM_NODE_P2_DELAY = "lsyqsddwsh";
    //临时用电批准人
    String BPM_NODE_P3_DELAY = "lsyqpzrsq";
    //结束标识
    String BPM_NODE_P_DELAY_FINISH = "power_delay_finish";

    //临时用电作业许可证关闭
    //断电人- 正常关闭时才有此步骤
    String BPM_NODE_P1_CLOSE = "lsgbddqr";
    //拆线人- 正常关闭时才有此步骤
    String BPM_NODE_P2_CLOSE = "lsgbcxqr";
    //批准人审核
    String BPM_NODE_P3_CLOSE = "lsgbpzrsh";
    //结束标识
    String BPM_NODE_P_COLSE_FINISH = "power_close_finish";

    //临时用电作业许可证取消
    //批准人审核
    String BPM_NODE_P1_CANCEL = "lsqxpzrsh";
    //结束标识
    String BPM_NODE_P_CANCEL_FINISH = "power_cancel_finish";

    //吊装作业
    String BPM_NODE_HOISTING_A_1 = "dzpzrsc";//审查
    String BPM_NODE_HOISTING_A_2 = "dzsddwxcqr";//属地单位现场确认
    String BPM_NODE_HOISTING_A_3 = "dzzydwxcqr";//作业单位现场确认
    String BPM_NODE_HOISTING_A_4 = "dzqzjczrsp";//起重机作业人会签
    String BPM_NODE_HOISTING_A_4_2 = "dzssrsp";//司索作业人会签
    String BPM_NODE_HOISTING_A_5 = "dzzydwjhrsp";//作业单位监护
    String BPM_NODE_HOISTING_A_6 = "dzsddwhq";//属地单位会签+-+-+
    String BPM_NODE_HOISTING_A_7 = "dzxgfhq";//相关方会签
    String BPM_NODE_HOISTING_A_8 = "dzpzrsq";//批准授权
    String BPM_NODE_HOISTING_C_A_F = "JS_C_A_F";

    //吊装延期
    String BPM_NODE_HOISTING_D_1 = "dzyqpzrsh";//批准人 审核+-+-+
    String BPM_NODE_HOISTING_D_2 = "dzyqsddwqr";//属地单位现场确认人/监护人
    String BPM_NODE_HOISTING_D_3 = "dzyqpzrsh";//作业批准人
    String BPM_NODE_HOISTING_D_F = "JS_C_D_F";

    //吊装关闭
    String BPM_NODE_HOISTING_C_1 = "dzgbxcczsh";//属地单位现场确认人/监护人
    String BPM_NODE_HOISTING_C_2 = "dzgbpzrsh";//作业批准人
    String BPM_NODE_HOISTING_C_F = "JS_C_CL_F";

    //吊装取消
    String BPM_NODE_HOISTING_CA_1 = "dzqxpzrsh";//取消-作业批准人
    //结束标识
    String BPM_NODE_HOISTING_CA_F = "JS_C_CA_F";

    //通用流程 common_apply 脚手架|设备/管线|受限空间|挖掘|格栅|射线
    String BPM_NODE_C_A_1 = "jspzrsc|gxpzrsc|sxsmsc|wjpzrsc|gspzrsc|sxzysmsc";//审查
    String BPM_NODE_C_A_2 = "jssddwxcqr|gxsddwxcqr|sxsddwxcqr|wjsddwxcqr|gssddwxcqr|sxzysddwxcqr";//属地单位现场确认
    String BPM_NODE_C_A_3 = "jszydwxcqr|gxzydwxcqr|sxzydwxcqr|wjzydwxcqr|gszydwxcqr|sxzyzydwxcqr";//作业单位现场确认
    String BPM_NODE_C_A_4 = "jszyrsp|gxzyrsp|sxzyrsp|wjzyrsp|gszyrsp|sxzyzyrsp";//作业人会签
    String BPM_NODE_C_A_5 = "jsjhrsp|gxzydwjhrsp|sxzydwjhrsp|wjjhrsp|gsjhrsp|sxzyjhrsp";//作业单位监护
    String BPM_NODE_C_A_6_1 = "jssddwhq|-|";//属地单位会签+-+-+
    String BPM_NODE_C_A_6_2 = "-|-|sxsddwjhrsp";//属地单位监护+-+-+
    String BPM_NODE_C_A_6_3 = "-|-|sxjd";//监督+-+-+
    String BPM_NODE_C_A_7 = "jsxgfhq|gxxgfhq|sxxgfhq|wjxgfhq|gsxgfhq|sxzyxgfhq";//相关方会签
    String BPM_NODE_C_A_8 = "jspzrsq|gxpzrsq|sxpzrsp|wjpzrsq|gspzrsq|sxzypzrsq";//批准授权
    String BPM_NODE_C_A_F = "JS_C_A_F";

    //common_delay
    String BPM_NODE_C_D_1 = "-|gxyqpzrsh|sxyqpzrsh|wjyqpzrsh|gsyqpzrsh|sxzyyqpzrsh";//批准人 审核+-+-+
    String BPM_NODE_C_D_2 = "jsyqsddwqr|gxyqzydwjhrsh|sxyqjhrsh|wjyqjhrsh|gsyqjhrsh|sxzyyqjhrsh";//属地单位现场确认人/监护人
    String BPM_NODE_C_D_3 = "jsyqpzrsq|gxyqpzrsq|sxyqpzrsq|wjyqpzrsq|gsyqpzrsq|sxzyyqpzrsq";//作业批准人
    String BPM_NODE_C_D_F = "JS_C_D_F";

    //common_close
    String BPM_NODE_C_CL_1 = "jsgbxcczrsh|gxgbxcczsh|sxgbsddwjhrsp|wjgbxcczsh|gsgbxcczrsh|sxzygbxcczsh";//属地单位现场确认人/监护人
    String BPM_NODE_C_CL_2 = "jsgbpzrsh|gxgbpzrsh|sxgbpzrsh|wjgbpzrsh|gsgbpzrsh|sxzygbpzrsh";//作业批准人
    String BPM_NODE_C_CL_F = "JS_C_CL_F";

    //common_cancel
    String BPM_NODE_C_CA_1 = "jsqxpzrsh|gxqxpzrsh|sxqxpzrsh|wjqxpzrsh|gsqxpzrsh|sxzyqxpzrsh";//取消-作业批准人
    //结束标识
    String BPM_NODE_C_CA_F = "JS_C_CA_F";

    String SUB_OPERATION_TYPE = "[{\"names\":[\"动火作业\"],\"code\":\"dhzy\"," +
            "\"isChecked\":false},{\"names\":[\"受限空间\"],\"code\":\"sxkj\"," +
            "\"isChecked\":false},{\"names\":[\"高处作业\"],\"code\":\"gczy\"," +
            "\"isChecked\":false},{\"names\":[\"临时用电\"],\"code\":\"dhlsyd\"," +
            "\"isChecked\":false},{\"names\":[\"吊装作业\"],\"code\":\"dzzy\"," +
            "\"isChecked\":false},{\"names\":[\"挖掘作业\"],\"code\":\"wjzy\"," +
            "\"isChecked\":false},{\"names\":[\"设备/管线打开\"],\"code\":\"sbgxdk\"," +
            "\"isChecked\":false},{\"names\":[\"射线作业\"],\"code\":\"sxzy\"," +
            "\"isChecked\":false},{\"names\":[\"脚手架作业\"],\"code\":\"jsjzy\"," +
            "\"isChecked\":false},{\"names\":[\"格栅作业\"],\"code\":\"gszy\"," +
            "\"isChecked\":false},{\"names\":[\"解除连锁/安全应急设备\"],\"code\":\"jclsaqyjsb\"," +
            "\"isChecked\":false},{\"names\":[\"屏蔽报警\"],\"code\":\"pbbj\"," +
            "\"isChecked\":false},{\"names\":[\"非计划性维修工作\"],\"code\":\"fjhxwxgz\"," +
            "\"isChecked\":false},{\"names\":[\"偏离规则/程序要求的工作\"],\"code\":\"plgzcxyqdgz\"," +
            "\"isChecked\":false},{\"names\":[\"没有安全程序可遵循的工作\"],\"code\":\"myaqcxkzxdgz\"," +
            "\"isChecked\":false},{\"names\":[\"其他\"],\"code\":\"qt\",\"isChecked\":false}]";

    String SUB_FIRE_LEVEL = "[{\"names\":[\"特级\"],\"code\":\"0\",\"isChecked\":true}," +
            "{\"names\":[\"一级\"],\"code\":\"1\",\"isChecked\":false}," +
            "{\"names\":[\"二级\"],\"code\":\"2\",\"isChecked\":false}]";

    String SUB_FIRE_TYPE = "[{\"names\":[\"伴热管线堵漏或更换\"],\"code\":\"0\",\"isChecked\":true}," +
            "{\"names\":[\"设备检修\"],\"code\":\"1\",\"isChecked\":false}," +
            "{\"names\":[\"物料管线堵漏或更换\"],\"code\":\"2\",\"isChecked\":false}," +
            "{\"names\":[\"技改技措\"],\"code\":\"3\",\"isChecked\":false}," +
            "{\"names\":[\"设备堵漏\"],\"code\":\"4\",\"isChecked\":false}," +
            "{\"names\":[\"工程项目建设\"],\"code\":\"5\",\"isChecked\":false}," +
            "{\"names\":[\"公用工程管线堵漏\"],\"code\":\"6\",\"isChecked\":false}," +
            "{\"names\":[\"临时用电\"],\"code\":\"7\",\"isChecked\":false}," +
            "{\"names\":[\"钢结构\"],\"code\":\"8\",\"isChecked\":false}," +
            "{\"names\":[\"防腐保温\"],\"code\":\"9\",\"isChecked\":false}," +
            "{\"names\":[\"其它\"],\"code\":\"10\",\"isChecked\":false}]";

    String SUB_FIRE_KIND = "[{\"names\":[\"明火\"],\"code\":\"0\",\"isChecked\":true}," +
            "{\"names\":[\"非明火\"],\"code\":\"1\",\"isChecked\":false}]";


    String SUB_FIRE_REASON = "[{\"names\":[\"设计缺陷\"],\"code\":\"0\",\"isChecked\":true}," +
            "{\"names\":[\"焊接缺陷\"],\"code\":\"1\",\"isChecked\":false}," +
            "{\"names\":[\"物料及冲刷腐蚀\"],\"code\":\"2\",\"isChecked\":false}," +
            "{\"names\":[\"环境腐蚀\"],\"code\":\"3\",\"isChecked\":false}," +
            "{\"names\":[\"冻胀\"],\"code\":\"4\",\"isChecked\":false}," +
            "{\"names\":[\"技改技措\"],\"code\":\"5\",\"isChecked\":false}," +
            "{\"names\":[\"工程建设项目\"],\"code\":\"6\",\"isChecked\":false}," +
            "{\"names\":[\"其它原因\"],\"code\":\"7\",\"isChecked\":false}]";

    String JSA_WORK_TYPE = "[{\"names\":[\"新工作任务\"],\"code\":\"新工作任务\",\"isChecked\":false}," +
            "{\"names\":[\"已作过工作任务\"],\"code\":\"已作过工作任务\",\"isChecked\":false}," +
            "{\"names\":[\"交叉作业\"],\"code\":\"交叉作业\",\"isChecked\":false}," +
            "{\"names\":[\"服务单位作业\"],\"code\":\"服务单位作业\",\"isChecked\":false}," +
            "{\"names\":[\"相关操作规程\"],\"code\":\"相关操作规程\",\"isChecked\":false}," +
            "{\"names\":[\"许可证\"],\"code\":\"许可证\",\"isChecked\":false}," +
            "{\"names\":[\"特种作业人员资质证明\"],\"code\":\"特种作业人员资质证明\",\"isChecked\":false}]";

    String ENE_HARM_TYPE = "[{\"names\":[\"物体打击\"],\"code\":\"物体打击\",\"isChecked\":false}," +
            "{\"names\":[\"机械伤害\"],\"code\":\"机械伤害\",\"isChecked\":false}," +
            "{\"names\":[\"触电\"],\"code\":\"触电\",\"isChecked\":false}," +
            "{\"names\":[\"淹溺\"],\"code\":\"淹溺\",\"isChecked\":false}," +
            "{\"names\":[\"灼烫\"],\"code\":\"灼烫\",\"isChecked\":false}," +
            "{\"names\":[\"火灾\"],\"code\":\"火灾\",\"isChecked\":false}," +
            "{\"names\":[\"高处坠落\"],\"code\":\"高处坠落\",\"isChecked\":false}," +
            "{\"names\":[\"瓦斯爆炸\"],\"code\":\"瓦斯爆炸\",\"isChecked\":false},"+
            "{\"names\":[\"锅炉爆炸\"],\"code\":\"锅炉爆炸\",\"isChecked\":false},"+
            "{\"names\":[\"容器爆炸\"],\"code\":\"容器爆炸\",\"isChecked\":false},"+
            "{\"names\":[\"其他爆炸\"],\"code\":\"其他爆炸\",\"isChecked\":false},"+
            "{\"names\":[\"中毒和窒息\"],\"code\":\"中毒和窒息\",\"isChecked\":false},"+
            "{\"names\":[\"其他伤害\"],\"code\":\"其他伤害\",\"isChecked\":false}]";

}
