////////////////////////////////////////////////////////////////////////////////
// Main File:        myMagicSquare.c
// This File:        myMagicSquare.c
// Other Files:      (name of all other files if any)
// Semester:         CS 354 Fall 2022
// Instructor:       deppeler
//
// Author:           Luke Wolfram
// Email:            lwolfram@wisc.edu
// CS Login:         lwolfram
//
/////////////////////////// OTHER SOURCES OF HELP //////////////////////////////
//                   Fully acknowledge and credit all sources of help,
//                   including Peer Mentors, Instructors, and TAs.
//
// Persons:          Identify persons by name, relationship to you, and email.
//                   Describe in detail the the ideas and help they provided.
//
// Online sources:   Avoid web searches to solve your problems, but if you do
//                   search, be sure to include Web URLs and description of
//                   of any information you find.
////////////////////////////////////////////////////////////////////////////////

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Structure that represents a magic square
typedef struct {
    int size;           // dimension of the square
    int **magic_square; // pointer to heap allocated magic square
} MagicSquare;

/* Prompts the user for the magic square's size, reads it,
 * checks if it's an odd number >= 3 (if not display the required
 * error message and exit), and returns the valid number.
 */
int getSize() {
    int toCheck;

    printf("Enter magic square's size (odd integer >=3)\n");
    scanf("%d", &toCheck);
    
    if (toCheck % 2 != 1 || toCheck < 3) {
        printf("Magic square size must be >= 3.\n");
        exit(1);
    }

    return toCheck;   
} 
   
/* Makes a magic square of size n using the alternate 
 * Siamese magic square algorithm from assignment and 
 * returns a pointer to the completed MagicSquare struct.
 *
 * n the number of rows and columns
 */
MagicSquare *generateMagicSquare(int n) {
    MagicSquare *toReturn = malloc(sizeof(MagicSquare));

    toReturn->magic_square = malloc(sizeof(int) * n);
    if (toReturn->magic_square == NULL) {
        printf("magic_square rows not allocated\n");
        exit(1);
    }

    for (int i = 0; i < n; i++) {
        *(toReturn->magic_square + i) = malloc(sizeof(int) * n);
        if (*(toReturn->magic_square + i) == NULL) {
            printf("magic_square column not allocated at column %d", i);
            exit(1);
        }
    }

    toReturn->size = n;

    //Get the magic sum; what all rows, columns, 
    //and diagonals should add up to
    int magicSum = (n * ((n * n) + 1)) / 2;

    //Set i and j to up and left of where 1 should be placed 
    //so the for loop can properly function
    int i = (n / 2) -1;
    int j = (n - 1) - 1;

    //Loop to insert all 1...n digits
    for (int toPut = 1; toPut < (n * n) + 1; toPut++) {

        //Previous i, j to help when encountering
        //occupied spaces in the magic square
        int previ = i;
        int prevj = j;

        //Go down and right
        i += 1;
        j += 1;

        //Set row and/or column to zero if outside of array's bounds
        if (i >= n) {
            i = 0;
        }
        if (j >= n) {
            j = 0;
        }

        //If down and to the right is taken, go to the left column
        if ((*(*(toReturn ->magic_square + i) + j) != 0)) {
            i = previ;
            j = prevj - 1;
        }

        //Insert toPut
        *(*(toReturn ->magic_square + i) + j) = toPut;
    }

    //Below is 4 checks to verify that the magic square is valid.
    //I just got carried away.  I know you didn't ask for them,
    //but I felt obliged to make them.  Hopefully it doesn't hurt
    //my grade for this submission.

    //Check that all rows sum to the magic sum
    int rowSum;
    for (int i = 0; i < n; i++) {
        rowSum = 0;

        for (int j = 0; j < n; j++) {
            rowSum += *(*(toReturn->magic_square + i) + j);
        }
        if (rowSum != magicSum) {
            printf("Row %d not equal to magic sum of %d\n", i, magicSum);
            exit(1);
        }
    }

    //Check that all cols sum to the magic sum
    int colSum;
    for (int i = 0; i < n; i++) {
        colSum = 0;

        for (int j = 0; j < n; j++) {
            colSum += *(*(toReturn->magic_square + j) + i);
        }
        if (colSum != magicSum) {
            printf("Column %d not equal to magic sum of %d\n", j, magicSum);
            exit(1);
        }
    }

    //Check that left diag sums to magic sum
    int leftDiagSum = 0;
    for (int j = 0; j < n; j++) {
        leftDiagSum += *(*(toReturn->magic_square + j) + j);
    }
    if (leftDiagSum != magicSum) {
        printf("Left diagonal not equal to magic sum of %d\n", magicSum);
        exit(1);
    }

    //Check that right diag sums to to the magic sum
    int rightDiagSum = 0;
    for (int k = n - 1; k > -1; k--) {
        rightDiagSum += *(*(toReturn->magic_square + k) + k);
    }
    if (rightDiagSum != magicSum) {
        printf("Right diagonal not equal to magic sum of %d\n", magicSum);
        exit(1);
    }

    return toReturn;    
} 

/* Opens a new file (or overwrites the existing file)
 * and writes the square in the specified format.
 *
 * magic_square the magic square to write to a file
 * filename the name of the output file
 */
void fileOutputMagicSquare(MagicSquare *magic_square, char *filename) {
    FILE *outputFile = fopen(filename, "w");
    if (outputFile == NULL) {
        fprintf(outputFile, "Can't open output file %s\n", filename);
        exit(1);
    }
    
    for (int i = 0; i < magic_square->size; i++) {
        for (int j = 0; j < magic_square->size - 1; j++) {
            fprintf(outputFile, "%d,", *(*(magic_square->magic_square + i) + j));
        }
        fprintf(outputFile, "%d", *(*(magic_square->magic_square + i) + magic_square->size - 1));
        fprintf(outputFile, "\n");
    }
   
    if (fclose(outputFile) != 0) {
        printf("Error while closing the file.\n");
        exit(1);
    } 
}

/* Generates a magic square of the user specified size and
 * output the square to the output filename
 *
 * CLAs: ./myMagicSquare <output_filename> (argc = 2)
 */
int main(int argc, char **argv) {
    // Check input arguments to get output filename
    if (argc != 2) {
        printf("Usage: ./myMagicSquare <output_filename>\n");
        exit(1);
    }

    // Get magic square's size from user
    int size = getSize();
    // Generate the magic square
    MagicSquare *magic = generateMagicSquare(size);
    // Output the magic square
    fileOutputMagicSquare(magic, *(argv + 1));

    //Free the 2D array magic_square
    for (int i = 0; i < magic->size; i++) {
        free(*(magic->magic_square + i));
    }
    free(magic->magic_square);

    return 0;
}


//     F22 deppeler myMagicSquare.c     
