#ifndef GPS_H
#define GPS_H

#include <stdio.h>
#include "stm32f0xx_hal_gpio.h"


typedef struct
{
    uint8_t seconds;
    uint16_t milliseconds;
}TIME;

TIME GgaTimeReception(char* nmea);

#endif