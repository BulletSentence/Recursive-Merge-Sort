// Merge Sort Recursivo
class MergeSort {

    static int quantidade_numeros = 8;

    public static double randint(double min, double max){
        double x = (int)(Math.random()*((max-min)+1))+min;
        return x;
    }

    void merge(int[] arr, int a, int b, int c)
    {
        int subArray1 = b - a + 1;
        int subArray2 = c - b;

        int[] temporaryArray1 = new int[subArray1];
        int[] temporaryArray2 = new int[subArray2];

        for (int i = 0; i < subArray1; ++i)
            temporaryArray1[i] = arr[a + i];
        for (int j = 0; j < subArray2; ++j)
            temporaryArray2[j] = arr[b + 1 + j];

        int i = 0, j = 0;

        int k = a;
        while (i < subArray1 && j < subArray2) {
            if (temporaryArray1[i] <= temporaryArray2[j]) {
                arr[k] = temporaryArray1[i];
                i++;
            }
            else {
                arr[k] = temporaryArray2[j];
                j++;
            }
            k++;
        }

        while (i < subArray1) {
            arr[k] = temporaryArray1[i];
            i++;
            k++;
        }

        while (j < subArray2) {
            arr[k] = temporaryArray2[j];
            j++;
            k++;
        }
    }

    void sort(int arr[], int esqueda, int direita)
    {
        if (esqueda < direita) {
            // Encontra o meio
            int m = esqueda + (direita-esqueda)/2;

            sort(arr, esqueda, m);
            sort(arr, m + 1, direita);
            merge(arr, esqueda, m, direita);
        }
    }

    static void mostraArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }


    public static void main(String args[])
    {
        int arr[] = new int[quantidade_numeros];
        for (int i = 0; i < quantidade_numeros; i++){
            arr[i] = (int) randint(0,quantidade_numeros);
        }

        int arrfixo[] = {110, 130, 150, 170, 190, 100, 120, 140, 160, 180};

        System.out.println("Numeros gerados");
        mostraArray(arrfixo);

        MergeSort ob = new MergeSort();
        ob.sort(arrfixo, 0, arr.length - 1);

        System.out.println("\nNumeros Ordenados");
        mostraArray(arrfixo);
    }
}
