//7seg.h

#ifndef _7seg_
#define _7seg_

//include
#include "main.h"

//register
#define REG_CODE 0x09
#define REG_INTENSITY 0x0a
#define REG_SCAN_LIMIT 0x0B
#define REG_SHUTDOWN 0x0c
#define REG_DISPTEST 0x0f

//values
#define VAL_ON 01
#define VAL_OFF 00

#define VAL_SCANL 3

//pin struct
typedef struct 7seg_pin{
    GPIO_TypeDef* cs_port;
    GPIO_TypeDef* miso_port;
    GPIO_TypeDef* clk_port;

    uint16_t cs_pin;
    uint16_t miso_pin;
    uint16_t clk_pin;
} 7SEG_PIN;

//functions
void setRegister(7SEG_PIN pin, uint8_t reg,uint8_t val);

void writeTime(7SEG_PIN pin , uint8_t * time, uint8_t nbTime);

//conversion ascii to uint 
void c2ui(uint8_t * time , uint8_t nb);

//use case
/*
7SEG_PIN mPin ={
    CS_GPIO
}
char[] data = {'1','2'};
writeTime()
*/
#endif