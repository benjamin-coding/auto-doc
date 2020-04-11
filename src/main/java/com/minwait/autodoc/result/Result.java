package com.minwait.autodoc.result;

import lombok.*;

/**
 * Result
 *
 * @author by xunmi
 * @version 1.0
 * 2020/3/4 13:29
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Result {
    /**
     * 状态码
     */
    @NonNull
    private String status;
    /**
     * 状态描述
     */
    private String message;
    /**
     * 数据
     */
    private Object data;

    public Result(@NonNull String status, String message) {
        this.status = status;
        this.message = message;
    }
}
