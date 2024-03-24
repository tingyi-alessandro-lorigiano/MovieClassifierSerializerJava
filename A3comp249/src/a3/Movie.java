package a3;
import java.io.*;
import java.util.Arrays;



public class Movie implements Serializable {
	
	protected int year;
	protected String  title;
	protected int duration;
	protected String genre;
	protected String rating;
	protected double score;
	protected String director;
	protected String actor1;
	protected String actor2;
	protected String actor3;
	protected static String[] genres = {"Musical","Comedy","Animation","Adventure",
										"Drama","Crime","Biography","Horror","Action",
										"Documentary","Fantasy","Mystery","Sci-fi",
										"Family","Romance","Thriller","Western"};
	protected static String[] ratings= {"PG","Unrated","G","R","PG-13","NC-17"};
	
	protected static String genre_message = "Invalid Genre. Valid genres are the following:"
											+ "\nmusical"
											+ "\ncomedy"
											+ "\nanimation"
											+ "\nadventure"
											+ "\ndrama"
											+ "\ncrime"
											+ "\nbiography"
											+ "\nhorror"
											+ "\naction"
											+ "\ndocumentary"
											+ "\nfantasy"
											+ "\nmystery"
											+ "\nsci-fi"
											+ "\nfamimly"
											+ "\nromance"
											+ "\nthriller"
											+ "\nwestern";
	
	protected static String ratings_message = "Invalid Rating. Should be one of the following:"
											+ "\nPG"
											+ "\nUnrated"
											+ "\nG"
											+ "\nR"
											+ "\nPG-13"
											+ "\nNC-17";
	
	public Movie(int year,String title,int duration, String genre,String rating,double score,String director, String actor1,String actor2,String actor3) {
		this.year=year;
		this.title=title;
		this.duration=duration;
		this.genre=genre;
		this.rating=rating;
		this.score=score;
		this.director=director;
		this.actor1=actor1;
		this.actor2=actor2;
		this.actor3=actor3;
	}
	
	public int getYear(){
		return this.year;
	}
	public String getTitle(){
		return this.title;
	}
	public int getDuration(){
		return this.duration;
	}
	public String getGenre(){
		return this.genre;
	}
	public String getRating(){
		return this.rating;
	}
	public double getScore(){
		return this.score;
	}
	public String getDirector(){
		return this.director;
	}
	public String getActor1(){
		return this.actor1;
	}
	public String getActor2(){
		return this.actor2;
	}
	public String getActor3(){
		return this.actor3;
	}
	public void setYear(int y) {
		this.year=y;
	}
	public void setTitle(String t) {
		this.title=t;
	}
	public void setDuration(int d) {
		this.duration=d;
	}
	public void setGenre(String g) {
		this.genre=g;
	}
	public void setRating(String r) {
		this.rating=r;
	}
	public void setScore(double s) {
		this.score=s;
	}
	public void setDirector(String d) {
		this.director=d;
	}
	public void setActor1(String a1){
		this.actor1=a1;
	}
	public void setActor2(String a2) {
		this.actor2=a2;
	}
	public void setActor3(String a3) {
		this.actor3=a3;
	}
	
	
	public boolean equals(Movie anotherMovie) {
		return this.actor3==anotherMovie.actor3 && 
			   this.actor2==anotherMovie.actor2 &&
			   this.actor1 == anotherMovie.actor1 &&
			   this.director==anotherMovie.director &&
			   this.duration==anotherMovie.duration &&
			   this.genre==anotherMovie.genre &&
			   this.rating==anotherMovie.genre &&
			   this.score==anotherMovie.score &&
			   this.title==anotherMovie.title &&
			   this.year==anotherMovie.year;
	}
	
	public String toString() {
		return  "Year:\t"+this.year + "\n"
			   + "Title:\t"+this.title +"\n"
			   + "Score:\t"+this.score +"\n"
			   + "Rating:\t"+this.rating+"\n"
			   + "Genre:\t"+this.genre+"\n"
			   + "Duration:\t"+this.duration+"\n"
			   + "Director:\t"+this.director+"\n"
			   + "Actor 1:\t"+this.actor1+"\n"
			   + "Actor 2:\t"+this.actor2+"\n"
			   + "Actor 3:\t"+this.actor3+"\n";
		}
	
	public static boolean EmptyString(String str) {
	     return str.length() == 0;
	    }
	  
	public static int LetterNumber(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                count++; 
            }
        }
        return count;
    }
	
    public static int DigitNumber(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= '0' && ch <= '9') {
                count++; 
            }
        }
        return count;
    }
    
    public static boolean Inside(String[] array, String targetString) {
        for (String str : array) {
            if (str.equals(targetString)) {
                return true; 
            }
        }
		return false;
        
    }
	
	public static int lines(String file) throws IOException {
		BufferedReader b = new BufferedReader(new FileReader(file));
		int number_lines=0;
		while(b.readLine()!=null) 
			number_lines+=1;
			
		b.close();
		return number_lines;
	}
	
	
	
	public static boolean Periods(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '.') {
                return true; 
            }
        }
        return false; 
    }
	
	public static boolean checkRecord(String record, BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.equals(record)) {
                return true;
            }
        }
        return false;
    }
	
//	public static String[] splitStringByCommasIgnoringQuotes(String str) {
//		
//	}
	
	public static String[] splitStringByCommasIgnoringQuotes(String str) {
	    // Assuming maximum of 10 parts initially
	    String[] parts = new String[10];
	    int partIndex = 0;
	    StringBuilder currentPart = new StringBuilder();
	    boolean withinQuotes = false;
//	    System.out.println(str);
	    for (int i = 0; i < str.length(); i++) {
	        char c = str.charAt(i);
	        
	        // Choosing (,) as delimiter.
	        if (c == '"') {
	            withinQuotes = !withinQuotes;
	        } else if (c == ',' && !withinQuotes) {
	            // Add the current part to the array when encountering a comma outside quotes
	            parts[partIndex++] = currentPart.toString();
	            currentPart.setLength(0); // Reset the current part
	            
	            // Resize the array if needed
	            if (partIndex >= parts.length) {
	                parts = resizeArray(parts);
	            }
	        } else {
	            // Append the character to the current part
	            currentPart.append(c);
	        }
	    }

	    // Add the last part if any
	    if (currentPart.length() > 0) {
	        parts[partIndex++] = currentPart.toString();
	    }

	    // Trim the array to the actual number of parts
	    parts = trimArray(parts, partIndex);
//	    System.out.println(Arrays.toString(parts));
	    return parts;
	}

	// Method to resize the array
	private static String[] resizeArray(String[] arr) {
	    int newSize = arr.length * 2; // Double the size
	    String[] newArr = new String[newSize];
	    for (int i = 0; i < arr.length; i++) {
	        newArr[i] = arr[i];
	    }
	    return newArr;
	}

	// Method to trim the array to the actual number of parts
	private static String[] trimArray(String[] arr, int size) {
	    String[] trimmedArr = new String[size];
	    for (int i = 0; i < size; i++) {
	        trimmedArr[i] = arr[i];
	    }
	    return trimmedArr;
	}

	
	public static String[] splitStringByCommas(String str) {
	    String[] parts = new String[10]; // Assuming maximum 10 parts (fields)
	    int partIndex = 0;
	    StringBuilder currentPart = new StringBuilder();
	    boolean withinQuotes = false;

	    for (int i = 0; i < str.length(); i++) {
	        char c = str.charAt(i);
	        if (c == '"') {
	            withinQuotes = !withinQuotes; // Toggle withinQuotes flag
	            currentPart.append(c);
	        } else if (c == ',' && !withinQuotes) {
	            parts[partIndex++] = currentPart.toString(); // Add current part to the array
	            currentPart.setLength(0); // Reset current part
	        } else {
	            currentPart.append(c); // Add character to current part
	        }
	    }

	    // Add the last part
	    parts[partIndex] = currentPart.toString();

	    return parts;
	}





	
	
	 
	public static void error_1file(String infile) throws IOException, FileNotFoundException{
		
		String line;
		BufferedReader b = new BufferedReader(new FileReader(infile));
		BufferedWriter w = new BufferedWriter(new FileWriter("bad_records.txt",true));
		int lineNumber =0;
		while((line = b.readLine())!=null) {
		try {
			
			
			lineNumber++;
			
			String[] record =  splitStringByCommasIgnoringQuotes(line);
			
//			System.out.println(Arrays.toString(record));
			if (record.length<10) 
			{
				throw new MissingFieldsException("Syntax Error: ");
			}
			else if(record.length>10)
			{
//				System.out.println(Arrays.toString(record));
				throw new ExcessFieldsException("Syntax Error: ");

			}
			else if(record.length==10) {
				int quotes =0;
				for(int j=0;j<record.length;j++) {
					if(record[j].indexOf("\"")!=-1)
							quotes+=1;
					}
				if(quotes%2!=0 )
					throw new MissingQuotesException("Syntax Error: Invalid");
				
				if(record[0].equals(""))
					throw new BadYearException("Syntax Error: Invalid");
				
				if(Periods(record[0]) || LetterNumber(record[0])>0 || (Integer.parseInt(record[0])>1999 || Integer.parseInt(record[0])<1990))
					throw new BadYearException("Semantic Error: Invalid");
				
				if(record[1].equals(""))
					throw new BadTitleException("Syntax Error: Missing");
				
				
				if(DigitNumber(record[1])==record[1].length())
					throw new BadTitleException("Semantic Error: Invalid");
				
				if(record[2].equals(""))
					throw new BadDurationException("Syntax Error: Missing");
				
				if(LetterNumber(record[2])>0 || Periods(record[2]) || (Integer.parseInt(record[2])>300 || Integer.parseInt(record[2])<30))
					throw new BadDurationException("Semantic Error: Invalid");
				
				if(record[3].equals(""))
					throw new BadGenreException("Syntax Error: Missing");
				
				if(!Inside(genres,record[3]))
					throw new BadGenreException("Semantic Error: Invalid");
				
				if(record[4].equals(""))
					throw new BadRatingException("Syntax Error: Missing");
				
				if(!Inside(ratings,record[4]))
					throw new BadRatingException("Semantic Error: Invalid");
					
				if(record[5].equals(""))
					throw new  BadScoreException("Syntax Error: Missing");
				
//				if(!Periods(record[5]))
//					throw new BadScoreException("Semantic Error: Invalid");
				
				if(Double.parseDouble(record[5])>10 || Double.parseDouble(record[5])<0)
					throw new BadScoreException("Semantic Error: Invalid");
				
//				if(Periods(record[5]) && (Double.parseDouble(record[5])>10 || Double.parseDouble(record[5])<0))
//					throw new BadScoreException("Semantic Error: Invalid");
				
				if(record[6].equals("") || record[7].equals("") || record[8].equals("") || record[9].equals(""))
					throw new BadNameException("Syntax Error: Missing");
				
				if(DigitNumber(record[6])>0 || DigitNumber(record[7])>0 || DigitNumber(record[8])>0 || DigitNumber(record[9])>0)
					throw new BadNameException("Semantic Error: Invalid");
			}
			}catch(MissingFieldsException | 
					ExcessFieldsException |
					MissingQuotesException | 
					BadYearException | 
					BadTitleException | 
					BadDurationException |
					BadGenreException |
					BadRatingException |
					BadScoreException |
					BadNameException e){
				
				
				w.write(e.getMessage() + "\n");
				w.write("Original Movie Record: " + line + "\n");
				w.write("Input Filename: " + infile + "\n");
				w.write("Input Line Number: " + lineNumber + "\n\n");
				
//				w.write(e.getMessage() +"in line " +lineNumber+ " of file "+infile+"\n");
//				w.write("line:\t"+line +"\n");
				
				
				
		}
		
		
		
		}
		b.close();
		w.close();
			
	}
	 public static boolean containsElement(String[] array, String target) {
	        for (String element : array) {
	            if (element !=null && target !=null && element.equals(target)) {
	                return true;
	            }
	        }
	        return false;
	    }
	 

//	 public static void a(String file) {
//		    try {
//		        BufferedReader a = new BufferedReader(new FileReader(file));
//		        BufferedReader b = new BufferedReader(new FileReader("bad_records.txt"));
//
//		        // Read movie file names
//		        String line;
//		        int movieFileCount = 0;
//		        while ((line = a.readLine()) != null) {
//		            movieFileCount++;
//		        }
//		        // now we have # of movie filesToChec
//		        a.close();
//		        
//		        }
	
	 public static void a(String file) {
		    try {
		        BufferedReader a = new BufferedReader(new FileReader(file));
		        BufferedReader b = new BufferedReader(new FileReader("bad_records.txt"));

		        // Read movie file names
		        String line;
		        int movieFileCount = 0;
		        while ((line = a.readLine()) != null) {
		            movieFileCount++;
		            
		        }
		        System.out.println("in a() method.");
		        System.out.println("moviefileCount" + movieFileCount);

		        a.close();

		        // Read manifest file again to initialize proper array size
		        a = new BufferedReader(new FileReader(file));
		        String[] moviefiles = new String[movieFileCount];
		        int total_records = 0;
		        for (int i = 0; i < moviefiles.length; i++) {
		            moviefiles[i] = a.readLine();
		            total_records += lines(moviefiles[i]);
		        }
		        a.close();

		        // Read error lines
		        String[] errorlines = new String[lines("bad_records.txt")];
		        int errorIndex = 0;
		        while ((line = b.readLine()) != null) {
		            errorlines[errorIndex++] = line;
		        }
		        b.close();
		        
		        
		        // Writing Genre Filenames to Part2_manifest.txt
		        BufferedWriter part2 = new BufferedWriter(new FileWriter("part2_manifest.txt", true));
		        for (String genre : genres) {
		        	part2.write(genre.toLowerCase() + ".csv\n");
		        }
		        part2.close();
		        // PART 2 MANIFEST FILE DONE
		        
		        // CREATING EMPTY genre.CSV files
		        for (String genre : genres) {
		            String genreFileName = genre.toLowerCase() + ".csv";
		            BufferedWriter genreFileWriter = new BufferedWriter(new FileWriter(genreFileName, true));
		            genreFileWriter.close();
		        }
		        System.out.println(Arrays.toString(errorlines));
		        // Now must categorize the records into their .CSV files
		        for(String inputFile : moviefiles) {
		        	BufferedReader movieFileReader = new BufferedReader(new FileReader(inputFile));
		        	while ((line = movieFileReader.readLine()) != null) {
		        		String[] stringArray = splitStringByCommasIgnoringQuotes(line);
		        		String movieTitle = stringArray[1];
		        		String linexxx;
		        		boolean errorMovie = false;
				        b = new BufferedReader(new FileReader("bad_records.txt"));

		        		while ((linexxx = b.readLine()) != null) {
		                    if (linexxx.contains(movieTitle)) {
		                    	errorMovie = true;
		                    }
		                }
		        		b.close();
		        		
		                if (!line.isEmpty() && !errorMovie && splitStringByCommasIgnoringQuotes(line).length ==10) 
		                {
		                	
		                	//line is not empty && line has no errors
//		                	System.out.println(movieTitle);
		                	if (movieTitle.equals("Richie Rich")) {
		                		System.out.println("CUNT" + containsElement(errorlines, movieTitle));
		                	}
		                	for(String genre : genres) {
		                		
	                	        
		                	    if (line.contains(genre)) {
		                	        // Append to the corresponding genre CSV file
		                	    	String genreFileName = genre.toLowerCase() + ".csv";
		                	        BufferedWriter genreFileWriter = new BufferedWriter(new FileWriter(genreFileName, true));
		                	        genreFileWriter.write(line + "\n");
		                	        genreFileWriter.close();

		                	        break; // Break the loop once the line is written to the correct file
		                	    }

		                	}
		                }
			        
			        	}
		            movieFileReader.close();

		        }
		        
		        // Process records by movie files

//		        for (String movieFile : moviefiles) {
//		            BufferedReader x = new BufferedReader(new FileReader(movieFile));
//		            BufferedWriter part2 = new BufferedWriter(new FileWriter("part2_manifest.txt", true));
//		            String fileName = movieFile.toLowerCase().replace(".txt", ".csv");
//		            part2.write(fileName + "\n");
//	            part2.close();
//		            
//		            
//		            
//		            // AT this point we are opening the CSV input data & writing
////		            BufferedWriter w = new BufferedWriter(new FileWriter(fileName));
////		            while ((line = x.readLine()) != null) {
////		                if (!line.isEmpty() && !containsElement(errorlines, line)) {
////		                	System.out.println("line:/n" + line);
////		                    String[] record = line.split(",");
////		                    for (String genre : genres) {
////		                        if (containsElement(record, genre)) {
////		                            w.write(line);
////		                            w.newLine();
////		                            break;
////		                        }
////		                    }
////		                }
////		            }
////		            x.close();
////		            part2.close();
////		            w.close();
//		        }

		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}

	
	public static void categoryFile( String category, String originalFile) {
		try {
		BufferedReader mistakes = new BufferedReader(new FileReader("bad_records.txt"));
		BufferedReader  original= new BufferedReader(new FileReader(originalFile));
		BufferedWriter bw = new BufferedWriter(new FileWriter(category+".txt",true));
		String lineA;
		
		while((lineA= original.readLine()) !=null) {
				if(!checkRecord(lineA,mistakes)&& lineA.contains(category))
					bw.write(lineA+"\n");
				}
		mistakes.close();
		original.close();
		bw.close();
		
		
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String[] readFilesToCheck(String fileA) throws IOException {
        BufferedReader readerA = new BufferedReader(new FileReader(fileA));
        String line;
        int count = 0;
        while (readerA.readLine() != null) {
            count++;
        }
        readerA.close();

        String[] filesToCheck = new String[count];
        readerA = new BufferedReader(new FileReader(fileA));
        int index = 0;
        while ((line = readerA.readLine()) != null) {
            filesToCheck[index++] = line;
        }
        readerA.close();
        return filesToCheck;
    }
	
	public static String do_part1(String file)  {
		 
		try(BufferedReader b1 = new BufferedReader(new FileReader(file));) {
		
		// DELETING OLD FILES TO REWRITE
		File badRecordsFile = new File("bad_records.txt");
	    if (badRecordsFile.exists()) {
	        badRecordsFile.delete();
	    }
	    File part2_Manifest = new File("part2_manifest.txt");
	    if (part2_Manifest.exists()) {
	    	part2_Manifest.delete();
	    }
	    
	    for (String genre: genres) {
	    	File genreFile = new File(genre+".csv");
		    if (genreFile.exists()) {
		    	genreFile.delete();
		    }
	    }
	    
		// DELETING OLD FILES TO REWRITE
		
	    
	    
		String linex;
		while((linex= b1.readLine()) !=null) {
			error_1file(linex);	
		}
		b1.close();
		a(file);
		
		
		
		}catch(	  IOException e){
			e.printStackTrace();
			}
		return "part2_manifest.txt";
			
	}

	
	public static String do_part2(String file) {
	    try {
	        BufferedReader b1 = new BufferedReader(new FileReader(file));
	        String line;
	        
	        BufferedReader badRecordsReader = new BufferedReader(new FileReader("bad_records.txt"));

	        // Read error lines
	        String[] errorlines = new String[lines("bad_records.txt")];
	        int errorIndex = 0;
	        while ((line = badRecordsReader.readLine()) != null) {
	            errorlines[errorIndex++] = line;
	        }
	        badRecordsReader.close();
	        System.out.println(Arrays.toString(errorlines));
	        while ((line = b1.readLine()) != null) {
	            BufferedReader b2 = new BufferedReader(new FileReader(line));
	            System.out.println("Processing file: " + line);
	            while ((line = b2.readLine()) != null) {
	            	if (!line.isEmpty() && !containsElement(errorlines, line)) {
	            		String[] l = splitStringByCommasIgnoringQuotes(line);
		                
		                for (String s : l) {
		                    System.out.println("Field: " + s);
		                }
		                System.out.println(Arrays.toString(l));
		                Movie movie = new Movie(Integer.parseInt(l[0]), l[1], Integer.parseInt(l[2]), l[3], l[4],
		                        Double.parseDouble(l[5]), l[6], l[7], l[8], l[9]);
		                System.out.println("Created movie: " + movie.toString());
		                ObjectOutputStream bro = new ObjectOutputStream(new FileOutputStream(movie.getGenre() + ".ser"));
		                bro.writeObject(movie);
		                bro.close();
		                System.out.println("Serialized movie to: " + movie.getGenre() + ".ser");
//	            		ObjectInputStream ming = new ObjectInputStream(new FileInputStream(movie.getGenre() + ".ser"));
//	            		ming.readObject(ming);
	            	}
	                
	            }
	            b2.close();
	        }
	        b1.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return "part3_manifest.txt";
	}


	
	
	
	
	
		
		
		
	
	
	
	
	public static void main(String[] args) {
		
		System.out.println("hell");
		String part1_manifest = "part1_manifest.txt";
		String part2_manifest = do_part1(part1_manifest);
		
		

		
	
		String part3_manifest = do_part2(part2_manifest);
		/*
								do_part3(part3_manifest );
																   
		return;
		*/
	}
	
	
}
