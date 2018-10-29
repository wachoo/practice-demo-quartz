package com.wachoo.demo.quartz.jmx.constants;

/**
 * @desc: 监控常量类
 * @author: wangchao3
 * @since: JDK1.8
 * @date: 2018/9/29 14:14
 */
public class MonitorConts {

  public static final String SEP = "#";
  public static final String COUNT_ = "COUNT_";

  public static final String API_PROTOCOL_CLASS_ = "com.apus.dap.hella.service.impl.";
  public static final String API_PROTOCOL_SIMPLE_CLASS_ = "c.a.d.h.s.i.";
  public static final String API_PROTOCOL_CLASS_NAME = API_PROTOCOL_CLASS_ + "*";

  public static final String API_USERPROFILE_CLASS_NAME = API_PROTOCOL_SIMPLE_CLASS_ + "UserProfileServiceImpl";
  public static final String API_USERPROFILE_CLASS_NAME_SEP = API_USERPROFILE_CLASS_NAME + SEP;
  public static final String API_USERPROFILE_NAME_GET = API_USERPROFILE_CLASS_NAME_SEP + "getProfile";
  public static final String API_USERPROFILE_NAME_UPDATE = API_USERPROFILE_CLASS_NAME_SEP + "updateProfile";
  public static final String API_USERPROFILE_NAME_DELETE = API_USERPROFILE_CLASS_NAME_SEP + "deleteProfile";
  public static final String API_USERPROFILE_COUNT_NAME_GET = COUNT_ + API_USERPROFILE_NAME_GET;
  public static final String API_USERPROFILE_COUNT_NAME_UPDATE = COUNT_ + API_USERPROFILE_NAME_UPDATE;
  public static final String API_USERPROFILE_COUNT_NAME_DELETE = COUNT_ + API_USERPROFILE_NAME_DELETE;

  public static final String API_USERBEHAVIOR_CLASS_NAME =  API_PROTOCOL_SIMPLE_CLASS_ + "UserBehaviorServiceImpl";
  public static final String API_USERBEHAVIOR_CLASS_NAME_SEP = API_USERBEHAVIOR_CLASS_NAME + SEP;
  public static final String API_USERBEHAVIOR_NAME_GET = API_USERBEHAVIOR_CLASS_NAME_SEP + "getBehavior";
  public static final String API_USERBEHAVIOR_NAME_DELETE = API_USERBEHAVIOR_CLASS_NAME_SEP + "deleteBehavior";
  public static final String API_USERBEHAVIOR_COUNT_NAME_GET = COUNT_ + API_USERBEHAVIOR_NAME_GET;
  public static final String API_USERBEHAVIOR_COUNT_NAME_DELETE = COUNT_ + API_USERBEHAVIOR_NAME_DELETE;

  public static final String API_SIGNOUT_CLASS_NAME = API_PROTOCOL_SIMPLE_CLASS_ + "SignOutServiceImpl";
  public static final String API_SIGNOUT_CLASS_NAME_SEP = API_SIGNOUT_CLASS_NAME + SEP;
  public static final String API_SIGNOUT_NAME_GET = API_SIGNOUT_CLASS_NAME_SEP + "signOut";
  public static final String API_SIGNOUT_COUNT_NAME_GET = COUNT_ + API_SIGNOUT_NAME_GET;

  public static final String API_PREDICT_CLASS_NAME = API_PROTOCOL_SIMPLE_CLASS_ + "PredictServiceImpl";
  public static final String API_PREDICT_CLASS_NAME_SEP = API_PREDICT_CLASS_NAME + SEP;
  public static final String API_PREDICT_NAME_GET = API_PREDICT_CLASS_NAME_SEP + "predict";
  public static final String API_PREDICT_COUNT_NAME_GET = COUNT_ + API_PREDICT_NAME_GET;

  public static final String API_DMPTAG_CLASS_NAME = API_PROTOCOL_SIMPLE_CLASS_ + "DmpTagServiceImpl";
  public static final String API_DMPTAG_CLASS_NAME_SEP = API_DMPTAG_CLASS_NAME + SEP;
  public static final String API_DMPTAG_NAME_GET = API_DMPTAG_CLASS_NAME_SEP + "getDmpTag";
  public static final String API_DMPTAG_COUNT_NAME_GET = COUNT_ + API_DMPTAG_NAME_GET;

  public static final String API_BLACKLIST_CLASS_NAME = API_PROTOCOL_SIMPLE_CLASS_ + "BlackListServiceImpl";
  public static final String API_BLACKLIST_CLASS_NAME_SEP = API_BLACKLIST_CLASS_NAME + SEP;
  public static final String API_BLACKLIST_NAME_VERIFYBY = API_BLACKLIST_CLASS_NAME_SEP + "verifyBy";
  public static final String API_BLACKLIST_COUNT_NAME_VERIFYBY = COUNT_ + API_BLACKLIST_NAME_VERIFYBY;

  public static final String API_REFERRAL_CLASS_NAME = API_PROTOCOL_SIMPLE_CLASS_ + "ReferralServiceImpl";
  public static final String API_REFERRAL_CLASS_NAME_SEP = API_REFERRAL_CLASS_NAME + SEP;
  public static final String API_REFERRAL_NAME_BY_BEHAVIOR = API_REFERRAL_CLASS_NAME_SEP + "recommendByBehavior";
  public static final String API_REFERRAL_NAME_BY_APP = API_REFERRAL_CLASS_NAME_SEP + "recommendByApp";
  public static final String API_REFERRAL_COUNT_NAME_BY_BEHAVIOR = COUNT_ + API_REFERRAL_NAME_BY_BEHAVIOR;
  public static final String API_REFERRAL_COUNT_NAME_BY_APP = COUNT_ + API_REFERRAL_NAME_BY_APP;

  public static final String API_AC_CLASS_NAME = API_PROTOCOL_SIMPLE_CLASS_ + "ACServiceImpl";
  public static final String API_AC_CLASS_NAME_SEP = API_AC_CLASS_NAME + SEP;
  public static final String API_AC_NAME_SCORE_GET = API_AC_CLASS_NAME_SEP + "getScore";
  public static final String API_AC_COUNT_NAME_SCORE_GET = COUNT_ + API_AC_NAME_SCORE_GET;

  public static final String API_ACCREDITPACKET_CLASS_NAME = API_PROTOCOL_SIMPLE_CLASS_ + "ACCreditPacketServiceImpl";
  public static final String API_ACCREDITPACKET_CLASS_NAME_SEP = API_ACCREDITPACKET_CLASS_NAME + SEP;
  public static final String API_ACCREDITPACKET_NAME_SCORE_GET = API_ACCREDITPACKET_CLASS_NAME_SEP + "getScore";
  public static final String API_ACCREDITPACKET_COUNT_NAME_SCORE_GET = COUNT_ + API_ACCREDITPACKET_NAME_SCORE_GET;
}
