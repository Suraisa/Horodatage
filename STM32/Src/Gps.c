#include "Gps.h"

uint32_t GgaTimeReception(char* nmea)
{
    if (strstr(nmea, "$GPGGA"))
    {
        char* nmeaGga = nmea;
        nmeaGga = strchr(nmeaGga, ',')+1;
        float timef = atof(nmeaGga);
        uint32_t timer = timef;
        timer = (timer % 5)*1000;
    }
}