# Custom Yocto Meta Layer for Raspberry Pi 3B Embedded Development

This meta layer contains custom recipes, configurations, and applications for embedded Linux development targeting Raspberry Pi 3B using C++20.

## Overview

This layer provides:
- Custom embedded Linux images optimized for Pi 3B
- C++20 development environment and toolchain
- Hardware-specific recipes and configurations
- Embedded services and applications
- System optimization for 1GB RAM constraint

## Layer Structure

```
meta-custom/
├── conf/
│   ├── layer.conf                 # Layer configuration
│   └── machine/
│       └── rpi3-embedded.conf     # Pi 3B machine definition
├── recipes-apps/
│   ├── images/
│   │   └── rpi3-custom-image.bb   # Custom embedded Linux image
│   └── embedded-monitor/
│       └── embedded-monitor_git.bb    # System monitoring service
└── README.md
```

## Features

### Embedded Linux Images
- **rpi3-custom-image**: Optimized for Pi 3B embedded deployment
- **C++20 toolchain**: Full development environment
- **Hardware drivers**: GPIO, I2C, SPI, UART support
- **Network support**: Wi-Fi, Bluetooth for Pi 3B
- **Read-only filesystem**: Robust embedded deployment

### Development Support
- **C++20 compiler**: GCC with C++20 features enabled
- **Development tools**: cmake, gdb, valgrind
- **Cross-compilation**: Host to ARM Cortex-A53 target
- **Debugging**: Remote debugging and profiling tools

### System Services
- **embedded-monitor**: System health monitoring
- **gpio-controller**: Hardware GPIO management
- **sensor-daemon**: Sensor data collection and processing
- **systemd integration**: Service management and startup

### Hardware Optimization
- **Memory optimization**: Efficient use of 1GB RAM
- **Boot optimization**: Fast startup for embedded deployment
- **Power management**: Low-power operation modes
- **Storage optimization**: microSD-friendly I/O patterns

## Usage

### Building Custom Image
```bash
# Enter Yocto development environment
uv run yocto-env enter

# Initialize build environment for Pi 3B
source poky/oe-init-build-env build/raspberrypi3

# Add meta-custom to layer configuration
bitbake-layers add-layer ../meta-custom

# Build custom embedded image
bitbake rpi3-custom-image
```

### Development Workflow
```bash
# Build specific service
bitbake embedded-monitor

# Clean and rebuild
bitbake -c clean rpi3-custom-image
bitbake rpi3-custom-image
```

### Image Deployment
```bash
# Flash to microSD card
sudo dd if=build/raspberrypi3/tmp/deploy/images/raspberrypi3/rpi3-custom-image-raspberrypi3.rpi-sdimg of=/dev/sdX bs=4M status=progress

# Or use bmaptool for faster flashing
bmaptool copy rpi3-custom-image-raspberrypi3.rpi-sdimg /dev/sdX
```

## Configuration

### Layer Configuration
- **Layer priority**: 6 (higher than base layers)
- **Compatible layers**: poky, meta-openembedded, meta-raspberrypi
- **Machine support**: raspberrypi3
- **Yocto version**: scarthgap (LTS)

### Machine Configuration
- **Architecture**: ARM Cortex-A53 (64-bit)
- **Memory**: 1GB RAM optimization
- **Storage**: microSD card support
- **Interfaces**: GPIO, I2C, SPI, UART enabled
- **Network**: Wi-Fi, Bluetooth support

### Image Configuration
- **Root filesystem**: Read-only for embedded robustness
- **Package management**: None (embedded deployment)
- **Init system**: systemd
- **Login**: Embedded user with SSH access

## C++20 Development

### Compiler Features
- **C++20 standard**: Full language feature support
- **Optimization**: ARM Cortex-A53 specific optimizations
- **Libraries**: Standard library with C++20 features
- **Cross-compilation**: Host development, target deployment

### Development Tools
- **CMake**: Modern C++ build system
- **GDB**: Remote debugging support
- **Valgrind**: Memory debugging and profiling
- **Static analysis**: Code quality tools

### Example Applications
- **GPIO control**: Hardware interface examples
- **Sensor integration**: I2C/SPI device communication
- **Network services**: TCP/UDP communication
- **System monitoring**: Resource usage tracking

## Testing and Validation

### Unit Testing
- **Google Test**: C++ testing framework
- **Mock frameworks**: Hardware abstraction testing
- **Automated testing**: CI/CD integration

### Hardware Testing
- **Pi 3B validation**: Actual hardware testing
- **Performance testing**: Resource usage validation
- **Stress testing**: System stability under load
- **Power testing**: Battery operation validation

### Integration Testing
- **Service interaction**: Multi-component testing
- **Network testing**: Connectivity validation
- **Storage testing**: microSD reliability
- **Boot testing**: Startup sequence validation

## Contributing

1. **Development setup**: Use docker-env for consistent build environment
2. **Code standards**: C++20 best practices, embedded coding guidelines
3. **Testing requirements**: Unit tests, hardware validation required
4. **Documentation**: Update recipes, README, and inline comments
5. **Review process**: Pull request with Pi 3B testing results

## Dependencies

### Required Layers
- **poky**: Core Yocto build system
- **meta-openembedded**: Additional recipes and tools
- **meta-raspberrypi**: Pi 3B hardware support

### External Dependencies
- **Docker environment**: Consistent build environment
- **Pi 3B hardware**: Testing and validation
- **microSD card**: Deployment medium
- **Development tools**: Host-side development environment

## Troubleshooting

### Build Issues
- **Layer conflicts**: Check layer priorities and compatibility
- **Recipe failures**: Verify dependencies and source availability
- **Disk space**: Monitor build directory size
- **Memory usage**: Ensure sufficient RAM for parallel builds

### Runtime Issues
- **Boot failures**: Check device tree and kernel configuration
- **Service failures**: Validate systemd unit files
- **Hardware issues**: Verify Pi 3B-specific configurations
- **Performance issues**: Profile and optimize for 1GB RAM constraint

## License

This layer is licensed under MIT License. Individual recipes may have different licenses as specified in their recipe files.

## Support

- **Documentation**: See individual recipe README files
- **Issues**: Report problems with specific hardware testing results
- **Community**: Contribute improvements and optimizations
- **Development**: Use established development environment