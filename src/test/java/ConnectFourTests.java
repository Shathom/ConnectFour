import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import javafx.scene.control.Button;


class MyTests {
	
	GameButton b1;
	GameButton b2;
	
	// for easier initializations after each test
	@BeforeEach
	void init() {
		
	}
	
//	@Test
//	void TestGameButtonConstructor() {
//		for(int col = 0; col < 7; col++) {				
//			for(int row = 0; row < 6; row++) {
//				b1 = new GameButton(row, col, 1);
//				assertEquals(col, b1.column, "Oops, number of columns for GameButton class is not correct!");
//				assertEquals(row, b1.row, "Oops, number of rows for GameButton class is not correct!");	
//				assertEquals(1, b1.player, "Oops, number of rows for GameButton class is not correct!");	
//			}
//		}
//	}
//
//	@Test
//	void TestGameButtonConstructor2() {
//	for(int col = 0; col < 7; col++) {				
//		for(int row = 0; row < 6; row++) {
//			b2 = new GameButton(row, col, 2);
//			assertEquals(col, b2.column, "Oops, number of columns for GameButton class is not correct!");
//			assertEquals(row, b2.row, "Oops, number of rows for GameButton class is not correct!");	
//			assertEquals(2, b2.player, "Oops, number of rows for GameButton class is not correct!");	
//		}
//	}
//	}
//	
}
