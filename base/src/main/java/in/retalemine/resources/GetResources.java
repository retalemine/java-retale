package in.retalemine.resources;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class GetResources {

	public GetResources() {
		/*
		 * Below three methods won't take up file system absolute path. All
		 * serve for resources at classpath
		 */
		classLocalResources();
		classLoaderAccessSystemResources();
		resourceBundle();
	}

	public void classLocalResources() {
		// Class uses ClassLoader methods indirectly
		// Path name prefixed with slash - absolute
		String pathPrefixedSlash = "/input/file1.txt";
		// Path not prefixed will act relative to invoking class package
		String fileAtClassPkg = "file2.txt";
		InputStream io = Class.class.getResourceAsStream(pathPrefixedSlash);
		try {
			System.out.println(io.available());
			io = Class.class.getClass().getResourceAsStream(pathPrefixedSlash);
			System.out.println(io.available());
			io = GetResources.class.getClass().getResourceAsStream(pathPrefixedSlash);
			System.out.println(io.available());
		} catch (NullPointerException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		io = GetResources.class.getResourceAsStream(pathPrefixedSlash);
		try {
			System.out.println(io.available());
			io = this.getClass().getResourceAsStream(pathPrefixedSlash);
			System.out.println(io.available());
		} catch (NullPointerException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		InputStream io2 = Class.class.getResourceAsStream(fileAtClassPkg);
		try {
			System.out.println(io2.available());
		} catch (NullPointerException e1) {
			System.out.println("Instanciated class needed - " + e1.getMessage());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		io2 = Class.class.getClass().getResourceAsStream(fileAtClassPkg);
		try {
			System.out.println(io2.available());
		} catch (NullPointerException e1) {
			System.out.println("Instanciated class needed - " + e1.getMessage());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		io2 = GetResources.class.getClass().getResourceAsStream(fileAtClassPkg);
		try {
			System.out.println(io2.available());
		} catch (NullPointerException e1) {
			System.out.println("Instanciated class needed - " + e1.getMessage());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		io2 = GetResources.class.getResourceAsStream(fileAtClassPkg);
		try {
			System.out.println(io2.available());
		} catch (NullPointerException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		io2 = this.getClass().getResourceAsStream(fileAtClassPkg);
		try {
			System.out.println(io2.available());
		} catch (NullPointerException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		URL url = Class.class.getResource(pathPrefixedSlash);
		try {
			URI uri = url.toURI();
			System.out.println(uri.toString());
			url = Class.class.getClass().getResource(pathPrefixedSlash);
			uri = url.toURI();
			System.out.println(uri.toString());
			url = GetResources.class.getClass().getResource(pathPrefixedSlash);
			uri = url.toURI();
			System.out.println(uri.toString());
		} catch (NullPointerException e1) {
			e1.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		url = GetResources.class.getResource(pathPrefixedSlash);
		try {
			URI uri = url.toURI();
			System.out.println(uri.toString());
			url = this.getClass().getResource(pathPrefixedSlash);
			uri = url.toURI();
			System.out.println(uri.toString());
		} catch (NullPointerException e1) {
			e1.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		try {
			System.out
					.println(GetResources.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

	}

	public void classLoaderAccessSystemResources() {
		// Path name should not be prefixed with slash for class loader
		String pathWithoutSlash = "input/file1.txt";
		// nothing as relative path for class loader
		String fileAtClassPkg = "file2.txt";
		ClassLoader cLoader = Class.class.getClassLoader();
		if (null == cLoader) {
			System.out.println("Instanciated class needed");
			cLoader = Class.class.getClass().getClassLoader();
		}
		if (null == cLoader) {
			System.out.println("Instanciated class needed");
			cLoader = GetResources.class.getClass().getClassLoader();
		}
		if (null == cLoader) {
			System.out.println("Instanciated class needed");
		}
		InputStream io = GetResources.class.getClassLoader().getResourceAsStream(pathWithoutSlash);
		try {
			System.out.println(io.available());
		} catch (NullPointerException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		io = this.getClass().getClassLoader().getResourceAsStream(pathWithoutSlash);
		try {
			System.out.println(io.available());
		} catch (NullPointerException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		io = this.getClass().getClassLoader().getResourceAsStream(fileAtClassPkg);
		try {
			System.out.println(io.available());
		} catch (NullPointerException e1) {
			System.out.println("Complete path needed!");
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		InputStream ioSCL = ClassLoader.getSystemClassLoader().getResourceAsStream(pathWithoutSlash);
		try {
			System.out.println(ioSCL.available());
		} catch (NullPointerException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		try {
			URI uri = ClassLoader.getSystemClassLoader().getResource(pathWithoutSlash).toURI();
			System.out.println(uri.toString());
		} catch (NullPointerException e1) {
			e1.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		URL url = ClassLoader.getSystemResource(pathWithoutSlash);
		try {
			System.out.println(url.toString());
		} catch (NullPointerException e1) {
			e1.printStackTrace();
		}
	}

	public void resourceBundle() {
		ResourceBundle resourceBundle = ResourceBundle.getBundle("in.retalemine.resources.message");
		System.out.println(resourceBundle.getKeys().nextElement());
	}

}
