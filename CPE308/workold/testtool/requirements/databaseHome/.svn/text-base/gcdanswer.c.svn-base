#include stdio.h


/* a & b are the numbers whose GCD is to be found. 
 Given a > b
 */
  int gcd(int a,int b)
  {
    int c;
    while(1)
    {
  	c = a%b;
  	if(c==0)
  	  return b;
  	a = b;
  	b = c;
    }
  }
  
int main(void)
{
  int a, b;
  scanf("%d", &a);
  scanf("%d", &b);
  printf("%d", gcd(a,b));
  return 0;
}