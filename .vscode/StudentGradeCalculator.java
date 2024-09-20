import java.util.Scanner;
public class StudentGradeCalculator {
    //function to calculate grade of the student.
    public static String gradeCalculator(float a){
        if(a>=90){
            return "A" ;
        }else if(a>=75){
            return "B" ;
        }else if(a>=60){
            return "C" ;
        }else if(a>=45){
            return "D";
        }else if(a>=33){
            return "E";
        }else
            return "F";
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int sum = 0 ;
        System.out.print("Enter no of subjects you have:");

        //no of subjects..
        int subjects = sc.nextInt() ;
        sc.nextLine();    

        //create an array to store the name of subjects.
        String[] name = new String[subjects];
        System.out.println("Enter the name of the subjects");
        for(int i = 0 ; i<subjects ;i++){
            name[i] = sc.nextLine();
        }
        //taking marks obtained ..
        System.out.println("Please enter the marks obtained in each subjects (out of 100) .");
        for(int i = 0 ; i<subjects ; i++){
            System.out.print("Marks obtained in "+ name[i] + " is = ");
            int a = sc.nextInt();
            //total marks..
            sum = sum + a ;
        }
        //average percentage.
        float average = (float)sum / subjects;
        //calling the gradeCalculator function.

        String grade = gradeCalculator(average);

        //create output total marks , average percentage , grade.
        System.out.println("Toatal marks = " + sum);
        System.out.println("Average percentage = " + String.format("%.2f" , average));
        //System.out.printf("Average percentage =%.2f " , average);
        System.out.println("Grade = " + grade);
    }
}
