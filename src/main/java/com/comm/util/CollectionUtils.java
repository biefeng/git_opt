package com.comm.util;

import cn.hutool.core.collection.CollUtil;

import java.util.Collection;
import java.util.Map;

/*
 *@Author BieFeNg
 *@Date 2019/5/10 17:51
 *@DESC
 */
public class CollectionUtils {

    public static boolean isEmpty(Collection coll) {
        boolean var = false;
        if (null == coll || coll.isEmpty()) {
            var = true;
        }
        return var;
    }

    public static boolean isNotEmpty(Collection coll) {
        return !isEmpty(coll);
    }

    public static boolean isEmpty(Map map) {
        boolean var = false;
        if (null == map || map.isEmpty()) {
            var = true;
        }
        return var;
    }

    public static boolean isNotEmpty(Map map) {
        return !isEmpty(map);
    }
}
