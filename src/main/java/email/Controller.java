package email;

import email.model.*;
import email.service.PageService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@org.springframework.stereotype.Controller
public class Controller {

    private final PageService pageService;

    public Controller(PageService pageService) {
        this.pageService = pageService;
    }

    @GetMapping("/")
    public String pageForm(Model model) {
        model.addAttribute("pageForm", new PageForm());
        return "page";
    }

    @PostMapping("/sendPageForm")
    public String sendPageForm(@ModelAttribute PageForm pageForm, Model model) {
        if (pageForm.getTo().isEmpty()) {
            model.addAttribute("error", "'Кому' не должно быть пустым");
            return "page";
        }
        if (pageForm.getMessage().isEmpty()) {
            model.addAttribute("error", "'Сообщение' не должно быть пустым");
            return "page";
        }
        pageService.save(new Page(pageForm.getTo(), pageForm.getSubject(), pageForm.getMessage()));
        model.addAttribute("emails", pageService.getAllPages());
        return "list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("emails", pageService.getAllPages());
        return "list";
    }

}
