DESCRIPTION = "Custom embedded image with C++20 applications for Raspberry Pi 3B"
LICENSE = "MIT"

# Inherit from meta-raspberrypi image as base
require recipes-core/images/rpi-hwup-image.bb

# Additional C++20 development packages
IMAGE_INSTALL += "\
    gcc \
    g++ \
    cmake \
    make \
    gdb \
    strace \
    valgrind \
"

# Custom C++20 applications and services
IMAGE_INSTALL += "\
    embedded-monitor \
    gpio-controller \
    sensor-daemon \
    cpp20-demo-app \
"

# Development tools for embedded C++20
IMAGE_INSTALL += "\
    git \
    vim \
    htop \
    iotop \
"

# Additional space for development
IMAGE_ROOTFS_EXTRA_SPACE = "1024"

# Enable development features
EXTRA_IMAGE_FEATURES += "debug-tweaks tools-debug"