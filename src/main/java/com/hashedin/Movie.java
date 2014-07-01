package com.hashedin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Movie {
	
	public Map<String, MovieRecomendor> getMovies(String file){
		InputStream is=(this.getClass().getClassLoader().getResourceAsStream(file));
		Map<String,MovieRecomendor> moviemap=getStringFromInputStream(is);
		//System.out.println(moviemap);
		return moviemap;
	}
	private Map<String, MovieRecomendor> getStringFromInputStream(InputStream is) {
		
		Map<String,MovieRecomendor> moviemap = new HashMap<String, MovieRecomendor>();
		BufferedReader br = null;
		
		
		String line;
		try {
			
			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				MovieRecomendor mn=getMovieobject(line);
				moviemap.put(mn.getId().toString(), mn);
			}
 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
 
		return moviemap;
 
	}
	
	private  MovieRecomendor getMovieobject(String line) {
		MovieRecomendor mr=new MovieRecomendor();
		StringTokenizer st2 = new StringTokenizer(line, "|");
	
		mr.setId(st2.nextElement().toString());
		mr.setName(st2.nextElement().toString());
		mr.setDate(st2.nextElement().toString());
		mr.setUrl(st2.nextElement().toString());
		
		
		mr.setYear(st2.nextElement().toString());
		return mr;
	}
	public static void main(String[] args){
		Movie mov=new Movie();
		Map<String,MovieRecomendor> movhmap = new HashMap<String, MovieRecomendor>();
		movhmap=mov.getMovies("movie.data");
		
	}
	
}




