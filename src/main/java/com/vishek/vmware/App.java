package com.vishek.vmware;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class App {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		// Reading the input file and storing it into Json object.
		JSONObject obj;
		try {
			obj = (JSONObject) new JSONParser().parse(new FileReader("TestInput.json"));
			System.out.println("Reading from the file completed");
			JSONObject firstInput = (JSONObject) obj.get("1");
			JSONObject secondInput = (JSONObject) obj.get("2");
			JSONObject thirdInput = (JSONObject) obj.get("3");

			// Creating a Json output object.
			JSONObject output = new JSONObject();

			// calculating area of Circle.
			double radius = Double.valueOf(firstInput.get("radius").toString());
			double areaCircle = 3.14 * radius * radius;

			output.put("1", areaCircle);

			// calculating area of Rectangle.
			int length = Integer.valueOf(secondInput.get("l").toString());
			int breadth = Integer.valueOf(secondInput.get("b").toString());
			int areaRect = length * breadth;

			output.put("2", areaRect);

			// calculating area of Square.
			int side = Integer.valueOf(thirdInput.get("side").toString());
			int areaSquare = side * side;

			output.put("3", areaSquare);

			// Creating an output file.
			PrintWriter pw = new PrintWriter("TestOutput.json");
			pw.write(output.toJSONString());

			pw.flush();
			pw.close();
			System.out.println("Writing into the file completed");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}
}
