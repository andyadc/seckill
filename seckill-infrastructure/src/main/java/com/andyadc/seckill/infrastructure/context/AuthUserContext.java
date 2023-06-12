package com.andyadc.seckill.infrastructure.context;

public class AuthUserContext {

    private static final ThreadLocal<Long> uid = new ThreadLocal<>();

    public static void set(Long userId) {
        uid.set(userId);
    }

    public static long get() {
        return uid.get();
    }

    public static void clear() {
        uid.remove();
    }
}
