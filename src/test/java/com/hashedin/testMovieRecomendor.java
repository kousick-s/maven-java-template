package com.hashedin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;

public class testMovieRecomendor {
	
	public static void main(String[] args){
		MovieManager mov=new MovieManager();
		ArrayList<MovieRatings> rathmap=new ArrayList<MovieRatings>();
		Map<String,MovieRecomendor> movhmap = new HashMap<String, MovieRecomendor>();
		movhmap=mov.getMovies("movie.data");
		//Map<String,MovieRatings> rathmap = new HashMap<String, MovieRatings>();
		rathmap=mov.getRatings("ratings.data");
		Map<String,MovieUser> userhmap = new HashMap<String, MovieUser>();
		userhmap=mov.getUsers("user.data");
		String MovieNamebyYear=mov.getMovieByYear(rathmap, movhmap, mov,"movie.data");
		System.out.println("Movie by Year -"+MovieNamebyYear);
		String MovieNamebyYearGenre=mov.getMovieByYearGenre(rathmap, movhmap, mov,"movie.data");
		System.out.println("Movie by Year and Genre -"+MovieNamebyYearGenre);
		String MovieNamebyGenre=mov.getMovieByGenre(rathmap, movhmap, mov,"movie.data");
		System.out.println("Movie by Genre -"+MovieNamebyGenre);
		System.out.println("Most Active User -");
		mov.getMostActiveUser(rathmap, userhmap);
		String MostWatchedGenres=mov.getMostWatchedGenre(mov, rathmap, movhmap);
		System.out.println(" Most Watched Genres: " + MostWatchedGenres);
		String HighestRatedGenres=mov.getHighestRatedGenre(mov,rathmap, movhmap);
		System.out.println("Highest Rated Genres:"+HighestRatedGenres);
		
	}

}
