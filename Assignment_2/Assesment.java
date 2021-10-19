package Assignment_2;

public class Assesment implements Deadline {
    private String problemStatement;
    private int max_marks;
    private int marks;
    private String submission = null;
    private boolean isGraded = false;
    private String checkerName;

    @Override
    public void addDeadline(String problemStatement, int maxMarks){
        this.problemStatement = problemStatement;
        this.max_marks = maxMarks;
    }

    @Override
    public void viewDeadline(){
        System.out.println("Assignment : "+problemStatement +" Max Marks : "+max_marks);
    }

    @Override
    public void setMarks(int marks) {
        this.marks = marks;
    }

    @Override
    public int getMarks() {
        return marks;
    }

    @Override
    public String getSubmission() {
        return submission;
    }

    @Override
    public void setSubmission(String submission) {
        this.submission = submission;
    }

    @Override
    public String getProblemStatement() {
        return problemStatement;
    }

    @Override
    public void setStatus(boolean status) {
        this.isGraded = status;
    }

    @Override
    public boolean getStatus() {
        return isGraded;
    }

    @Override
    public String getCheckerName() {
        return checkerName;
    }

    @Override
    public void setCheckerName(String name) {
        this.checkerName = name;
    }

    @Override
    public int getMax_marks() {
        return max_marks;
    }
}
