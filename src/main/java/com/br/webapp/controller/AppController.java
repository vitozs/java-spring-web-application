package com.br.webapp.controller;

import com.br.webapp.model.CepModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@Controller
public class AppController {

    @GetMapping("/cep")
    public String index(@RequestParam(name = "cep") String cep, Model model) throws IOException {

        URL url;
        url = new URL("https://viacep.com.br/ws/"+cep+"/json/");

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        InputStream res = conn.getInputStream();
        ObjectMapper mapper = new ObjectMapper();

        CepModel cepObj = mapper.readValue(res, CepModel.class);

        model.addAttribute("cep", cepObj);

        return "cepResult";
    }

}
