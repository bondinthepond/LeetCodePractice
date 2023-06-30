public class PrimitiveTypes {

	//8 primitive data types in JAVA

	//For Whole Number
	//byte - Byte
	//shot - Short
	//int - Integer
	//long - Long

	//For real number - floating point or decimal
	//float - Float
	//double - Double

	//Single Character
	//char - Character

	//Boolean Value
	//boolean - Boolean


	//OverFlow and UnderFlow in Java
	//When you try to calculate maxValue + 1 - you get the minValue - overFlows
	//When you try to calculate minValue - 1 - you get the maxValue - underFlows

	//If you assign a numeric literal value to a data type outside it range - Compiler throws as error
	//But if you write a expression, that returns a value that is outside the range - overflow/underlfow occurs

	public static void main(String[] args){
		System.out.println("Integer Value Range ( " + Integer.MIN_VALUE + " to " + Integer.MAX_VALUE + " ) ");
		System.out.println("Float Value Range ( " + Float.MIN_VALUE + " to " + Float.MAX_VALUE + " ) ");
	}

}
