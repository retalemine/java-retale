package in.retalemine.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesPaths {

	public FilesPaths() {
		tryPaths();
	}

	public void tryPaths() {
		// Get the default directory path
		System.out.println(Paths.get("").toAbsolutePath());
		System.out.println(Paths.get("/").toAbsolutePath());
		System.out.println(Paths.get("/", "tmp").toAbsolutePath());
		System.out.println(Paths.get("", "tmp").toAbsolutePath());
		System.out.println(Paths.get("tmp").toAbsolutePath());
		FileSystems.getDefault().getRootDirectories().forEach(System.out::println);
		System.out.println(FileSystems.getDefault().getSeparator());
		Path path = FileSystems.getDefault().getPath("logs", "access.log");
		System.out.println(path.getFileName());
		path = Paths.get("logs", "access.log");
		System.out.println(path.toAbsolutePath());
		try {
			BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
			System.out.println(reader.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
		FileSystems.getDefault().getFileStores().forEach(System.out::println);
	}
}
