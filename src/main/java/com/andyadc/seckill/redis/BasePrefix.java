package com.andyadc.seckill.redis;

/**
 * @author andaicheng
 * @since 2018/9/2
 */
public abstract class BasePrefix implements KeyPrefix {

    private String prefix;
    private int expire;

    public BasePrefix(String prefix) {
        this(prefix, 0);
    }

    public BasePrefix(String prefix, int expire) {
        this.prefix = prefix;
        this.expire = expire;
    }

    @Override
    public String prefix() {
        return getClass().getSimpleName().toLowerCase() + ":" + prefix + ":";
    }

    @Override
    public int expire() {
        return expire;
    }
}
