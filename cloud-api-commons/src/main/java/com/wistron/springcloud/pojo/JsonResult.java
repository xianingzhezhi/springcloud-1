package com.wistron.springcloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonResult<T> {
    private Integer code;

    private String msg;

    private T data;

    public JsonResult(Integer code,String msg){
        this(code,msg,null);
    }
}
