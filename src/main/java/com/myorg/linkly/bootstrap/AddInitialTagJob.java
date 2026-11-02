package com.myorg.linkly.bootstrap;

import com.myorg.linkly.entity.Tag;
import com.myorg.linkly.repository.TagRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AddInitialTagJob implements CommandLineRunner {

    private final TagRepository tagRepository;

    public AddInitialTagJob(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    private final Logger logger = LoggerFactory.getLogger(AddInitialTagJob.class);

    @Override
    public void run(String... args) throws Exception {
        if(tagRepository.count() == 0L) {
            List<String> tags = new ArrayList<>();
            tags.add("Java");
            tags.add("Python");
            tags.add("JavaScript");
            tags.add("C");
            tags.add("C++");
            tags.add("C#");
            tags.add("Programming");
            tags.add("AI");
            tags.add("ML");
            tags.add("Deep Learning");

            for (String tag : tags) {
                tagRepository.save(new Tag(tag));
            }

            logger.info("Tags saved successfully");
        }
    }
}
