package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Football;
import com.nt.repository.FootballPlayerRepository;

@Component
public class FootballRunner implements CommandLineRunner {
	@Autowired
	FootballPlayerRepository frepo;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		List<Football> club = frepo.findByClub("Sports Club");
		club.forEach(System.out::println);
        System.out.println("===========opertion1==========");
		List<Football> salary = frepo.findPlayersWithSalaryGreaterThan(25000.0);
		salary.forEach(System.out::println);
		System.out.println("===========opertion2==========");
		List<Football> country = frepo.findByPositionAndCountry("Captain", "India");
		country.forEach(System.out::println);
		System.out.println("===========opertion3==========");
		List<Football> name = frepo.findByNameStartsWith("Cristiano");
		name.forEach(System.out::println);
		System.out.println("===========opertion4==========");
		List<Football> jersey = frepo.findByJerseyNumberBetween(10, 99);
		jersey.forEach(System.out::println);
		System.out.println("===========opertion5==========");
		Long count = frepo.countPlayersByCountry("India");
		System.out.println(count.toString());
		System.out.println("===========opertion6==========");
		List<Football> highestSalary = frepo.findHighestPaidPlayers();
		highestSalary.forEach(System.out::println);

	}

}
