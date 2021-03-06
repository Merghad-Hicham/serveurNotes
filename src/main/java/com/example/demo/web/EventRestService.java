package com.example.demo.web;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;


import com.example.demo.entities.Event;
import com.example.demo.metier.EventMetier;

@RestController
@CrossOrigin("*")
public class EventRestService {
    @Autowired
    private EventMetier eventMetier;
    
    
    @RequestMapping(value = "/events", method = RequestMethod.POST)
    public Event saveEvent(@RequestBody Event e) {
        return eventMetier.saveEvent(e);
    }

    @RequestMapping(value = "/events", method = RequestMethod.GET)
    public List<Event> listEvent() {
        return eventMetier.listEvent();
    }
    @RequestMapping(value = "/events/{id}", method = RequestMethod.GET)
	public Event getEvent(@PathVariable Long id) {
		return eventMetier.getEvent(id);
	}
    @RequestMapping(value = "/events/{id}", method = RequestMethod.DELETE)
	public boolean supprimEvent(@PathVariable Long id) {
		return eventMetier.supprimEvent(id);
	}
    @RequestMapping(value = "/eventsDate/{s}", method = RequestMethod.GET)
	public List<Event> chercherparDate(@PathVariable @DateTimeFormat(pattern="yyyy-MM-dd") Date s) {
		return eventMetier.chercherparDate(s);
	}
    @RequestMapping(value = "/match", method = RequestMethod.GET)
	public List<Event> getMatch() {
		return eventMetier.getMatch();
	}
    @RequestMapping(value = "/entrainemet", method = RequestMethod.GET)
	public List<Event> getEntrainement() {
		return eventMetier.getEntrainement();
	}
    @RequestMapping(value = "/activete", method = RequestMethod.GET)
	public List<Event> getActivete() {
		return eventMetier.getActivete();
	}

   
    
}
