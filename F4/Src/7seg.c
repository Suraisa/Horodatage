//7seg.c

#include "7seg.h"

void setRegister(7SEG_PIN pin, uint8_t reg,uint8_t val){
    uint16_t data  = reg<<8 | val;
    HAL_GPIO_WritePin(pin.cs_port,pin.cs_pin,1);

    HAL_SPI_Transmit(&hspi2,&data,1,10);

    HAL_GPIO_WritePin(pin.cs_port,pin.cs_pin,0);    
}

void writeTime(7SEG_PIN pin , uint8_t * time, uint8_t nbTime){
    
    //a tester si val_on ou val off pour la ligne suivante
    setRegister(pin, REG_SHUTDOWN,VAL_ON);
    setRegister(pin, REG_SCAN_LIMIT, VAL_SCANL);
    //time print begin
    int i;
    for (i = 0; i<nbTime;i++){
        setRegister(pin, i, time[i]);
    }
    //time print end
    setRegister(pin, REG_CODE,0xff);
    setRegister(pin , REG_SHUTDOWN,VAL_ON);
}

void c2ui(uint8_t * time , uint8_t nb){
    int i;
    for(i=0;i<nb;i++){
        time[i]-=48;
    }
}