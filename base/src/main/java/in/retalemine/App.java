package in.retalemine;

import in.retalemine.abstracte.AbstractChildExample;
import in.retalemine.enume.EnumTest;
import in.retalemine.generics.GenericExamples;
import in.retalemine.itext.TryItext;
import in.retalemine.jscience.JscienceExamples;
import in.retalemine.jscience.RetaUnitExample;
import in.retalemine.nio.FilesPaths;
import in.retalemine.regex.RegExExample;
import in.retalemine.resources.GetResources;

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
				new RetaUnitExample();
			} else if (args[0].equalsIgnoreCase("abstract")) {
				new AbstractChildExample();
			} else if (args[0].equalsIgnoreCase("enum")) {
				new EnumTest();
			} else if (args[0].equalsIgnoreCase("generic")) {
				new GenericExamples();
			} else if (args[0].equalsIgnoreCase("regex")) {
				new RegExExample();
			} else if (args[0].equalsIgnoreCase("tryitext")) {
				new TryItext();
			} else if (args[0].equalsIgnoreCase("resource")) {
				new GetResources();
			} else if (args[0].equalsIgnoreCase("nio")) {
				new FilesPaths();
			}
		} else {
			System.err.println("Usage: mvn exec:java -Dexec.mainClass="
					+ App.class.getName() + " -Dexec.args=\"enum\"");
			System.exit(1);
		}
	}
}
