public class HeapSort {
    public static void sort(int[] array){
        // построение кучу перегруппировываем массив
        for (int i = array.length / 2 - 1; i >= 0 ; i--) {
            heapifi(array, array.length, i);
        }
        // извлекаем элементы один за другим из кучи
        for (int i = array.length -1; i >= 0 ; i--) {
            // перемещаем текщий корень в конец
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // вызываем процедуру heapify на уменьшенной куче

            heapifi(array, i, 0);
        }

    }

    private static void heapifi (int[] array, int heapSize, int rootIndex){
        int largest = rootIndex;
        int rightChild = 2 * rootIndex + 1;
        int leftChild  = 2 * rootIndex + 2;

        if (leftChild < heapSize && array[leftChild] > array[largest]){
            largest = leftChild;
        }

        if (rightChild < heapSize && array[rightChild] > array[largest]){
            largest = rightChild;
        }
        if (largest != rootIndex){
            int temp = array[rootIndex];
            array[rootIndex] = array[largest];
            array[largest] = temp;
            // Рекурсивно преобразуем затронутую кучу в дерево

            heapifi(array, heapSize, largest);
        }



    }
}
