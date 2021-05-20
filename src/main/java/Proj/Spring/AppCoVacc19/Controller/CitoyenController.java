package Proj.Spring.AppCoVacc19.Controller;

import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Proj.Spring.AppCoVacc19.Aspect.LogAspect;
import Proj.Spring.AppCoVacc19.Entity.Citoyen;
import Proj.Spring.AppCoVacc19.Service.CitoyenService;
import Proj.Spring.AppCoVacc19.Service.EmailSenderService;
import Proj.Spring.AppCoVacc19.Service.RendezVousService;

@RestController
public class CitoyenController {

	@Autowired
	private CitoyenService CitoyenService;
	@Autowired
    public EmailSenderService emailSender;
	@Autowired
	public RendezVousService rendezVousService;
	
	private final Logger logger = LoggerFactory.getLogger(LogAspect.class);

	@CrossOrigin

	
	// GET
	@GetMapping("/Citoyen")
	public List<Citoyen> SelectCitoyen(){
		return  CitoyenService.SelectCitoyen();
		
	}
	
	//GET by ID
	@GetMapping("/Citoyen/{idCitoyen}")
	public ResponseEntity<Citoyen> getCitoyenById(@PathVariable int idCitoyen){
		return 	CitoyenService.getCitoyenById(idCitoyen);

	}
	
	//DELETE
	@DeleteMapping("/Citoyen/{idCitoyen}")
	public ResponseEntity<Map<String,Boolean>> deleteCitoyen(@PathVariable int idCitoyen){
		return CitoyenService.deleteCitoyen(idCitoyen);
	}
	
	//UPDATE
	@PutMapping("/Citoyen/{idCitoyen}")
	public void UpdateCitoyen(@PathVariable int idCitoyen,@RequestBody Citoyen citoyen) {
		CitoyenService.UpdateCitoyen(idCitoyen,citoyen);
		System.out.println("Citoyen modifié !");

	}
	
	//ADD
	@PostMapping("/Citoyen")
	public void AddCitoyen(@RequestBody Citoyen citoyen) {
		CitoyenService.AddCitoyen(citoyen);
		System.out.println("Citoyen ajouté !");

	}
	
	//ADD_postman
	@PostMapping("/Citoyen/Add/{date}")
	public @ResponseBody String Add_Citoyen(@RequestBody Citoyen citoyen, @PathVariable String date) {
		if (rendezVousService.addRDVDate(date)== true) {
			CitoyenService.AddCitoyen(citoyen);
			return ("Citoyen ajouté");
		
		}
		else {
			return("Veuillez choisir une autre date! ");
		}
		
	}
	
	
	@ResponseBody
    @GetMapping("Citoyen/sendSimpleEmail/{mail}")
    public String sendSimpleEmail(@PathVariable String mail) {
 
		emailSender.sendSimpleEmail(mail, "CoVacc19", "Bonjour, votre rendez-vous est validé! ");
 
        return "Email Sent!";
    }
	
	@ResponseBody
    @GetMapping("Citoyen/sendEmail/{mail}")
    public String sendEmail(@PathVariable String mail) throws MessagingException {
 
		emailSender.sendEmailWithAttachment(mail, "CoVacc19", "Bonjour, votre rendez-vous est validé!", "C:\\Users\\malek\\Downloads\\AppCoVacc19\\src\\main\\java\\Proj\\Spring\\AppCoVacc19\\images\\image1.jpg");
 
        return "Email Sent!";
    }
}
