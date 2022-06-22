//Author: Seth Walloch

public class findMe {
    public static void main(String[] args) throws Exception {
        int value = Integer.parseInt(args[0]);
        int[] A = new int[args.length - 1];
        int counter = 1;

        //A way to get all the elements into a list so I can send it to my index finder
        for (int i = 0; i < args.length - 1; i++) {
            int temp = Integer.parseInt(args[counter]);
            A[i] = temp;
            counter++;
        }

        int low = 0;
        int high = A.length - 1;
        int answer = indexFinder(A, low, high, value);
        int answer2 = getComparisons();

        //This will take what the answer is and decide if it was in the list or not
        //If it was in the list it will give its index but if it wasn't it will say it wasn't
        //Either way it will give the amount of comparisons done
        if(answer == -1){
            System.out.println(value + " was not found in the list given");
        }else{
            System.out.println(value + "'s index in the list is: " + answer);
        }
        System.out.println("The amount of comparisons done: " + answer2);
    }

    //A variables to keep track of comparisons
    static int comparisons = 0;
    static int mid;

    //This method is pretty much just Binary Search that is done recursively
    //This means that it should run in O(log n) time
    public static int indexFinder(int[] A, int low, int high, int value){
        if(mid >= A.length - 1){
            return -1;
        }

        mid = ((low + high) / 2);
        if(value == A[mid]){
            comparisons = comparisons + 1;
            return mid;
        }else if(value < A[mid]){
            comparisons = comparisons + 1;
            return indexFinder(A, low, mid - 1, value);
        }else if(value > A[mid]){
            comparisons = comparisons + 1;
            return indexFinder(A, mid + 1, high, value);
        }else{
            return -1;
        }
    }

    //Simple get method to return the amount of comparisons
    public static int getComparisons(){
        return comparisons;
    }

}