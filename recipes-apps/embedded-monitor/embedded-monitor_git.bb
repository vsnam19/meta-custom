DESCRIPTION = "Embedded system monitor service written in C++20"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=97d4ac6c90ab8b0b6f0e69f5be8fe0e6"

DEPENDS = "systemd"
RDEPENDS_${PN} = "systemd"

SRC_URI = "git://github.com/vsnam19/embedded-services-pi3b.git;branch=main;protocol=https"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

inherit cmake systemd

SYSTEMD_SERVICE_${PN} = "embedded-monitor.service"
SYSTEMD_AUTO_ENABLE = "enable"

# C++20 compilation flags
EXTRA_OECMAKE += "-DCMAKE_CXX_STANDARD=20 -DCMAKE_CXX_STANDARD_REQUIRED=ON"

do_install_append() {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${S}/systemd/embedded-monitor.service ${D}${systemd_system_unitdir}
    
    install -d ${D}${sysconfdir}
    install -m 0644 ${S}/config/embedded-monitor.conf ${D}${sysconfdir}
}

FILES_${PN} += "${systemd_system_unitdir}/embedded-monitor.service"
FILES_${PN} += "${sysconfdir}/embedded-monitor.conf"