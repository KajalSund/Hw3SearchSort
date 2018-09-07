import java.util.*;
import java.io.*;
public class keywordSorting {
	public static void main(String args[])throws Exception
	{
		File keywordFile =new File("F:\\java_assignments\\HW3-unsorted-keywords.txt");   //input unsorted file
		FileWriter fileWriter = new FileWriter("F:\\java_assignments\\HW3-OUTPUT-16103037.txt");   //output file
		File input_code=new File("F:\\java_assignments\\HW3-input-code.cpp");     //input code files
		BufferedWriter writer = new BufferedWriter(fileWriter);    // buffer writer 
		Scanner s= new Scanner(keywordFile);            //keyword file scanner
		Scanner file_code= new Scanner(input_code);         //input code file scanner
		int i=0;                               
		//to read file line by line
		while(s.hasNextLine())
		{
			//to count the no. of keywords
			String d=s.nextLine();  
			if(d.length()>0)
				i++;
		
		}
		int counter=0;
		//System.out.print(i);
        String a[]=new String[i];
        int j=-1;
        s.close();
        s= new Scanner(keywordFile);
        while(s.hasNextLine())
		{
        	// to count the no. of the keywords.
			String d=s.nextLine();  
			if(d.length()>0)
			{
				j++;
				a[j]=d;
			}
		
		}
        j++;
        int k,l;
        for(k=1;k<j;k++)
        {
          // sorting the strings
      	  for(l=0;l<j-k;l++)  
      	  {
      		  if(a[l+1].compareTo(a[l])>0)
      		  {
      			  String g=a[l+1];
      			  a[l+1]=a[l];
      			  a[l]=g;
      		  }
      	  }
        }
        String g;
        i=0;
        while(file_code.hasNextLine())               //checking of input code file
		{
        	i++;
        	int flag=0;
		g=file_code.nextLine();
	
		String x="line "+i+": ";
		for(k=0;k<g.length();k++)
		der:{int r=k;
			char w=g.charAt(k);
			if(w=='/'&& g.charAt(k+1)=='/')
			{
				break;
			}
			if(w>='a'&&w<='z'||w>='0'&& w<='9'||w=='_')        //keyword checking
			{
				String q="";
				while(w>='a'&&w<='z'||w>='0'&&w<='9'||w=='_')
				{
					q=q+w;
				k++;
				if(k<g.length())
				w=g.charAt(k);
				else
					w='&';
				}k=k-1;
				int y,u,h;
				y=0;
				u=j-1;
				while(y<=u)
				{
					h=(y+u)/2;
					if(q.compareTo(a[h])==0)
					{
						flag=1;
						counter++;
						x=x+q+"("+r+") ";
						break;
					}
					else if(q.compareTo(a[h])>0)
					u=h-1;	
					else
                    y=h+1;						
				}
			}
			else
			{
				if(w=='/')
				{
					k++;
					w=g.charAt(k);
					if(w=='/')
					{
						break der;
					}
					else
						k=k-1;
				}
			}
		}
		if(flag==1)
		{
			x=x+"\n";
			writer.write(x);                // writing found keywords into the output file
			writer.newLine();
			System.out.print(x);	
		}
		}
		
        String f="Number of keywords found : "+counter+"\n";
        System.out.print(f);
        writer.write(f);
        s.close();
        file_code.close();
        writer.close();}
}   





