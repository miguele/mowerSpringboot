package com.seat.mower;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.seat.mower.model.Mower;


public class MowerApplicationTests {

	@Test
	public void exampleMower1Test() {
		Mower mower = new Mower(1, 2, 'N');
		String movements = "LMLMLMLMM";
		mower.move(movements.toCharArray());
		assertEquals("1 3 N", mower.toString());
	}

	@Test
	public void exampleMower2Test() {
		Mower mower = new Mower(3, 3, 'E');
		String movements = "MMRMMRMRRM";
		mower.move(movements.toCharArray());
		assertEquals("5 1 E", mower.toString());
	}

}
