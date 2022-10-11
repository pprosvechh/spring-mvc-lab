package email;

import email.model.EmailForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmailController {

    @GetMapping("/index")
    public String indexForm(Model model) {
        model.addAttribute("emailForm", new EmailForm());
        return "index";
    }

    @GetMapping("/sendForm")
    public String sendForm(Model model) {
        model.addAttribute("emailForm", new EmailForm());
        return "page";
    }

    @GetMapping("/card")
    public String cardForm(Model model) {
        model.addAttribute("cardForm", new EmailForm());
        return "page2";
    }

    @GetMapping("/medication")
    public String medicationForm(Model model) {
        model.addAttribute("medicationForm", new EmailForm());
        return "page4";
    }

    @GetMapping("/feedback")
    public String feedbackForm(Model model) {
        model.addAttribute("feedbackForm", new EmailForm());
        return "page5";
    }

    @PostMapping("/sendPageForm")
    public String sendPageForm(@ModelAttribute EmailForm emailForm, Model model) {
        if (emailForm.getTo().isEmpty()) {
            model.addAttribute("error", "'Кому' не должно быть пустым");
            return "page";
        }
        if (emailForm.getMessage().isEmpty()) {
            model.addAttribute("error", "'Сообщение' не должно быть пустым");
            return "page";
        }
        return "page2";
    }

    @PostMapping("/sendCard")
    public String sendCard(@ModelAttribute EmailForm cardForm, Model model) {
        if (cardForm.getSubject().isEmpty()) {
            model.addAttribute("error", "'Имя' не должно быть пустым");
            return "page2";
        }
        if (cardForm.getTo().isEmpty()) {
            model.addAttribute("error", "'Фамилия' не должно быть пустым");
            return "page2";
        }
        if (cardForm.getMessage().isEmpty()) {
            model.addAttribute("error", "'Заболевание' не должно быть пустым");
            return "page2";
        }
        return "page3";
    }

    @PostMapping("/Medication")
    public String medicationForm(@ModelAttribute EmailForm medicationForm, Model model) {
        if (medicationForm.getSubject().isEmpty()) {
            model.addAttribute("error", "'Назначенные лекарства' не должно быть пустым");
            return "page4";
        }
        if (medicationForm.getTo().isEmpty()) {
            model.addAttribute("error", "'Инструкции к использованию лекарств' не должно быть пустым");
            return "page4";
        }
        return "page5";
    }


    @PostMapping("/Feedback")
    public String getFeedbackForm(@ModelAttribute EmailForm feedbackForm, Model model) {
        if (feedbackForm.getSubject().isEmpty()) {
            model.addAttribute("error", "'Круглосуточный телефон' не должно быть пустым");
            return "page5";
        }
        if (feedbackForm.getTo().isEmpty()) {
            model.addAttribute("error", "'Адреса филиалов' не должно быть пустым");
            return "page5";
        }
        return "resultpage";
    }

}
