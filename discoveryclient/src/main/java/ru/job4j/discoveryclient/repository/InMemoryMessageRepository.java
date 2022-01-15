package ru.job4j.discoveryclient.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.discoveryclient.model.Message;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryMessageRepository implements MessageRepository {

    private final List<Message> messages = new ArrayList<>();
    private int id = 1;

    @Override
    public Message save(Message message) {
        message.setId(id++);
        messages.add(message);
        return message;
    }

    @Override
    public List<Message> findAll() {
        return messages;
    }
}
