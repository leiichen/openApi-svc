package com.lei.chen.common;

import com.lei.chen.constant.CommonConstant;
import lombok.Data;

/**
 * 分页请求
 *
 * @author yupi
 */
@Data
public class PageRequest {

    /**
     * 当前页号
     */
    private Integer pageNum = 1;

    /**
     * 页面大小
     */
    private Integer pageSize =  10;

    private Integer getOffSet() {
        if (pageSize == null || pageNum == null) {
            return null;
        }
        return (pageNum - 1) * pageSize;
    }

    /**
     * 排序字段
     */
    private String sortField;

    /**
     * 排序顺序（默认升序）
     */
    private String sortOrder = CommonConstant.SORT_ORDER_ASC;
}
