package ru.ilka.helpcenter;

import java.util.List;
import java.util.Queue;

public class IssueProducer implements Runnable {

    private Queue<Issue> queue;
    private String inputIssuesFilePath;

    @Override
    public void run() {
        //раз в N минут считвает файл и заполняет очередь
        List<Issue> issues = CsvUtil.readIssuesAndClearFile(inputIssuesFilePath);

    }
}
