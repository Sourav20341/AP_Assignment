package Assignment_2;

public class Lecture_Video implements Materials{

    private String title;
    private String videoFile;
    private String uploaderName;
    private String dateOfUpload;

    @Override
    public void add_Material(String topic,String uploadDate,String uploaderName) {
        this.title = topic;
        this.dateOfUpload = uploadDate;
        this.uploaderName = uploaderName;
    }

    @Override
    public void view_Material() {
        System.out.println("Title of Video : "+title);
        System.out.println("Video file : "+videoFile);
        System.out.println("Date of upload : "+dateOfUpload);
        System.out.println("Uploaded by : "+uploaderName);
    }

    public void setVideoFile(String videoFile) {
        this.videoFile = videoFile;
    }
}
