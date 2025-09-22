package ucamp.java.day1.mission1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class GuessGame {
	private static final String INPUT_MESSAGE = "1부터 100사이의 값을 입력하세요 : ";
	private static final int INVALID_NUMBER = 999999;
	
	static int tryCount = 0;	//게임 시도 횟수
	
	public static void main(String[] args) {
		// 사용자가 게임을 시작할지 여부를 Y/N 으로 입력하여 Y인 경우 게임을 시작하고, N인 경우 프로그램을 종료한다. 
		
		// 사용자가 Y를 입력한 경우 게임을 시작한다.
		System.out.print("게임을 시작합니다(Y/N): ");
		String gameStart = inputString();
		while(gameStart.equals("Y")) {
			// 1 ~ 100 사이의 난수를 설정한다.
			int randomNum = getRandomNumber();
			System.out.println("무작위값(확인용): "+randomNum);
			
			// 사용자가 난수를 맞출 때까지 반복하는 코드를 반복문(do~while 권장)으로 작성한다.
			// 입력한 숫자와 무작위 숫자가 일치하지 않는 동안(= 일치할 때까지) 반복
			int inputNum1 = 0;
			do {
				// 사용자로부터 숫자 입력 받기 시작
				inputNum1 = getValidNumber();
				
				if(inputNum1 == randomNum) {
					System.out.println("축하합니다! "+tryCount+"번째에 맞추셨습니다.");
					tryCount = 0;
					System.out.print("게임을 다시 할까요?(Y/N): ");
					gameStart = inputString();
					if(gameStart.equals("N")) {							
						break;
					}
				}
				if(inputNum1 > randomNum) {
					if((inputNum1 - randomNum) >= 10) {
						System.out.println("입력하신 값은 너무 큽니다.");
					} else if((inputNum1 - randomNum) >= 5) {
						System.out.println("입력하신 값은 약간 큽니다.");
					} else {
						System.out.println("입력하신 값은 아주 약간 큽니다."); 
					}
				} 
				if(randomNum > inputNum1) {
					if((randomNum - inputNum1) <= 1) {
						System.out.println("입력하신 값은 아주 약간 작습니다.");
					} else if((randomNum - inputNum1) <= 5) {
						System.out.println("입력하신 값은 약간 작습니다.");
					} else {
						System.out.println("입력하신 값은 너무 작습니다.");
					}
				}
			}
			while(inputNum1 != randomNum);
		}
		// 사용자가 N을 입력한 경우
		System.out.println("게임을 종료합니다.");
		// 게임 시도 횟수 초기화
		tryCount = 0;
		return;
	}
	
	public static int getValidNumber() 
	{
		// 입력값 초기화
		int inputNum = 0;
		
		//"[n번째 시도] 1부터 100사이의 값을 입력하세요 : " 메시지(n은 시도 횟수)를 화면에 출력하고, 
		++tryCount;
		System.out.print("["+tryCount+"]번째 시도! "+INPUT_MESSAGE);
		
		//사용자로부터 숫자를 입력 받아 그 수를 리턴한다. 
		inputNum = inputNumber();
		
		//만약 사용자가 입력한 값이 숫자가 아니거나 1부터 100사이의 값이 아닌 경우, 
		//올바른 숫자를 입력할 때까지 메시지를 출력하고 숫자를 입력 작업을 반복한다.
		while(inputNum == INVALID_NUMBER || inputNum < 1 || inputNum > 100) {
			System.out.print("1~100 사이의 숫자만 입력해주세요: ");
			inputNum = inputNumber();
		}
		return inputNum;
	}
	
	public static int inputNumber() {
		int inputData = 0;
		
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			inputData = Integer.parseInt(in.readLine());
			
			return inputData;
		} catch(Exception e) {
			return INVALID_NUMBER;
			
		}
	}
	
	public static String inputString() {
		String inputString = null;
		
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			inputString = in.readLine();
			if(inputString.equals("Y") ||inputString.equals("N"))
				return inputString;
			throw new Exception();
		} catch(Exception e) {
			return "N";
		}
	}
	
	private static int getRandomNumber() {
		return new Random().nextInt(100) + 1;
	}
}
