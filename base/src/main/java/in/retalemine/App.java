package in.retalemine;

import in.retalemine.abstracte.AbstractChildExample;
import in.retalemine.enume.EnumTest;
import in.retalemine.generics.GenericExamples;
import in.retalemine.jscience.JscienceExamples;
import in.retalemine.regex.RegExExample;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		if (args.length > 0) {
			if (args[0].equalsIgnoreCase("jscience")) {
				new JscienceExamples();
			} else if (args[0].equalsIgnoreCase("abstract")) {
				new AbstractChildExample();
			} else if (args[0].equalsIgnoreCase("enum")) {
				new EnumTest();
			} else if (args[0].equalsIgnoreCase("generic")) {
				new GenericExamples();
			} else if (args[0].equalsIgnoreCase("regex")) {
				new RegExExample();
			}
		}
	}
}
