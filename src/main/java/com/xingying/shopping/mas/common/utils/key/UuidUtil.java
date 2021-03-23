package com.xingying.shopping.mas.common.utils.key;

import java.util.UUID;

/**
 * @author SiletFlower
 * @date 2021/3/18 02:45:13
 * @description
 */
public class UuidUtil {
    public static String createUuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
