int twoDColsArray[3000][500];

int main (int argc, char *argv[]) {
    //Outer loop traverses columns
    for (int i = 0; i < 500; i++) {
        //Inner loop traverses rows
        //Set each element to index of outer loop + index of inner loop
        for (int j = 0; j < 3000; j++) {
            twoDColsArray[j][i] = i + j;
        }
    }
    return 0;
}