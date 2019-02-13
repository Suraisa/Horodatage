#ifndef GPS_H
#define GPS_H

#include <stdio.h>
#include "stm32f0xx_hal_gpio.h"

uint32_t GgaTimeReception(char* nmea);

#endif