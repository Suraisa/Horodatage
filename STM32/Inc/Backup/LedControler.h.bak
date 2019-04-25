#ifndef LED_CONTROLER_H
#define LED_CONTROLER_H

#include <stdio.h>
#include <main.h>

typedef struct{
    GPIO_TypeDef* port;
    uint16_t pin;
} ADRESSE;

#define WriteLedTime(seconds, milliseconds)\
{\
    HAL_GPIO_WritePin(LED0_GPIO_Port, 0, 0);\
    HAL_GPIO_WritePin(LED0_GPIO_Port, (milliseconds|(seconds*10000))&0xfff, 1);\
}\

void LedInitialization(ADRESSE ledInfos[12]);

#endif