
// DEFINES

#define M_SHUTDOWN      0x0C
#define M_SCANLIMIT     0x0B
#define M_DECODE        0x09

/*
// enumerate the MAX7219 registers
// See MAX7219 Datasheet, Table 2, page 7
enum {  MAX7219_REG_DECODE    = 0x09,  
        MAX7219_REG_INTENSITY = 0x0A,
        MAX7219_REG_SCANLIMIT = 0x0B,
        MAX7219_REG_SHUTDOWN  = 0x0C,
        MAX7219_REG_DISPTEST  = 0x0F };
*/

//Prototypes

void shiftOut(GPIO_TypeDef* Port, uint16_t dataPin, uint8_t clockPin, uint8_t val);
void myWait(void);
void set_register(uint8_t reg, uint8_t value);
void displayTime(void); // A modifier par la suite, donner l'heure en argument