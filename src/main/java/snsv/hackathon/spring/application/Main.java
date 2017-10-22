package snsv.hackathon.spring.application;

import factchecking.FactChecking;
import org.springframework.web.bind.annotation.*;
import snsv.hackathon.spring.entity.UIResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

@Controller
@CrossOrigin
@SpringBootApplication
public class Main {

  public static void main(String[] args) throws Exception {
    SpringApplication.run(Main.class, args);
  }

  @RequestMapping(value = "/", method = RequestMethod.GET)
  @ResponseBody
  public UIResponse myServlet(@RequestParam("link") String externalLink, @RequestParam("text") String text) {
    double result = new FactChecking().api(text, externalLink);
    return new UIResponse(String.valueOf(result));
  }
}
