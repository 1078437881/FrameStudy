#include <jni.h>
#include <android/log.h>
#include <string>

extern "C"
JNIEXPORT jstring

JNICALL
Java_com_yshare_framestudy_MainActivity_stringFromJNI(
        JNIEnv *env,
//        auto JNI_TAG="stringFromJNI",
        jobject /* this */) {
    for(int i=0;i<=10;i++){
        -__android_log_print(ANDROID_LOG_INFO,"stringFromJNI","stringFromJNI %d",i);
    }
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
