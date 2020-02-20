package com.yxy.utils;

import com.yxy.base.BusinessException;

public class MarketShortNameUtil {

    public static String getShortName(String compName) throws BusinessException {
        if ("西郊国际".equals(compName)){
            return "XJ";
        }
        if ("江杨市场".equals(compName)){
            return "JY";
        }
        if ("江桥市场".equals(compName)){
            return "JQ";
        }
        if ("三林市场".equals(compName)){
            return "SL";
        }
        if ("中山市场".equals(compName)){
            return "ZS";
        }
        throw new BusinessException(500,"市场编码缩写不存在");
    }
}
