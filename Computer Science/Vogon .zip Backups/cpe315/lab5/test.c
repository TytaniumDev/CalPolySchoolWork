int main(void)
{
int zero = 0;
int a = 1;
int a2 = 1;
int b = 3;
int c = -2;
int d = -5;
char alpha = 10;//Char is byte long, so tests SB
char alpha2 = -2;
unsigned char beta = 5;// will be used to test LBU
unsigned char beta2 = -1;
int e = b + c; //Tests ADDU; should be 1
int f = b << 1; //Tests SLL; should be 6
int g1 = a < b; //Tests SLL with two positive, should be 1
int g2 = b < a; //Tests SLL with two positve, should be 0
int g3 = a < c; //Tests SLL with one pos, one neg; should 0
int g4 = c < a; //Tests SLL with one pos, one neg, should be 1
int g5 = d < c; // Tests SLL with two negatives, should be 1
int g6 = c < d; // Tests SLL with two negatives, should be 0
//Disclaimer: Since the -d test dumps the whole register, and we are
//only interested in one byte, just refer to the final byte
//in the register dump for these byte tests.
int h1 = (int)alpha; //Tests LB. LSB should be a
int h2 = (int)alpha2; //Tests LB, LSB should be e
int i1= (int)beta;//Tests LBU, LSB should be 5;
int i2 = (unsigned int)beta2;//Tests LBU, should f
//Disclaimer: You must have JR implemented for these following tests to work.
if (a == a2) //Tests BEQ
{
int j1 = 10; //Should print out a, because we got here.
}
if (a == b)
{
int j2 = 11; //Should NOT print out b, because we shouldn't get here.
}
if (a != b) //Tests BNE
{
int k1 = 12; // Should print out c, because we should get here.
}
if (a!= a2)
{
int k2 = 13; //should NOT print out d, because we shouldn't get here
}
if (a > 0)//Tests BLEZ
{
int l1 = 14; // Should print out e, because we should get here.
}
if (c > 0)
{
int l2 = 15;// should NOT print out f, because we shouldn't get here.
}
if (zero > 0)
{
int l3 = 16;// should NOT print out 10, because zero isn't greater than zero.
}


return a;
}
