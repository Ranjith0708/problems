package DataStructures;

import java.util.Scanner;

public class Problems {
    public static void main(String[] args) {
        System.out.println("------START-------");
        String[][] arr = new String[5][5];
        for(int i=0;i< arr.length;i++){
            for (int j=0;j<arr[i].length;j++){
                arr[i][j] = "_";
            }
        }
        fallBall1(arr);

    }
    public static void fallingBalls(String[][] arr){
        boolean start = true;
        int indexStart = arr.length-1;
        while (start){
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter index : ");
            int index = sc.nextInt();
            if(index>0){
                for(int i=indexStart;i>=0 ;i--){
                    System.out.println("index "+i);
                    int mid = (arr[i].length)/2;
                    System.out.println("mid "+mid);
                    for (int j=arr[i].length-1;j>=0;j--){
                        if(arr[i][mid] == "0"){
                            if(arr[i][mid+1]!="0"){
                                if(i+1<= (arr.length-1)){
                                    if(arr[i+1][mid+1] !="0"){
                                        arr[i+1][mid+1] = "0";
                                    }else{
                                        arr[i][mid+1] = "0";
                                    }
                                }else if(i == arr.length-1){
                                    arr[i][mid+1] = "0";
                                }
                                break;
                            }else if(arr[i][mid-1]!= "0"){
                                if(i+1<(arr.length)){
                                    if(!(arr[i+1][mid-1]).equalsIgnoreCase("0")){
                                        arr[i+1][mid-1] = "0";
                                    }else{
//                                        if()
                                        arr[i+1][mid-1] = "0";
                                    }
                                }else if(i == arr.length-1){
                                    arr[i][mid-1] = "0";
                                }

                                break;
                            }else{
                                if(i-1>=0){
                                    i=i-1;
                                    indexStart = i;
                                    System.out.println("Assigned Value : "+indexStart);
                                    continue;
                                }else{
                                    System.out.println("All indexes filled");
                                    start = false;
                                }
                            }
                        }else{
                            arr[i][mid] = "0";
                            break;
                        }
                    }
                    break;
                }
                for(int k=0;k< arr.length;k++){
                    for (int l=0;l<arr[k].length;l++){
                        System.out.print(arr[k][l]+" ");
                    }
                    System.out.println();
                }
                continue;
            }else{
                start = false;
                System.out.println("------END------");
            }
        }
    }


    public static void fallBall(String[][] arr){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter input : ");
        int index = sc.nextInt();
        while (index<10){
            boolean outerLoop = false;
            for (int row = arr.length-1; row >= 0; row--) {
                for (int col = 0; col < arr[row].length; col++) {
                    int mid = (arr[row].length)/2;
                    if(arr[row][mid].equalsIgnoreCase("_")){
                        arr[row][mid] = "o";
                        outerLoop = true;
                        break;
                    }else if(arr[row][mid+1].equalsIgnoreCase("_")){
                        arr[row][mid+1] = "o";
                        outerLoop = true;
                        break;
                    }else if(arr[row][mid-1].equalsIgnoreCase("_")){
                        if(row+1< arr.length){
                            mid = mid-1;
                            if(arr[row+1][mid-1].equalsIgnoreCase("_")){
                                arr[row+1][mid-1] = "o";
                            }else{
                                mid = mid+1;
                                arr[row][mid-1] = "o";
                            }
                        }else{
                            arr[row][mid-1] = "o";
                        }
                        outerLoop = true;
                        break;
                    }else {
                        break;
                    }
                }
                if(outerLoop){
                    break;
                }
            }
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }
            System.out.print("Enter input : ");
             index = sc.nextInt();

        }

    }

    static void fallBall1(String[][] arr){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter num : ");
        int input = sc.nextInt();
        while (input<10){
            for (int row = arr.length-1; row >=0 ; row--) {
                boolean outerLoop = false;
                for (int col = 0; col < arr[row].length; col++) {
                    int pointer = arr[row].length/2;
                    if(arr[row][pointer].equalsIgnoreCase("_")){
                        if(row+1< arr.length){
                            if(arr[row+1][pointer-1].equalsIgnoreCase("o")){
                                arr[row][pointer] = "o";
                                outerLoop = true;
                                break;
                            }else if(arr[row+1][pointer-1].equalsIgnoreCase("_")){
                                arr[row+1][pointer-1] = "o";
                                outerLoop = true;
                                break;
                            }

                        }else{
                            arr[row][pointer] = "o";
                            outerLoop = true;
                            break;
                        }
                    }else{
                        pointer = pointer+1;
                        while (pointer<arr[row].length){
                            if(arr[row][pointer].equalsIgnoreCase("_")){
                                arr[row][pointer] = "o";
                                outerLoop = true;
                                break;
                            }else{
                                pointer = pointer+1;
                            }
                        }
                        if(pointer>=arr[row].length){
                            pointer = (arr[row].length/2)-1;
                            if(row+1<arr.length){
                                while(pointer>=1){
                                    if(arr[row][pointer].equalsIgnoreCase("_")){
                                        if(arr[row+1][pointer-1].equalsIgnoreCase("o")){
                                            arr[row][pointer] = "o";
                                            outerLoop = true;
                                            break;
                                        }else{
                                            arr[row+1][pointer-1] = "o";
                                            outerLoop = true;
                                            break;
                                        }
                                    }
                                    pointer = pointer-1;

                                }
                                if(row==0 && (pointer-1)<=0){
                                    arr[row][pointer] = "o";
                                    outerLoop = true;
                                    break;
                                }
                            }else if( arr[row][pointer].equalsIgnoreCase("_")){
                                arr[row][pointer] = "o";
                                outerLoop = true;
                                break;
                            }else{
                                break;
                            }
                        }
                    }
                    if(outerLoop){
                        break;
                    }
                }
                if(outerLoop){
                    break;
                }
            }

            for(int i=0;i< arr.length;i++){
                for (int j=0;j<arr[i].length;j++){
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }
            System.out.print("Enter num : ");
            input = sc.nextInt();
        }
    }
}
