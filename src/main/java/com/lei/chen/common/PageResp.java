package com.lei.chen.common;

import lombok.Data;

import java.util.List;

@Data
public class PageResp<T> {
    private int total;
    private List<T> list;
}
