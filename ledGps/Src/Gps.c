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

char* GgaStringTime(char* nmea)
{
    char* nmeaGga;
    if (nmea[0] == '$' && strstr(nmea, "GPGGA"))
    {
        nmeaGga = strchr(nmea, ',')+1;
        return nmeaGga;
    }
    return NULL;
}
