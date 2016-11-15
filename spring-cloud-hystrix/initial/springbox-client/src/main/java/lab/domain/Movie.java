package lab.domain;

import java.util.List;

public class Movie {


	private Long id;

	private String title;

	private String mlId;

	private List<Genre> genres;

	private int numberInStock;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMlId() {
		return mlId;
	}

	public void setMlId(String mlId) {
		this.mlId = mlId;
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	public int getNumberInStock() {
		return numberInStock;
	}

	public void setNumberInStock(int numberInStock) {
		this.numberInStock = numberInStock;
	}

}
