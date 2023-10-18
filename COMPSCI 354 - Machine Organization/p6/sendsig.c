////////////////////////////////////////////////////////////////////////////////
// Main File:        sendsig.c
// This File:        sendsig.c
// Other Files:      mySigHandler.c
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
#include <unistd.h>
#include <sys/types.h>
#include <signal.h>
#include <string.h>
#include <stdlib.h>

/* Sends SIGINT and SIGUSR1 signals to mySigHandler
 * argv[1] = -i to send SIGINT, -u for SIGUSR1
 *
 * CLAs: sendsig <signal type> <pid> (argc = 3)
 *
 * RETURN 0
 */
int main (int argc, char *argv[]) {
	if (argc != 3) { //CLA usage if expecting more/less args
		printf("Usage: sendsig <signal type> <pid>\n");
		exit(1);
	}

	if (strcmp(argv[1], "-u") == 0) {
		if (kill(atoi(argv[2]), SIGUSR1) == -1) { //Send SIGINT if arg2 is "-u"
			printf("Error: kill -u did not send a signal\n");
			exit(1);
		}
	}
       	else if (strcmp(argv[1], "-i") == 0) {
		if (kill(atoi(argv[2]), SIGINT) == -1) { //Send SIGUSR1 if arg2 is "-i"
			printf("Error: kill -i did not send a signal\n");
			exit(1);
		}
	}

	return 0;
}
