int array[128][8];

int main (int argc, char *argv[]) {
    //Repeats the two loops below 100 times
    for (int i = 0; i < 100; i++) {
        //Traverse rows, increment by 64
        for (int j = 0; j < 128; j += 64) {
            //Traverse cols
            for (int k = 0; k < 8; k++) {
                //Each element equals outer loop index + row loop index + col loop index
                array[j + i][k] = i + j + k;
            }
        }
    }
    return 0;
}