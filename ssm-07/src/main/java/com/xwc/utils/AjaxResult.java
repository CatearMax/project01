package com.xwc.utils;

import com.google.gson.Gson;

/**
 * @author shkstart
 * @create 2020-04-10 20:28
 * @name AjaxResult
 * @description 返回的格式工具类
 */
public class AjaxResult {

    //返回数据成功标志 0为成功 1为失败 2为未登录
    private Integer flag;
    //返回的数据
    private Object data;
    //返回的消息
    private String msg;

    /**
     * 前后端交互成功 且不需要传入一个后端对象返回给前端
     * @return 转换为gson格式的对象
     */
    public static AjaxResult success() {
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.flag = 0;
        ajaxResult.msg = "成功";
        return ajaxResult;
    }

    /**
     * 前后端交互成功 且需要传给前端一个对象
     * @return 转换为gson格式的对象
     */
    public static AjaxResult success(Object object) {
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.flag = 0;
        ajaxResult.data = object;
        ajaxResult.msg = "成功";
        return ajaxResult;
    }

    /**
     * 前后端交互失败 且不需要传入一个后端对象返回给前端
     * @return 转换为gson格式的对象
     */
    public static AjaxResult fail() {
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.flag = 1;
        ajaxResult.msg = "成功";
        Gson gson = new Gson();
        ajaxResult.msg = "成功";return ajaxResult;
    }

    /**
     * 前后端交互失败 且需要传给前端一个对象
     * @return 转换为gson格式的对象
     */
    public static AjaxResult fail(Object object) {
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.flag = 1;
        ajaxResult.data = object;
        ajaxResult.msg = "成功";
        ajaxResult.msg = "成功";
        return ajaxResult;

    }

    @Override
    public String toString() {
        return "AjaxResult{" +
                "flag=" + flag +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
