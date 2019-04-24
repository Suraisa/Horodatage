//7seg.c

#include "7seg.h"

int time;
SEG_PIN seg_pin = { .cs_port = CS_GPIO_Port, .cs_pin = CS_Pin};

void setRegister(SEG_PIN pin, uint8_t reg,uint8_t val){
    uint16_t data  = reg<<8 | val;
    HAL_GPIO_WritePin(pin.cs_port,pin.cs_pin,0);

    HAL_SPI_Transmit(&hspi2,&data,1,10);

    HAL_GPIO_WritePin(pin.cs_port,pin.cs_pin,1);
}

void setupSeg(SEG_PIN pin){
    setRegister(pin, REG_SHUTDOWN,VAL_OFF);
    setRegister(pin, REG_DISPTEST,VAL_OFF);
    setRegister(pin, REG_INTENSITY,0x0d);
}

void writeTime(SEG_PIN pin , uint8_t * time, uint8_t nbTime){
    //a tester si val_on ou val off pour la ligne suivante
    setRegister(pin, REG_SHUTDOWN,VAL_OFF);
    setRegister(pin, REG_SCAN_LIMIT, nbTime-1);
    setRegister(pin, REG_CODE,0b111111);

    //time print begin
    int i;
    for (i = 0; i<nbTime;i++){
        setRegister(pin, i+1, time[nbTime-1-i]);
    }
    //time print end
    setRegister(pin , REG_SHUTDOWN,VAL_ON);
}

void wT (SEG_PIN pin , uint8_t * time, int start, uint8_t nbTime){

    //a tester si val_on ou val off pour la ligne suivante
    setRegister(pin, REG_SHUTDOWN,VAL_OFF);
    setRegister(pin, REG_SCAN_LIMIT, nbTime-1);
    setRegister(pin, REG_CODE,0b111111);
    //time print begin
    int i;
    for (i = start; i<start + nbTime;i++){
        setRegister(pin, i+1, time[i]);
    }
    //time print end
    setRegister(pin , REG_SHUTDOWN,VAL_ON);
}

void c2ui(uint8_t * time ,uint8_t * itime, uint8_t nb){
    int i;
    for(i=0;i<nb;i++){
        itime[i] = time[i] - 48;
    }
}

int ui2i (uint8_t * time, uint8_t nb){
    int rtime = 0;
    int i;
    for(i=0;i<nb;i++){
        rtime = rtime*10 + time[i];
    }
    return rtime;
}

void i2ui(uint8_t * itime , uint8_t nb ,int time){
    int i;
    for(i=0; i< nb ; i++){
        itime[nb-1-i] = (time/(10*(i+1)))%10;
    }
}

void ui2c(uint8_t * itime , uint8_t * time , uint8_t nb){
    int i;
    for(i=0;i<nb;i++){
        time[i] = itime[i] + 48;
    }
}