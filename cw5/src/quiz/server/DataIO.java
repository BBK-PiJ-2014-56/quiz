package quiz.server;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * Created by James Thornton
 */
public class DataIO {

    private final File QuizFile = new File("Quizzes.txt");
    final static Charset ENCODING = StandardCharsets.UTF_8;
    private ArrayList<String> quizzes = new ArrayList();
    private ArrayList<quizImpl> quizArray = new ArrayList();
    private int quizNo = 1;
    private int questionNo = 1;

    public DataIO() throws IOException {
        if (!QuizFile.isFile())
            QuizFile.createNewFile();
    }

    public ArrayList<quizImpl> readFile() {

        // The name of the file to open.
        String fileName = "Quizzes.txt";

        // This will reference one line at a time
        String line;

        try {
            //reads file twice the first time adding contacts the second adding meetings
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);

            // Wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                quizzes.add(line);
            }
            bufferedReader.close();
            for (String s : quizzes) {
                if (s.startsWith("quizName")) {
                    //splits the line into an array of strings
                    String[] stringArray = s.split(",");
                    //If game already has a highScore
                    if (stringArray[stringArray.length - 3].equals("highScore")) {
                        quizImpl q = new quizImpl(stringArray[1], stringArray[stringArray.length - 2], Integer.parseInt(stringArray[stringArray.length - 1]));
                        for (int i = 2; i < stringArray.length - 3; i = i + 6) {
                            q.addQuestion(stringArray[i], stringArray[i + 1], stringArray[i + 2], stringArray[i + 3], stringArray[i + 4], Integer.parseInt(stringArray[i + 5]));
                        }
                        quizArray.add(q);
                    } else {
                        quizImpl q = new quizImpl(stringArray[1]);
                        for (int i = 2; i < stringArray.length; i = i + 6) {
                            q.addQuestion(stringArray[i], stringArray[i + 1], stringArray[i + 2], stringArray[i + 3], stringArray[i + 4], Integer.parseInt(stringArray[i + 5]));
                        }
                        quizArray.add(q);
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");
        }
        return quizArray;
    }

    public void writeToFile() {
        Path path = Paths.get("Quizzes.txt");
        try (Scanner scanner = new Scanner(path, String.valueOf(ENCODING))) {
            try (BufferedWriter writer = Files.newBufferedWriter(path, ENCODING)) {
                String toBeWritten = null;
                for (quizImpl q : quizArray) {
                    String questionsString = "";
                    //gets a list of questions for that quiz
                    List<QuestionAndAnswer> questions = q.getQuestions();
                    //for each question in the quiz get the answers
                    for (QuestionAndAnswer question : questions) {
                        List<String> answers = question.getAllAnswers();
                        String answerString = "";
                        for (String s : answers)
                            answerString = answerString + s + ",";
                        answerString = answerString + question.getCorrectAnswer();
                        questionsString = questionsString + "," + question.getQuestion() + "," + answerString;
                    }
                    if (q.getHighScore() == -1) toBeWritten = "quizName," + q.getQuizName() + questionsString;
                    else
                        toBeWritten = "quizName," + q.getQuizName() + questionsString + ",highScore," + q.playerWithHighScore() + "," + q.getHighScore();
                    writer.write(toBeWritten);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
/*
                for(Meeting m : meetingData){
                    String meetingContactsByID = "";
                    for(Contact c : m.getContacts()){
                        meetingContactsByID = meetingContactsByID + ";" + c.getId();
                    }
                    if (m instanceof FutureMeeting) {
                        writer.write("Meeting," + m.getId() + ",meetingContactIDs" + meetingContactsByID  + "," + simpleDate.format(m.getDate().getTime()) + System.getProperty("line.separator"));
                    }
                    // If meeting is a Past Meeting write with notes
                    else if (m instanceof PastMeeting) {
                        writer.write("Meeting," + m.getId() + ",meetingContactIDs" + meetingContactsByID  + "," + simpleDate.format(m.getDate().getTime()) + ", " + ((PastMeeting) m).getNotes() + System.getProperty("line.separator"));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }*/
/*
    private void meetingadder(String line) {

        //splits the Meeting line into an array
        String[] stringArray = line.split(",");
        //Sets the Id of the meeting
        int ID = Integer.parseInt(stringArray[1]);
        //splits a list of contact ID's
        String[] contactArray = stringArray[2].split(";");
        Set<Contact> meetingContacts = new HashSet<>();
        //iterates through contacts adding them as they are found to another list
        for (int i = 1; i < contactArray.length; i++) {
            int contactID = Integer.parseInt(contactArray[i]);
            meetingContacts.addAll(contacts
                    .stream()
                    .filter(inContactList -> inContactList.getId() == contactID)
                    .collect(Collectors.toList()));
        }
        //Adds date
        String[] splitDate = stringArray[3].split("-");
        int day = Integer.parseInt(splitDate[0]);
        int month = Integer.parseInt(splitDate[1]);
        int year = Integer.parseInt(splitDate[2]);
        Calendar date = new GregorianCalendar(day, month, year);
        Meeting newMeeting = new MeetingImpl(ID, date, meetingContacts);
        meetings.add(newMeeting);
    }

    private void contactadder(String line) {
        //split line into parts
        String[] stringArray = line.split(",");
        //each part of the array gets added to a new contact
        int ID = Integer.parseInt(stringArray[1]);
        String name = stringArray[2];
        String notes = stringArray[3];
        Contact newContact = new ContactImpl(ID, name, notes);
        contacts.add(newContact);
    }


}

*/
