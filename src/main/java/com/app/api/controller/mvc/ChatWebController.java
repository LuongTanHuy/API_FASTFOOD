package com.app.api.controller.mvc;


import com.app.api.service.implement.TokenServiceImpl;
import com.app.api.service.interfaces.IAccountService;
import com.app.api.service.interfaces.IChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("webServerChatController")
@RequestMapping("/FastFood/")
public class ChatWebController {

    @Autowired
    private IAccountService accountInterface;
    @Autowired
    private TokenServiceImpl tokenService;
    @Autowired
    private IChatService chatInterface;

    @GetMapping("chat")
    public String PageChat(Model model, @CookieValue("FastFood") String token) {
//        int idAccount = Integer.parseInt(this.tokenService.validateTokenAndGetAccountId(token));
//        int idStore = this.accountInterface.getAccountDetailForWeb(idAccount).getStoreModel().getId();

//        model.addAttribute("listCustomer",this.chatInterface.listCustomer(idStore));
//        model.addAttribute("account", this.accountInterface.accountProfile(idAccount,"Web"));
        model.addAttribute("title", "Trò Chuyện");
        model.addAttribute("file_html", "/components/chatBody");
        model.addAttribute("component", "chatBody");
        return "pages/index";
    }

}
