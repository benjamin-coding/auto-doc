package com.minwait.autodoc.result;

/**
 * ResultBuilder
 * Result 构建器
 *
 * @author by xunmi
 * @version 1.0
 * 2020/3/4 14:13
 */
public class ResultBuilder {

    private Result result;

    public static ResultBuilder create() {
        ResultBuilder resultBuilder = new ResultBuilder();
        resultBuilder.result = new Result();
        return resultBuilder;
    }

    public ResultBuilder status(String status) {
        this.result.setStatus(status);
        return this;
    }

    public ResultBuilder resultCode(ResultEnum resultEnum) {
        this.result.setStatus(resultEnum.getStatus());
        this.result.setMessage(resultEnum.getMessage());
        return this;
    }

    public ResultBuilder message(String message) {
        this.result.setMessage(message);
        return this;
    }

    public ResultBuilder data(Object data) {
        this.result.setData(data);
        return this;
    }

    public Result build() {
        return this.result;
    }

    public ResultBuilder success() {
        success(null);
        return this;
    }

    public ResultBuilder success(Object data) {
        this.result.setStatus(ResultEnum.OK.getStatus());
        this.result.setMessage(ResultEnum.OK.getMessage());
        this.result.setData(data);
        return this;
    }
}
