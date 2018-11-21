package Framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Functions {
    private static final String FILE_PATH="src/test/resources/reviews.csv";
    public Set findClassesReviews(String pageSourse){
        Pattern p = Pattern.compile("(ModelReviewsHome__ContentModelReview)");
        Matcher m = p.matcher(pageSourse);
        Set<String> classes= new LinkedHashSet<>();
        while(m.find()) {
            classes.add(pageSourse.substring(m.start(), m.end()));
        }
        return classes;
    }


    public void saveReviews(List data){

        Path path = Paths.get(FILE_PATH);
        try {
            Files.write(path, data);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

