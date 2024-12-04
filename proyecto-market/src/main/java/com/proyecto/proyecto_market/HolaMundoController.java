package com.proyecto.proyecto_market;


import org.apache.tomcat.util.net.jsse.JSSEUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/saludar")

public class HolaMundoController {
    @GetMapping("/hola")
    public String saludar(){
        return "Nunca pares de aprender hola";
    }

}
