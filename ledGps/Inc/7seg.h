//7seg.h

#ifndef _7seg_
#define _7seg_

//include

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
#include "main.h"

#include "spi.h"
//pin struct
typedef struct
{
    GPIO_TypeDef* cs_port;
    //GPIO_TypeDef* miso_port;
    //GPIO_TypeDef* clk_port;

    uint16_t cs_pin;
    //uint16_t miso_pin;
    //uint16_t clk_pin;
} SEG_PIN;
extern char itime[8];
extern SEG_PIN seg_pin;

//functions
void setRegister(SEG_PIN pin, uint8_t reg, uint8_t val);
void setupSeg(SEG_PIN pin);
void writeTime(SEG_PIN pin, uint8_t* time, uint8_t nbTime);

void wT(SEG_PIN pin, uint8_t* time, int start, uint8_t nbTime);

//conversion ascii to uint
void c2ui(uint8_t* time, uint8_t* itime, uint8_t nb);
int ui2i(uint8_t* itime, uint8_t nb);
void i2ui(uint8_t* itime, uint8_t nb, int time);
void ui2c(uint8_t* itime, uint8_t* time, uint8_t nb);
//use case
/*
7SEG_PIN mPin ={
    CS_GPIO
}
char[] data = {'1','2'};
writeTime()
*/

#endif