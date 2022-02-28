//package br.com.cineclube.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//public class ImcController {
//
//    @RequestMapping("/imc")
//    public String imc(@RequestParam Double peso, Double altura, Model model){
//        //System.out.println("Seu peso é: "+peso);
//
//        Double imc = peso/ (altura*altura);
//
//
//        if(imc>18.5 && imc<25) {
//            model.addAttribute("mensagem", "Seu imc: "+imc + ", está ótimo!");
//        }else {
//            model.addAttribute("mensagem", "Seu imc: "+imc+", cuidado! Reveja seus hábitos!");
//        }
//
//        return "imc.html";
//    }
//}
