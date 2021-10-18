package Assignment_2;

import java.util.ArrayList;

public class Student{

    private String name;

    private ArrayList<Assesment>assesments = new ArrayList<>();
    private ArrayList<Quiz>quizzes = new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addQuiz(Quiz quiz){
        quizzes.add(quiz);
    }

    public void addAssigment(Assesment assesment){
        assesments.add(assesment);
    }

    public ArrayList<Assesment> getAssesments() {
        return assesments;
    }

    public ArrayList<Quiz> getQuizzes() {
        return quizzes;
    }

    public void setAssesments(ArrayList<Assesment> assesments) {
        this.assesments = assesments;
    }

    public void setQuizzes(ArrayList<Quiz> quizzes) {
        this.quizzes = quizzes;
    }
}
