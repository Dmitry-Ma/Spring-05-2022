package ru.otus.spring.dao;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import ru.otus.spring.domain.Answer;
import ru.otus.spring.domain.Question;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;


public class QuestionDaoCsv implements QuestionDao {

    private String fileName = "questions.csv";

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Question[] read() throws FileNotFoundException {
        URL resource = getClass().getClassLoader().getResource(fileName);

        if (resource == null) {
            throw new FileNotFoundException("file " + fileName + " not found in resources!");
            //System.out.println("file " + fileName + " not found in resources!");
        } else {

            //parse csv file
            try (CSVReader reader = new CSVReader(new FileReader(new File(resource.toURI())))) {
                List<String[]> r = reader.readAll();
                Question[] q = new Question[r.size()];
                String[] line;
                for(int i = 0; i < r.size(); i++) {
                    line = r.get(i);
                    Answer[] answers = new Answer[line.length-1];
                    for (int k = 1; k < line.length; k++) {
                        answers[k-1] = new Answer(line[k],false);
                    }
                    q[i] = new Question(line[0], answers);
                }
                return q;

            } catch ( URISyntaxException | IOException | CsvException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
