//package com.xingying.shopping.mas.common.context;
//
//
//
///**
// * 用户上下文
// * @author xueyanjun
// */
//public class UserContext {
//
//    private static ThreadLocal<HisUser> HOLDER = new ThreadLocal<>();
//
//    /**
//     * 获取当前系统用户
//     * @return 系统用户
//     */
//    public static HisUser getCurrentUser(){
//        return HOLDER.get();
//    }
//
//    /**
//     * 设置当前系统用户
//     * @return 系统用户
//     */
//    public static void setCurrentUser(HisUser user){
//        HOLDER.set(user);
//    }
//
//    /**
//     * 设置当前系统用户
//     * @return 系统用户
//     */
//    public static void clearCurrentUser(){
//        HOLDER.remove();
//    }
//
//}
