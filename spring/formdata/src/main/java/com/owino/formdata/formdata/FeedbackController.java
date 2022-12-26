package com.owino.formdata.formdata;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FeedbackController {

    @GetMapping("/")
    public String loadApp(Model model){
        Feedback feedback  = new Feedback();
        model.addAttribute("feedback", feedback);
        return "feedback";
    }

    @GetMapping(value = "/feedback")
    public String getFeedbackForm(Model model){
        Feedback feedback  = new Feedback();
        model.addAttribute("feedback", feedback);
        return "feedback";
    }

    @PostMapping(value = "/feedback", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public String handleSubmitFeedback(Feedback feedback) throws Exception {
        return "redirect:/feedback/success";
    }

    @GetMapping(value = "feedback/success")
    public String handleSuccess(){
        return "success";
    }
}
