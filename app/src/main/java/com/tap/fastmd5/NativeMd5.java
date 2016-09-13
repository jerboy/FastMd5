package com.tap.fastmd5;

public class NativeMd5 {
    static{
        System.loadLibrary("tapmd5");
    }

    public static native String md5(String path);
}
