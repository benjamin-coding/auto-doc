package com.minwait.autodoc.result;

/**
 * ResultEnum 状态码
 *
 * @author by xunmi
 * @version 1.0
 * 2020/3/7 9:57
 */
public enum ResultEnum {
    OK("ok", "操作成功"),
    FAIL("fail", "操作失败"),
    WARNING("warning", "操作警告"),
    ERROR("error", "似乎出了点问题"),
    FORBIDDEN("forbidden", "权限不足"),
    MISSING("missing", "数据丢失"),
    ILLEGAL("illegal", "参数非法"),
    INVALID("invalid", "非法状态");


    private String status;

    private String message;

    ResultEnum(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public static ResultEnum statusOf(String status) {
        ResultEnum[] values = ResultEnum.values();
        for (ResultEnum resultEnum : values) {
            if (resultEnum.status.equals(status)) {
                return resultEnum;
            }
        }
        throw new IllegalArgumentException("can not found status {" + status + "} in ResultEnum");
    }
}
