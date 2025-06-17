################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
../src/Product\ Struct.cpp 

OBJS += \
./src/Product\ Struct.o 

CPP_DEPS += \
./src/Product\ Struct.d 


# Each subdirectory must supply rules for building sources it contributes
src/Product\ Struct.o: ../src/Product\ Struct.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: GCC C++ Compiler'
	g++ -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"src/Product Struct.d" -MT"src/Product\ Struct.d" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


