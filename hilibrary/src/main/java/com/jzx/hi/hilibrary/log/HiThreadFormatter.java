package com.jzx.hi.hilibrary.log;

public class HiThreadFormatter implements HiLogForMatter<Thread> {
    @Override
    public String format(Thread data) {
        return "Thread:"+data.getName();
    }
}
