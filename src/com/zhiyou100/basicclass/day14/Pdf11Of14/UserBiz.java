package com.zhiyou100.basicclass.day14.Pdf11Of14;

/**
 * @packageName: javase_26
 * @className: UserBiz
 * @Description: TODO
 * @author: YangLei
 * @date: 2020/3/10 7:37 下午
 */
public interface UserBiz {
    void register(String username, String password, String password2,
                  String name, String email) throws RegisterException;
    //用户注册
    void login(String username, String password) throws LoginException;
    //用户登录
}
