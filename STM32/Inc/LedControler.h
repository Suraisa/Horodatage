#ifndef LED_CONTROLER_H
#define LED_CONTROLER_H

#include <stdio.h>
#include <main.h>

typedef struct{
    GPIO_TypeDef* port;
    uint16_t pin;
} ADRESSE;

void LedInitialization(ADRESSE* ledInfos);

#endif