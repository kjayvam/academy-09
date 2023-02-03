package com.javasw.project.map.service;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.springframework.ui.Model;

public interface IMapService {

	public void execute(Model model) throws IOException, ParseException;
}
