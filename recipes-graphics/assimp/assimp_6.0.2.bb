DESCRIPTION = "Open Asset Import Library is a portable Open Source library to import \
               various well-known 3D model formats in a uniform manner."
HOMEPAGE = "http://www.assimp.org/"
SECTION = "devel"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d9d5275cab4fb13ae624d42ce64865de"

DEPENDS += "\
    compiler-rt \
    libcxx \
    zlib \
"

SRC_URI = "git://github.com/assimp/assimp.git;protocol=https;lfs=1;branch=master"

SRCREV = "fb375dd8c0a032106a2122815fb18dffe0283721"

RUNTIME:class-native = "llvm"
TOOLCHAIN:class-native = "clang"
PREFERRED_PROVIDER_libgcc:class-native = "compiler-rt"
LIBCPLUSPLUS:class-native = "-stdlib=libc++"
PREFERRED_PROVIDER_llvm:class-native = "clang"

RUNTIME:class-target = "llvm"
TOOLCHAIN:class-target = "clang"
PREFERRED_PROVIDER_libgcc:class-target = "compiler-rt"
LIBCPLUSPLUS:class-target = "-stdlib=libc++"
PREFERRED_PROVIDER_llvm:class-target = "clang"
PREFERRED_PROVIDER_libgomp = "openmp"

S = "${UNPACKDIR}/git"

inherit cmake

EXTRA_OECMAKE = "-DASSIMP_BUILD_ASSIMP_TOOLS=OFF -DASSIMP_BUILD_TESTS=OFF -DASSIMP_LIB_INSTALL_DIR=${baselib}"

INSANE_SKIP:${PN}-dev = "buildpaths"
