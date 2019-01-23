#include "Gps.h"

TIME GgaTimeReception(char* nmea)
{
    if (strstr(nmea, "$GPGGA"))
    {
        TIME utcTime;
        char nmeaGga = nmea;
        nmeaGga = strchr(nmeaGga, ',')+1;
        float timef = atof(nmeaGga);
        uint32_t time = timef;
        utcTime.hour = time / 10000;
        utcTime.minutes = (time % 10000) / 100;
        utcTime.seconds = (time % 100);
        utcTime.milliseconds = fmod(timef, 1.0) * 1000;
        HAL_GPIO_WritePin(LD4_GPIO_Port, LD4_Pin, 0);
    }
    else
    {
        HAL_GPIO_WritePin(LD4_GPIO_Port, LD4_Pin, 1);
    }
}