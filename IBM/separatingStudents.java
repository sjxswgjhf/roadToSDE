package IBM;

public class separatingStudents {

    public int separatingStudents(int[] students){
        if(students == null || students.length == 0){
            return 0;
        }
        int zeros = 0;
        int numZero = 0;
        for(int student : students){
            if(student == 1){
                zeros += numZero;
            }else{
                numZero++;
            }
        }
        int ones = 0;
        int numOne = 0;
        for(int student : students){
            if(student == 0){
                ones += numOne;
            }else{
                numOne++;
            }
        }
        return Math.min(ones, zeros);
    }
}
