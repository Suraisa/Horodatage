#include "7_seg_driver.h"

/*
void HAL_GPIO_WritePin 	( 	GPIO_TypeDef *  	GPIOx,
		uint16_t  	GPIO_Pin,
		GPIO_PinState  	PinState 
	) 		
*/

/*
void shiftOut(uint8_t dataPin, uint8_t clockPin, uint8_t bitOrder, uint8_t val)
{
    uint8_t i;

    for (i = 0; i < 8; i++)  {
        if (bitOrder == LSBFIRST)
            digitalWrite(dataPin, !!(val & (1 << i)));
        else    
            digitalWrite(dataPin, !!(val & (1 << (7 - i))));

        digitalWrite(clockPin, HIGH);
        digitalWrite(clockPin, LOW);        
    }
}
*/

void shiftOut(GPIO_TypeDef* Port, uint16_t dataPin, uint8_t clockPin, uint8_t val)
{
    uint8_t i;

    for (i = 0; i < 8; i++)  {
        HAL_GPIO_WritePin(Port, dataPin, !!(val & (1 << i)) );

        HAL_GPIO_WritePin(Port, clockPin, 1);
        digitalWrite(,clockPin, HIGH);
        myWait();
        HAL_GPIO_WritePin(Port, clockPin, 0);      
        myWait();
    }
}

void myWait(){
    int k;

    for(k=0; k<100; k++){
        __asm__("NOP");
    }
}


void set_register(uint8_t reg, uint8_t value)  
{
    HAL_GPIO_WritePin(CS_GPIO_Port, CS_Pin, 0);      
    shiftOut(DATA_DISPLAY_OUT_GPIO_Port, DATA_DISPLAY_OUT_Pin, CLK_Pin, reg);
    shiftOut(DATA_DISPLAY_OUT_GPIO_Port, DATA_DISPLAY_OUT_Pin, CLK_Pin, value);
    HAL_GPIO_WritePin(CS_GPIO_Port, CS_Pin, 1); 
}



// ... display the TIME on the 7-segment display
void displayTime()  
{
    set_register(M_SHUTDOWN, 0);      // turn off display
    set_register(M_SCANLIMIT, 7);       // limit to 8 digits
    set_register(M_DECODE, 0b11111111); // decode all digits

    set_register(1, 48);
    set_register(2, 49);
    set_register(3, 50);

    set_register(M_SHUTDOWN, 1);       // Turn on display
}








