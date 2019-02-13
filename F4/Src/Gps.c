#include "Gps.h"

void GgaTimeReception(uint32_t* timer, char* nmea)
{
    if (strstr(nmea, "$GPGGA"))
    {
        char* nmeaGga = nmea;
        nmeaGga = strchr(nmeaGga, ',')+1;
        float timef = atof(nmeaGga);
        *timer = (uint32_t)timef;
        timer = (*timer % 5)*1000;
    }
}