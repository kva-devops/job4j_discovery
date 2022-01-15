package ru.job4j.discoveryclient.service;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.job4j.discoveryclient.model.Message;
import ru.job4j.discoveryclient.repository.MessageRepository;

import java.util.List;

@Service
public class EurekaMessageService implements MessageService {

    private final DiscoveryClient discoveryClient;

    private final RestTemplate restTemplate;

    private final MessageRepository messageRepository;

    public EurekaMessageService(DiscoveryClient discoveryClient,
                                RestTemplate restTemplate,
                                MessageRepository messageRepository) {
        this.discoveryClient = discoveryClient;
        this.restTemplate = restTemplate;
        this.messageRepository = messageRepository;
    }

    @Override
    public boolean send(String serviceId, Message message) {
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances(serviceId);
        if (serviceInstances.isEmpty()) {
            return false;
        }
        for (ServiceInstance instance : serviceInstances) {
            String url = String.format(
                    "http://%s:%d/messages/receive", instance.getHost(), instance.getPort()
            );
            restTemplate.postForObject(url, message, Message.class);
        }
        return true;
    }

    @Override
    public List<Message> getReceivedMessages() {
        return messageRepository.findAll();
    }

    @Override
    public void saveReceivedMessage(Message message) {
        messageRepository.save(message);
    }
}
