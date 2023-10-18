////////////////////////////////////////////////////////////////////////////////
// Main File:        mySigHandler.c
// This File:        mySigHandler.c
// Other Files:      sendsig.c
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

#include <signal.h>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <sys/types.h>
#include <time.h>
#include <unistd.h>

const unsigned int SECONDS_LIMIT = 4;
int sigUsrReceivedCount = 0;

/* Implementation of a SIGALRM handler
 * Prints mySigHandler's PID and current time every four seconds.
 * 
 * RETURN void
 */
void handler_SIGALRM() {
	time_t t; //Initialize time type

	time(&t); //Get value of time
	
	int pid_t = getpid(); //get pid of mySigHandler

	if (t == 0 || strcmp(ctime(&t), "") == 0) {
		printf("Error: c/time not working\n");
		exit(1);
	}

	printf("PID: %d CURRENT TIME: %s", pid_t, ctime(&t));

	alarm(SECONDS_LIMIT); //Re-arm alarm to go off every 4 seconds
}

/* Updates number of times SIGUSR1 has been received, and prints a
 * message confirming it has been handled.
 *
 * RETURN void
 */
void handler_SIGUSR1() {
	sigUsrReceivedCount++;
	printf("SIGUSR1 handled and counted!\n");
}

/* Prints total number of times SIGUSR1 was received and exits 0
 *
 * RETURN void
 */
void handler_SIGINT() {
	printf("\nSIGINT handled.\nSIGUSR1 was handled %d times.", sigUsrReceivedCount);
	printf("  Exiting now.\n");
	exit(0);
}

/* An infinite while-loop where the function sends a SIGALRM every four seconds
 * Terminated when user inputs Ctrl + C
 *
 * RETURN 0
 */
int main () {

	alarm(SECONDS_LIMIT); //Initialize alarm send a SIGALRM signal every 4 seconds

	printf("PID and time print every 4 seconds.\n");
	printf("Type Ctrl-C to end the program.\n"); //Instructions for user

	struct sigaction sa; //sigaction struct for SIGALRM
	memset(&sa, 0, sizeof(sa)); //zero out struct
	sa.sa_handler = handler_SIGALRM; //Register SIGALRM to sa handler

	if (sigaction(SIGALRM, &sa, NULL) != 0) { //Binding error, exit
		printf("Error: binding SIGALRM handler\n");
		exit(1);
	}

	struct sigaction su; //sigaction struct for SIGUSR1
	memset(&su, 0, sizeof(su)); //zero out struct
	su.sa_handler = handler_SIGUSR1; //Register SIGUSR1 to su handler

	if (sigaction(SIGUSR1, &su, NULL) != 0) { //Binding error, exit
		printf("Error: binding SIGUSR1 handler\n");
		exit(1);
	}

	struct sigaction si; //sigaction struct for SIGINT
	memset(&si, 0, sizeof(si)); //zero out struct
	si.sa_handler = handler_SIGINT; //Register SIGINT to si handler

	if (sigaction(SIGINT, &si, NULL) != 0) { //Binding error, exit
		printf("Error: binding SIGINT handler\n");
		exit(1);
	}


	while (1) {}

	return 0;
}
