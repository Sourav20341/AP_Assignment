package Assignment_2;

import java.text.SimpleDateFormat;
import java.util.*;

public class IIITD_BACKPACK {

    public static void main(String[] args) {

        Date date = new Date();
        SimpleDateFormat sd = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
        sd.setTimeZone(TimeZone.getTimeZone("IST"));

        ArrayList<Instructor>instructors = new ArrayList<>();
        ArrayList<Student>students = new ArrayList<>();
        ArrayList<Lecture_Slide>lecture_slides = new ArrayList<>();
        ArrayList<Lecture_Video>lecture_videos = new ArrayList<>();
        ArrayList<Comment>comments = new ArrayList<>();
        ArrayList<Assesment>assesments = new ArrayList<>();
        ArrayList<Quiz>quizzes = new ArrayList<>();

        instructors.add(new Instructor("I0"));
        instructors.add(new Instructor("I1"));

        students.add(new Student("S0"));
        students.add(new Student("S1"));
        students.add(new Student("S2"));


        Scanner sc = new Scanner(System.in);
        System.out.println("====================================================");
        System.out.println("             WELCOME TO IIITD BACKPACK              ");
        System.out.println("====================================================");
        while(true){
            System.out.println("----------------------");
            System.out.println("1. Enter as instructor");
            System.out.println("2. Enter as Student");
            System.out.println("3. Exit");
            System.out.println("----------------------");

            int n;
            System.out.print("Enter the input : ");
            n = sc.nextInt();

            if(n == 1){
                int instIndx;

                System.out.println("INSTRUCTORS :");
                System.out.println("---------------------------");
                for(int i = 0;i<instructors.size();i++){
                    System.out.println(i + " " + instructors.get(i).getName());
                }
                System.out.println("---------------------------");
                System.out.print("Choose Id : ");
                instIndx = sc.nextInt();
                if(instIndx >= 0 && instIndx < instructors.size()){
                    while (true){
                        System.out.println("---------------------------");
                        System.out.println("        WELCOME " + instructors.get(instIndx).getName()+ "      ");
                        System.out.println("---------------------------");
                        int idx;
                        System.out.println("===========================");
                        System.out.println("      INSTRUCTOR MENU      ");
                        System.out.println("===========================");
                        System.out.println("1. Add lecture materials");
                        System.out.println("2. Add assessments");
                        System.out.println("3. View lecture materials");
                        System.out.println("4. View assessments");
                        System.out.println("5. Grade assessments");
                        System.out.println("6. Close assessment");
                        System.out.println("7. View comments");
                        System.out.println("8. Add comments");
                        System.out.println("9. Logout");
                        System.out.println("===========================");
                        System.out.print("Choose your operation : ");
                        idx = sc.nextInt();

                        if(idx == 1){
                            int index;
                            System.out.println("--------------------");
                            System.out.println("1. Add Lecture Slide");
                            System.out.println("2. Add Lecture Video");
                            System.out.println("--------------------");
                            System.out.print("Choose your option : ");
                            index = sc.nextInt();

                            if(index == 1){
                                Lecture_Slide lecture_slide = new Lecture_Slide();
                                String slide;
                                int numOfSlide;
                                sc.nextLine();
                                System.out.print("Enter topic of slides : ");
                                slide = sc.nextLine();
                                System.out.print("Enter the number of slides : ");
                                numOfSlide = sc.nextInt();
                                lecture_slide.setNumber_of_slides(numOfSlide);
                                System.out.println("Enter content of slides : ");
                                sc.nextLine();
                                for (int i = 0;i<numOfSlide;i++) {
                                    String content;
                                    System.out.print("Content of slide " + (i + 1) + ": ");
                                    content = sc.nextLine();
                                    lecture_slide.addContent(content);
                                }
                                lecture_slide.add_Material(slide,date.toString(),instructors.get(instIndx).getName());
                                lecture_slides.add(lecture_slide);
                            }

                            else if(index == 2){
                                Lecture_Video lecture_video = new Lecture_Video();
                                String topic;
                                String filename;
                                sc.nextLine();
                                System.out.print("Enter topic of video : ");
                                topic = sc.nextLine();
                                System.out.print("Enter filename of video : ");
                                filename = sc.nextLine();
                                if(filename.length() >= 5 && filename.endsWith(".mp4")){
                                    lecture_video.add_Material(topic,date.toString(),instructors.get(instIndx).getName());
                                    lecture_video.setVideoFile(filename);
                                    lecture_videos.add(lecture_video);
                                }
                                else{
                                    System.out.println("Upload failed!You try to upload a file with wrong extension!");
                                }
                            }

                            else{
                                System.out.println("---------------------------");
                                System.out.println("Please enter a valid Id!");
                                System.out.println("---------------------------");
                            }
                        }

                        else if(idx == 2){
                            int index;
                            System.out.println("--------------------");
                            System.out.println("1. Add Assignment");
                            System.out.println("2. Add Quiz");
                            System.out.println("--------------------");
                            System.out.print("Choose your option : ");
                            index = sc.nextInt();
                            if(index == 1){
                                Assesment assesment = new Assesment();
                                String problem;
                                int maxMarks;
                                sc.nextLine();
                                System.out.print("Enter problem statement : ");
                                problem = sc.nextLine();
                                System.out.print("Enter max marks : ");
                                maxMarks = sc.nextInt();
                                assesment.addDeadline(problem,maxMarks);
                                assesments.add(assesment);
                            }

                            else if(index == 2){
                                Quiz quiz = new Quiz();
                                String question;
                                sc.nextLine();
                                System.out.print("Enter quiz question : ");
                                question = sc.nextLine();
                                quiz.addDeadline(question,1);
                                quizzes.add(quiz);
                            }

                            else{
                                System.out.println("---------------------------");
                                System.out.println("Please enter a valid operation!");
                                System.out.println("---------------------------");
                            }
                        }

                        else if(idx == 3){
                            for(Lecture_Slide slides : lecture_slides){
                                slides.view_Material();
                                System.out.println();
                            }
                            for (Lecture_Video video : lecture_videos){
                                video.view_Material();
                                System.out.println();
                            }
                        }

                        else if(idx == 4){
                            int i = 0;
                            for (Assesment assesment:assesments){
                                System.out.print("ID "+i + " ");
                                assesment.viewDeadline();
                                System.out.println("---------");
                                i++;
                            }
                            for(Quiz quiz : quizzes){
                                System.out.print("ID " + i + " ");
                                quiz.viewDeadline();
                                System.out.println("----------");
                                i++;
                            }
                            if(i == 0){
                                System.out.println("No assessment is given!");
                            }
                        }

                        else if(idx == 5){
                            int id;
                            ArrayList<Student>newStudents = new ArrayList<>();
                            System.out.println("List of Assessment : ");
                            int i = 0;
                            for (Assesment assesment:assesments){
                                System.out.print("ID "+i + " ");
                                assesment.viewDeadline();
                                System.out.println("---------");
                                i++;
                            }
                            int j = i;
                            for(Quiz quiz : quizzes){
                                System.out.print("ID " + i + " ");
                                quiz.viewDeadline();
                                System.out.println("----------");
                                i++;
                            }
                            if(i == 0){
                                System.out.println("No assessment is given!");
                            }
                            else{
                                System.out.print("Enter ID of assessment to view submission : ");
                                id = sc.nextInt();
                                if(id >= 0 && id<j){
                                    for(Student student : students){
                                        for(Assesment assesment : student.getAssesments()){
                                            if(assesment.getProblemStatement().equals(assesments.get(id).getProblemStatement()) && (assesment.getSubmission()!= null) && (!assesment.getStatus())){
                                                newStudents.add(student);
                                                break;
                                            }
                                        }
                                    }
                                    System.out.println("Choose ID from these ungraded submissions : ");
                                    int c = 0;
                                    for(Student student:newStudents){
                                        System.out.println(c + " " + student.getName());
                                        c++;
                                    }
                                    if(newStudents.size() > 0) {
                                        int chooseID;
                                        chooseID = sc.nextInt();
                                        if (chooseID >= 0 && chooseID < c) {
                                            System.out.print("Submission : ");
                                            for (Assesment assem : newStudents.get(chooseID).getAssesments()) {
                                                if (assem.getProblemStatement().equals(assesments.get(id).getProblemStatement())) {
                                                    System.out.println(assem.getSubmission());
                                                    System.out.println("Max Marks : " + assem.getMax_marks());
                                                    int marks;
                                                    System.out.print("Marks scored : ");
                                                    marks = sc.nextInt();
                                                    if(marks >= assem.getMax_marks()){
                                                        System.out.println("You can't gave marks more than maximum marks");
                                                        continue;
                                                    }
                                                    assem.setMarks(marks);
                                                    assem.setStatus(true);
                                                    assem.setCheckerName(instructors.get(instIndx).getName());
                                                }
                                            }
                                            for(Student student : students){
                                                for(Student student1 : newStudents){
                                                    if(student.getName().equals(student1.getName())){
                                                        student.setAssesments(student1.getAssesments());
                                                    }
                                                }
                                            }
                                        }
                                        else {
                                            System.out.println("---------------------------");
                                            System.out.println("Please enter a valid ID!");
                                            System.out.println("---------------------------");
                                        }
                                    }
                                    else{
                                        System.out.println("No submission found!");
                                    }
                                }
                                else if(id >= j && id<i){
                                    for(Student student : students){
                                        for(Quiz quiz : student.getQuizzes()){
                                            if(quiz.getProblemStatement().equals(quizzes.get(id-j).getProblemStatement()) && (quiz.getSubmission()!= null) && (!quiz.getStatus())){
                                                newStudents.add(student);
                                                break;
                                            }
                                        }
                                    }
                                    System.out.println("Choose ID from these ungraded submissions : ");
                                    int c = 0;
                                    for(Student student:newStudents){
                                        System.out.println(c + " " + student.getName());
                                        c++;
                                    }
                                    if(newStudents.size() > 0){
                                        int chooseID;
                                        chooseID = sc.nextInt();
                                        if(chooseID>= 0 && chooseID < c) {
                                            System.out.print("Submission : ");
                                            for (Quiz quiz: newStudents.get(chooseID).getQuizzes())
                                            {
                                                if(quiz.getProblemStatement().equals(quizzes.get(id-j).getProblemStatement())){
                                                    System.out.println(quiz.getSubmission());
                                                    System.out.println("Max Marks : " + quiz.getMax_marks());
                                                    int marks;
                                                    System.out.print("Marks scored : ");
                                                    marks = sc.nextInt();
                                                    if(marks >= quiz.getMax_marks()){
                                                        System.out.println("You can't gave marks more than maximum marks");
                                                        continue;
                                                    }
                                                    quiz.setMarks(marks);
                                                    quiz.setStatus(true);
                                                    quiz.setCheckerName(instructors.get(instIndx).getName());
                                                }
                                            }
                                            for(Student student : students){
                                                for(Student student1 : newStudents){
                                                    if(student.getName().equals(student1.getName())){
                                                        student.setQuizzes(student1.getQuizzes());
                                                    }
                                                }
                                            }
                                        }
                                        else{
                                            System.out.println("---------------------------");
                                            System.out.println("Please enter a valid ID!");
                                            System.out.println("---------------------------");
                                        }
                                    }
                                    else{
                                        System.out.println("No Submission found!");
                                    }
                                }
                                else{
                                    System.out.println("---------------------------");
                                    System.out.println("Please enter a valid ID!");
                                    System.out.println("---------------------------");
                                }
                            }
                        }

                        else if(idx == 6){
                            if(assesments.isEmpty() && quizzes.isEmpty()){
                                System.out.println("No assignment is open!");
                                continue;
                            }
                            System.out.println("List of Open Assignments : ");
                            int i = 0;
                            for (Assesment assesment:assesments){
                                System.out.print("ID "+i + " ");
                                assesment.viewDeadline();
                                System.out.println("---------");
                                i++;
                            }
                            int j = i;
                            for(Quiz quiz : quizzes){
                                System.out.print("ID " + i + " ");
                                quiz.viewDeadline();
                                System.out.println("----------");
                                i++;
                            }

                            int closingidx;
                            System.out.print("Enter the id of assignment to close : ");
                            closingidx = sc.nextInt();
                            if(closingidx >= 0 && closingidx < quizzes.size()+assesments.size()){
                                if(closingidx < assesments.size()){
                                    assesments.remove(closingidx);
                                }
                                else{
                                    quizzes.remove(closingidx-j);
                                }
                            }
                            else {
                                System.out.println("---------------------------");
                                System.out.println("Please enter a valid Id!");
                                System.out.println("---------------------------");
                            }
                        }

                        else if(idx == 7){
                            if(comments.isEmpty()){
                                System.out.println("No Comment has been posted yet!");
                            }
                            for(Comment comment : comments){
                                comment.viewDiscussion();
                                System.out.println();
                            }
                        }

                        else if(idx == 8){
                            Comment newComment = new Comment();
                            String comnt;
                            sc.nextLine();
                            System.out.print("Enter comment : ");
                            comnt = sc.nextLine();
                            newComment.post(comnt,instructors.get(instIndx).getName(),date.toString());
                            comments.add(newComment);
                        }

                        else if(idx == 9){
                            System.out.println("---------------------------");
                            System.out.println("        Logging out!       ");
                            System.out.println("---------------------------");
                            break;
                        }

                        else{
                            System.out.println("---------------------------");
                            System.out.println("Please enter a valid Id!");
                            System.out.println("---------------------------");
                        }
                    }
                }
                else{
                    System.out.println("---------------------------");
                    System.out.println("Please enter a valid Id!");
                    System.out.println("---------------------------");
                }
            }

            else if(n == 2) {
                int stdIndx;

                System.out.println("STUDENTS :");
                System.out.println("---------------------------");
                for (int i = 0; i < students.size(); i++) {
                    System.out.println(i + " " + students.get(i).getName());
                }
                System.out.println("---------------------------");
                System.out.print("Choose Id : ");
                stdIndx = sc.nextInt();
                if (stdIndx >= 0 && stdIndx < students.size()) {
                    while (true){
                        System.out.println("---------------------------");
                        System.out.println("        WELCOME " + students.get(stdIndx).getName() + "      ");
                        System.out.println("---------------------------");
                        int idx;
                        System.out.println("===========================");
                        System.out.println("        STUDENT MENU       ");
                        System.out.println("===========================");
                        System.out.println("1. View lecture materials");
                        System.out.println("2. View assessments");
                        System.out.println("3. Submit assessment");
                        System.out.println("4. View grades");
                        System.out.println("5. View comments");
                        System.out.println("6. Add comments");
                        System.out.println("7. Logout");
                        System.out.println("===========================");
                        System.out.print("Choose your operation : ");
                        idx = sc.nextInt();

                        if(idx == 1){
                            for(Lecture_Slide slides : lecture_slides){
                                slides.view_Material();
                                System.out.println();
                            }
                            for (Lecture_Video video : lecture_videos){
                                video.view_Material();
                                System.out.println();
                            }
                        }

                        else if(idx == 2){
                            int i = 0;
                            for (Assesment assesment:assesments){
                                System.out.print("ID "+i + " ");
                                assesment.viewDeadline();
                                System.out.println("---------");
                                i++;
                            }
                            for(Quiz quiz : quizzes){
                                System.out.print("ID " + i + " ");
                                quiz.viewDeadline();
                                System.out.println("----------");
                                i++;
                            }
                        }

                        else if(idx == 3){
                            int id;
                            String text;
                            if(assesments.size() == students.get(stdIndx).getAssesments().size() && quizzes.size() == students.get(stdIndx).getQuizzes().size()){
                                System.out.println("No Pending Assessment");
                                continue;
                            }
                            System.out.println("Pending Assessment : ");
                            int i = 0;
                            for (Assesment assesment:assesments){
                                boolean isfound = false;
                                for(Assesment as : students.get(stdIndx).getAssesments()){

                                    if(as.getProblemStatement().equals(assesment.getProblemStatement())){
                                        isfound = true;
                                        break;
                                    }
                                }
                                if (isfound){
                                    continue;
                                }
                                System.out.print("ID "+i + " ");
                                assesment.viewDeadline();
                                System.out.println("---------");
                                i++;
                            }
                            int j = i;
                            for(Quiz quiz : quizzes){
                                boolean isfound = false;
                                for(Quiz qu : students.get(stdIndx).getQuizzes()){

                                    if(qu.getProblemStatement().equals(quiz.getProblemStatement())){
                                        isfound = true;
                                        break;
                                    }
                                }
                                if(isfound){
                                    continue;
                                }
                                System.out.print("ID " + i + " ");
                                quiz.viewDeadline();
                                System.out.println("----------");
                                i++;
                            }
                            System.out.print("Enter ID of assessment : ");
                            id = sc.nextInt();
                            if(id>=0 && id<j){
                                sc.nextLine();
                                System.out.print("Enter the filename : ");
                                text = sc.nextLine();
                                if(text.endsWith(".zip")){
                                    int c = 0;
                                    for (Assesment assesment:assesments){
                                        boolean isfound = false;
                                        for(Assesment as : students.get(stdIndx).getAssesments()){

                                            if(as.getProblemStatement().equals(assesment.getProblemStatement())){
                                                isfound = true;
                                                break;
                                            }
                                        }
                                        if (isfound){
                                            continue;
                                        }
                                        if(c == id){
                                            students.get(stdIndx).addAssigment(assesment);
                                            students.get(stdIndx).getAssesments().get(students.get(stdIndx).getAssesments().size()-1).setSubmission(text);
                                            break;
                                        }
                                        c++;
                                    }
                                }
                                else{
                                    System.out.println("Upload has been failed!You use a file with wrong extension");
                                }
                            }
                            else if(id >=j && id < i){
                                int c = 0;
                                int r = 0;
                                for (Quiz quiz : quizzes){
                                    r++;
                                    boolean isfound = false;
                                    for(Quiz qu : students.get(stdIndx).getQuizzes()){

                                        if(qu.getProblemStatement().equals(quiz.getProblemStatement())){
                                            isfound = true;
                                            break;
                                        }
                                    }
                                    if(isfound){
                                        continue;
                                    }
                                    if(c == id){
                                        students.get(stdIndx).addQuiz(quiz);
                                        break;
                                    }
                                    c++;
                                }
                                sc.nextLine();
                                System.out.print(quizzes.get(r-1).getProblemStatement() + " : ");
                                text = sc.nextLine();
                                students.get(stdIndx).getQuizzes().get(students.get(stdIndx).getQuizzes().size()-1).setSubmission(text);
                            }
                            else{
                                System.out.println("---------------------------");
                                System.out.println("Please enter a valid Id!");
                                System.out.println("---------------------------");
                            }
                        }

                        else if(idx == 4){
                            System.out.println("=====================");
                            System.out.println("Graded Submission : ");
                            System.out.println("=====================");

                            for (Assesment assmt: students.get(stdIndx).getAssesments())
                            {
                                if(assmt.getStatus()){
                                    System.out.println("Submission : "+assmt.getSubmission());
                                    System.out.println("Marks scored : "+assmt.getMarks());
                                    System.out.println("Graded by - "+assmt.getCheckerName());
                                    System.out.println("-------------------------");
                                }
                            }
                            for (Quiz quiz: students.get(stdIndx).getQuizzes())
                            {
                                if(quiz.getStatus()){
                                    System.out.println("Submission : "+quiz.getSubmission());
                                    System.out.println("Marks scored : "+quiz.getMarks());
                                    System.out.println("Graded by - "+quiz.getCheckerName());
                                    System.out.println("-------------------------");
                                }
                            }
                            System.out.println("=====================");
                            System.out.println("Ungraded Submission : ");
                            System.out.println("=====================");
                            for (Assesment assmt: students.get(stdIndx).getAssesments())
                            {
                                if(!assmt.getStatus()){
                                    System.out.println("Submission : "+assmt.getSubmission());
                                    System.out.println("-------------------------");
                                }
                            }
                            for (Quiz quiz: students.get(stdIndx).getQuizzes())
                            {
                                if(!quiz.getStatus()){
                                    System.out.println("Submission : "+quiz.getSubmission());
                                    System.out.println("-------------------------");
                                }
                            }

                        }

                        else if(idx == 5){
                            if(comments.isEmpty()){
                                System.out.println("No Comment has been posted yet!");
                            }
                            for(Comment comment : comments){
                                comment.viewDiscussion();
                                System.out.println();
                            }
                        }

                        else if(idx == 6){
                            Comment newComment = new Comment();
                            String comnt;
                            sc.nextLine();
                            System.out.print("Enter comment : ");
                            comnt = sc.nextLine();
                            newComment.post(comnt,students.get(stdIndx).getName(),date.toString());
                            comments.add(newComment);
                        }

                        else if(idx == 7){
                            System.out.println("---------------------------");
                            System.out.println("        Logging out!       ");
                            System.out.println("---------------------------");
                            break;
                        }

                        else{
                            System.out.println("---------------------------");
                            System.out.println("Please enter a valid Id!");
                            System.out.println("---------------------------");
                        }
                    }
                }
                else{
                    System.out.println("---------------------------");
                    System.out.println("Please enter a valid Id!");
                    System.out.println("---------------------------");
                }
            }

            else if(n == 3){
                System.out.println("====================================================");
                System.out.println("          THANKS FOR USING IIITD BACKPACK           ");
                System.out.println("====================================================");
                break;
            }

            else{
                System.out.println("---------------------------");
                System.out.println("Please enter a valid input!");
                System.out.println("---------------------------");
            }
        }
    }
}
