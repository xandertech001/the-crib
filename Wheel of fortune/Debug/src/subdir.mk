################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
../src/Wheel\ of\ fortune.cpp 

OBJS += \
./src/Wheel\ of\ fortune.o 

CPP_DEPS += \
./src/Wheel\ of\ fortune.d 


# Each subdirectory must supply rules for building sources it contributes
src/Wheel\ of\ fortune.o: ../src/Wheel\ of\ fortune.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: GCC C++ Compiler'
	g++ -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"src/Wheel of fortune.d" -MT"src/Wheel\ of\ fortune.d" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


