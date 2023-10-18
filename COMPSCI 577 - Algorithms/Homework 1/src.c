#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {

	int n;

	scanf("%d\n", &n);

	char names[n][30];

	for (int i = 0; i < n; i++) {
		char* buffer = NULL;
		size_t bufSize = 30;
		size_t characters;

		buffer = (char*)malloc(bufSize * sizeof(char));
		if (buffer == NULL) {
			printf("Unable to allocate buffer\n");
			exit(1);
		}

		characters = getline(&buffer, &bufSize, stdin);

		int size = strlen(buffer);
		if (buffer[size - 1] == '\n') {
			buffer[size - 1] = '\0';
		}

		strcpy(names[i], buffer);
	}

	for (int i = 0; i < n; i++) {
		printf("Hello, %s!\n", names[i]);
	}

	return 0;
}
