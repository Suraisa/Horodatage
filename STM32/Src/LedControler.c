#include "LedControler.h"

void LedInitialization(ADRESSE ledInfos[4])
{
    ledInfos[0].port = LED0_GPIO_Port;
    ledInfos[0].pin = LED0_Pin;
    ledInfos[1].port = LED1_GPIO_Port;
    ledInfos[1].pin = LED1_Pin;
    ledInfos[2].port = LED2_GPIO_Port;
    ledInfos[2].pin = LED2_Pin;
    ledInfos[3].port = LED3_GPIO_Port;
    ledInfos[3].pin = LED3_Pin;
}