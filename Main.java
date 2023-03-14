package game;

import java.io.*;
import java.util.*;

public class Main {
//this function will be useed in main algorithm to sort the country dictionary alphabetically
	public static boolean isAlphabetical(String word1, String word2)
	{
		boolean result=true;
		if(word1.length()>word2.length())
		{
			for(int i=0;i<word2.length();i++)
			{
				if(word1.charAt(i)<word2.charAt(i))
					{
					result=true;
					break;
					}
				else if(word1.charAt(i)>word2.charAt(i))
				{
					result= false;
					break;
				}
			}
		
		}
		else if(word1.length()<=word2.length())
		{
			for(int i=0;i<word1.length();i++)
			{
				if(word1.charAt(i)<word2.charAt(i))
					{
					result=true;
				     break;
					}
				else if(word1.charAt(i)>word2.charAt(i))
				{
					result=false;
					break;
				}
			}
		
		}
		return result;
		
	}

	public static void main(String[] args) throws IOException {
	
		FileReader fileReader = new FileReader("countries.txt");
		String line;

		BufferedReader br = new BufferedReader(fileReader);

		Stack s1= new Stack(20);//stack for countries
		Stack temp1= new Stack(21);//temp stack for sorting countries
		Stack s2= new Stack(26);//stack for alphabet
		while ((line = br.readLine()) != null)
		{
            line=line.toUpperCase(Locale.ENGLISH);
			s1.push(line);
		

		}
		
		br.close();
		String temp=" ";
		temp1.push(" ");//temp string for sorting countries
		while(!s1.isEmpty())
		{
			if(!isAlphabetical(s1.peek().toString(), temp1.peek().toString()))
			{
				//if s1.peek comes after in alphabetical order we put it in temp1
				temp1.push(s1.pop());
			}
			else if(isAlphabetical(s1.peek().toString(), temp1.peek().toString()))
			{
				//else if we take it to a temp string
				temp=s1.pop().toString();
				while(!temp1.isEmpty()&&isAlphabetical(temp, temp1.peek().toString()))
				{
					//then take other elements and insert the temp to make an alphabetical order
					s1.push(temp1.pop());
				}
				temp1.push(temp);
			}
		}
	    while(!temp1.isEmpty())
		{
	    	//temp was reversed so we put it in original stack to order it
			s1.push(temp1.pop());
		}
	      
	    Random rand = new Random();
	    int randnum=rand.nextInt(21);
	    
	    for(int i=0;i<randnum-1;i++)
	    { 
	    	//choose a random country
	    	s1.pop();
	    }

	    //System.out.println(s1.peek());
		Queue q1= new Queue(s1.peek().toString().length());//queue for country
		Queue q2= new Queue(s1.peek().toString().length());//queue for contest
		
		for(int i=0; i<s1.peek().toString().length();i++)
		{
			//setting letters of the country to queue
			q1.enqueue(s1.peek().toString().charAt(i));
		}
		

	    Random random_wheel = new Random();
	    int wheel=random_wheel.nextInt(1, 9);
	    int prize=0;
	    String wheel_prize=" ";
	    Random random = new Random();
	    int randomnum=random.nextInt(1, 27);
	    
	    for(int i=90;i>=65;i--)
	    {
	    	//setting alphabet to s2
	    	s2.push((char)i);
	    }
	    
	    Stack temp_s2= new Stack(randomnum);
	    String temp_alpha=" ";
	    int alphabet_size=26;
	    Stack test= new Stack(alphabet_size);
	    for(int i=0;i<randomnum-1;i++)
	    {
	    	//taking the letters untill the random letter
	    	temp_s2.push(s2.pop());
	    }
	    //taking the random letter
	    temp_alpha=s2.pop().toString();
        while(!temp_s2.isEmpty())
        {
        	//putting other letters back
        	s2.push(temp_s2.pop());
        }
        //System.out.println(temp_alpha);
        while(!s2.isEmpty())
        {
        	//printing the alphabet
            //System.out.print(s2.peek());
            test.push(s2.pop());
        }
        
        while(!test.isEmpty())
        {
            s2.push(test.pop());
        }

        int size=q1.size();
        int counter=0;
        for(int i=0;i<size;i++)
        {
        	if(temp_alpha.compareTo(q1.peek().toString())==0)
        	{
        		//if random letter is in the word this shows it to user
        		q2.enqueue(temp_alpha);
        	}
        	else
        	{
        		q2.enqueue("-");
        	}
    		q1.enqueue(q1.dequeue());
        }
        System.out.println("Randomly generated number:" +randnum);
        int step=0;
        int score=0;
        while(counter<size)
        {  	wheel=random_wheel.nextInt(1, 9);
    	switch(wheel)//switch-case id for wheel 
	    {
	    case 1:
	    	wheel_prize=" ";
	    	prize=10;
	    	break;
	    case 2:
	    	wheel_prize=" ";
	    	prize=50;
	    	break;
	    case 3:
	    	wheel_prize=" ";
	    	prize=100;
	    	break;
	    case 4:
	    	wheel_prize=" ";
	    	prize=250;
	    	break;
	    case 5:
	    	wheel_prize=" ";
	    	prize=500;
	    	break;
	    case 6:
	    	wheel_prize=" ";
	    	prize=1000;
	    	break;
	    case 7:
	    	wheel_prize="Double Money";
	    	prize=0;
	    	score=score*2;
	    	break;
	    case 8:
	    	wheel_prize="Bankrupt";
	    	prize=0;
	    	score=0;
	    	break;
	    	
	    }
    	score=score+prize;
    	System.out.println("   ");

    	step++;
            alphabet_size--;//decreasing alphabet by one size as we pick letters from it one by one
            randomnum=random.nextInt(1, alphabet_size + 1);

    	    temp_s2= new Stack(randomnum);
    	    temp_alpha=" ";
    	    test= new Stack(alphabet_size);
            
    	    for(int i=0;i<randomnum-1;i++)
    	    {
    	    	temp_s2.push(s2.pop());
    	    }
    	    
    	    temp_alpha=s2.pop().toString();

            while(!temp_s2.isEmpty())
            {
            	s2.push(temp_s2.pop());
            }

            System.out.println(" ");
          
		for(int i=0;i<size;i++)
		{
			
    		
        	if(temp_alpha.compareTo(q1.peek().toString())==0)
        	{
        		//if random letter is in the word this shows it to user
        		q2.dequeue();
        		q2.enqueue(temp_alpha);
        	}
        	else
        	{
        		q2.enqueue(q2.dequeue());
        	}
			q1.enqueue(q1.dequeue());
		}
    	counter = 0;

        for(int i=0;i<size;i++)
        {
        
        	if(q2.peek()!="-")
        	{
        	    counter++;
        	}
        	q2.enqueue(q2.dequeue());
        }

    	
        System.out.println(" ");
        System.out.print("word: ");
		for(int i=0;i<size;i++)
		{
			System.out.print(q2.peek());
			q2.enqueue(q2.dequeue());
		}
		System.out.print("       step: "+step+"   ");
    	System.out.print("  SCORE: "+score+"     ");

        while(!s2.isEmpty())
        {
            System.out.print(s2.peek());
            test.push(s2.pop());
        }
        while(!test.isEmpty())
        {
            s2.push(test.pop());
        }
        System.out.println("     ");
    	if(prize==0)
    	{
    		System.out.println("WHEEL: "+wheel_prize);
    	}
    	else
    	{
    		System.out.println("WHEEL: "+prize);
    	}
        }
        System.out.println("Your prize: "+score+"!!");
        try(FileWriter fw = new FileWriter("HighScoreTable.txt", true);
        	    BufferedWriter bw = new BufferedWriter(fw);
        	    PrintWriter out = new PrintWriter(bw))
        	{
        	    out.println("");
        	    out.print("You ");
        	  
        	    out.print(score);
        	   
        	} catch (IOException e) {
        	    //exception handling left as an exercise for the reader
        	}
        FileReader fileReader2 = new FileReader("HighScoreTable.txt");
		String line2;
		String[] highscore;

		BufferedReader br2 = new BufferedReader(fileReader2);

		Stack s3= new Stack(10);//stack for names in highscore table
		Stack s4= new Stack(10);//stack for scores in highscore table
		Stack temp2= new Stack(11);//temps for sorting
		Stack temp3= new Stack(11);
		while ((line2 = br2.readLine()) != null)
		{
            highscore=line2.split(" ");
			s3.push(highscore[0]);
			s4.push(highscore[1]);
		
		}
			
		br2.close();
		Object tmp2=0;
	    String tmp3="";
	    String max="0 0";
		temp2.push(max);
		temp3.push("");

		while(!s4.isEmpty())//this is the same sorting algorithm as we did for sorting countries
		{
			if(s4.peek().toString().length()>temp2.peek().toString().length())
			{
				temp2.push(s4.pop());
				temp3.push(s3.pop());
				max=temp2.peek().toString();
			}
			else if(s4.peek().toString().length()==temp2.peek().toString().length())
			{
				if(s4.peek().toString().compareTo(temp2.peek().toString())>0)
			
			{
				temp2.push(s4.pop());
				temp3.push(s3.pop());
				max=temp2.peek().toString();
			}
			
			    else if(s4.peek().toString().compareTo(temp2.peek().toString())<=0)
			  {
				tmp2=s4.pop();
				tmp3=s3.pop().toString();
				while(!temp2.isEmpty()&&((tmp2.toString().compareTo(temp2.peek().toString()))<=0||tmp2.toString().length()<temp2.peek().toString().length()))
				{
					s4.push(temp2.pop());
					s3.push(temp3.pop());
				}
				temp2.push(tmp2);
				temp3.push(tmp3);
				max=temp2.peek().toString();
			   }
			}
			else if(s4.peek().toString().length()<temp2.peek().toString().length())
			{
				tmp2=s4.pop();
				tmp3=s3.pop().toString();
				while(!temp2.isEmpty()&&((tmp2.toString().compareTo(temp2.peek().toString()))<=0||tmp2.toString().length()<temp2.peek().toString().length()))
				{
					s4.push(temp2.pop());
					s3.push(temp3.pop());
				}
				temp2.push(tmp2);
				temp3.push(tmp3);
				max=temp2.peek().toString();
			}
		}

	       try(FileWriter fw = new FileWriter("HighScoreTable.txt",false);
	          	    BufferedWriter bw = new BufferedWriter(fw);
	          	    PrintWriter out = new PrintWriter(bw))
	          	{


	       	   while(!temp2.isEmpty())
	      		{

	       		   if(temp2.peek()!="0 0")
	       		   {
	      			out.println(temp3.pop()+" "+temp2.pop());
	       		   }
	       		   else if(temp2.peek()=="0 0")
	       		   {
	       			   out.print("SCORES 0000");
	       			   temp2.pop();
	       		   }
	      		}
	      	
	          	     
	          	} catch (IOException e) {
	          	    //exception handling left as an exercise for the reader
	          	}

	}
}
