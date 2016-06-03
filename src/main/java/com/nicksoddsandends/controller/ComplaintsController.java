package com.nicksoddsandends.controller;

import com.nicksoddsandends.entity.Complaint;
import com.nicksoddsandends.entity.Employee;
import com.nicksoddsandends.service.ComplaintService;
import com.nicksoddsandends.service.EmployeeService;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
* @author 
* @version 1.0
*/
@Controller
public class ComplaintsController {

	private static final Logger logger = Logger.getLogger(EmployeeController.class);

	public ComplaintsController() {
		System.out.println("ComplaintController()");
	}

	@Autowired
	private ComplaintService complaintService;

	@RequestMapping("createComplaint")
	public ModelAndView createComplaint(@ModelAttribute Complaint complaint) {
		logger.info("Creating Complaint. Data: "+complaint);
		return new ModelAndView("complaintForm");
	}
	
	@RequestMapping("editComplaint")
	public ModelAndView editComplaint(@RequestParam long id, @ModelAttribute Complaint complaint) {
		logger.info("Updating the Complaint for the Id "+id);
		complaint = complaintService.getComplaint(id);
		return new ModelAndView("complaintForm", "complaintObject", complaint);
	}
	
	@RequestMapping("saveComplaint")
	public ModelAndView saveComplaint(@ModelAttribute Complaint complaint) {
		logger.info("Saving the Complaint. Data : "+complaint);
		complaintService.createComplaint(complaint);
		return new ModelAndView("redirect:findAllComplaints");
	}
	@RequestMapping(value = {"complaints"})
	public ModelAndView findAllComplaints() {
		logger.info("Getting all Complaints.");
		List<Complaint> complaintList = complaintService.findAllComplaints();
		return new ModelAndView("complaintList", "complaintList", complaintList);
	}


}