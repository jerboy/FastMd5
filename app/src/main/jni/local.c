#include <jni.h>

#include "nativemd5driver.h"
#include "common.h"
#include <string.h>


JNIEXPORT jstring JNICALL Java_com_tap_fastmd5_NativeMd5_md5(JNIEnv *env, jobject obj, jstring path)
{
    jboolean tmp = JNI_FALSE;
    const char* _path = (*env)->GetStringUTFChars(env, path, &tmp);
    LOGD("path %s", _path);
    char md5[100];
    md5File(_path, md5);
    LOGD("Finsish %s lenght  %d", md5, strlen(md5));
    return (*env)->NewStringUTF(env, md5);
}
