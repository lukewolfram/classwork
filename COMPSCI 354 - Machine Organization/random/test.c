#include <stdio.h>

int array[3000][8];

int main (int argc, char *argv[]) {
    //Outer loop traverses rows
    for (int i = 0; i < 3000; i++) {
        //Inner loop traverses columns
        //Set each element to index of outer loop + index of inner loop
        for (int j = 0; j < 500; j++) {
            array[i][j] = i + j;
        }
    }

    for (int k = 0; k < 3000; k++) {
        printf("Row %d: ", k);
        for (int l = 0; l < 500; l++) {
            printf("%d ", array[k][l]);
        }
        printf("\n");
    }
}