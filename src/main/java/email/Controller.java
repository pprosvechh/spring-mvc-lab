package email;

import email.model.CardForm;
import email.model.PageForm;
import email.model.FeedbackForm;
import email.model.MedicationForm;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping("/index")
    public String indexForm(Model model) {
        model.addAttribute("emailForm", new PageForm());
        return "index";
    }

    @GetMapping("/sendForm")
    public String sendForm(Model model) {
        model.addAttribute("emailForm", new PageForm());
        return "page";
    }

    @GetMapping("/card")
    public String cardForm(Model model) {
        model.addAttribute("cardForm", new PageForm());
        return "page2";
    }

    @GetMapping("/medication")
    public String medicationForm(Model model) {
        model.addAttribute("medicationForm", new PageForm());
        return "page4";
    }

    @GetMapping("/feedback")
    public String feedbackForm(Model model) {
        model.addAttribute("feedbackForm", new PageForm());
        return "page5";
    }

    @PostMapping("/sendPageForm")
    public String sendPageForm(@ModelAttribute PageForm emailForm, Model model) {
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
    public String sendCard(@ModelAttribute CardForm cardForm, Model model) {
        if (cardForm.getName().isEmpty()) {
            model.addAttribute("error", "'Имя' не должно быть пустым");
            return "page2";
        }
        if (cardForm.getSurname().isEmpty()) {
            model.addAttribute("error", "'Фамилия' не должно быть пустым");
            return "page2";
        }
        if (cardForm.getDisease().isEmpty()) {
            model.addAttribute("error", "'Заболевание' не должно быть пустым");
            return "page2";
        }
        return "page3";
    }

    @PostMapping("/Medication")
    public String medicationForm(@ModelAttribute MedicationForm medicationForm, Model model) {
        if (medicationForm.getMedicament().isEmpty()) {
            model.addAttribute("error", "'Назначенные лекарства' не должно быть пустым");
            return "page4";
        }
        if (medicationForm.getInstruction().isEmpty()) {
            model.addAttribute("error", "'Инструкции к использованию лекарств' не должно быть пустым");
            return "page4";
        }
        return "page5";
    }


    @PostMapping("/Feedback")
    public String getFeedbackForm(@ModelAttribute FeedbackForm feedbackForm, Model model) {
        if (feedbackForm.getPhone().isEmpty()) {
            model.addAttribute("error", "'Круглосуточный телефон' не должно быть пустым");
            return "page5";
        }
        if (feedbackForm.getAddress().isEmpty()) {
            model.addAttribute("error", "'Адреса филиалов' не должно быть пустым");
            return "page5";
        }
        return "resultpage";
    }

}
