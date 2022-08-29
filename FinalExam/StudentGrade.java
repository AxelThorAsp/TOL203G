import java.util.Arrays;
import java.lang.Math;

public class StudentGrade implements Comparable<StudentGrade> {
    public String name;
    public String course;
    public int grade;

    public StudentGrade(String name, String course, int grade){
        this.name = name;
        this.course = course;
        this.grade = grade;
    }   

    public String toString(){
        return name + " " + course;
    }

    public int compareTo(StudentGrade that){
        if(this.name.compareTo(that.name) != 0){
            return this.name.compareTo(that.name);
        }
        else if(this.grade - that.grade != 0){
            return (int) Math.signum(that.grade - this.grade);
        }
        else if(this.course.compareTo(that.course) != 0 ){
            return this.course.compareTo(that.course);
        }
        else{
            return 0;
        }
    }

    public static void main(String[] args) {
        

    }
}