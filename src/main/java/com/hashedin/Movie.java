package com.hashedin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;

public class Movie {
	
	public Map<String, MovieRecomendor> getMovies(String file){
		InputStream is=(this.getClass().getClassLoader().getResourceAsStream(file));
		Map<String,MovieRecomendor> moviemap=getStringFromInputStream(is);
	//	System.out.println(moviemap);
		return moviemap;
	}
	public ArrayList<MovieRatings> getRatings(String file){
		InputStream is=(this.getClass().getClassLoader().getResourceAsStream(file));
		ArrayList<MovieRatings> moviemap=RatingMap(is);
		//System.out.println(moviemap);
		return moviemap;
	}
	public Map<String, MovieUser> getUsers(String file){
		InputStream is=(this.getClass().getClassLoader().getResourceAsStream(file));
		Map<String,MovieUser> moviemap=UserMap(is);
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
				moviemap.put(Integer.toString((mn.getId())) , mn);
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
private ArrayList<MovieRatings> RatingMap(InputStream is) {
		ArrayList<MovieRatings> moviemap =new ArrayList<MovieRatings>();
		//Map<String,MovieRatings> moviemap = new HashMap<String, MovieRatings>();
		BufferedReader br = null;
		String line;
		try {
			
			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				MovieRatings mr=getRatingObject(line);
				moviemap.add(mr);
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
private Map<String, MovieUser> UserMap(InputStream is) {
	
	Map<String,MovieUser> moviemap = new HashMap<String, MovieUser>();
	BufferedReader br = null;
	String line;
	try {
		
		br = new BufferedReader(new InputStreamReader(is));
		while ((line = br.readLine()) != null) {
			MovieUser mr=getUserObject(line);
			moviemap.put(Integer.toString(mr.getUid()),mr);
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
public ArrayList<String> GenreMap(String file) {
	
	
	InputStream is=(this.getClass().getClassLoader().getResourceAsStream(file));
	ArrayList<String> gnames=new ArrayList<String>();
	
	BufferedReader br = null;
	String line;
	try {
		
		br = new BufferedReader(new InputStreamReader(is));
		while ((line = br.readLine()) != null) {
			
			gnames.add(getMovieGenre(line));
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

	return gnames;

}



	
	private  MovieRecomendor getMovieobject(String line) {
		MovieRecomendor mr=new MovieRecomendor();
		StringTokenizer st2 = new StringTokenizer(line, "|");
	
		mr.setId(Integer.parseInt(st2.nextElement().toString()) );
		mr.setName(st2.nextElement().toString());
		mr.setDate(st2.nextElement().toString());
		mr.setUrl(st2.nextElement().toString());
		
		
		mr.setYear(st2.nextElement().toString());
		return mr;
	}
	private  String getMovieGenre(String line) {
		
		StringTokenizer st2 = new StringTokenizer(line, "|");
		return ((st2.nextElement().toString()) );
	}
	private  MovieUser getUserObject(String line) {
		MovieUser mr=new MovieUser();
		StringTokenizer st2 = new StringTokenizer(line, "|");
	
		mr.setUid(Integer.parseInt(st2.nextElement().toString()) );
		mr.setAge(Integer.parseInt(st2.nextElement().toString()) );
		mr.setGender(st2.nextElement().toString());
		mr.setOccupation(st2.nextElement().toString());
		mr.setZip(st2.nextElement().toString());
		return mr;
	}
	
	private  MovieRatings getRatingObject(String line) {
		MovieRatings mr=new MovieRatings();
		StringTokenizer st2 = new StringTokenizer(line, "\t");
	
		mr.setUid(Integer.parseInt(st2.nextElement().toString()) );
		mr.setMid(Integer.parseInt(st2.nextElement().toString()) );
		mr.setRating(Integer.parseInt(st2.nextElement().toString()) );
		mr.setTimestamp(Integer.parseInt(st2.nextElement().toString()) );
		
		
		return mr;
	}
	
	public ArrayList<Integer> getGenre(String file, int n){
BufferedReader br = null;
InputStream is=(this.getClass().getClassLoader().getResourceAsStream(file));
ArrayList<Integer> mid = new ArrayList<Integer>();
		String line;
		try {
			
			br = new BufferedReader(new InputStreamReader(is));
			
			while ((line = br.readLine()) != null) {
				mid.add(getGenreValue(line,n));
				
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
 
		return mid;
	}
	public ArrayList<Integer> getYear(String file, String year){
		BufferedReader br = null;
		InputStream is=(this.getClass().getClassLoader().getResourceAsStream(file));
		ArrayList<Integer> mid = new ArrayList<Integer>();
				String line;
				try {
					
					br = new BufferedReader(new InputStreamReader(is));
					
					while ((line = br.readLine()) != null) {
						mid.add(getYearValue(line,year));
						
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
		 
				return mid;
			}
	public ArrayList<Integer> getYearGenre(String file, String year, int n){
		BufferedReader br = null;
		InputStream is=(this.getClass().getClassLoader().getResourceAsStream(file));
		ArrayList<Integer> mid = new ArrayList<Integer>();
				String line;
				try {
					
					br = new BufferedReader(new InputStreamReader(is));
					
					while ((line = br.readLine()) != null) {
						mid.add(getYearValue(line,year));
						
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
		 
				return mid;
			}
	private  int getYearValue(String line, String year) {
		
		String token=new String();

		
		ArrayList<String> val1=new ArrayList<String>(Arrays.asList(line.split("\\|")));
		int mid=Integer.parseInt(val1.get(0));
		int syear=0;
		token=val1.get(2);
		int bool=token.compareTo("");
		if(bool>0){
		ArrayList<String> mdate = new ArrayList<String>(Arrays.asList(token.split("-")));
		syear=Integer.parseInt((mdate.get(2)));
		}
		int val=-1;
		if(syear==Integer.parseInt(year))
		{
		val=mid;
		}
		return val;
	}
private  int getYearGenreValue(String line, String year, int n) {
		
		String token=new String();

		
		ArrayList<String> val1=new ArrayList<String>(Arrays.asList(line.split("\\|")));
		int mid=Integer.parseInt(val1.get(0));
		int syear=0;
		token=val1.get(2);
		int test=Integer.parseInt(val1.get(5+n));
		int bool=token.compareTo("");
		
		if(bool>0){
		ArrayList<String> mdate = new ArrayList<String>(Arrays.asList(token.split("-")));
		syear=Integer.parseInt((mdate.get(2)));
		}
		int val=-1;
		if((test==1)&&(syear==Integer.parseInt(year)))
		{
		val=mid;
		}
		return val;
	}
	private  int getGenreValue(String line, int n) {
		ArrayList<String> val1=new ArrayList<String>(Arrays.asList(line.split("\\|")));
		int mid=Integer.parseInt(val1.get(0));
		//int syear=0;
	
		int test=Integer.parseInt(val1.get(5+n));
		int val=-1;
		if(test==1)
		{
		val=mid;
		}
		return val;
	}
	
	public static void main(String[] args){
		Movie mov=new Movie();
		ArrayList<MovieRatings> rathmap=new ArrayList<MovieRatings>();
		Map<String,MovieRecomendor> movhmap = new HashMap<String, MovieRecomendor>();
		movhmap=mov.getMovies("movie.data");
		//Map<String,MovieRatings> rathmap = new HashMap<String, MovieRatings>();
		rathmap=mov.getRatings("ratings.data");
		Map<String,MovieUser> userhmap = new HashMap<String, MovieUser>();
		userhmap=mov.getUsers("user.data");
		String MovieName=mov.getMovieByYear(rathmap, movhmap, mov,"movie.data");
		System.out.println(MovieName);
		String MovieName1=mov.getMovieByYearGenre(rathmap, movhmap, mov,"movie.data");
		System.out.println(MovieName1);
		String MovieName2=mov.getMovieByGenre(rathmap, movhmap, mov,"movie.data");
		System.out.println(MovieName2);
		mov.getMostActiveUser(rathmap, userhmap);
		
		
	}
	
	public String getMostWatchedMovie(ArrayList<MovieRatings> rathmap,Map<String,MovieRecomendor> movhmap){
		ArrayList<Integer>movieIdList=new ArrayList<Integer>();
		ArrayList<Integer>countList=new ArrayList<Integer>();
		for(MovieRatings rats:rathmap){
	        int iid=rats.getMid();
	        	if(!movieIdList.contains(iid)){
	        		movieIdList.add(iid);
	        		countList.add(1);
	        	}
	        	else{
	        		int tempcount=countList.get(movieIdList.indexOf(iid));
	        		tempcount++;
	        		int indx=movieIdList.indexOf(iid);
	        		countList.set(indx,tempcount);
	        	}
		}
		int maxcount=Collections.max(countList);
		int MovId=movieIdList.get(countList.indexOf(maxcount));
		MovieRecomendor mrd=new MovieRecomendor();
		mrd=movhmap.get(Integer.toString(MovId));
		return mrd.getName();
		
	}
	
	public void  getMostActiveUser(ArrayList<MovieRatings> rathmap,Map<String,MovieUser> userhmap){
		ArrayList<Integer>movieIdList=new ArrayList<Integer>();
		ArrayList<Integer>countList=new ArrayList<Integer>();
		for(MovieRatings rats:rathmap){
	        int iid=rats.getUid();
	        	if(!movieIdList.contains(iid)){
	        		movieIdList.add(iid);
	        		countList.add(1);
	        	}
	        	else{
	        		int tempcount=countList.get(movieIdList.indexOf(iid));
	        		tempcount++;
	        		int indx=movieIdList.indexOf(iid);
	        		countList.set(indx,tempcount);
	        	}
		}
		int maxcount=Collections.max(countList);
		int UserId=movieIdList.get(countList.indexOf(maxcount));
		MovieUser mrd=new MovieUser();
		mrd=userhmap.get(Integer.toString(UserId));
		System.out.println("Name: Not Known");
		System.out.println("UID: " + mrd.getUid());
		System.out.println("Age: " + mrd.getAge());
		System.out.println("Gender: " + mrd.getGender());
		System.out.println("Occupation: " + mrd.getOccupation());
		System.out.println("ZIP Code: " + mrd.getZip());
		
	}
	
	
	public String getMovieByYear(ArrayList<MovieRatings> rathmap,Map<String,MovieRecomendor> movhmap,Movie mov, String File){
		ArrayList<String> genrelist= new ArrayList<String>();
		genrelist=mov.GenreMap("genre.data");
		System.out.println(genrelist);
		String year="1997";
		
		
		ArrayList<Integer> mids=new ArrayList<Integer>();
		mids=mov.getYear(File,year);
		ArrayList<Integer> newmids=new ArrayList<Integer>();
		ArrayList<Integer> averagelist=new ArrayList<Integer>();
		
		for(int d:mids){
			if(d!=-1)
			{
				newmids.add(d);
			}
		}
		//System.out.println(newmids);
		
		int fmid=mov.getByGenre(newmids, rathmap);
		
		MovieRecomendor mrd=new MovieRecomendor();
		mrd=movhmap.get(Integer.toString(fmid));
		return mrd.getName();
		
	}
	public String getMovieByYearGenre(ArrayList<MovieRatings> rathmap,Map<String,MovieRecomendor> movhmap,Movie mov, String File){
		ArrayList<String> genrelist= new ArrayList<String>();
		genrelist=mov.GenreMap("genre.data");
		System.out.println(genrelist);
		String year="1995";
		
		genrelist=mov.GenreMap("genre.data");
		System.out.println(genrelist);
		String genre="Action";
		System.out.println("Select Genre");
		int i=0;
		for(String s : genrelist)
		{
			i++;
			System.out.println(i + ". " + s);
			
		}
		int arrindex=genrelist.indexOf(genre);
		
		ArrayList<Integer> mids=new ArrayList<Integer>();
		mids=mov.getYearGenre(File,year,arrindex);
		ArrayList<Integer> newmids=new ArrayList<Integer>();
		ArrayList<Integer> averagelist=new ArrayList<Integer>();
		
		for(int d:mids){
			if(d!=-1)
			{
				newmids.add(d);
			}
		}
		//System.out.println(newmids);
		
		int fmid=mov.getByGenre(newmids, rathmap);
		
		MovieRecomendor mrd=new MovieRecomendor();
		mrd=movhmap.get(Integer.toString(fmid));
		return mrd.getName();
		
	}
	
	public String getMovieByGenre(ArrayList<MovieRatings> rathmap,Map<String,MovieRecomendor> movhmap,Movie mov, String File){
		ArrayList<String> genrelist= new ArrayList<String>();
		genrelist=mov.GenreMap("genre.data");
		System.out.println(genrelist);
		String genre="Animation";
		System.out.println("Select Genre");
		int i=0;
		for(String s : genrelist)
		{
			i++;
			System.out.println(i + ". " + s);
			
		}
		int arrindex=genrelist.indexOf(genre);
		ArrayList<Integer> mids=new ArrayList<Integer>();
		mids=mov.getGenre(File,arrindex);
		ArrayList<Integer> newmids=new ArrayList<Integer>();
		ArrayList<Integer> averagelist=new ArrayList<Integer>();
		
		for(int d:mids){
			if(d!=-1)
			{
				newmids.add(d);
			}
		}
		//System.out.println(newmids);
		
		int fmid=mov.getByGenre(newmids, rathmap);
		
		MovieRecomendor mrd=new MovieRecomendor();
		mrd=movhmap.get(Integer.toString(fmid));
		return mrd.getName();
	}
	
	public  int  getByGenre(ArrayList<Integer> mids,ArrayList<MovieRatings> m){
		ArrayList<Integer> averagelist=new ArrayList<Integer>();
		 ArrayList<MovieRatings> mapmid=new ArrayList<MovieRatings>();
		 int fmid=0;
		for(int item: mids){
			
			for(MovieRatings rats:m){
		        int iid=rats.getMid();
		       if(item==iid){
		        mapmid.add(rats);
		        
		        }
		        //System.out.println(pairs.getKey() + " = " + pairs.getValue());
		       // avoids a ConcurrentModificationException
		    }
		}
		for(int item: mids){
			int average=0,count=0,oaverage=0;
		for(MovieRatings id: mapmid){
	
			
	        if((id.getMid()==item)){
	        	int rating=id.getRating();
	        	average=average+(rating);
	        	count++;
			    average=average/count;
			    
			    
			    
			    
				}
	        
			if(average>=oaverage){
				oaverage=average;
				fmid=id.getMid();
			}
			}
		
		averagelist.add(average);
		}
		//Collections.sort(averagelist);
				
		return fmid;
		
	}
	
}




