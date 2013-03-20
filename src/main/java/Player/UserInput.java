package Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInput {
	private BufferedReader readInput;
	private String input;
	private boolean validatedInput;
	
	public final static String YES = "Y";
	public final static String NO = "N";
	
	public final static int FIRST = 1;
	public final static int SECOND = 2;
	public final static int THIRD = 3;
	
	public final static String EXIT = "F";
	
	public UserInput(){
		setReadInput(new BufferedReader(new InputStreamReader(System.in)));
		this.setValidatedInput(false);
	}

	public void ynValidated() {
		try {
			this.setInput(readInput.readLine().trim().toUpperCase());
		} catch (IOException e) {
			setValidatedInput(false);
			return;
		}
		if(this.getInput().equals("Y") || this.getInput().equals("N"))
			setValidatedInput(true);
		else
			setValidatedInput(false);
	}
	
	public void toolsHouseInputValidated(){
		try{
			this.setInput(readInput.readLine().trim().toUpperCase());
		}
		catch(IOException e){
			setValidatedInput(false);
			return;
		}
		if(this.input != EXIT){
			try{
				int i = Integer.parseInt(input);
				if(i == THIRD || i == SECOND || i == FIRST)
					setValidatedInput(true);
				else
					setValidatedInput(false);
			}catch(Exception e){
				setValidatedInput(false);
				return;
			}
		}else{
			setValidatedInput(true);
		}
		
	}
	
	public BufferedReader getReadInput() {
		return readInput;
	}

	public void setReadInput(BufferedReader readInput) {
		this.readInput = readInput;
	}

	public boolean getValidatedInput() {
		return validatedInput;
	}

	public void setValidatedInput(boolean validatedInput) {
		this.validatedInput = validatedInput;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}
}
