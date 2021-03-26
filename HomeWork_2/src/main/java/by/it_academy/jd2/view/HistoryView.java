package by.it_academy.jd2.view;

import by.it_academy.jd2.core.dto.PersonUser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HistoryView {

    private final Map<String, List<String>> history = new HashMap<>();

    public void addMessage(String userName, String message) {
        if (this.history.get(userName) == null) {
            List<String> listMessages = new ArrayList<>();
            listMessages.add(message);
            this.history.put(userName, listMessages);
        } else
            this.history.get(userName).add(message);

    }

    public List <String> getUserHistory(String userName) {
        return this.history.get(userName);
    }
}
