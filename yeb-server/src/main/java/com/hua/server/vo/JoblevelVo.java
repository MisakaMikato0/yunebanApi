package com.hua.server.vo;

import com.hua.server.pojo.Joblevel;
import lombok.Data;

/**
 * @author mornd
 * @date 2021/2/5 - 21:44
 */
@Data
public class JoblevelVo extends Joblevel {
    private Integer page;
    private Integer size;
}
