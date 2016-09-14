# 各种方式的 MD5 在安卓上运行效率比较

## Java Md5
**完全通过 java API的 方式去计算**

## FastMd5
**参考实现方案 http://twmacinta.com/myjava/fast_md5.php**

## NativeMd5
**通过 java 调用底层方法实现 MD5计算，（包括读取文件，计算等）**

***

实际运行结果是 1.4G 左右大小的文件，通过 Java Md5方案竟然是最快的，而不是 fastMd5以及 Native Md5方式。
运行结果
java       **15s 左右**
fastmd5    **21s 左右**
nativemd5  **30s 左右**


![img](/shoots.png)


