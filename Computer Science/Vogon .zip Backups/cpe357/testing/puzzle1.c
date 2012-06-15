       #include <unistd.h>
          #include <stdlib.h>
          #include <stdio.h>
          int main(int argc, char **argv) {
            int i, j, m;
            for (i = 1; i <= 3; i++) {
              for (j = 0; j < i; j++) {
              	printf("%d", i * j);
              }
              putchar('\n');
            }
            putchar('\n');
            return EXIT_SUCCESS;
          }
