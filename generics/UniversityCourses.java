package generics;
import java.util.List;
import java.util.ArrayList;

abstract class CourseType{
    private String evaluationMethod;

    public CourseType(String evaluationMethod){
        this.evaluationMethod=evaluationMethod;
    }

    public String getEvaluationMethod(){
        return evaluationMethod;
    }
}
class ExamCourse extends CourseType{
    public ExamCourse(){
        super("Exam Based");
    }
}
class AssignmentCourse extends CourseType{
    public AssignmentCourse(){
        super("Assignment Based");
    }
}
class ResearchCourse extends CourseType{
    public ResearchCourse(){
        super("Research Based");
    }
}
class Course<T extends CourseType>{
    private String courseName;
    private T courseType;

    public Course(String courseName,T courseType){
        this.courseName=courseName;
        this.courseType=courseType;
    }
    public String getDetails(){
        return courseName+"-"+courseType.getEvaluationMethod();
    }
}
class University{
    public static void displayCourses(List<? extends CourseType> types){
        for (CourseType type: types){
            System.out.println(type.getEvaluationMethod());
        }
    }
}



public class UniversityCourses {
    public static void main(String[] args) {

        Course<ExamCourse> math =
                new Course<>("Mathematics", new ExamCourse());

        Course<AssignmentCourse> java =
                new Course<>("Java Programming", new AssignmentCourse());

        Course<ResearchCourse> ai =
                new Course<>("AI Research", new ResearchCourse());

        System.out.println(math.getDetails());
        System.out.println(java.getDetails());
        System.out.println(ai.getDetails());

        // Wildcard example
        List<ExamCourse> examList = new ArrayList<>();
        examList.add(new ExamCourse());

        University.displayCourses(examList);
    }
}
