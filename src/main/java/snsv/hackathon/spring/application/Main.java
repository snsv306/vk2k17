package snsv.hackathon.spring.application;

import snsv.hackathon.spring.entity.UIResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class Main {

  public static void main(String[] args) throws Exception {
    SpringApplication.run(Main.class, args);
  }

  @RequestMapping(value = "/get", method = RequestMethod.GET)
  @ResponseBody
  public UIResponse myServlet(@RequestParam("link") String link, @RequestParam("text") String text) {
    return new UIResponse(link, text);
  }
}
