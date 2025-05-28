package musicLibrary;

import java.util.HashMap;
import java.util.Objects;

public class Artist {
	private String name;
	private HashMap<Integer, Integer> ratings;
	private String debutDate;
	private	boolean listenedTo;
	private double averageRating;
	
	public Artist(String name, String debutDate) {
		this.name = name;
		this.ratings = new HashMap<Integer, Integer>();
		this.debutDate = debutDate;
		this.listenedTo = false;
		this.averageRating = 0.0;
	}
	
	/*
	 * rating > = && rating < 11
	 */
	public void rate(int user_ID, int rating) {
		ratings.put(user_ID, rating);
		calculateWeightedRating();
	}
	
	public void listened() {
		listenedTo = false;
	}

	public String getName() {
		return name;
	}
	
	public int getRating(int user_ID) {
		return ratings.get(user_ID);
	}
	
	public int getReviews() {
		return ratings.size();
	}
	
	public String getDebutDate() {
		return debutDate;
	}
	
	public boolean isListenedTo() {
		return listenedTo;
	}
	
	public double getWeightedRating() {
		return averageRating;
	}
	
	private void calculateWeightedRating() {
		int sum = 0;
		for (int v : ratings.values()) {
			sum += v;
		}
		averageRating = sum/ratings.size();
	}

	@Override
	public int hashCode() {
		return Objects.hash(averageRating, debutDate, listenedTo, name, ratings);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Artist other = (Artist) obj;
		return Double.doubleToLongBits(averageRating) == Double.doubleToLongBits(other.averageRating)
				&& Objects.equals(debutDate, other.debutDate) && listenedTo == other.listenedTo
				&& Objects.equals(name, other.name) && Objects.equals(ratings, other.ratings);
	}

	@Override
	public String toString() {
		return "Artist [name=" + name + ", debutDate=" + debutDate + ", listenedTo="
				+ listenedTo + ", averageRating=" + averageRating + "]";
	}
}
