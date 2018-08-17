package com.luohuasheng.demo2.fallback;

import com.luohuasheng.demo2.facade.Demo2Facade;
import org.springframework.stereotype.Component;

/**
 * @author panda
 */
@Component
public class Demo2ClientHystrix implements Demo2Facade {
    @Override
    public Integer sub(Integer a, Integer b) {
        return -Integer.MAX_VALUE;
    }

    @Override
    public Integer add(Integer a, Integer b) {
        return Integer.MAX_VALUE;
    }
}
