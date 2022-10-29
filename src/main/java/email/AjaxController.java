package email;

import email.model.Page;
import email.service.PageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/ajax")
public class AjaxController {
    private final PageService pageService;

    public AjaxController(PageService pageService) {
        this.pageService = pageService;
    }

    @ResponseBody
    @GetMapping("/getPage/{id}")
    public Page getPage(@PathVariable("id") Integer id) {
        return pageService.getPageById(id);
    }

    @ResponseBody
    @GetMapping("/list")
    public List<Page> getList() {
        return pageService.getAllPages();
    }

    @ResponseBody
    @PostMapping("/savePage")
    public Page savePage(@RequestBody Page page) {
        if (page.getSubject().isEmpty()) {
            throw new RuntimeException("Поле 'Кому' не должно быть пустым");
        }
        Page previousPage = pageService.getPageById(page.getId());
        previousPage.setMessage(page.getMessage());
        previousPage.setSubject(page.getSubject());
        previousPage.setTo(page.getTo());
        return pageService.save(previousPage);
    }
}

