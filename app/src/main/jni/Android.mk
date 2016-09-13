LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

TARGET_PLATFORM := android-21

# Enable PIE manually. Will get reset on $(CLEAR_VARS). This
# is what enabling PIE translates to behind the scenes.
# LOCAL_CFLAGS += -fPIE
# LOCAL_LDFLAGS += -fPIE -pie

LOCAL_MODULE    := tapmd5
LOCAL_SRC_FILES := md5.c \
                   nativemd5.c \
                   nativemd5driver.c \
                   local.c

LOCAL_LDLIBS := -llog

include $(BUILD_SHARED_LIBRARY)
