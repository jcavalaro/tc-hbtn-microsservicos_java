package com.song.MegaSenaAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping(value="/megasena")
public class MegaSenaController {

    @GetMapping("/simpleMessageWelcome")
    public String mensagemBoasVindas() {

        return "Boas-Vindas!";
    }


    @GetMapping("/getNumbers")
    public List<Integer> numerosMegaSena() {
        Set<Integer> setRandon = new LinkedHashSet<>();
        while (setRandon.size() < 6){
            setRandon.add((int)(Math.random()*(1 - 99)+99));
        }
        List<Integer> resultadoFinal = new ArrayList<>(setRandon);

        Collections.sort(resultadoFinal);

        return resultadoFinal;

    }

}
