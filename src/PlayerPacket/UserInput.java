package PlayerPacket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInput {
	private BufferedReader ReadInput;
	private String Input;
	private boolean ValidatedInput;
	
	public final static String YES = "Y";
	public final static String NO = "N";
	
	public final static int FIRST = 1;
	public final static int SECOND = 2;
	public final static int THIRD = 3;
	
	public final static String EXIT = "F";
	
	public UserInput(){
		SetReadInput(new BufferedReader(new InputStreamReader(System.in)));
		this.SetValidatedInput(false);
	}

	public void YNValidated() {
		try {
			this.SetInput(ReadInput.readLine().trim().toUpperCase());
		} catch (IOException e) {
			SetValidatedInput(false);
			return;
		}
		if(this.GetInput().equals("Y") || this.GetInput().equals("N"))
			SetValidatedInput(true);
		else
			SetValidatedInput(false);
	}
	
	public void ToolsHouseInputValidated(){
		try{
			this.SetInput(ReadInput.readLine().trim().toUpperCase());
		}
		catch(IOException e){
			SetValidatedInput(false);
			return;
		}
		if(this.Input != EXIT){
			try{
				int i = Integer.parseInt(Input);
				if(i == THIRD || i == SECOND || i == FIRST)
					SetValidatedInput(true);
				else
					SetValidatedInput(false);
			}catch(Exception e){
				SetValidatedInput(false);
				return;
			}
		}else{
			SetValidatedInput(true);
		}
		
	}
	
	public BufferedReader GetReadInput() {
		return ReadInput;
	}

	public void SetReadInput(BufferedReader readInput) {
		ReadInput = readInput;
	}

	public boolean GetValidatedInput() {
		return ValidatedInput;
	}

	public void SetValidatedInput(boolean validatedInput) {
		ValidatedInput = validatedInput;
	}

	public String GetInput() {
		return Input;
	}

	public void SetInput(String input) {
		Input = input;
	}
}
