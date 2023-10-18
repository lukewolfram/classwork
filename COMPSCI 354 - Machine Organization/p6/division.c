////////////////////////////////////////////////////////////////////////////////
// Main File:        division.c
// This File:        division.c
// Other Files:      
// Semester:         CS 354 Lecture 04 Fall 2022
// Instructor:       deppeler
// 
// Author:           Luke Wolfram
// Email:            lwolfram@wisc.edu
// CS Login:         lwolfram
//
/////////////////////////// OTHER SOURCES OF HELP //////////////////////////////
//                   fully acknowledge and credit all sources of help,
//                   other than Instructors and TAs.
//
// Persons:          Identify persons by name, relationship to you, and email.
//                   Describe in detail the the ideas and help they provided.
//
// Online sources:   avoid web searches to solve your problems, but if you do
//                   search, be sure to include Web URLs and description of 
//                   of any information you find.
//////////////////////////// 80 columns wide ///////////////////////////////////

#include <stdio.h>
#include <string.h>
#include <sys/types.h>
#include <signal.h>
#include <unistd.h>
#include <stdlib.h>

int numSuccOps = 0; //Number of successful, legal integer division operations

/* Implementation of a SIGFPE handler
 * Upon an illegal division operation, prints an error message about dividing by zero
 * Then prints numSuccOps and a termination message
 * Then exits(0)
 *
 * RETURN void
 */
void handler_SIGFPE() {
	printf("Error: a division by 0 operation was attempted.\n");
	printf("Total number of operations completed successfully: %d\n", numSuccOps);
	printf("The program will be terminated.\n");
	exit(0);
}

/* Implementation of a SIGINT handler
 * Upon an interrupt, prints numSuccOps and a termination message
 * Then exits(0)
 *
 * RETURN void
 */
void handler_SIGINT() {
	printf("\nTotal number of operations completed successfully: %d\n", numSuccOps);
	printf("The program will be terminated.\n");
	exit(0);
}

/* A rudimentary function for dividing two integers.
 * Sends SIGFPE and SIGINT signals, SIGFPE if user tries to divide by zero
 * Enters a while loop, so the only way out is Ctrl+C or sending a SIGFPE
 *
 * RETURN 0
 */
int main () {
	char intBuf[100];
	int i1 = 0;
	int i2 = 0;

	struct sigaction sz; //sigaction struct for SIGFPE
	memset(&sz, 0, sizeof(sz));
	sz.sa_handler = handler_SIGFPE;

	if (sigaction(SIGFPE, &sz, NULL) != 0) {
		printf("Error: binding SIGFPE handler\n");
		exit(1);
	}

	struct sigaction si; //sigaction struct for SIGINT
	memset(&si, 0, sizeof(si));
	si.sa_handler = handler_SIGINT;

	if (sigaction(SIGINT, &si, NULL) != 0) {
		printf("Error: binding SIGINT handler\n");
		exit(1);
	}

	while (1) {
		printf("Enter first integer: ");
		if (fgets(intBuf, 100, stdin) == NULL) {
			printf("Error: fgets() first integer returned NULL");
			exit(1);
		}

		i1 = atoi(intBuf);

		printf("Enter second integer: ");
		if (fgets(intBuf, 100, stdin) == NULL) {
			printf("Error: fgets() second integer returned NULL");
			exit(1);
		}

		i2 = atoi(intBuf);

		printf("%d / %d is %d with a remainder of %d\n", i1, i2, i1/i2, i1%i2);
		numSuccOps++; //inc if no signals were sent
	}

	return 0;
}
