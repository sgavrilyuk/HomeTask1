import java.util.*;

public class ArrayMadness {
    public static void main(String[] args){

        System.out.println("The array of simple numbers:");
        ArrayMadness.arrayOfSimpleNumb();

        System.out.println("The array of random 10 numbers:");
        ArrayMadness.switchOfMaxAndMin();

        System.out.println("The array of 10 numbers to calculate its average :");
        ArrayMadness.averageOfArray();

        System.out.println("The array of random [-1: 1] 13 numbers :");
        ArrayMadness.arrayOfZerosAndOnes();

        System.out.println("Create List with 5 strings:");
        ArrayMadness.shortValueOfArray();

        ArrayMadness.repitedElemntsOfString();

    }

    public static void arrayOfSimpleNumb(){
        int[] arrayOfSimpleNumbers = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};

        for (int i = 0; i < 10; i++){
            if (i < 9){
                System.out.print(arrayOfSimpleNumbers[i]+", ");
            } else {
                System.out.println(arrayOfSimpleNumbers[i]+"");
            }
        }
    }

    public static void switchOfMaxAndMin(){
        int [] array = new int[10];
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            array[i] = random.nextInt(100);
            if (i < 9) {
                System.out.print(array[i] + ", ");
            } else {
                System.out.println(array[i] + "");
            }
        }

        int tmpMax = array[0];
        int tmpMin = array[0];

        for (int i = 0; i < 10; i++) {
            if (tmpMax < array[i]){
                tmpMax = array[i];
            } else if (tmpMin > array[i]){
                tmpMin = array[i];
            }
        }

        System.out.println("Max value of array: " + tmpMax);
        System.out.println("Min value of array: " + tmpMin);
        System.out.println("The array with switched Min and Max value: ");

        for(int i = 0; i < 10; i++){
            if(array[i] ==  tmpMax){
                array[i] = tmpMin;
            } else if (array[i] == tmpMin) {
                array[i] = tmpMax;
            }
            if (i < 9) {
                System.out.print(array[i] + ", ");
            } else {
                System.out.println(array[i] + "");
            }
        }
    }

    public static void averageOfArray(){
        int [] array = new int[20];
        float sum = 0;
        Random random = new Random();
        for (int i =0; i < 20; i++) {
            array[i] = random.nextInt(11) - 5; //random values from [-5; 5]
            sum += array[i];
            if (i < 19) {
                System.out.print(array[i] + ", ");
            } else {
                System.out.println(array[i] + "");
            }
        }
        System.out.println("Average value of array = " + sum/array.length);
    }

    public static void arrayOfZerosAndOnes() {
        int[] array = new int[13];

        Random random = new Random();
        for (int i = 0; i < 13; i++) {
            array[i] = random.nextInt(3) - 1; //random values from [-1; 1]
            if (i < 12) {
                System.out.print(array[i] + ", ");
            } else {
                System.out.println(array[i] + "");
            }
        }

        int valueInArray = 0;
        int frequ = 0;
        for (int temp : array) {
            int narr = frequency(array, temp);
            if (frequ < narr) {
                valueInArray = temp;
                frequ = narr;
            }
        }

        System.out.println("The number " + valueInArray + " is repeated " + frequ + " times");
    }

    public static int frequency(int[] arr, int x){
        int n = 0;
        for (int temp : arr) {
            if (x == temp) {
                n++;
            }
        }
        return n;
    }

    public static void shortValueOfArray(){
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();

        for (int i = 0; i <5; i++){
            System.out.println("Input list "+i+":");
            list.add(sc.nextLine());
        }

        int minLength = Integer.MAX_VALUE;
        for (String i:list){
            if (minLength > i.length()){
                minLength = i.length();
            }
        }
        for (String i:list) {
            if (minLength == i.length())
            System.out.println("The length of the shortest string is: "+minLength+" and here it is: "+i);
        }
    }

    public static void repitedElemntsOfString() {
        System.out.println("Input string of integers (not less 3) separated by a comma, e.g 1,2,3,4,5,6");
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String[] strMas = string.split(",");

        while (strMas.length < 4){
            System.out.println("Input more then 3 integers");
            string = scanner.nextLine();
            strMas = string.split(",");
        }
        ArrayList numbers = new ArrayList(strMas.length);
        for (int i = 0; i < strMas.length; i++) {
            numbers.add(Integer.parseInt(strMas[i]));
        }
        Set<String> inputedIntegers = new HashSet<>(numbers);
        String uniqueIntegers = inputedIntegers.toString();
        System.out.println("Your unique list : " + uniqueIntegers);
    }
}