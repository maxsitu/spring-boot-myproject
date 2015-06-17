package com.jpm.spt.situ.sandbox.boot.web;

import com.jpm.spt.situ.sandbox.boot.dbo.City;
import com.jpm.spt.situ.sandbox.boot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * Created by v545192 on 6/12/2015.
 */
@Controller
public class AppController {

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/city",
            method= RequestMethod.GET,
            produces={MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    @Transactional(readOnly = true)
    public @ResponseBody City city(){
        return this.cityService.getCity("Bath", "UK");
    }

    @RequestMapping(value = "/cities",
            method= RequestMethod.GET,
            produces={MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    @Transactional(readOnly = true)
    public @ResponseBody
    List<City> cities( @RequestParam("page") int page, @RequestParam("size") int size, @RequestParam String country){
        return this.cityService.getCities(country, new PageRequest(page, size));
    }
}
