package com.egzamin.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.egzamin.domain.Pizza;
import com.egzamin.repositories.KucharzRepository;
import com.egzamin.services.OrderService;
import com.egzamin.services.PizzaService;
import com.egzamin.domain.Kucharz;
import com.egzamin.domain.Orders;


@Controller
public class PizzaControler {
	
	@Autowired
	private PizzaService pizzaService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private KucharzRepository kucharzrepo;
	
	private List<Orders> allZamowienie = new ArrayList<>();
	
	private List<Kucharz> KucharzZamowienie = new ArrayList<>();
	
	private List<Orders> allZamowienieK = new ArrayList<>();
	
	@GetMapping("/makeOrder")
    public String form(Model model) {
		Orders zamowienie = new Orders();
		model.addAttribute("order", zamowienie);
		model.addAttribute("nazwa", pizzaService.findAllPizzas());
        return "makeOrder";
	}
	@PostMapping("/makeOrder")
	public String add(Orders order, RedirectAttributes redirect) {
		allZamowienie.add(order);
		redirect.addAttribute("imie", order.getImie());
		return "redirect:zamowienie/{imie}";
	}
	@GetMapping("/zamowienie/{imie}")
	public String zamowienia(@PathVariable String imie,Model model, RedirectAttributes redirect) {
		List<Orders> wynik = allZamowienie.stream()
				.filter(allZamowienie -> allZamowienie.getImie().equals(imie))
				.collect(Collectors.toList());
		model.addAttribute("orders", wynik);
		
		return "zamowienie";
	}
	@PostMapping("/zamowienie")
	public String czyscKoszyk() {
		allZamowienie.clear();
		return "zamowienie";
	}
	@PostMapping("/koniec")
	public String send() {
		orderService.SaveAllOrders(allZamowienie);
		allZamowienie.clear();
		return "koniec";
	}
	@GetMapping("/przygotowanie")
	public String przygotowanie(Model model){
		allZamowienieK = orderService.FindAllOrders();
		model.addAttribute("orders", allZamowienieK);
		model.addAttribute("kucharz", new Kucharz());
		return "przygotowanie";
	}
	@PostMapping("/przygotowanie")
	public String send_kucharz(Kucharz kucharz) {
		KucharzZamowienie.add(kucharz);
		List<Orders> wynik = allZamowienieK.stream()
				.filter(allZamowienieK -> allZamowienieK.getId() == kucharz.getNumerZamowienia())
				.collect(Collectors.toList());
		kucharzrepo.saveAll(KucharzZamowienie);
		allZamowienieK.remove(wynik);
		return "redirect:przygotowanie";
	}
}
