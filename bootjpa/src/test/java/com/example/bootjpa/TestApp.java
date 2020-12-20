package com.example.bootjpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.bootjpa.controller.AlienController;
import com.example.bootjpa.dao.AlienRepo;
import com.example.bootjpa.model.Alien;

public class TestApp 
{

	@Autowired
	private AlienRepo ar;
	
	@Autowired
	private AlienController ac;
	
	@Test
	public void saveStudent_tests()
	{
		Alien a = new Alien(1,"jill","c");
		when(ar.save(a)).thenReturn(a);
		assertEquals(a, ac.addAlien(a));
	}

	@Test
	public void saveStudent_tests1()
	{
		Alien a = new Alien();
		a.setAid(1);
		a.setAname("jill");
		a.setTech("c++");
		when(ar.save(a)).thenReturn(a);
		assertEquals(a, ac.addAlien(a));
	}
	
	@Test
	public void getUsersTest() {
		when(ar.findAll()).thenReturn(Stream
				.of(new Alien(101,"ricky","java"), new Alien(102,"rimy","c")).collect(Collectors.toList()));
		assertEquals(2, ac.getAliens().size());
	}

}
