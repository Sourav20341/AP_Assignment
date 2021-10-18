package Assignment_2;

public interface Deadline {

    void addDeadline(String problemStatement,int maxMarks);

    void viewDeadline();

    void setMarks(int marks);

    void setSubmission(String text);

    String getProblemStatement();

    int getMarks();

    String getSubmission();

    void setStatus(boolean status);

    boolean getStatus();

    String getCheckerName();

    void setCheckerName(String name);
}
