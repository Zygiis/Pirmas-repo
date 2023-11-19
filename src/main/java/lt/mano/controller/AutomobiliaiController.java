package lt.mano.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.automobiliai.Automobilis;
import com.example.automobiliai.AutomobilisService;

@Controller
@RequestMapping("/automobiliai")
public class AutomobiliaiController {

    @Autowired
    private AutomobilisService automobilisService;

    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("/vidutinis-variklio-turis")
    public String vidutinisVariklioTuriSkaiciavimas(@RequestParam(required = false) String marke, @RequestParam(required = false) String modelis, Model model) {
        ArrayList<Automobilis> automobiliai = automobilisService.findAll();
        double vidutinisTuris = 0;
        if (marke != null && modelis != null) {
            Automobilis automobilis = automobilisService.findByMarkeAndModelis(marke, modelis);
            if (automobilis != null) {
                vidutinisTuris = automobilis.getVariklioTuris();
            }
        } else {
            vidutinisTuris = Automobilis.vidutinioVariklioTurioSkaiciavimas(automobiliai);
        }
        model.addAttribute("vidutinisTuris", vidutinisTuris);
        return "vidutinis-variklio-turis";
    }

    @GetMapping("/ieskoti-pagal-marke-modeli")
    public String ieskotiPagalMarkeModeli(@RequestParam(required = true) String marke, @RequestParam(required = true) String modelis) {
        Automobilis automobilis = automobilisService.findByMarkeAndModelis(marke, modelis);
        if (automobilis != null) {
            return "ieskoti-pagal-marke-modeli?automobilis=" + automobilis;
        } else {
            return "ieskoti-pagal-marke-modeli?automobilis=nerastas";
        }
    }

    @GetMapping("/ieskoti-pagal-marke-modeli-greiti")
    public String ieskotiPagalMarkeModeliGreiti(@RequestParam(required = true) String marke, @RequestParam(required = true) String modelis, @RequestParam(required = true) int maksimalusGreitis) {
        Automobilis automobilis = automobilisService.findByMarkeModeliAndMaksimalusGreitis(marke, modelis, maksimalusGreitis);
        if (automobilis != null) {
            return "ieskoti-pagal-marke-modeli-greiti?automobilis=" + automobilis;
        } else {
            return "ieskoti-pagal-marke-modeli-greiti?automobilis=nerastas";
        }
    }
}