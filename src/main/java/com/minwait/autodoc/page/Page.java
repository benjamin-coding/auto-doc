package com.minwait.autodoc.page;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Page
 *
 * @author by xunmi
 * 2020/4/10 9:56
 * @version 1.0
 */
@Getter
@Setter
public class Page<Entity> {
    private List<Entity> dataList = new ArrayList<>();
    private int totalPages;
    private int totalElements;
    private int size;
    private int number;
}
