package com.DvdSpringBootMvc.controller;

import com.DvdSpringBootMvc.dto.entity.Dvd;
import com.DvdSpringBootMvc.model.service.DvdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class DvdController {
    @Autowired
    private DvdService dvdService;

    @RequestMapping("/")
    public ModelAndView welcomePageController() {
        return new ModelAndView("index");
    }

    @RequestMapping("/InputDvdTitlePage")
    public ModelAndView InputDvdTitlePageController() {
        return new ModelAndView("InputDvdTitle");
    }

    @RequestMapping("searchDvdByTitle")
    public ModelAndView searchDvdByTitleController(@RequestParam("title") String title) {
        ModelAndView modelAndView = new ModelAndView();
        Dvd dvd = dvdService.getDvdByTitle(title);

        if(dvd != null) {
            modelAndView.addObject("dvd", dvd);
            modelAndView.setViewName("ShowDvd");
        } else {
            modelAndView.addObject("message", "DVD with Title " + title + " does not exist");
            modelAndView.setViewName("Output");
        }
        return modelAndView;
    }

    @RequestMapping("/InputDvdDetails")
    public ModelAndView InputDvdDetailsPageController() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("dvd", new Dvd());
        modelAndView.setViewName("InputDvdDetails");
        return modelAndView;
    }

    @RequestMapping("/showAllDvds")
    public ModelAndView showAllDvdsController() {
        ModelAndView modelAndView = new ModelAndView();

        List<Dvd> dvdList = dvdService.getAllDvds();
        modelAndView.addObject("dvdList", dvdList);
        modelAndView.setViewName("DisplayAllDvds");
        return modelAndView;
    }

    @RequestMapping("/saveDvd")
    public ModelAndView saveDvdController(@ModelAttribute("dvd") Dvd dvd) {
        ModelAndView modelAndView = new ModelAndView();

        String message = null;
        if(dvdService.addDvd(dvd))
            message = "Dvd Added";
        else
            message = "Dvd not added";

        modelAndView.addObject("message", message);
        modelAndView.setViewName("Output");
        return modelAndView;
    }

    @RequestMapping("/InputDvdTitlePageForDelete")
    public ModelAndView inputDvdTitlePageForDeleteController() {
        return new ModelAndView("InputDvdTitleForDelete");
    }

    @RequestMapping("/deleteDvd")
    public ModelAndView deleteDvdController(@RequestParam("title") String title) {
        ModelAndView modelAndView = new ModelAndView();
        String message = null;

        if(dvdService.deleteDvdByTitle(title)) {
            message = "DVD with title " + title + " deleted";
        } else {
            message = "DVD with title " + title + " not deleted";
        }
        modelAndView.addObject("message", message);
        modelAndView.setViewName("Output");

        return modelAndView;
    }

    @RequestMapping("/InputDvdDetailsPageForUpdate")
    public ModelAndView InputDvdDetailsPageForUpdateController() {
        return new ModelAndView("InputDvdDetailsForUpdate");
    }

    @RequestMapping("/updateUserRating")
    public ModelAndView updateUserRatingController(@RequestParam("title") String title, @RequestParam("newRating") double newRating) {
        String message = null;

        if(dvdService.updateUserRating(title, newRating))
            message = "User rating updated for DVD " + title;
        else
            message = "User rating not updated for DVD " + title;

        return new ModelAndView("Output", "message", message);
    }

}
