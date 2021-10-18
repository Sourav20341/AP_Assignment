package Assignment_2;

import java.util.ArrayList;

public class Lecture_Slide implements Materials{
    private ArrayList<String>contents = new ArrayList<>();
    private String title;
    private int number_of_slides;
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
        System.out.println("Title : "+ title);
        for(int i = 0 ;i<number_of_slides;i++){
            System.out.println("Slide " + (i+1) + ": "+ contents.get(i));
        }
        System.out.println("Number of slides : " + number_of_slides);
        System.out.println("Date of upload : "+ dateOfUpload);
        System.out.println("Uploaded by : "+uploaderName);
    }

    public void addContent(String content) {
        contents.add(content);
    }

    public void setNumber_of_slides(int number_of_slides) {
        this.number_of_slides = number_of_slides;
    }
}
