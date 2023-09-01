import java.util.*;

public class Searching {

    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) throws InterruptedException {
        int choice;

        do {
            System.out.println("\t\t\t   Menu");
            System.out.println("\t----------------------------------------");
            System.out.println("\t1. Linear Search");
            System.out.println("\t2. Binary Search");
            System.out.println("\t3. Hashing using HashMap");
            System.out.println("\t4. String Searching");
            System.out.println("\t5. Exit");
            System.out.println("\t----------------------------------------");
            System.out.print("\tEnter your choice: ");
            choice = in.nextInt();

            switch (choice) {
                case 1: linearSearch();
                        break;
                case 2: binarySearch();
                        break;
                case 3: hashing();
                        break;
                case 4: stringSearching();
                        break;
                case 5: System.out.println("\tExiting.......");
                        break;
                default: System.out.println("\tInvalid choice.");
            }
        } while (choice != 5);
        in.close();
    }

    static void linearSearch() throws InterruptedException {
       System.out.print("\tEnter the size of the array:");
       int n = in.nextInt();
       int arr[] = new int[n];

       System.out.print("\tEnter the array elements:");
       for (int i = 0 ;i<arr.length;i++) {
            arr[i] = in.nextInt();
       }

       System.out.print("\tEnter key to be searched:");
       int key = in.nextInt();

       long start = System.nanoTime();
       for (int i = 0; i < arr.length; i++) {
        if (arr[i] == key) {
            System.out.println("\tElement " + key + " found at index " + arr[i - 1]);
        }
       }
       long end = System.nanoTime();
       long time = end - start;
       System.out.println("\tTime taken for Linear Search: " + time + " ns");
       Thread.sleep(10000);
    }


    static void binarySearch() throws InterruptedException {
        System.out.print("\tEnter the size of the array:");
       int n = in.nextInt();
       int arr[] = new int[n];

       System.out.print("\tEnter the array elements:");
       for (int i = 0 ;i<arr.length;i++) {
            arr[i] = in.nextInt();
       }

       Arrays.sort(arr);

       System.out.println("\tSorted array for searching:");
       for (int i = 0 ;i<arr.length;i++) {
            System.out.print("\t" + arr[i] + " ");
       }

       System.out.print("\tEnter key to be searched:");
       int key = in.nextInt();

        long start = System.nanoTime();
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key) {
                System.out.println("\tElement " + key + " found at index " + mid);
                break;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        long end = System.nanoTime();
        long time = end - start;
        System.out.println("\tTime taken for Linear Search: " + time + " ns");
        Thread.sleep(10000);
    }

    static void hashing() throws InterruptedException {
        Map<Integer, String> map = new HashMap<>();
        
        System.out.print("\tEnter the number of key-value pairs:");
        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("\tEnter key " + (i + 1) + ": ");
            int key = in.nextInt();
            System.out.print("\tEnter value for key " + key + ": ");
            String value = in.next();
            map.put(key, value);
        }

        System.out.print("\tEnter a key to search for its value: ");
        int key = in.nextInt();

        long start = System.nanoTime();
        if (map.containsKey(key)) {
            System.out.println("\tValue for key " + key + ": " + map.get(key));
        } else {
            System.out.println("\tKey not found");
        }
        long end = System.nanoTime();
        long time = end - start;
        System.out.println("\tTime taken for Linear Search: " + time + " ns");
        Thread.sleep(10000);
    }

    static void stringSearching() throws InterruptedException {
        try (Scanner scan = new Scanner(System.in)) {
            String text = "";
            String search = "";
            
            System.out.print("\tEnter a string: ");
            text = scan.nextLine();
            
            System.out.print("\tEnter the string to be searched: ");
            search = scan.nextLine();
            
            long start = System.nanoTime();
            int index = text.indexOf(search);
            
            if (index != -1) {
                System.out.println("\t" + search + " found at index " + index);
            } else {
                System.out.println("\t" + search + " not found");
            }
            long end = System.nanoTime();
            long time = end - start;
            System.out.println("\tTime taken for Linear Search: " + time + " ns");
            Thread.sleep(10000);
        }
    }
}
