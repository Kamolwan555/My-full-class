package th.co.cdgs;

public class Grade
{
    public static void main(String[] args) {}
 
    public String grade(int score) {
        if (score >= 0 && score <= 49) {
            return "F";
        } else if (score >= 50 && score <= 59) {
            return "D";
        } else if (score >= 60 && score <= 69) {
            return "C";
        } else if (score >= 70 && score <= 79) {
            return "B";
        } else if (score >= 80 && score <= 100) {
            return "A";
        } else {
            return null;
        }
       }
 
}