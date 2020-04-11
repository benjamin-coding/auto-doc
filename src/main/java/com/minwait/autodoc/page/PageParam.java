package com.minwait.autodoc.page;

import lombok.Data;

/**
 * PageParam
 *
 * @author by xunmi
 * 2020/3/11 14:17
 * @version 1.0
 */
@Data
public class PageParam {
    /**
     * 页码
     */
    private int number = 1;
    /**
     * 页大小
     */
    private int size = 10;
}
