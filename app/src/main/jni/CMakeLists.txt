cmake_minimum_required(VERSION 3.5)
project(untitled1)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(SOURCE_FILES nativemd5.c nativemd5driver.c local.c)
include_directories(/Users/caojianbo/DEV/android-ndk-r10e/platforms/android-21/arch-arm64/usr/include)
add_executable(untitled1 ${SOURCE_FILES})