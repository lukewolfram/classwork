int twoDRowsArray[3000][500];

int main (int argc, char *argv[]) {
    //Outer loop traverses rows
    for (int i = 0; i < 3000; i++) {
        //Inner loop traverses columns
        //Set each element to index of outer loop + index of inner loop
        for (int j = 0; j < 500; j++) {
            twoDRowsArray[i][j] = i + j;
        }
    }
    return 0;
}