package edu.umb.cs680.hw13.fs;

import java.time.LocalDateTime;


public class TestFixtureInitializer {
    public static FileSystem createFS() {
        FileSystem fs = FileSystem.getFileSystem();
        Directory repo = new Directory(null, "repo", LocalDateTime.now());
        fs.appendRootDir(repo);

        Directory src = new Directory(repo, "src", LocalDateTime.now());
        repo.appendChild(src);
        
        File A = new File(src, "A.java", 100, LocalDateTime.now());
        src.appendChild(A);
        File B = new File(src, "B.java", 100, LocalDateTime.now());
        src.appendChild(B);

        Directory test = new Directory(repo, "test", LocalDateTime.now());
        repo.appendChild(test);
        Directory testSrc = new Directory(test, "src", LocalDateTime.now());
        test.appendChild(testSrc);
        File ATest = new File(testSrc, "ATest.java", 100, LocalDateTime.now());
        testSrc.appendChild(ATest);
        File BTest = new File(testSrc, "BTest.java", 100, LocalDateTime.now());
        testSrc.appendChild(BTest);

        File readme = new File(repo, "readme.md", 100, LocalDateTime.now());
        repo.appendChild(readme);

        Link rmd = new Link(testSrc, "rm.md", 0, LocalDateTime.now(), readme);
        testSrc.appendChild(rmd);

        return fs;
    }
}