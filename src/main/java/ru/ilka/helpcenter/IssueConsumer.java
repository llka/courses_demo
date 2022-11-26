package ru.ilka.helpcenter;

import java.util.Queue;

public class IssueConsumer implements Runnable {

    private Queue<Issue> queue;
    private String outputFilePath;

    @Override
    public void run() {
        if (!queue.isEmpty()) {
            // обработать жалобу
            var res = resolveIssue(queue.poll());

            CsvUtil.saveResolvedIssue(outputFilePath, res);
        }
    }

    private ResolvedIssue resolveIssue(Issue issue) {
        return null;
    }
}
