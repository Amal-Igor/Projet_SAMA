//package fr.dawan.SamaTravel.controllers;
//
//
//
//import java.util.List;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import fr.dawan.SamaTravel.entities.Gare;
//import fr.dawan.SamaTravel.service.GareService;
//
//@RestController
//@RequestMapping("/api")
//public class GareRestController {
//	
//	@Autowired
//	private GareService gareService;
//	
//	@GetMapping(value="/gares", produces="application/json")
//	public List<Gare> findAll() {
//		return gareService.findAll();
//	}
//	
//	@GetMapping(value ="/gares/{id}")
//	public ResponseEntity<?> getById(@PathVariable("id") int id){
//		Gare g = gareService.findById(id);
//		if(g == null) {
//			return new ResponseEntity<String>("Produit avec id = "+id+" introuvable", HttpStatus.NOT_FOUND);
//		}else {
//			return new ResponseEntity<Gare>(g, HttpStatus.OK);
//		}
//	}
//
//	@PostMapping(value="/gares", consumes="application/json")
//	public ResponseEntity<String> insertProduit(@RequestBody Gare p){
//		gareService.save(p);
//		return new ResponseEntity<String>("Produit inséré", HttpStatus.CREATED);
//	}
//	
//	@DeleteMapping(value="/gares/{id}", consumes="application/json", produces="text/plain")
//	public ResponseEntity<String> deleteGare(@PathVariable int id) {
//		Gare g = this.gareService.findById(id);
//		if (g==null) {
//			return new ResponseEntity<String>("Produit avec id ="+id+" introuvable", HttpStatus.NOT_FOUND);
//		} else {
//			this.gareService.deleteById(id);
//			return new ResponseEntity<String>("Gare supprimé", HttpStatus.OK);
//		}
//	}
//}
