package email.service;

import email.model.Page;
import email.repository.EmailRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageService {
    private final EmailRepository emailRepository;

    public PageService(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    public List<Page> getAllPages() {
        return emailRepository.findAll();
    }

    public Page save(Page email) {
        return emailRepository.save(email);
    }

    public Page getPageById(Integer id) {
        return emailRepository.getOne(id);
    }

    public void delete(Integer setId) {
        emailRepository.deleteById(setId);
    }

}