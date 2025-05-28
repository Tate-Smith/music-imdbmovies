package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import musicLibrary.Artist;

class ArtistTest {
	private Artist travis_Scott = new Artist("Travis Scott", "5/21/2013");
	private Artist frank_Ocean = new Artist("Frank Ocean", "5/1/2005");
	private Artist kanye = new Artist("Kanye West", "9/30/2003");

	@Test
	void testRate() {
		travis_Scott.rate(1, 3);
		frank_Ocean.rate(1, 5);
		kanye.rate(1, 4);
		assertTrue(travis_Scott.getRating(1) == 3);
		assertTrue(frank_Ocean.getRating(1) == 5);
		assertTrue(kanye.getRating(1) != 0);
	}
	
	@Test
	void testWeightedRating() {
		travis_Scott.rate(1, 3);
		travis_Scott.rate(2, 4);
		travis_Scott.rate(3, 1);
		travis_Scott.rate(4, 5);
		travis_Scott.rate(5, 2);
		travis_Scott.rate(6, 3);
		travis_Scott.rate(7, 4);
		travis_Scott.rate(8, 0);
		
		assertTrue(travis_Scott.getWeightedRating() == (22/8));
		assertTrue(travis_Scott.getReviews() == 8);
	}

}
