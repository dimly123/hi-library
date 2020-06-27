package com.jzx.hi.hilibrary.log;

public class HiStacTraceUtil {


    public static StackTraceElement[] getCroppedRealReaStackTrack(StackTraceElement[] stackTrace, String ignorePack,int maxDepth){
        return cropStackTrace(getRealStackTrack(stackTrace, ignorePack),maxDepth);
    }
    /*
    * 获取除忽略包之外的堆栈信息
    * */
    private static StackTraceElement[] getRealStackTrack(StackTraceElement[] stackTrace, String ignorePack) {
        int ignoreDepth = 0;
        int allDepth = stackTrace.length;
        String className;
        for (int i = allDepth-1; i >=0 ; i--) {
            className = stackTrace[i].getClassName();
            if(ignorePack!= null && className.startsWith(ignorePack)){
                ignoreDepth = i+1;
                break;
            }

        }
        int realDepth = allDepth - ignoreDepth;
        StackTraceElement[] realStack = new StackTraceElement[realDepth];
        System.arraycopy(stackTrace,ignoreDepth,realStack,0,realDepth);
        return realStack;
    }

    /*
     * 裁剪堆栈信息
     * */
    private static StackTraceElement[] cropStackTrace(StackTraceElement[] callStack, int maxDepth) {
        int realDepth = callStack.length;
        if (maxDepth > 0) {
            realDepth = Math.min(maxDepth, realDepth);
        }
        StackTraceElement[] realStack = new StackTraceElement[realDepth];
        System.arraycopy(callStack, 0, realStack, 0, realDepth);
        return realStack;
    }
}
