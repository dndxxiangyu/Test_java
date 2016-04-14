#include "jin_JniTest.h"
#include <stdio.h>

JNIEXPORT jstring JNICALL Java_jni_JniTest_get(JNIEnv *env, jobject thiz){
	printf("invoke get in c\n");
	return (*env)->NewStringUTF(env, "Hello from JNI!");
}
JNIEXPORT void JNICALL Java_jni_JniTest_set(JNIEnv *env, jobject thiz, jstring string){
	printf("invoke set from c\n");
	char* str=(char*)(*env)->GetStringUTFChars(env, string, NULL);
	printf("%s\n",str);
	(*env)->ReleaseStringUTFCharsenv, (string, str);
}