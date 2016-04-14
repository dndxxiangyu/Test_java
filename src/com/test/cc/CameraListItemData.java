package com.test.cc;
/* 
 * @ProjectName iVMS-5060
 * @Copyright HangZhou Hikvision System Technology Co.,Ltd. All Right Reserved
 * 
 * @FileName CameraListItemData.java
 * @Description 监控类表Item数据类
 * 
 * @author Dengshihua
 * @data 2012-6-26
 * 
 * @note 这里写本文件的详细功能描述和注释
 * @note 历史记录
 * 
 * @warning 这里写本文件的相关警告
 */


import java.io.Serializable;
import java.util.List;

/**
 * 监控类表Item数据类
 * 
 * @author
 * @data 2012-6-26
 */
public class CameraListItemData implements Serializable {
    /** 变量/常量说明 */
    public static final String CAMERA_DATA_INFO = "camera_data_info";
    /** 序列化ID */
    private static final long  serialVersionUID = 1L;
    /** 数据类型(1-控制中心;2-区域;3-监控点) */
    public int                 dataType;
    /** 监控点类型,当dataType为3时,该值才有效 */
    public int                 cameraType;
    /** 控制中心/区域/监控点ID */
    public String              id               = "";
    /** 所属ID */
    public String              deviceID         = "";
    /** item文字描述 */
    public String              name             = "";
    /** 云台控制标志 */
    public boolean             isPTZControl     = false;
    /** 监控点是否在线 */
    public boolean             isOnLine         = false;
    /** 录像位置 */
    public List<Integer>       recordPos        = null;
    /** 用户能力说明 */
    public List<Integer>       userCapability   = null;
    /** 云台控制IP */
    public String              acsIP            = null;
    /** 云台控制端口 */
    public int                 acsPort          = 0;
    /** 通道号 */
    public int                 channelNo        = 0;
    /** 收藏标识 */
    public int                 collectedFlag    = 0;
    /** 分组标识 */
    public int                 groupID          = 0;
    /** 级联标识 */
    public int                 cascadeFlag      = 0;
    /** 设备网域ID */
    public int                 deviceNetId      = 0;
    /** 经度：实际度*3600*100 */
    public String              longitude        = "";
    /** 纬度：实际度*3600*100 */
    public String              latitude         = "";

}
