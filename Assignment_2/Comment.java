package Assignment_2;

public class Comment implements Discussion {
    private String statement;
    private String uploaderName;
    private String dateOfUpload;

    @Override
    public void post(String statement, String uploaderName, String uploadingDate) {
        this.statement = statement;
        this.uploaderName = uploaderName;
        this.dateOfUpload = uploadingDate;
    }

    @Override
    public void viewDiscussion() {
        System.out.println(statement + " - " + uploaderName);
        System.out.println(dateOfUpload);
    }
}
