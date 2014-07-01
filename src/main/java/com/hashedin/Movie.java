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
	
	public void getMovies(){
		InputStream is=(this.getClass().getClassLoader().getResourceAsStream("movie.data"));
		Map<String,MovieRecomendor> moviemap=getStringFromInputStream(is);
		System.out.println(moviemap);
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
		Movie mn=new Movie();
		mn.getMovies();
//		try {
//			fis = new FileInputStream(file);
//			
//			System.out.println("Total file size to read (in bytes) : "
//					+ fis.available());
// 
//			int content;
//			while ((content = fis.read()) != -1) {
//				// convert to char and display it
//				System.out.print((char) content);
//			}
// 
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
	
}




