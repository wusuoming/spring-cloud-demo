package com.luohuasheng.demo1.fallback;

import com.luohuasheng.demo1.facade.Demo1Facade;
import org.springframework.stereotype.Component;

/**
 * @author panda
 */
@Component
public class Demo1ClientHystrix implements Demo1Facade {
    @Override
    public Integer sub(Integer a, Integer b) {
        return -Integer.MAX_VALUE;
    }

    @Override
    public Integer add(Integer a, Integer b) {
        return Integer.MAX_VALUE;
    }
}
