import java.io.*;
import de.congrace.exp4j.Calculable;
import de.congrace.exp4j.ExpressionBuilder;

public class CliGraph{

	static String axis="+ ";
	static String line="X ";
	static String graph=". ";
	
	static int size=15;
	static double step=1.0;
	
	static String input="x";
	
	public static void main(String args[]){
		getInput();
		
		int values[]=setvalues(new int[size+size+1]);
		
		System.out.println("\n\n");
		
		displayGraph(values);
	}
	
	public static void getInput(){
		BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Size of graph? Default is "+size+" : ");
		try{
			size=Integer.parseInt(b.readLine());
		}
		catch(Exception e){
			System.out.println("Using default value.");
		}
		
		System.out.print("Zoom factor? Default is 1 : ");
		try{
			step/=Integer.parseInt(b.readLine());
		}
		catch(Exception e){
			System.out.println("Using default value.");
		}
		
		System.out.print("Graph value? (Examples:\"x\",\"x*x\",\"cos(x)\") : ");
		try{
			input=b.readLine();
		}
		catch(Exception e){
			System.out.println("Showing graph for x");
		}
	}
	
	public static int[] setvalues(int arr[]){
		for(int i=0;i<arr.length;i++){
			double x=(i-(size));
			x=x*step;
			
			double value = evaluate(x);
			
			value = value/step;
			arr[i] = (int)(round(value));
		}
		return arr;
	}
	
	public static double evaluate(double x){
		Calculable calc=null;
		try{
			calc = new ExpressionBuilder(input).withVariable("x",x).build();
		}
		catch(Exception e){
			System.out.println("There is an error in your expression.");
			System.exit(0);
		}
		return calc.calculate();
	}
	
	public static double round(double n){
		return n<0.0?Math.ceil(n-0.5):Math.floor(n+0.5);
	}
	
	public static void displayGraph(int[] values){
		for(int i=0;i<size;i++){
			for(int b=0;b<size;b++){
				if(size-i==values[b])
					System.out.print(line);
				else
					System.out.print(graph);
			}

			if(size-i==values[size])
				System.out.print(line);
			else
				System.out.print(axis);

			for(int b=0;b<size;b++){
				if(size-i==values[b+size+1])
					System.out.print(line);
				else
					System.out.print(graph);
			}	
			System.out.print("\n");
		}
		
		for(int i=0;i<size*2+1;i++){
			if(0==values[i])
				System.out.print(line);
			else
				System.out.print(axis);
		}
		System.out.print("\n");

		for(int i=0;i<size;i++){
			for(int b=0;b<size;b++){
				if(0-i-1 == values[b])
					System.out.print(line);
				else
					System.out.print(graph);
			}
			if(0-i-1==values[size])
				System.out.print(line);
			else
				System.out.print(axis);

			for(int b=0;b<size;b++){
				if(0-i-1==values[b+size+1])
					System.out.print(line);
				else
					System.out.print(graph);
			}
			System.out.print("\n");
		}
	}
}