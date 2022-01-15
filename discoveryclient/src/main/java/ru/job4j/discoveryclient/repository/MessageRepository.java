package ru.job4j.discoveryclient.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.discoveryclient.model.Message;

import java.util.List;

@Repository
public interface MessageRepository {
    Message save(Message message);
    List<Message> findAll();
}
