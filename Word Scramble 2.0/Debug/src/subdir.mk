################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
../src/Word\ Scramble\ 2.0.cpp 

OBJS += \
./src/Word\ Scramble\ 2.0.o 

CPP_DEPS += \
./src/Word\ Scramble\ 2.0.d 


# Each subdirectory must supply rules for building sources it contributes
src/Word\ Scramble\ 2.0.o: ../src/Word\ Scramble\ 2.0.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: GCC C++ Compiler'
	g++ -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"src/Word Scramble 2.0.d" -MT"src/Word\ Scramble\ 2.0.d" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


