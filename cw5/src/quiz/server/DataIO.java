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

    /**
     * checks to see if a file exists and creates one if it doesn't
     * @throws IOException
     */
    public DataIO() throws IOException {
        if (!QuizFile.isFile())
            QuizFile.createNewFile();
    }

    /**
     * starts the file writer
     * @param ql a list of quizzes
     */
    public DataIO(ArrayList<quizImpl> ql) {
        writeToFile(ql);
    }

    /**
     * reads data from the Quizzes file
     * @return a list of quizzes
     */
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
                    if (stringArray.length > 3) {
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

    /**
     * saves any changes to the quiz when server is shutdown
     * @param ql a list of quizzes
     */
    public void writeToFile(ArrayList<quizImpl> ql) {
        Path path = Paths.get("Quizzes.txt");
        try (Scanner scanner = new Scanner(path, String.valueOf(ENCODING))) {
            try (BufferedWriter writer = Files.newBufferedWriter(path, ENCODING)) {
                String toBeWritten;
                for (quizImpl q : ql) {
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
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
